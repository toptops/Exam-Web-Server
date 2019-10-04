package com.top.study;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.top.study.domain.user.exception.MemberExecptionBuilder;
import com.top.study.domain.user.exception.MemberExecptions;
import com.top.study.global.error.ResultTypes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {

//	private static final Logger logger = LogManager.getLogger(StudyApplicationTests.class);
	
	@Test
	public void contextLoads() {
//		logger.info("test");
		
		System.out.println(MemberExecptionBuilder.newBuilder(MemberExecptions.EmptyMember)
										.errorContent(null)
										.errorType(ResultTypes.BadRequest)
										.execptionCause(null).build());
	}

}
