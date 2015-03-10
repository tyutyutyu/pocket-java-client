package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

public enum ArticleDetailType {

	SIMPLE, COMPLETE;

	@Override
	public String toString() {

		return name().toLowerCase();
	}
}
