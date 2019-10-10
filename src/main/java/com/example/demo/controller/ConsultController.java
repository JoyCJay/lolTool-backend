package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Match;
import com.example.demo.domain.Summoner;
import com.example.demo.service.ChartService;
import com.example.demo.service.SummonerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * consultController
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consult")
public class ConsultController {

	private SummonerService summonerService;
	private ChartService chartService;

	@Autowired
	ConsultController(SummonerService summonerService, ChartService chartService) {
	    this.summonerService = summonerService;
	    this.chartService = chartService;
	}

	@GetMapping(value = "/summonerInfo/{summonerName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getSummonerInfo(@PathVariable String summonerName) {
		return summonerService.getSummonerByName(summonerName);
	}

	@GetMapping(value = "/matches/{accountId}/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getMatches(@PathVariable String accountId, @PathVariable int index) throws MalformedURLException, IOException {
		return summonerService.getMathes(accountId, index);
	}

    @GetMapping(value = "/singleMatchChartsData/{match_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getDamageChartJson(@PathVariable Long match_id) {
	    return chartService.getSingleMatchChartData(match_id);
    }

//    @GetMapping(value = "/chartsData/damage/{matchId}", produces = MediaType.APPLICATION_XML_VALUE)
//    public Object getDamageChartXml() {
//        return chartService.getDmgChartData();
//    }
}