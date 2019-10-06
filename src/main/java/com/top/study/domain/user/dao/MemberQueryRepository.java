package com.top.study.domain.user.dao;

import java.util.List;

import com.top.study.domain.user.domain.Member;

public interface MemberQueryRepository {
	List<Member> SearchByAgeMembers(int age);
	List<Member> SearchByMoreThanAge(int age);
	List<Member> SearchByLessThanAge(int age);
}
