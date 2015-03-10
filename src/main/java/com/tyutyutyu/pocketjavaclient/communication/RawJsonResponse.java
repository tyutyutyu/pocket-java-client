package com.tyutyutyu.pocketjavaclient.communication;

import com.google.common.base.Optional;

public class RawJsonResponse {

	private final ResponseStatus status;

	private final Optional<String> response;

	public static RawJsonResponse invalid(ResponseStatus status) {

		return new RawJsonResponse(status, Optional.<String> absent());
	}

	public static RawJsonResponse ok(String response) {

		return new RawJsonResponse(ResponseStatus.OK, Optional.of(response));
	}

	private RawJsonResponse(ResponseStatus status, Optional<String> response) {

		this.status = status;
		this.response = response;
	}

	public ResponseStatus getStatus() {

		return status;
	}

	public Optional<String> getResponse() {

		return response;
	}

	public boolean statusIsOk() {

		return ResponseStatus.OK == status;
	}
}
