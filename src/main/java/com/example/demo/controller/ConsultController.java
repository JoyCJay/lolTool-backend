package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Match;
import com.example.demo.domain.Summoner;
import com.example.demo.service.SummonerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * consultController
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consult")
public class ConsultController {

	private SummonerService summonerService;

	@Autowired
	ConsultController(SummonerService summonerService) {
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