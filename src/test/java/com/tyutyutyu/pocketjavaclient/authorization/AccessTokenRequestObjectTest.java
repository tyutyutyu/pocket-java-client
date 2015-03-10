package com.tyutyutyu.pocketjavaclient.authorization;

import org.junit.Rule;
import org.junit.Test;

import pl.wkr.fluentrule.api.FluentExpectedException;

public class AccessTokenRequestObjectTest {

	@Rule
	public FluentExpectedException thrown = FluentExpectedException.none();

	@SuppressWarnings({ "unused" })
	@Test
	public void shouldThrowExceptionOnMissingConsumerKey() {

		thrown.expect(IllegalArgumentException.class).hasMessageContaining("Consumer Key");

		new AccessTokenRequestObject("", "token");
	}

	@SuppressWarnings({ "unused" })
	@Test
	public void shouldThrowExceptionOnMissingRequestToken() {

		thrown.expect(IllegalArgumentException.class).hasMessageContaining("Request Token");

		new AccessTokenRequestObject("consumerkey", "");
	}

}
