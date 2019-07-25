package com.reader.api.rss.domain;

import java.util.List;

public class Channel {
	private Image image;

	private String copyright;

	private List<Item> item;

	private String link;

	private String description;

	private String language;

	private String title;

	private String pubDate;

	private String webMaster;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

	@Override
	public String toString() {
		return "Channel [image=" + image + ", copyright=" + copyright + ", link=" + link + ", description="
				+ description + ", language=" + language + ", title=" + title + ", pubDate=" + pubDate + ", webMaster="
				+ webMaster + "]";
	}

}
