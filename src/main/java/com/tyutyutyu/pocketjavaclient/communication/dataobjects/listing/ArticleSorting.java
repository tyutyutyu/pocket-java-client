package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

public enum ArticleSorting {

	NEWEST, OLDEST, TITLE, SITE;

	@Override
	public String toString() {

		return name().toLowerCase();
	}
}
