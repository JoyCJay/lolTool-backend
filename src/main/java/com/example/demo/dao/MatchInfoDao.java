package com.example.demo.dao;

import com.example.demo.entity.MatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchInfoDao extends JpaRepository<MatchInfo, String> {

    @Query("from MatchInfo m where m.id.matchId=?1")
    List<MatchInfo> findMatchByMatchId(String match_id);
}
