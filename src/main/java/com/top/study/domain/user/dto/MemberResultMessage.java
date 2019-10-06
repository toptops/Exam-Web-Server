package com.top.study.domain.user.dto;

import lombok.Getter;

@Getter
public enum MemberResultMessage {

	FindAllSuccess ("Success All Member Select"),
	FindOneSuccess ("Success One Member Select"),
	FindSameAgeAllSuccess("Success Same Age Member Select");
	
	private String resultMessage;
	
	private MemberResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
