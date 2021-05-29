package com.example.demo.jwt;
import java.security.SignatureException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.services.UserDetailsImpl;

import io.jsonwebtoken.*;
@Component
public class JwtUtils {
	 private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	    @Value("${spring-boot-server.app.jwtSecret}")
	    private String jwtSecret;

	    @Value("${spring-boot-server.app.jwtExpirationMs}")
	    private int jwtExpirationMs;

	    public String generateJwtToken(Authentication authentication) {

	        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) userPrincipal.getAuthorities();

	        return Jwts.builder()
	                .setSubject((userPrincipal.getUsername()))
	                .setIssuedAt(new Date())
	                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
					.claim("role", authorities)
	                //on signe avec un algorithme symetrique
	                .signWith(SignatureAlgorithm.HS512, jwtSecret)
	                .compact();
	    }

	    public String getUserNameFromJwtToken(String token) {
	        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	    }

	    public boolean validateJwtToken(String authToken) throws SignatureException {
	        try {
	            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	            return true;
	        } catch (MalformedJwtException e) {
	            logger.error("Invalid JWT token: {}", e.getMessage());
	        } catch (ExpiredJwtException e) {
	            logger.error("JWT token is expired: {}", e.getMessage());
	        } catch (UnsupportedJwtException e) {
	            logger.error("JWT token is unsupported: {}", e.getMessage());
	        } catch (IllegalArgumentException e) {
	            logger.error("JWT claims string is empty: {}", e.getMessage());
	        }

	        return false;
	    }
}
