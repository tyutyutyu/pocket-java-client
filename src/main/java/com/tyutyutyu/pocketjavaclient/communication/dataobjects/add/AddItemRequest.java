package com.tyutyutyu.pocketjavaclient.communication.dataobjects.add;

import com.google.common.base.Preconditions;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractPocketRequest;

import org.apache.commons.lang3.StringUtils;

public class AddItemRequest extends AbstractPocketRequest {

	private final String url;

	private final String title;

	private final Long tweetId;

	private final String tags;

	public AddItemRequest(String consumer_key, String access_token, String url) {

		this(consumer_key, access_token, url, null, null, null);
	}

	public AddItemRequest(String consumer_key, String access_token, String url, String title, Long tweetId, String tags) {

		super(consumer_key, access_token);
		Preconditions.checkArgument(StringUtils.isNotBlank(url), "Article url must be provided");

		this.title = title;
		this.tweetId = tweetId;
		this.tags = tags;
		this.url = url;
	}

	public String getUrl() {

		return url;
	}

	public String getTitle() {

		return title;
	}

	public Long getTweetId() {

		return tweetId;
	}

	public String getTags() {

		return tags;
	}
}
