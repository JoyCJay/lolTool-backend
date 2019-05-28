package com.example.demo.service;

import com.example.demo.domain.Match;
import com.example.demo.domain.chartData.ChartData;
import com.example.demo.domain.chartData.DamageChartData;

public interface ChartService {
    ChartData getKdaChartData(Match match);
    DamageChartData getDamageChartData();
}
