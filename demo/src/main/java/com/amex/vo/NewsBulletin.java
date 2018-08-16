package com.amex.vo;

public class NewsBulletin {
	int id;
	String headLine;
	String url;
	String publisher;
	String pubUrl;
	String character;
	String exponent;

	public NewsBulletin() {

	}

	public NewsBulletin(String headLine, String url, String publisher, String pubUrl, String character,
			String exponent) {
		super();
		this.headLine = headLine;
		this.url = url;
		this.publisher = publisher;
		this.pubUrl = pubUrl;
		this.character = character;
		this.exponent = exponent;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubUrl() {
		return pubUrl;
	}

	public void setPubUrl(String pubUrl) {
		this.pubUrl = pubUrl;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getExponent() {
		return exponent;
	}

	public void setExponent(String exponent) {
		this.exponent = exponent;
	}

}
