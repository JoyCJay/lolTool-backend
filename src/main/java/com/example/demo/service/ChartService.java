package com.example.demo.service;

import com.example.demo.domain.Match;
import com.example.demo.domain.chartData.ChartData;
import com.example.demo.dto.SingleMatchChartDataDto;

public interface ChartService {
    SingleMatchChartDataDto getSingleMatchChartData(Long match_id);
}
