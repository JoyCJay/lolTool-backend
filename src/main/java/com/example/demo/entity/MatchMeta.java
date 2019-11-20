package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "match_meta")
public class MatchMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "match_id", nullable = false)
    private String gameId;
    @Column(name = "date")
    private Date date;
    @Column(name = "champion")
    private int champion;
    @Column(name = "duration")
    private String duration;
    @Column(name = "win_team")
    private String winTeam;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "account_id")
    private SummonerInfo summonerInfo;
}
