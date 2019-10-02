package com.top.study.domain.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name", nullable = false)
	private String memberName;
	
	private Integer age;
	
	@Builder
	public Member(String memberName) {
		this.memberName = memberName;
	}
	
}
