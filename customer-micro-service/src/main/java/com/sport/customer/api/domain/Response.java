package com.sport.customer.api.domain;

import java.util.List;

public class Response {

	private String message;
	private List<Campaign> campaigns;
	
	public Response(String message, List<Campaign> campaigns) {
		super();
		this.message = message;
		this.campaigns = campaigns;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}
	
}
