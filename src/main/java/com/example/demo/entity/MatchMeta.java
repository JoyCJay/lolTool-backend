package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "match_meta")
public class MatchMeta {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "match_id", nullable = false)
    private String gameId;
    @Column(name = "date")
    private Date date;
    @Column(name = "duration")
    private String duration;
    @Column(name = "win_team")
    private String winTeam;
}
