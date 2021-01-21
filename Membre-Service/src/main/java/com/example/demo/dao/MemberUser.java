package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MemberUser extends JpaRepository {
	@Query("SELECT m.id FROM Membre m WHERE m.cin=:x")
	Long getMemberIdByMemberCin(@Param("x") String cin);
}
