package com.top.study;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.top.study.domain.user.dao.MemberRepository;
import com.top.study.domain.user.exception.MemberExecptionBuilder;
import com.top.study.domain.user.exception.MemberExecptions;
import com.top.study.global.dto.ErrorResponse;
import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.GlobalExecptions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {

//	private static final Logger logger = LogManager.getLogger(StudyApplicationTests.class);
	
	@Autowired
	MemberRepository MemberRepository;
	
	@Test
	public void contextLoads() {
		System.out.println(MemberRepository.SearchByAgeMembers(23).get(0).getMemberName());
		
		System.out.println(MemberExecptionBuilder.newBuilder(MemberExecptions.EmptyMember)
										.errorType(ResultTypes.BadRequest).build());
	}

}
