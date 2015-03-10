package com.tyutyutyu.pocketjavaclient.authorization;

import org.junit.Rule;
import org.junit.Test;

import pl.wkr.fluentrule.api.FluentExpectedException;

public class PocketAuthorizerTest {

	@Rule
	public FluentExpectedException thrown = FluentExpectedException.none();

	@Test
	public void shouldThrowExceptionOnMissingRequestToken() {

		thrown.expect(IllegalArgumentException.class).hasMessageContaining("Request Token");

		PocketAuthorizer.getAuthorizationUrlFor(null, "http://tomaszdziurko.pl");
	}

	@Test
	public void shouldThrowExceptionOnMissingRedirectUrl() {

		thrown.expect(IllegalArgumentException.class).hasMessageContaining("Redirect Back Url");

		PocketAuthorizer.getAuthorizationUrlFor("token", "");
	}

}
