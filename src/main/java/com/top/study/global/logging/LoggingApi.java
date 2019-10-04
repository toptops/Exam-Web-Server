package com.top.study.global.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/loggin")
@Slf4j
public class LoggingApi {
	
	private static final Logger logger = LogManager.getLogger(LoggingApi.class);
	
	@GetMapping("/test")
	public String logginTest() {
		log.trace("A Trace Message");
		log.debug("A debug Message");
		log.info("A info Message");
		log.warn("A warn Message");
		log.error("A error Message");
		
		return "Check how the Lombok basic log(@Slf4j) is printed!!";
	}
	
	@GetMapping("/log4j2Test")
	public String log4j2Test() {
		logger.trace("A Trace Message");
		logger.debug("A Debug Message");
		logger.info("A Info Message");
		logger.warn("A Warn Message");
		logger.error("A Error Message");
		
		
		return "Check how the Lombok basic log(@log4j2) is printed!!"; 
	}
}
