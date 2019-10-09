package com.example.demo.service.impl;

import com.example.demo.dao.MatchInfoDao;
import com.example.demo.domain.chartData.SingleMatchData;
import com.example.demo.domain.Player;
import com.example.demo.dto.SingleMatchChartDataDto;
import com.example.demo.entity.Match;
import com.example.demo.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    private MatchInfoDao matchInfoDao;

//    @Override
//    public KdaChartData getKdaChartData(Long match_id) {
//
//        List<Match> matchList = matchDao.findMatchByMatch_id(match_id);
//
//        KdaChartData kdaChartData = new KdaChartData();
//
//        List<Object> bluePlayersKill = new ArrayList<>();
//        List<Object> bluePlayersDeath = new ArrayList<>();
//        List<Object> bluePlayersAssist = new ArrayList<>();
//        List<Object> bluePlayersName = new ArrayList<>();
//
//        int[] redPlayersKill = new int[5];
//        int[] redPlayersDeath = new int[5];
//        int[] redPlayersAssist = new int[5];
//        String[] redPlayersName = new String[5];
//
//        for(Player bluePlayer: match.getBluePlayers()){
//            bluePlayersKill.add(1);
//            bluePlayersDeath.add(2);
//            bluePlayersAssist.add(3);
//            bluePlayersName.add(bluePlayer.getSummonerName());
//        }
//        kdaChartData.getBlueTeam().put("kill", bluePlayersKill);
//        kdaChartData.getBlueTeam().put("name", bluePlayersDeath);
//        kdaChartData.getBlueTeam().put("name", bluePlayersAssist);
//        kdaChartData.getBlueTeam().put("name", bluePlayersName);
//
//        return kdaChartData;
//    }

    @Override
    public SingleMatchChartDataDto getSingleMatchChartData(Long match_id) {

        List<Match> matchList = matchInfoDao.findMatchByMatchId(match_id);

        int kill = 0;
        int death = 0;
        int assist = 0;
        for(Match m : matchList){
            String kda = m.getKda();
            String[] arr = kda.split("/");
            kill = Integer.parseInt(arr[0]);
            death = Integer.parseInt(arr[1]);
            assist = Integer.parseInt(arr[2]);
        }

        List<SingleMatchData> blueTeam = new ArrayList<>();
        for(Match m : matchList){
            if(m.getTeam().equals("blue")){
                blueTeam.add(new SingleMatchData(m.getSummonerName(), m.getDmg(), kill, death, assist, m.getGold()));
            }
        }
//        blueTeam.add(new DamageData(24370, "Valeera SQ"));
//        blueTeam.add(new DamageData(16215, "fanyizhe"));
//        blueTeam.add(new DamageData(18953, "JoyCJay"));
//        blueTeam.add(new DamageData(35284, "Tonyilian"));
//        blueTeam.add(new DamageData(22833, "Diane katy"));

        List<SingleMatchData> redTeam = new ArrayList<>();
        for(Match m : matchList){
            if(m.getTeam().equals("red")){
                redTeam.add(new SingleMatchData(m.getSummonerName(), m.getDmg(), kill, death, assist, m.getGold()));
            }
        }
//        redTeam.add(new DamageData(24914, "Tavile T1 CuBe"));
//        redTeam.add(new DamageData(31770, "FluffyMasterlein"));
//        redTeam.add(new DamageData(12282, "iMe Shamy"));
//        redTeam.add(new DamageData(35357, "Gintoki6sama"));
//        redTeam.add(new DamageData(21590, "SoA Bane"));

        return new SingleMatchChartDataDto(blueTeam, redTeam);
    }

}
