package com.example.demo.dao;

import com.example.demo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchInfoDao extends JpaRepository<Match, Long> {

    @Query("from Match m where m.matchId=?1")
    List<Match> findMatchByMatchId(Long match_id);
}
