package com.example.demo.domain.chartData;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
//@XmlRootElement
public class SingleMatchData {

    private String name;
    private int dmg;
    private int kill;
    private int death;
    private int assist;
    private int gold;

    public SingleMatchData(String name, int dmg, int kill, int death, int assist, int gold) {
        this.name = name;
        this.dmg = dmg;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
        this.gold = gold;
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
