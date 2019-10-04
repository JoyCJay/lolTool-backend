package com.example.demo.domain.chartData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DamageData {

    private int dmg;
    private String name;

    public DamageData(int dmg, String name) {
        this.dmg = dmg;
        this.name = name;
    }

    @XmlElement
    public int getDmg() {
        return dmg;
    }

    @XmlElement
    public String getName() {
        return name;
    }

}
