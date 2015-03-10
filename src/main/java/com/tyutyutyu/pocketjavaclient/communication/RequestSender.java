package com.tyutyutyu.pocketjavaclient.communication;

import static com.jayway.restassured.RestAssured.with;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.tyutyutyu.pocketjavaclient.communication.gson.GsonProducer;

public class RequestSender {

	private final Gson gson;

	public RequestSender() {

		gson = GsonProducer.create();
	}

	public RawJsonResponse sendRequest(Object data, String url) {

		final Response response = with().body(gson.toJson(data)).header("Content-Type", "application/json; charset=UTF8").header("X-Accept", "application/json").post(url);
		final ResponseStatus status = ResponseStatusExtractor.getStatus(response.getHeaders());
		final String responseString = response.asString();

		if (status.isOk()) {
			return RawJsonResponse.ok(responseString);
		} else {
			return RawJsonResponse.invalid(status);
		}
	}

}
