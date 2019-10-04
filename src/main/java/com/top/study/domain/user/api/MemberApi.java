package com.top.study.domain.user.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.top.study.domain.user.application.MemberSearchService;
import com.top.study.domain.user.domain.Member;
import com.top.study.domain.user.dto.MemberResponse;
import com.top.study.domain.user.exception.MemberExecptionBuilder;
import com.top.study.domain.user.exception.MemberExecptions;
import com.top.study.global.dto.ResponseFactory;
import com.top.study.global.dto.RestResponse;
import com.top.study.global.error.ResultTypes;


@RestController
@RequestMapping("/members")
public class MemberApi {
	
	private final ResponseFactory responseFactory = ResponseFactory.getInstance();
	
	@Autowired
	private MemberSearchService memberSearchService;
	
	@GetMapping(value = "/")
	public RestResponse getAllUser() {
		List<Member> allMember = new ArrayList<>();
		allMember = memberSearchService.findAll();
		
		if(allMember.size() < 1) {
			throw MemberExecptionBuilder.newBuilder(MemberExecptions.EmptyMember)
										.errorContent(null)
										.errorType(ResultTypes.BadRequest)
										.execptionCause(null).build();
		}
		
		return responseFactory.create("Success All User Select", MemberResponse.take(memberSearchService.findAll()));
	}
 	
 	@GetMapping(value = "/{userId}")
 	public RestResponse getOneUser(@PathVariable("userId") String userId) {
 		return responseFactory.create("Success All User Select", MemberResponse.take(memberSearchService.getById(userId)));
 	}
}
