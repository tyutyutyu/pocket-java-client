package com.tyutyutyu.pocketjavaclient;

import com.tyutyutyu.pocketjavaclient.communication.RawJsonResponse;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.add.AddArticleResponse;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.add.AddItemRequest;

public class AddService extends AbstractService {

	public AddService(Pocket pocket) {

		super(pocket);
	}

	public AddArticleResponse with(String url) {

		final AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url);
		return sendAndConvertResponse(addItem);
	}

	private AddArticleResponse sendAndConvertResponse(AddItemRequest addItem) {

		final RawJsonResponse response = requestSender.sendRequest(addItem, "https://getpocket.com/v3/add");

		if (response.statusIsOk()) {
			return gson.fromJson(response.getResponse().get(), AddArticleResponse.class);
		} else {
			return new AddArticleResponse(response.getStatus());
		}
	}

	public AddArticleResponse with(String url, String title) {

		final AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url, title, null, null);
		return sendAndConvertResponse(addItem);
	}

	public AddArticleResponse with(String url, String title, String tags, Long tweetId) {

		final AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url, title, tweetId, tags);
		return sendAndConvertResponse(addItem);
	}

	public AddArticleResponse with(String url, String title, String tags) {

		final AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url, title, null, tags);
		return sendAndConvertResponse(addItem);
	}

}
