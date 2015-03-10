package com.tyutyutyu.pocketjavaclient.communication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.jayway.restassured.response.Headers;

import org.junit.Test;

public class ResponseStatusExtractorTest {

	@SuppressWarnings("static-method")
	@Test
	public void shouldReturnOkStatus() {

		// Given
		final Headers headers = mock(Headers.class);
		when(headers.hasHeaderWithName("X-Error-Code")).thenReturn(false);

		// When
		final ResponseStatus status = ResponseStatusExtractor.getStatus(headers);

		// Then
		assertThat(status).isEqualTo(ResponseStatus.OK);
	}

	@SuppressWarnings("static-method")
	@Test
	public void shouldReturnCorrectErrorStatus() {

		// Given
		final Headers headers = mock(Headers.class);
		when(headers.hasHeaderWithName("X-Error-Code")).thenReturn(true);
		when(headers.getValue("X-Error-Code")).thenReturn("152");

		// When
		final ResponseStatus status = ResponseStatusExtractor.getStatus(headers);

		// Then
		assertThat(status).isEqualTo(ResponseStatus.INVALID_CONSUMER_KEY);
	}

}
