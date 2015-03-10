package com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.actions;

import org.joda.time.DateTime;

public class ArchiveAction extends Action {

	public ArchiveAction(Long itemId, DateTime time) {

		super(ActionType.ARCHIVE, itemId, time);
	}

}
