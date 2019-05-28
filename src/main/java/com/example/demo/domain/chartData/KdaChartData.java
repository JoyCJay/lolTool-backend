package com.example.demo.domain.chartData;

import java.util.HashMap;
import java.util.List;

public class KdaChartData extends ChartData {
    HashMap<String, List<Object>> blueTeam = new HashMap<>();
    HashMap<String, List<Object>> redTeam = new HashMap<>();

    public HashMap<String, List<Object>> getBlueTeam() {
        return blueTeam;
    }

    public HashMap<String, List<Object>> getRedTeam() {
        return redTeam;
    }
}
