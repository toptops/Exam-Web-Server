package com.top.study.domain.user.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(MemberApi.class);
	private final RestResponseFactory responseFactory = RestResponseFactory.getInstance();
	
	@Autowired
	private MemberSearchService memberSearchService;
	
	@GetMapping(value = "/")
	public RestResponse getAllMember() {
		logger.info("All Member Select !!");
		return responseFactory.create("Success All Member Select", MemberResponse.take(memberSearchService.findAll()));
	}
 	
 	@GetMapping(value = "/{userId}")
 	public RestResponse getOneMember(@PathVariable("userId") String memberId) {
 		logger.info("One Member Select !!");
 		return responseFactory.create("Success One Member Select", MemberResponse.take(memberSearchService.getById(memberId)));
 	}
 	
 	@GetMapping(value = "/age/{age}")
 	public RestResponse getOneMemberSame(@PathVariable("age") int age) {
 		logger.info("Age Members Select !!");
 		return responseFactory.create("Success Age Member Select", MemberResponse.take(memberSearchService.findAllSameAge(age)));
 	}
}
