package com.tyutyutyu.pocketjavaclient.authorization;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TokenRequestResponse extends AbstractAuthorizationResponse {

	private String code;

	private String state;

	public TokenRequestResponse(ResponseStatus status) {

		super(status);
	}

}
