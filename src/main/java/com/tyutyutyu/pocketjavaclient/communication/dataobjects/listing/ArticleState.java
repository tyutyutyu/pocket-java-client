package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

public enum ArticleState {

	UNREAD, ARCHIVE, ALL;

	@Override
	public String toString() {

		return name().toLowerCase();
	}
}
