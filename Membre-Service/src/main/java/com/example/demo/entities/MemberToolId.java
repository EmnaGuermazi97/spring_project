package com.example.demo.entities;
import java.io.Serializable;
import javax.persistence.Embeddable;
public class MemberToolId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long memberId;
	private Long toolId;
	public MemberToolId() {
		super();
	}
	public MemberToolId(Long memberId, Long toolId) {
		super();
		this.memberId = memberId;
		this.toolId = toolId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getToolId() {
		return toolId;
	}
	public void setToolId(Long toolId) {
		this.toolId = toolId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
