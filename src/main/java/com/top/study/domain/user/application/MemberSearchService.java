package com.top.study.domain.user.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.top.study.domain.user.dao.MemberRepository;
import com.top.study.domain.user.domain.Member;

@Service
public class MemberSearchService {
	@Autowired
	private MemberRepository userRepository;
	
	public Member getById(String userId) {
		Optional<Member> member = userRepository.findById(userId);
		
		member.orElseThrow();
		
		return member.get();
	}
	
	public List<Member> findAll() {
		return userRepository.findAll();
	}
}
