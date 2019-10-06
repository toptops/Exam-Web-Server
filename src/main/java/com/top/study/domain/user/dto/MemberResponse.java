package com.top.study.domain.user.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.top.study.domain.user.domain.Member;

import lombok.Getter;

@Getter
public class MemberResponse {
	private String userId;
	private String memberName;
	private int age;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createAt;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime updateAt;
	
	public MemberResponse(final Member member) {
		this.userId = member.getId();
		this.memberName = member.getMemberName();
		this.age = member.getAge();
		this.createAt = member.getCreateAt();
		this.updateAt = member.getUpdateAt();
	}
	
	public static MemberResponse take(final Member member) {
		return new MemberResponse(member);
	}
	
	public static List<MemberResponse> take(List<Member> members) {
		return members.stream()
				.map(member -> MemberResponse.take(member))
				.collect(Collectors.toList());
	}
}
