package com.example.demo.domain.chartData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DamageData {

    private int value;
    private String name;

    public DamageData(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @XmlElement
    public int getValue() {
        return value;
    }

    @XmlElement
    public String getName() {
        return name;
    }

}
