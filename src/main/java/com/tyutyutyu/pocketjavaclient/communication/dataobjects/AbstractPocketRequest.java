package com.tyutyutyu.pocketjavaclient.communication.dataobjects;

import com.google.common.base.Preconditions;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

@Data
public class AbstractPocketRequest {

	private final String consumerKey;

	private final String accessToken;

	public AbstractPocketRequest(String consumerKey, String accessToken) {

		Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
		Preconditions.checkArgument(StringUtils.isNotBlank(accessToken), "Access Token must be provided");

		this.consumerKey = consumerKey;
		this.accessToken = accessToken;
	}

}
