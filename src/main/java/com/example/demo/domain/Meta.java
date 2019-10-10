package com.example.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
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

    public Meta(JSONObject matchMetaJSON, String accountId){
        this.setGameId(matchMetaJSON.getString("gameId"));
        // this.setRole(match.getString("role"));
//        Long stamp = match.getLong("timestamp");
        this.setDate(matchMetaJSON.getDate("timestamp"));
        this.setChampion(matchMetaJSON.getIntValue("champion"));
        this.setAccountId(accountId);
//        this.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stamp));
    }
}