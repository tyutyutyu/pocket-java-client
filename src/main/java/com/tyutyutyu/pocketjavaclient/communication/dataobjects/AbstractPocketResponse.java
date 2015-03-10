package com.tyutyutyu.pocketjavaclient.communication.dataobjects;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

public class AbstractPocketResponse {

	private int status;

	public AbstractPocketResponse() {

	}

	public AbstractPocketResponse(ResponseStatus status) {

		this.status = status.getCode();
	}

	public ResponseStatus getStatus() {

		return ResponseStatus.findByCode(status);
	}
}
