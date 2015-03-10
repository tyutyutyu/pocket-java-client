package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractPocketResponse;

public class ArticleListingRootData extends AbstractPocketResponse {

	private int complete;

	private long since;

	public ArticleListingRootData() {

	}

	public int getComplete() {

		return complete;
	}

	public long getSince() {

		return since;
	}
}
