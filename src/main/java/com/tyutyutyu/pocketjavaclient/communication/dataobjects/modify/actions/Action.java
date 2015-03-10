package com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.actions;

import lombok.Data;

import org.joda.time.DateTime;

@Data
public abstract class Action {

	private final ActionType action;

	private final Long itemId;

	private final String time;

	protected Action(ActionType action, Long itemId, DateTime time) {

		this.action = action;
		this.itemId = itemId;
		this.time = String.valueOf(time.getMillis() / 100L);
	}

}
