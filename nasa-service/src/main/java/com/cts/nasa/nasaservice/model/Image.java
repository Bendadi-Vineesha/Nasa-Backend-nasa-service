package com.cts.nasa.nasaservice.model;

import java.util.Date;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

	@JsonProperty("copyright")
	private String copyright;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("explanation")
	private String explanation; 
	
	@JsonProperty("hdurl")
	private String hdurl;
	
	@JsonProperty("media_type")
	private String media_type;
	
	@JsonProperty("service_version")
	private String service_version;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("url")
	private String url;

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getHdurl() {
		return hdurl;
	}

	public void setHdurl(String hdurl) {
		this.hdurl = hdurl;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getService_version() {
		return service_version;
	}

	public void setService_version(String service_version) {
		this.service_version = service_version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
		
}
