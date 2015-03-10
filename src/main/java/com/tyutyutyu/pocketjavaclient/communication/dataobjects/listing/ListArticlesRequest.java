package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractPocketRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.joda.time.DateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListArticlesRequest extends AbstractPocketRequest {

	public ListArticlesRequest(String consumer_key, String access_token) {

		super(consumer_key, access_token);
		state = ArticleState.UNREAD;
	}

	private ArticleState state;

	private Boolean favorite;

	private String tag;

	private ArticleContentType contentType;

	private ArticleSorting sort;

	private ArticleDetailType detailType;

	private String search;

	private String domain;

	private String since;

	private Integer count;

	private Integer offset;

	public ListArticlesRequest withSince(DateTime dateTime) {

		since = String.valueOf(dateTime.getMillis() / 1000L);
		return this;
	}

	public ListArticlesRequest withState(ArticleState articleState) {

		state = articleState;
		return this;
	}

}
