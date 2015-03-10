package com.tyutyutyu.pocketjavaclient.parsers;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing.Article;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArticlesListFromJsonExtractor {

	private final Gson gson;

	public ArticlesListFromJsonExtractor(Gson gson) {

		this.gson = gson;
	}

	public List<Article> extractArticlesData(String jsonString) {

		final List<Integer> articlesStartIndexes = getArticlesStartIndexes(jsonString);
		final List<String> articleStrings = extractArticleStrings(jsonString, articlesStartIndexes);

		return convertToObjects(articleStrings);
	}

	static List<Integer> getArticlesStartIndexes(String jsonString) {

		final List<Integer> indexes = Lists.newArrayList();

		int currentIndex = -1;
		while (true) {
			currentIndex = jsonString.indexOf("{\"item_id\":", currentIndex + 1);

			if (currentIndex >= 0) {
				indexes.add(currentIndex);
			} else {
				break;
			}
		}

		return indexes;
	}

	static List<String> extractArticleStrings(String jsonString, List<Integer> articlesStartIndexes) {

		final List<String> articleStrings = Lists.newArrayList();

		for (int i = 0; i < articlesStartIndexes.size(); i++) {
			if (i < articlesStartIndexes.size() - 1) {
				final String articleWithSomeJunkAtEnd = jsonString.substring(articlesStartIndexes.get(i), articlesStartIndexes.get(i + 1));
				final String article = articleWithSomeJunkAtEnd.substring(0, articleWithSomeJunkAtEnd.lastIndexOf("}") + 1);
				articleStrings.add(article);
			} else {
				final String article = jsonString.substring(articlesStartIndexes.get(i), jsonString.lastIndexOf("}}") + 1);
				articleStrings.add(article);
			}
		}

		return articleStrings;
	}

	List<Article> convertToObjects(List<String> articleStrings) {

		final List<Article> articles = Lists.newArrayList();

		for (final String articleString : articleStrings) {
			log.trace("articleString: {}", articleString);
			articles.add(gson.fromJson(articleString, Article.class));
		}

		return articles;
	}

}
