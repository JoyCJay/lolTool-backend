package com.example.demo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SummonerInfoRespDto {
//    private Long id;
    private String accountId;
    private String summonerName;
    private int summonerLevel;
    @JSONField(format = "yyyy-MM-dd")
    private Date revisionDate;
}