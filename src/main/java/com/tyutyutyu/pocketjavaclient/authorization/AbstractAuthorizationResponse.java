package com.tyutyutyu.pocketjavaclient.authorization;

import static com.tyutyutyu.pocketjavaclient.communication.ResponseStatus.OK;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

public abstract class AbstractAuthorizationResponse {

	private ResponseStatus responseStatus = OK; // default value for valid responses

	protected AbstractAuthorizationResponse() {

	}

	public AbstractAuthorizationResponse(ResponseStatus responseStatus) {

		this.responseStatus = responseStatus;
	}

	public ResponseStatus getResponseStatus() {

		return responseStatus;
	}

	public boolean isOk() {

		return OK == responseStatus;
	}
}
