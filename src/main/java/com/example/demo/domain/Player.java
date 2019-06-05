package com.example.demo.domain;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * Player
 */
@Data
public class Player {

	public Player(JSONObject id, JSONObject data) {
        // participantIdentities
        this.setSummonerName(id.getString("summonerName"));
        this.setAccountId(id.getString("accountId"));
        // participant
        JSONObject stats = data.getJSONObject("stats");
        this.setLane(data.getJSONObject("timeline").getString("lane"));
        this.setChampion(data.getString("championId")); //championId to championName
        this.setSpells(getSpellArray(data));
        this.setItems(getItemsArray(stats));
        this.setKda(stats.getString("kills") + "-" + stats.getString("deaths") + "-" + stats.getString("assists"));
        this.setLargestMultiKill(stats.getIntValue("largestMultiKill"));
        this.setTotalMinionsKilled(stats.getIntValue("totalMinionsKilled"));
        this.setTurretKills(stats.getIntValue("turretKills"));
        this.setGold(stats.getIntValue("goldSpent"));
        this.setDmg(stats.getIntValue("totalDamageDealtToChampions"));//totalDamageDealt
        this.setDmgTaken(stats.getIntValue("totalDamageTaken"));
        this.setVisionScore(stats.getIntValue("visionScore"));
	}
	String  summonerName;
    String accountId;

    String lane;
    String champion;
    int[] spells;
    int[] items;
    String kda;
    int largestMultiKill;
    int totalMinionsKilled;
    int turretKills;
    int gold;
    int dmg;
    int dmgTaken;
    int visionScore;

    int[] getSpellArray(JSONObject data){
        int[] result = {data.getIntValue("spell1Id"),data.getIntValue("spell2Id")};
        return result;
    }

    int[] getItemsArray(JSONObject stats){
        int[] result = new int[7];
        for (int i = 0; i < 7; i++) {
            result[i] = stats.getIntValue("item"+i);
        }
        return result;
    }
}