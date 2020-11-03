package com.behl.bookmark.app.entities;

import com.behl.bookmark.app.partner.Shareable;

public class WebLink extends Bookmark implements Shareable{
//	private long id;
//	private String title;
	private String url;
	private String host;

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if (url.contains("porn") || getTitle().contains("porn") || host.contains("adult")) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>WebLink</type>");
			builder.append("<type>title</type>").append(getTitle()).append("</title>");
			builder.append("<type>url</type>").append(url).append("</url>");
			builder.append("<type>host</type>").append(host).append("</host>");
		builder.append("<item>");
		
	return builder.toString();
	}


}
