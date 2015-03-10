package com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify;

import com.google.common.collect.Lists;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractPocketRequest;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.actions.Action;

import java.util.List;

public class ModifyRequest extends AbstractPocketRequest {

	private final List<Action> actions = Lists.newArrayList();

	public ModifyRequest(String consumerKey, String accessToken, Action action) {

		super(consumerKey, accessToken);
		actions.add(action);
	}

	public ModifyRequest withAction(Action action) {

		actions.add(action);
		return this;
	}
}
