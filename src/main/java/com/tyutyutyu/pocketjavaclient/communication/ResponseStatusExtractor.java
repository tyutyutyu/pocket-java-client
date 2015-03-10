package com.tyutyutyu.pocketjavaclient.communication;

import com.jayway.restassured.response.Headers;

public class ResponseStatusExtractor {

	public static ResponseStatus getStatus(Headers headers) {

		final boolean hasErrorCode = headers.hasHeaderWithName("X-Error-Code");

		// TODO
		// X-Limit-User-Limit: Current rate final limit enforced per user
		// X-Limit-User-Remaining: Number of final calls remaining before hitting user's rate limit
		// X-Limit-User-Reset: Seconds until user's rate limit resets
		// X-Limit-Key-Limit: Current rate limit enforced per consumer key
		// X-Limit-Key-Remaining: Number of calls remaining before hitting consumer key's rate limit
		// X-Limit-Key-Reset: Seconds until consumer key rate limit resets

		if (hasErrorCode == false) {
			return ResponseStatus.OK;
		} else {
			final String errorCode = headers.getValue("X-Error-Code");
			return ResponseStatus.findByCode(Integer.valueOf(errorCode));
		}
	}
}
