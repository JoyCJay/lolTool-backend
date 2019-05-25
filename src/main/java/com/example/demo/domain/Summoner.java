package com.example.demo.domain;

import lombok.Data;

@Data
public class Summoner {
	private String id; //encryptedSummonerId
	private String accountId;
	private String name;
	private int summonerLevel;
	private Long revisionDate;
	
	// not very useful properties
	private String puuid;
	private int profileIconId;

}

