package com.tyutyutyu.pocketjavaclient.authorization;

import com.google.common.base.Preconditions;

import org.apache.commons.lang3.StringUtils;

public class AccessTokenRequestObject {

	private final String consumerKey;

	private final String code;

	public AccessTokenRequestObject(String consumerKey, String requestToken) {

		Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
		Preconditions.checkArgument(StringUtils.isNotBlank(requestToken), "Request Token must be provided");

		this.consumerKey = consumerKey;
		code = requestToken;
	}

	public String getConsumerKey() {

		return consumerKey;
	}

	public String getRequestToken() {

		return code;
	}

}
