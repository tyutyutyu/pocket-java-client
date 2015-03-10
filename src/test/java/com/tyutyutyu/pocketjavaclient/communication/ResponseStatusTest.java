package com.tyutyutyu.pocketjavaclient.communication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ResponseStatusTest {

	@SuppressWarnings("static-method")
	@Test
	public void shouldFindStatusByCode() {

		// When
		final ResponseStatus status = ResponseStatus.findByCode(138);

		// Then
		assertThat(status).isEqualTo(ResponseStatus.MISSING_CONSUMER_KEY);
	}

	@SuppressWarnings("static-method")
	@Test
	public void shouldReturnUnknownErrorStatus() {

		// When
		final ResponseStatus status = ResponseStatus.findByCode(Integer.MAX_VALUE);

		// Then
		assertThat(status).isEqualTo(ResponseStatus.UNKNOWN_ERROR);
	}

}
