package com.top.study.domain.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.top.study.domain.user.domain.Member;

@Transactional
public class MemberQueryRepositoryImpl extends QuerydslRepositorySupport implements MemberQueryRepository{

	public MemberQueryRepositoryImpl() {
		super(Member.class);
	}

	@Override
	public List<Member> SearchByAge(int age) {
		
		return null;
	}

	@Override
	public List<Member> SearchByMoreThanAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> SearchByLessThanAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

}
