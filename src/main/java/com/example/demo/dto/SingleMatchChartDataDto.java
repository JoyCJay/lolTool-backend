package com.example.demo.dto;

import com.example.demo.domain.chartData.ChartData;
import com.example.demo.domain.chartData.SingleMatchData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
public class SingleMatchChartDataDto extends ChartData {
    private List<SingleMatchData> blueTeam;
    private List<SingleMatchData> redTeam;

    public SingleMatchChartDataDto(List<SingleMatchData> blueTeam, List<SingleMatchData> redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;
    }
//
//    @XmlElement
//    public List<SingleMatchData> getBlueTeam() {
//        return blueTeam;
//    }
//
//    @XmlElement
//    public List<SingleMatchData> getRedTeam() {
//        return redTeam;
//    }

}
