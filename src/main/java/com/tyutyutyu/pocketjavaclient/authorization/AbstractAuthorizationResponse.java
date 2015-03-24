package com.tyutyutyu.pocketjavaclient.authorization;

import static com.tyutyutyu.pocketjavaclient.communication.ResponseStatus.OK;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class AbstractAuthorizationResponse {

	private ResponseStatus responseStatus = OK; // default value for valid responses

	public boolean isOk() {

		return OK == responseStatus;
	}

}
