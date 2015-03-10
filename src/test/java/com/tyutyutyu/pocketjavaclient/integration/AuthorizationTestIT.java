package com.tyutyutyu.pocketjavaclient.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.tyutyutyu.pocketjavaclient.authorization.AccessTokenResponse;
import com.tyutyutyu.pocketjavaclient.authorization.PocketAuthorizer;
import com.tyutyutyu.pocketjavaclient.authorization.TokenRequestResponse;
import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;

import org.junit.Test;

public class AuthorizationTestIT {

	PocketAuthorizer client = new PocketAuthorizer();

	@Test
	public void shouldGetInvalidKeyStatus() {

		// When
		final TokenRequestResponse requestToken = client.getRequestToken("invalid", "url", null);

		// Then
		assertThat(requestToken.getResponseStatus()).isEqualTo(ResponseStatus.INVALID_CONSUMER_KEY);
		assertThat(requestToken.getCode()).isNull();
	}

	@Test
	public void shouldReceiveRequestToken() {

		// Given
		final String state = "example-state";

		// Then
		final TokenRequestResponse requestToken = client.getRequestToken(IntegrationTestsConfig.get().getConsumerKey(), "url", state);

		// When
		assertThat(requestToken.isOk()).isTrue();
		assertThat(requestToken.getCode()).isNotEmpty();
		assertThat(requestToken.getState()).isEqualTo(state);
	}

	@Test
	public void shouldRejectNotApprovedConsumerKey() {

		// Given
		final String notApprovedConsumerKey = IntegrationTestsConfig.get().getNotApprovedConsumerKey();

		final TokenRequestResponse requestToken = client.getRequestToken(notApprovedConsumerKey, "url", null);
		assertThat(requestToken.isOk()).isTrue();
		final String token = requestToken.getCode();

		// When
		final AccessTokenResponse accessToken = client.getAccessToken(notApprovedConsumerKey, token);

		// Then
		assertThat(accessToken.isOk()).isFalse();
		assertThat(accessToken.getResponseStatus()).isEqualTo(ResponseStatus.USER_REJECTED_CODE);
	}

}
