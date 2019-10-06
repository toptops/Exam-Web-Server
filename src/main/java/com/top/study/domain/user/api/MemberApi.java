package com.top.study.domain.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.top.study.domain.user.dto.MemberResponse;
import com.top.study.domain.user.service.MemberSearchService;
import com.top.study.global.dto.RestResponseFactory;
import com.top.study.global.dto.RestResponse;


@RestController
@RequestMapping("/members")
public class MemberApi {
	
	private final RestResponseFactory responseFactory = RestResponseFactory.getInstance();
	
	@Autowired
	private MemberSearchService memberSearchService;
	
	@GetMapping(value = "/")
	public RestResponse getAllUser() {
		return responseFactory.create("Success All User Select", MemberResponse.take(memberSearchService.findAll()));
	}
 	
 	@GetMapping(value = "/{userId}")
 	public RestResponse getOneUser(@PathVariable("userId") String userId) {
 		return responseFactory.create("Success One User Select", MemberResponse.take(memberSearchService.getById(userId)));
 	}
 	
 	@GetMapping(value = "/age/{age}")
 	public RestResponse getOneUserSame(@PathVariable("age") int age) {
 		return responseFactory.create("Success Age User Select", MemberResponse.take(memberSearchService.findAllSameAge(age)));
 	}
}
