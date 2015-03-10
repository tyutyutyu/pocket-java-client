package com.tyutyutyu.pocketjavaclient.authorization;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

public class TokenRequestResponse extends AbstractAuthorizationResponse {

	private String code;

	private String state;

	public TokenRequestResponse() {

	}

	public TokenRequestResponse(ResponseStatus status) {

		super(status);
	}

	public String getCode() {

		return code;
	}

	public String getState() {

		return state;
	}
}
