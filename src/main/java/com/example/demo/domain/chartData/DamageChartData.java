package com.example.demo.domain.chartData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class DamageChartData extends ChartData {
    private ArrayList<DamageData> blueTeam;
    private ArrayList<DamageData> redTeam;

    public DamageChartData(ArrayList<DamageData> blueTeam, ArrayList<DamageData> redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;
    }

    @XmlElement
    public ArrayList<DamageData> getBlueTeam() {
        return blueTeam;
    }

    @XmlElement
    public ArrayList<DamageData> getRedTeam() {
        return redTeam;
    }

}
