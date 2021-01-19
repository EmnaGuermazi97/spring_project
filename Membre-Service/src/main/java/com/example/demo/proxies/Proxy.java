package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.Bean.UserBean;

@FeignClient(value = "proxy-service", decode404 = true)
//@AuthorizedFeignClient("proxy-service")
public interface Proxy {
	@GetMapping("/api/auth/users")
	CollectionModel<UserBean>findAllUsers();
	@GetMapping(value="/api/auth/{id}")
	EntityModel<UserBean> findUserById(@PathVariable Long id);
}
