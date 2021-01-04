package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
@Entity
public class MemberTool {
	@EmbeddedId
	MemberToolId toolMemberId;
	@ManyToOne
	@MapsId("memberId")
	private Membre member;
	public MemberTool() {
		super();
	}
	public MemberTool(MemberToolId toolMemberId, Membre member) {
		super();
		this.toolMemberId = toolMemberId;
		this.member = member;
	}
	public MemberToolId getToolMemberId() {
		return toolMemberId;
	}
	public void setToolMemberId(MemberToolId toolMemberId) {
		this.toolMemberId = toolMemberId;
	}
	public Membre getMember() {
		return member;
	}
	public void setMember(Membre member) {
		this.member = member;
	}
	
}
