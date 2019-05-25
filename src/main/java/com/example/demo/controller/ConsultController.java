package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Match;
import com.example.demo.domain.Summoner;
import com.example.demo.service.SummonerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * consultController
 */

@RestController
@RequestMapping("/consult")
public class consultController {

	private SummonerService summonerService;

	@Autowired
	consultController(SummonerService summonerService) {
		this.summonerService = summonerService;
	}

	@GetMapping("/getSummoner")
	public String getSummoner(@RequestParam String summonerName) throws IOException {
		Summoner summoner = this.summonerService.getSummonerByName(summonerName);
		return JSON.toJSONString(summoner);
	}

	@GetMapping("/getMatches")
	public ArrayList<Match> getMatches(@RequestParam String accountId, @RequestParam int index) throws MalformedURLException, IOException {
		return summonerService.get5Games(accountId,index);
	}
}