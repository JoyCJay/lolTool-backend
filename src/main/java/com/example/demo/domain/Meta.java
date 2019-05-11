package com.example.demo.domain;

import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * matchMeta
 */
@Data
public class Meta {
    String gameId;
    // String role;
    String date;
    String druation;
    String winTeam;

    public Meta(JSONObject match){
        this.setGameId(match.getString("gameId"));
        // this.setRole(match.getString("role"));
        Long stamp = match.getLong("timestamp");
        this.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stamp));
    }
}