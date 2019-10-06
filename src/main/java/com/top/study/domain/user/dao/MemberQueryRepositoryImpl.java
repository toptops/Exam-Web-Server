package com.top.study.domain.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import com.top.study.domain.user.domain.Member;
import com.top.study.domain.user.domain.QMember;

@Transactional(readOnly = true)
public class MemberQueryRepositoryImpl extends QuerydslRepositorySupport implements MemberQueryRepository{
	final QMember qMember = QMember.member;
	
	public MemberQueryRepositoryImpl() {
		super(Member.class);
	}

	@Override
	public List<Member> SearchByAgeMembers(int age) {
		return from(qMember)
				.where(qMember.age.intValue().like(age + "%"))
				.fetch();
	}

	@Override
	public List<Member> SearchByMoreThanAge(int age) {
		return from(qMember)
				.where(qMember.age.intValue().goe(age))
				.fetch();
	}

	@Override
	public List<Member> SearchByLessThanAge(int age) {
		return from(qMember)
				.where(qMember.age.intValue().loe(age))
				.fetch();
	}

}
