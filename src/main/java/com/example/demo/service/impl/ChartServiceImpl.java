package com.example.demo.service.impl;

import com.example.demo.domain.KdaChartData;
import com.example.demo.domain.Match;
import com.example.demo.domain.Player;
import com.example.demo.service.ChartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    @Override
    public KdaChartData getKdaChartData(Match match) {
        KdaChartData kdaChartData = new KdaChartData();

        List<Object> bluePlayersKill = new ArrayList<>();
        List<Object> bluePlayersDeath = new ArrayList<>();
        List<Object> bluePlayersAssist = new ArrayList<>();
        List<Object> bluePlayersName = new ArrayList<>();

        int[] redPlayersKill = new int[5];
        int[] redPlayersDeath = new int[5];
        int[] redPlayersAssist = new int[5];
        String[] redPlayersName = new String[5];

        for(Player bluePlayer: match.getBluePlayers()){
            bluePlayersKill.add(1);
            bluePlayersDeath.add(2);
            bluePlayersAssist.add(3);
            bluePlayersName.add(bluePlayer.getSummonerName());
        }
        kdaChartData.getBlueTeam().put("kill", bluePlayersKill);
        kdaChartData.getBlueTeam().put("name", bluePlayersDeath);
        kdaChartData.getBlueTeam().put("name", bluePlayersAssist);
        kdaChartData.getBlueTeam().put("name", bluePlayersName);

        return kdaChartData;
    }

}
