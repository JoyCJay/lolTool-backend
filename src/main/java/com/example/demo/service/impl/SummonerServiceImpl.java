package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.MatchInfoDao;
import com.example.demo.dao.MatchMetaDao;
import com.example.demo.dao.SummonerInfoDao;
import com.example.demo.domain.Summoner;
import com.example.demo.domain.Match;
import com.example.demo.domain.Meta;
import com.example.demo.domain.Player;
import com.example.demo.dto.MatchRespDto;
import com.example.demo.dto.SummonerInfoRespDto;
import com.example.demo.entity.MatchInfo;
import com.example.demo.entity.MatchInfoId;
import com.example.demo.entity.MatchMeta;
import com.example.demo.entity.SummonerInfo;
import com.example.demo.service.SummonerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * summonerServiceImpl
 */
@Service
public class SummonerServiceImpl implements SummonerService {

    @Value("${api-token}")
    private String APIToken;

    @Autowired
    private SummonerInfoDao summonerInfoDao;
    @Autowired
    private MatchMetaDao matchMetaDao;
    @Autowired
    private MatchInfoDao matchInfoDao;

    @Override
    public SummonerInfoRespDto getSummonerByName(String summonerName) {
        //find summonerInfo from database firstly
        SummonerInfo summonerInfo = summonerInfoDao.findSummonerByName(summonerName);
        SummonerInfoRespDto summonerInfoRespDto = new SummonerInfoRespDto();
        //if summonerInfo exists in database
        if(summonerInfo != null){
            BeanUtils.copyProperties(summonerInfo, summonerInfoRespDto);
        }
        //if not
        else{
            JSONObject rawSummoner = null;
            try {
                rawSummoner = getAPI("https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (rawSummoner != null) {
                summonerInfoRespDto.setAccountId(rawSummoner.getString("accountId"));
                summonerInfoRespDto.setSummonerName(rawSummoner.getString("name"));
                summonerInfoRespDto.setSummonerLevel(rawSummoner.getIntValue("summonerLevel"));
                summonerInfoRespDto.setRevisionDate(rawSummoner.getTimestamp("revisionDate"));
                BeanUtils.copyProperties(rawSummoner, summonerInfoRespDto);
            }
            //insert into database, table summoner_info
            putSummonerInfo(new SummonerInfo(), rawSummoner);
        }
        return summonerInfoRespDto;
    }

    private void putSummonerInfo(SummonerInfo summonerInfo, JSONObject rawSummoner) {
        summonerInfo.setAccountId(rawSummoner.getString("accountId"));
        summonerInfo.setSummonerName(rawSummoner.getString("name"));
        summonerInfo.setSummonerLevel(rawSummoner.getIntValue("summonerLevel"));
        summonerInfo.setRevisionDate(rawSummoner.getTimestamp("revisionDate"));
        summonerInfoDao.save(summonerInfo);
    }

    @Override
    public List<MatchRespDto> getMathes(String accountId, int index) throws IOException{

        JSONObject rawMatchLists = getAPI("https://euw1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId
        + "?endIndex=" + 5 * index + "&beginIndex=" + (5 * index - 5));

        List<MatchRespDto> matchList = new ArrayList<>();
        JSONArray matchesMeta = rawMatchLists.getJSONArray("matches");

        for (Object matchMeta : matchesMeta) {
            JSONObject matchMetaJSON = JSON.parseObject(matchMeta.toString());
            //create meta
            Meta meta = new Meta(matchMetaJSON, accountId);
            //get info of a single match
            JSONObject singleMatchInfo = getAPI("https://euw1.api.riotgames.com/lol/match/v4/matches/"+meta.getGameId());
            meta.setWinTeam(winTeam(singleMatchInfo));
            meta.setDuration(singleMatchInfo.getIntValue("gameDuration")/60+" mins");
            //update table match_meta in database
            putMatchMeta(new MatchMeta(), meta);

            // build Match
            MatchRespDto matchRespDto = new MatchRespDto();
            matchRespDto.setMeta(meta);

            //get info of two teams' players
            List<Player> bluePlayer = getBluePlayers(singleMatchInfo);
            List<Player> redPlayer = getRedPlayers(singleMatchInfo);

            matchRespDto.setBluePlayers(bluePlayer); // 100
            matchRespDto.setRedPlayers(redPlayer); // 200

            //update table match_info in database
            putMatchInfo(new MatchInfo(), new MatchInfoId(), singleMatchInfo, bluePlayer, redPlayer);

            matchList.add(matchRespDto);
        }
        return matchList;
    }

    private void putMatchMeta(MatchMeta matchMeta, Meta meta){
//        BeanUtils.copyProperties(matchMeta, meta);
        matchMeta.setGameId(meta.getGameId());
        matchMeta.setDate(meta.getDate());
        matchMeta.setDuration(meta.getDuration());
        matchMeta.setWinTeam(meta.getWinTeam());
        matchMeta.setChampion(meta.getChampion());
        matchMeta.setAccountId(meta.getAccountId());
        matchMetaDao.save(matchMeta);
    }

    private void putMatchInfo(MatchInfo matchInfo, MatchInfoId matchInfoId, JSONObject singleMatchInfo, List<Player> bluePlayer, List<Player> redPlayer){
        for(Player p : bluePlayer){
            matchInfoId.setMatchId(singleMatchInfo.getString("gameId"));
            matchInfoId.setAccountId(p.getAccountId());
            matchInfo.setId(matchInfoId);
            matchInfo.setDmg(p.getDmg());
            matchInfo.setChampion(p.getChampion());
            matchInfo.setGold(p.getGold());
            matchInfo.setKda(p.getKda());
            matchInfo.setSummonerName(p.getSummonerName());
            matchInfo.setTeam("blue");
            matchInfoDao.save(matchInfo);
        }
        for(Player p : redPlayer){
            matchInfoId.setMatchId(singleMatchInfo.getString("gameId"));
            matchInfoId.setAccountId(p.getAccountId());
            matchInfo.setId(matchInfoId);
            matchInfo.setDmg(p.getDmg());
            matchInfo.setChampion(p.getChampion());
            matchInfo.setGold(p.getGold());
            matchInfo.setKda(p.getKda());
            matchInfo.setSummonerName(p.getSummonerName());
            matchInfo.setTeam("red");
            matchInfoDao.save(matchInfo);
        }
    }

    //scheduled task
    private void scheduledTasks(){

    }

    private String winTeam(JSONObject singleMatchInfo) {
        String result;
        JSONObject blueTeamInfo =  (JSONObject)singleMatchInfo.getJSONArray("teams").get(0);
        String winContent = blueTeamInfo.getString("win");
        if (winContent.equals("Win")) {
            result = "Blue";
        } else {
            result = "Red";
        }
        return result;
    }

    private List<Player> getBluePlayers(JSONObject singleMatchInfo) {
        List<Player> bluePlayers = new ArrayList<>();
        JSONArray participantIdentities = singleMatchInfo.getJSONArray("participantIdentities");
        JSONArray participants = singleMatchInfo.getJSONArray("participants");
        for (int i = 0; i <= 4; i++) {
            JSONObject identities = (JSONObject)participantIdentities.get(i);
            JSONObject data = (JSONObject)participants.get(i);
            Player p = new Player(identities.getJSONObject("player"),data);
            bluePlayers.add(p);
        }
        return bluePlayers;
    }

    private List<Player> getRedPlayers(JSONObject singleMatchInfo) {
        List<Player> redPlayers = new ArrayList<>();
        JSONArray participantIdentities = singleMatchInfo.getJSONArray("participantIdentities");
        JSONArray participants = singleMatchInfo.getJSONArray("participants");
        for (int i = 5; i <= 9; i++) {
            JSONObject identities = (JSONObject)participantIdentities.get(i);
            JSONObject data = (JSONObject)participants.get(i);
            Player p = new Player(identities.getJSONObject("player"),data);
            redPlayers.add(p);
        }
        return redPlayers;
    }

//    private JSONObject getRawMatch(String gameId) throws IOException {
//        return  getAPI("https://euw1.api.riotgames.com/lol/match/v4/matches/"+gameId);
//    }

    // timeout
    // restart if error
    // value boundary condition
    private JSONObject getAPI(String URL) throws IOException{
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Riot-Token", this.APIToken);
        connection.setRequestProperty("Accept", "application/json");
        // response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        connection.disconnect();
        return JSON.parseObject(content.toString());
    }
}

