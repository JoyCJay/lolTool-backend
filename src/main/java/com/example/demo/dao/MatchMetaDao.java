package com.example.demo.dao;

import com.example.demo.entity.MatchMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MatchMetaDao extends JpaRepository<MatchMeta, String> {

//    @Modifying
//    @Transactional
//    @Query("delete from MatchMeta m where m.accountId=?1")
//    void deleteByAccountId(String accountId);
}
