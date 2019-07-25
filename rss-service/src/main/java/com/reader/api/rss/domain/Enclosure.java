package com.reader.api.rss.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="enclosure")
@XmlAccessorType(XmlAccessType.FIELD)
public class Enclosure {
	
	@XmlAttribute(name = "length")
	private String length;

	@XmlAttribute(name = "type")
	private String type;

	@XmlAttribute(name = "url")
	private String url;

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ClassPojo [length = " + length + ", type = " + type + ", url = " + url + "]";
	}
}
