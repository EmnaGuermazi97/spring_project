package com.example.demo.entities;
import java.io.Serializable;
import javax.persistence.Embeddable;
@Embeddable
public class MemberEventIds implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long memberId;
	private Long eventId;
	public MemberEventIds() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberEventIds(Long memberId, Long eventId) {
		super();
		this.memberId = memberId;
		this.eventId = eventId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
