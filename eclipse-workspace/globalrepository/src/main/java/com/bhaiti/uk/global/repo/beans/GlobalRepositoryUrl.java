package com.bhaiti.uk.global.repo.beans;

public class GlobalRepositoryUrl {
	
	public GlobalRepositoryUrl() {}
	
	public GlobalRepositoryUrl(String url, char isActive, char isApproved) {
		this.active = (isActive == 'Y') ? true : false;
		this.approved = (isApproved == 'Y') ? true : false;;
		this.url = url;
	}
	
	boolean active;
	boolean approved;
	String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url.strip();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
