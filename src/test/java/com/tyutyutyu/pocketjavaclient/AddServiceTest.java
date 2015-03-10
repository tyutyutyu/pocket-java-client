package com.tyutyutyu.pocketjavaclient;

import org.junit.Rule;
import org.junit.Test;

import pl.wkr.fluentrule.api.FluentExpectedException;

public class AddServiceTest {

	@Rule
	public FluentExpectedException thrown = FluentExpectedException.none();

	Pocket pocket = new Pocket("consumerKey", "accessToken");

	@Test
	public void shouldThrowExceptionOnMissingUrlForAddedItem() {

		final AddService addService = new AddService(new Pocket("consumerKey", "accessToken"));

		thrown.expect(IllegalArgumentException.class).hasMessageContaining("Article url");
		addService.with("   ");
	}

}
