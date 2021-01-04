package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MemberTool;
import com.example.demo.entities.MemberToolId;
public interface MemberToolRepository extends JpaRepository<MemberTool, MemberToolId> {
	@Query("select m from MemberTool  m where member_id=:membreId")
	List<MemberTool> findMemberToolId(@Param("membreId") Long memberId);
}
