package com.example.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.example.demo.dto.MatchRespDto;
import com.example.demo.dto.SummonerInfoRespDto;

/**
 * summonerService
 */
public interface SummonerService {

    SummonerInfoRespDto getSummonerByName(String name);

    List<MatchRespDto> getMathes(String accountId, int index) throws MalformedURLException, IOException;
}