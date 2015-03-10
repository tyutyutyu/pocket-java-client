package com.tyutyutyu.pocketjavaclient;

import com.google.gson.Gson;
import com.tyutyutyu.pocketjavaclient.communication.RequestSender;
import com.tyutyutyu.pocketjavaclient.communication.gson.GsonProducer;

class AbstractService {
	protected Pocket pocket;

	protected Gson gson;

	protected RequestSender requestSender;

	public AbstractService(Pocket pocket) {

		gson = GsonProducer.create();
		this.pocket = pocket;
		requestSender = new RequestSender();
	}
}
