package com.tyutyutyu.pocketjavaclient.integration;

import static com.tyutyutyu.pocketjavaclient.integration.ExampleLinks.ANGULARJS_STARTER;
import static com.tyutyutyu.pocketjavaclient.integration.ExampleLinks.GEB_REUSING_BROWSER;
import static org.assertj.core.api.Assertions.assertThat;

import com.tyutyutyu.pocketjavaclient.communication.dataobjects.add.AddArticleResponse;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.Article;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.ListArticlesResponse;

import org.junit.Ignore;
import org.junit.Test;

public class AddArticleITestIT extends BasePocketIntegrationTest {

	@Test
	public void shouldAddArticle() {

		// When
		final AddArticleResponse response = pocket.addArticle().with(ANGULARJS_STARTER);

		// Then
		assertThat(response.getStatus().isOk()).isTrue();

		final ListArticlesResponse listArticlesResponse = pocket.listArticles().allUnread();
		assertThat(listArticlesResponse.getList()).hasSize(1);

		final Article article = listArticlesResponse.getList().get(0);
		assertThat(article.getResolvedUrl()).isEqualTo(ANGULARJS_STARTER);
	}

	@Ignore
	@Test
	public void shouldAddArticleWithTitle() {

		// When
		final AddArticleResponse response = pocket.addArticle().with(GEB_REUSING_BROWSER, "Example title");

		// Then
		assertThat(response.getStatus().isOk()).isTrue();
		final ListArticlesResponse listArticlesResponse = pocket.listArticles().allUnread();

		assertThat(listArticlesResponse.getList()).hasSize(1);
		final Article article = listArticlesResponse.getList().get(0);
		assertThat(article.getResolvedUrl()).isEqualTo(GEB_REUSING_BROWSER);
		assertThat(article.getGivenTitle()).isEqualTo("Example title");
		assertThat(article.getResolvedTitle()).contains("Reusing browser");

	}

}
