package com.example.demo.entities;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
@Entity
public class MemberEvent {
	@EmbeddedId
	private MemberEventIds eventMemberId ;
	@ManyToOne
	@MapsId("memberId")
	private Membre member;
	public MemberEvent() {
		super();
	}
	public MemberEvent(MemberEventIds eventMemberId, Membre member) {
		super();
		this.eventMemberId = eventMemberId;
		this.member = member;
	}
	public MemberEventIds getEventMemberId() {
		return eventMemberId;
	}
	public void setEventMemberId(MemberEventIds eventMemberId) {
		this.eventMemberId = eventMemberId;
	}
	public Membre getMember() {
		return member;
	}
	public void setMember(Membre member) {
		this.member = member;
	}
	
}
