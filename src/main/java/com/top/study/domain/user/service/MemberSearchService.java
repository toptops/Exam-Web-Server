package com.top.study.domain.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.top.study.domain.user.dao.MemberRepository;
import com.top.study.domain.user.domain.Member;
import com.top.study.domain.user.exception.MemberExecptionBuilder;
import com.top.study.domain.user.exception.MemberExecptions;
import com.top.study.global.error.ResultTypes;

@Service
public class MemberSearchService {
	
	@Autowired
	private MemberRepository userRepository;
	
	private Map<String, Object> errorContent;
	
	public MemberSearchService() {
		errorContent = new HashMap<String, Object>();
	}
	
	public Member getById(String userId) {
		Optional<Member> member = userRepository.findById(userId);
		errorContent.clear();
		errorContent.put("UserId", userId);
		
		
		member.orElseThrow(() -> MemberExecptionBuilder.newBuilder(MemberExecptions.NotFoundMemmber)
														.errorType(ResultTypes.BadRequest)
														.errorContent(errorContent)
														.build());
		
		return member.get();
	}
	
	public List<Member> findAll() {
		List<Member> allMember = new ArrayList<>();
		allMember = userRepository.findAll();
		
		if(allMember.size() < 1) {
			throw MemberExecptionBuilder.newBuilder(MemberExecptions.EmptyMember)
										.errorType(ResultTypes.BadRequest)
										.build();
		}
		
		return allMember;
	}
	
	public List<Member> findAllSameAge(int age) {
		List<Member> ageAllMember = new ArrayList<Member>();
		ageAllMember = userRepository.SearchByAgeMembers(age);
		
		errorContent.clear();
		errorContent.put("Age", age);
		
		if(ageAllMember.size() < 1) {
			throw MemberExecptionBuilder.newBuilder(MemberExecptions.EmptyMember)
										.errorType(ResultTypes.BadRequest)
										.errorContent(errorContent)
										.build();
		}
		
		return ageAllMember;
	}
}
