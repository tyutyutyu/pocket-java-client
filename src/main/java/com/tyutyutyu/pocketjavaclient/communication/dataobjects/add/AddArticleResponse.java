package com.tyutyutyu.pocketjavaclient.communication.dataobjects.add;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractPocketResponse;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AddArticleResponse extends AbstractPocketResponse {

	private AddedArticle item;

	public AddArticleResponse(ResponseStatus status) {

		super(status);
	}

	public AddedArticle getArticle() {

		return item;
	}

	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}
}
