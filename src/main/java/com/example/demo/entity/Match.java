package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "match_info")
public class Match {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "account_id", nullable = false)
    private String accountId;
    @Column(name = "match_id", nullable = false)
    private Long matchId;
    @Column(name = "summoner_name", nullable = false)
    private String summonerName;
    @Column(name = "team", nullable = false)
    private String team;
    @Column(name = "champion")
    private String champion;
    @Column(name = "dmg")
    private int dmg;
    @Column(name = "kda")
    private String kda;
    @Column(name = "gold")
    private int gold;

}
