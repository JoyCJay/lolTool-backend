package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "summoner_info")
public class SummonerInfo {
    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;
    @Column(name = "summoner_name", nullable = false)
    private String summonerName;
    @Column(name = "summoner_level")
    private int summonerLevel;
    @Column(name = "revision_date")
    private Date revisionDate;

}
