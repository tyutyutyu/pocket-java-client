package com.tyutyutyu.pocketjavaclient;

import com.google.common.base.Preconditions;
import com.tyutyutyu.pocketjavaclient.communication.RawJsonResponse;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.ModifyRequest;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.ModifyResponse;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.actions.Action;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.actions.ArchiveAction;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.modify.actions.DeleteAction;

import org.joda.time.DateTime;

public class ModifyService extends AbstractService {

	public ModifyService(Pocket pocket) {

		super(pocket);
	}

	public ModifyResponse archiveArticle(Long articleId) {

		Preconditions.checkArgument(articleId != null, "ArticleId value can not be null");
		final Action archive = new ArchiveAction(articleId, DateTime.now());
		return sendModifyRequest(archive);
	}

	public ModifyResponse deleteArticle(Long articleId) {

		Preconditions.checkArgument(articleId != null, "ArticleId value can not be null");
		final Action archive = new DeleteAction(articleId, DateTime.now());
		return sendModifyRequest(archive);
	}

	private ModifyResponse sendModifyRequest(Action archive) {

		final ModifyRequest request = new ModifyRequest(pocket.getConsumerKey(), pocket.getAccessToken(), archive);

		final RawJsonResponse rawJsonResponse = requestSender.sendRequest(request, "https://getpocket.com/v3/send");

		if (rawJsonResponse.statusIsOk()) {
			final String json = rawJsonResponse.getResponse().get();
			System.out.println("response = " + json);
			return new ModifyResponse(rawJsonResponse.getStatus());
		} else {
			return new ModifyResponse(rawJsonResponse.getStatus());
		}
	}

}
