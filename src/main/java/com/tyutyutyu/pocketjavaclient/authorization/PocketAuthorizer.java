package com.tyutyutyu.pocketjavaclient.authorization;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.tyutyutyu.pocketjavaclient.communication.RawJsonResponse;
import com.tyutyutyu.pocketjavaclient.communication.RequestSender;
import com.tyutyutyu.pocketjavaclient.communication.gson.GsonProducer;

import org.apache.commons.lang3.StringUtils;

public class PocketAuthorizer {

	private final Gson gson;

	private final RequestSender requestSender;

	public PocketAuthorizer() {

		gson = GsonProducer.create();
		requestSender = new RequestSender();
	}

	public TokenRequestResponse getRequestToken(String consumerKey, String redirectUri, String state) {

		final TokenRequestObject requestObject = new TokenRequestObject(consumerKey, redirectUri, state);
		final RawJsonResponse response = requestSender.sendRequest(requestObject, "https://getpocket.com/v3/oauth/request");

		if (response.statusIsOk()) {
			return gson.fromJson(response.getResponse().get(), TokenRequestResponse.class);
		} else {
			return new TokenRequestResponse(response.getStatus());
		}
	}

	public static String getAuthorizationUrlFor(String requestToken, String redirectBackUrl) {

		Preconditions.checkArgument(StringUtils.isNotBlank(requestToken), "Request Token must be provided");
		Preconditions.checkArgument(StringUtils.isNotBlank(redirectBackUrl), "Redirect Back Url must be provided");

		return "https://getpocket.com/auth/authorize?request_token=" + requestToken + "&redirect_uri=" + redirectBackUrl;
	}

	public AccessTokenResponse getAccessToken(String consumerKey, String requestToken) {

		final AccessTokenRequestObject requestObject = new AccessTokenRequestObject(consumerKey, requestToken);
		final RawJsonResponse response = requestSender.sendRequest(requestObject, "https://getpocket.com/v3/oauth/authorize");

		if (response.statusIsOk()) {
			return gson.fromJson(response.getResponse().get(), AccessTokenResponse.class);
		} else {
			return new AccessTokenResponse(response.getStatus());
		}
	}

}
