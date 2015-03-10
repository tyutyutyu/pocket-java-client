package com.tyutyutyu.pocketjavaclient;

import com.google.common.base.Preconditions;

import org.apache.commons.lang3.StringUtils;

public class Pocket {

	private final String consumerKey;

	private final String accessToken;

	private final AddService addService;

	private final ListingService listingService;

	private final ModifyService modifyService;

	public Pocket(String consumerKey, String accessToken) {

		Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
		Preconditions.checkArgument(StringUtils.isNotBlank(accessToken), "Access Token must be provided");

		this.consumerKey = consumerKey;
		this.accessToken = accessToken;

		addService = new AddService(this);
		listingService = new ListingService(this);
		modifyService = new ModifyService(this);

	}

	public AddService addArticle() {

		return addService;
	}

	public ListingService listArticles() {

		return listingService;
	}

	public ModifyService modifyArticles() {

		return modifyService;
	}

	public String getConsumerKey() {

		return consumerKey;
	}

	public String getAccessToken() {

		return accessToken;
	}
}
