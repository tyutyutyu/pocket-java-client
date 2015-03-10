package com.tyutyutyu.pocketjavaclient;

import com.google.common.base.Preconditions;
import com.tyutyutyu.pocketjavaclient.communication.RawJsonResponse;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.Article;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.ArticleListingRootData;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.ArticleState;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.ListArticlesRequest;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.ListArticlesResponse;
import com.tyutyutyu.pocketjavaclient.parsers.ArticlesListFromJsonExtractor;

import java.util.List;

import org.joda.time.DateTime;

public class ListingService extends AbstractService {

	private final ArticlesListFromJsonExtractor articlesListFromJsonResponseExtractor;

	public ListingService(Pocket pocket) {

		super(pocket);
		articlesListFromJsonResponseExtractor = new ArticlesListFromJsonExtractor(gson);
	}

	public ListArticlesResponse allUnread() {

		final ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken());
		return retrieveArticles(request);
	}

	public ListArticlesResponse allUnreadSince(DateTime since) {

		Preconditions.checkArgument(since != null, "Since value can not be null");

		final ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken()).withSince(since);
		return retrieveArticles(request);
	}

	public ListArticlesResponse allOfThem() {

		final ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken()).withState(ArticleState.ALL);
		return retrieveArticles(request);
	}

	public ListArticlesResponse allOfThemSince(DateTime since) {

		Preconditions.checkArgument(since != null, "Since value can not be null");

		final ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken()).withState(ArticleState.ALL).withSince(since);
		return retrieveArticles(request);
	}

	private ListArticlesResponse retrieveArticles(ListArticlesRequest request) {

		final RawJsonResponse rawJsonResponse = requestSender.sendRequest(request, "https://getpocket.com/v3/get");

		if (rawJsonResponse.statusIsOk()) {
			final String json = rawJsonResponse.getResponse().get();
			final ArticleListingRootData listingRootData = gson.fromJson(json, ArticleListingRootData.class);
			final List<Article> articles = articlesListFromJsonResponseExtractor.extractArticlesData(json);
			return new ListArticlesResponse(listingRootData.getStatus(), listingRootData.getComplete(), listingRootData.getSince(), articles);
		} else {
			return new ListArticlesResponse(rawJsonResponse.getStatus());
		}
	}

}
