package com.top.study.domain.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.top.study.domain.user.application.MemberSearchService;
import com.top.study.domain.user.dto.MemberResponse;
import com.top.study.global.dto.ResponseFactory;
import com.top.study.global.dto.RestResponse;


@RestController
@RequestMapping("/members")
public class MemberApi {
	
	private final ResponseFactory responseFactory = ResponseFactory.getInstance();
	
	@Autowired
	private MemberSearchService userSearchService;
	
	@GetMapping(value = "/")
	public RestResponse getAllUser() {
		return responseFactory.create("Success All User Select", MemberResponse.take(userSearchService.findAll()));
	}
 	
 	@GetMapping(value = "/{userId}")
 	public RestResponse getOneUser(@PathVariable("userId") String userId) {
 		return responseFactory.create("Success All User Select", MemberResponse.take(userSearchService.getById(userId)));
 	}
}
