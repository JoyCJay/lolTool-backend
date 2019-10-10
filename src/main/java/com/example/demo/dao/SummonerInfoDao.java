package com.example.demo.dao;

import com.example.demo.entity.SummonerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerInfoDao extends JpaRepository<SummonerInfo, Long> {

    @Query("from SummonerInfo s where s.summonerName=?1")
    SummonerInfo findSummonerByName(String summonerName);

}
