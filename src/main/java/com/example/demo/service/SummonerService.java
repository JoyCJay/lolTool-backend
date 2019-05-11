package com.example.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.example.demo.domain.Match;
import com.example.demo.domain.Summoner;

/**
 * summonerService
 */
public interface SummonerService {

    Summoner getSummonerByName(String name) throws MalformedURLException, IOException;

    ArrayList<Match> get5Games(String accountId, int index) throws MalformedURLException, IOException;
}