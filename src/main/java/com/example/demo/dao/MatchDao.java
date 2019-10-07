package com.example.demo.dao;

import com.example.demo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchDao extends JpaRepository<Match, Long> {

    @Query("from Match m where m.match_id=?1")
    List<Match> findMatchByMatch_id(Long match_id);
}
