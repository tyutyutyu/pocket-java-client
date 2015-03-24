package com.tyutyutyu.pocketjavaclient.communication.dataobjects;

import lombok.Data;

@Data
public abstract class AbstractArticle {

	private Long itemId;

	private Long resolvedId;

	private String resolvedUrl;

	private String excerpt;

	private Boolean isArticle;

	private Boolean hasImage;

	private Boolean hasVideo;

	private Long wordCount;

	// TODO Not yet implemented
	// private List authors;
	// private List images;
	// private List videos;

}
