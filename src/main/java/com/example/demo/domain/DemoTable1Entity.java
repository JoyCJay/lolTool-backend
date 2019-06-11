package com.example.demo.domain;

public class DemoTable1Entity {
	private String email;
	private String summonerName;
	private String timeInterval;
	
	public DemoTable1Entity() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String toString() {
		return "demoId=" + email + "," + "name=" + summonerName;
	}
}
