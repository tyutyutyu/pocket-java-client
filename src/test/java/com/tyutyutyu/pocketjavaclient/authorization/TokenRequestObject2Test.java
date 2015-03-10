package com.tyutyutyu.pocketjavaclient.authorization;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import com.tyutyutyu.pocketjavaclient.communication.gson.GsonProducer;

import org.junit.Test;

public class TokenRequestObject2Test {

	@SuppressWarnings("static-method")
	@Test
	public void shouldConvertToJsonWhenStateIsNull() {

		// Given
		final TokenRequestObject requestObject = new TokenRequestObject("1234-asdf-asdf", "http://localhost", null);

		// When
		final Gson gson = GsonProducer.create();
		final String json = gson.toJson(requestObject);

		// Then
		assertThat(json).isEqualTo("{\"consumer_key\":\"1234-asdf-asdf\",\"redirect_uri\":\"http://localhost\"}");
	}

}
