package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

public enum ArticleContentType {

	ARTICLE, VIDEO, IMAGE;

	@Override
	public String toString() {

		return name().toLowerCase();
	}
}
