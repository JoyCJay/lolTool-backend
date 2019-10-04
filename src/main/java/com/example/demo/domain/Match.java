package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Match
 */
@Data
public class Match {
    public Match(com.example.demo.domain.Meta meta2) {
        this.Meta = meta2;
	}
	Meta Meta;
    List<Player> bluePlayers;
    List<Player> redPlayers;
}