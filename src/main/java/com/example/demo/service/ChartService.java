package com.example.demo.service;

import com.example.demo.dto.SingleMatchChartDataDto;

public interface ChartService {
    SingleMatchChartDataDto getSingleMatchChartData(String match_id);
}
