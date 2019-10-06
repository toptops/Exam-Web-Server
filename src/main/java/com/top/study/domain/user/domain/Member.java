package com.top.study.domain.user.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@CreationTimestamp
	@Column(name = "create_at", nullable = false, updatable = false)
	private LocalDateTime createAt;
	
	@UpdateTimestamp
	@Column(name = "update_at", nullable = false)
	private LocalDateTime updateAt;
	
	@Builder
	public Member(String memberName) {
		this.memberName = memberName;
	}
	
}
