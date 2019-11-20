package com.example.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.SummonerInfo;
import lombok.Data;

/**
 * matchMeta
 */
@Data
public class Meta {
    String gameId;
    // String role;
    Date date;
    int champion;
    String duration;
    String winTeam;
    String accountId;
    SummonerInfo summonerInfo;

    public Meta(JSONObject matchMetaJSON, String accountId, SummonerInfo summonerInfo){
        this.setGameId(matchMetaJSON.getString("gameId"));
        // this.setRole(match.getString("role"));
//        Long stamp = match.getLong("timestamp");
        this.setDate(matchMetaJSON.getDate("timestamp"));
        this.setChampion(matchMetaJSON.getIntValue("champion"));
        this.setAccountId(accountId);
        this.setSummonerInfo(summonerInfo);
//        this.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stamp));
    }
}