package com.tyutyutyu.pocketjavaclient.communication.dataobjects.listing;

import com.tyutyutyu.pocketjavaclient.communication.dataobjects.AbstractArticle;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends AbstractArticle {

	private String givenUrl;

	private String givenTitle;

	private String resolvedTitle;

	private Boolean favorite;

	private Integer status;

}
