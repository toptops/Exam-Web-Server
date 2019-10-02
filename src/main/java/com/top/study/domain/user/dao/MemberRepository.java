package com.top.study.domain.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.top.study.domain.user.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
}
