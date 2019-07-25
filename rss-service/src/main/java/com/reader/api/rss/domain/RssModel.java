package com.reader.api.rss.domain;

public class RssModel {
	private Rss rss;

	public Rss getRss() {
		return rss;
	}

	public void setRss(Rss rss) {
		this.rss = rss;
	}

	@Override
	public String toString() {
		return "ClassPojo [rss = " + rss + "]";
	}
}