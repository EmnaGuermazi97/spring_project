package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MemberEventIds;
import com.example.demo.entities.MemberEvent;

public interface MemberEventRepository extends JpaRepository<MemberEvent, MemberEventIds> {
	@Query("select m from MemberEvent  m where member_id=:x")
	List<MemberEvent> findMemberEventId(@Param("x")Long idMember);
}
