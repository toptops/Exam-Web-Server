package com.top.study.domain.user.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.top.study.domain.user.domain.Member;

import lombok.Getter;

@Getter
public class MemberResponse {
	private String userId;
	private String memberName;
	private int age;
	
	public MemberResponse(final Member member) {
		this.userId = member.getId();
		this.memberName = member.getMemberName();
		this.age = member.getAge();
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
