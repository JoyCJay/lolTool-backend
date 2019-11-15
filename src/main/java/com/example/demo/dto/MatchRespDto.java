package com.example.demo.dto;

import com.example.demo.domain.Meta;
import com.example.demo.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchRespDto {
    private Meta Meta;
    private List<Player> bluePlayers;
    private List<Player> redPlayers;
}
