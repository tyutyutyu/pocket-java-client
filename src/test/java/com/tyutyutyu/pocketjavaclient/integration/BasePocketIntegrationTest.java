package com.tyutyutyu.pocketjavaclient.integration;

import com.tyutyutyu.pocketjavaclient.Pocket;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.Article;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.ListArticlesResponse;

import org.junit.Before;

public class BasePocketIntegrationTest {

	Pocket pocket = new Pocket(IntegrationTestsConfig.get().getConsumerKey(), IntegrationTestsConfig.get().getAccessToken());

	@Before
	public void clear() {

		final ListArticlesResponse listArticlesResponse = pocket.listArticles().allOfThem();
		if (listArticlesResponse.hasArticles() == false) {
			return;
		}

		for (final Article article : listArticlesResponse.getList()) {
			pocket.modifyArticles().deleteArticle(article.getItemId());
		}

		if (pocket.listArticles().allOfThem().hasArticles()) {
			throw new RuntimeException("Unable to clear articles before test method");
		}
	}

}
