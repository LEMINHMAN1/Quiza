package com.zet.web.access.model;

/**
 * 
 * @author man le
 *
 */
public class AccessModel {

	private Boolean success;
	private String name;
	private String email;
	private String timeSpam;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTimeSpam() {
		return timeSpam;
	}
	public void setTimeSpam(String timeSpam) {
		this.timeSpam = timeSpam;
	}
	
	
	
}
