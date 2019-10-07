package com.example.demo.domain.chartData;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
//@XmlRootElement
public class SingleMatchData {

    private String name;
    private int dmg;
    private String kda;

    public SingleMatchData(String name, int dmg, String kda) {
        this.dmg = dmg;
        this.name = name;
        this.kda = kda;
    }

//    @XmlElement
//    public int getDmg() {
//        return dmg;
//    }
//
//    @XmlElement
//    public String getName() {
//        return name;
//    }

}
