package com.example.demo.service.impl;

import com.example.demo.domain.chartData.DamageChartData;
import com.example.demo.domain.chartData.DamageData;
import com.example.demo.domain.chartData.KdaChartData;
import com.example.demo.domain.Match;
import com.example.demo.domain.Player;
import com.example.demo.service.ChartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public DamageChartData getDamageChartData() {

        ArrayList<DamageData> blueTeam = new ArrayList<>();
        blueTeam.add(new DamageData(24370, "Valeera SQ"));
        blueTeam.add(new DamageData(16215, "fanyizhe"));
        blueTeam.add(new DamageData(18953, "JoyCJay"));
        blueTeam.add(new DamageData(35284, "Tonyilian"));
        blueTeam.add(new DamageData(22833, "Diane katy"));

        ArrayList<DamageData> redTeam = new ArrayList<>();
        redTeam.add(new DamageData(24914, "Tavile T1 CuBe"));
        redTeam.add(new DamageData(31770, "FluffyMasterlein"));
        redTeam.add(new DamageData(12282, "iMe Shamy"));
        redTeam.add(new DamageData(35357, "Gintoki6sama"));
        redTeam.add(new DamageData(21590, "SoA Bane"));

        return new DamageChartData(blueTeam, redTeam);

    }

}
