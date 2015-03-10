package com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify;

import com.tyutyutyu.pocketjavaclient.communication.ResponseStatus;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractPocketResponse;

public class ModifyResponse extends AbstractPocketResponse {

	public ModifyResponse(ResponseStatus status) {

		super(status);
	}
}
