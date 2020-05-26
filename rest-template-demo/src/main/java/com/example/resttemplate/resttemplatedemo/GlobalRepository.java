package com.example.resttemplate.resttemplatedemo;

import java.util.List;

public class GlobalRepository {

	String siteName;
	List<GlobalRepositoryUrl> urls;
	
	
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public List<GlobalRepositoryUrl> getUrls() {
		return urls;
	}
	public void setUrls(List<GlobalRepositoryUrl> urls) {
		this.urls = urls;
	}
	
	
}
