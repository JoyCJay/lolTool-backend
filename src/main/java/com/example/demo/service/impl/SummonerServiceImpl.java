package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Summoner;
import com.example.demo.domain.Match;
import com.example.demo.domain.Meta;
import com.example.demo.domain.Player;
import com.example.demo.service.SummonerService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * summonerServiceImpl
 */
@Service
public class SummonerServiceImpl implements SummonerService {

    HttpURLConnection connection;
    @Value("${api-token}")
    private String APIToken;

    @Override
    public Summoner getSummonerByName(String name) throws IOException {
        JSONObject rawSummoner = getAPI("https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name);
        Summoner summoner = JSON.parseObject(rawSummoner.toString(), Summoner.class);
        return summoner;
    }

    @Override
    public ArrayList<Match> get5Games(String accoutId, int index) throws IOException {
        JSONObject rawMatchLists = getAPI("https://euw1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accoutId
        + "?endIndex=" + 5 * index + "&beginIndex=" + (5 * index - 5));
        ArrayList<Match> matchList = new ArrayList<Match>();
        JSONArray matchesMeta = rawMatchLists.getJSONArray("matches");
        for (Object matchMeta : matchesMeta) {
            JSONObject matchMetaJSON = JSON.parseObject(matchMeta.toString());
            Meta meta = new Meta(matchMetaJSON);

            // build Match
            Match game = new Match(meta);
            JSONObject raw = this.getRawMatch(meta.getGameId());
            game.setBluePlayers(getbluePlayers(raw)); // 100
            game.setRedPlayers(getRedPlayers(raw)); // 200
            game.getMeta().setDuration(raw.getIntValue("gameDuration")/60+" mins");
            game.getMeta().setWinTeam(winTeam(raw));;
            matchList.add(game);
        }
        return matchList;
    }

    private String winTeam(JSONObject raw) {
        String result;
        JSONObject blueTeamInfo =  (JSONObject)raw.getJSONArray("teams").get(0);
        String winContent = blueTeamInfo.getString("win");
        if (winContent.equals("Win")) {
            result = "Blue";
        } else {
            result = "Red";
        }
        return result;
    }

    private ArrayList<Player> getbluePlayers(JSONObject raw) {
        ArrayList<Player> bluePlayers = new ArrayList<>();
        JSONArray participantIdentities = raw.getJSONArray("participantIdentities");
        JSONArray participants = raw.getJSONArray("participants");
        for (int i = 0; i <= 4; i++) {
            JSONObject identities = (JSONObject)participantIdentities.get(i);
            JSONObject data = (JSONObject)participants.get(i);
            Player p = new Player(identities.getJSONObject("player"),data);
            bluePlayers.add(p);
        }
        return bluePlayers;
    }

    public ArrayList<Player> getRedPlayers(JSONObject raw) {
        ArrayList<Player> redPlayers = new ArrayList<>();
        JSONArray participantIdentities = raw.getJSONArray("participantIdentities");
        JSONArray participants = raw.getJSONArray("participants");
        for (int i = 5; i <= 9; i++) {
            JSONObject identities = (JSONObject)participantIdentities.get(i);
            JSONObject data = (JSONObject)participants.get(i);
            Player p = new Player(identities.getJSONObject("player"),data);
            redPlayers.add(p);
        }
        return redPlayers;
    }

    public JSONObject getRawMatch(String gameId) throws IOException {
        return  getAPI("https://euw1.api.riotgames.com/lol/match/v4/matches/"+gameId);
    }

    // timeout
    // restart if error
    // value boundary condition
    public JSONObject getAPI(String URL) throws IOException{
        URL url = new URL(URL);
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Riot-Token", this.APIToken);
        connection.setRequestProperty("Accept", "application/json");
        // response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        connection.disconnect();
        return JSON.parseObject(content.toString());
    }
}

