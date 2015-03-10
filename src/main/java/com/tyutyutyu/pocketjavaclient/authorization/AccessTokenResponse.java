package com.tyutyutyu.pocketjavaclient.authorization;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

public class AccessTokenResponse extends AbstractAuthorizationResponse {

	private String accessToken;

	private String username;

	public AccessTokenResponse() {

	}

	public AccessTokenResponse(ResponseStatus status) {

		super(status);
	}

	public String getAccessToken() {

		return accessToken;
	}

	public String getUsername() {

		return username;
	}
}
