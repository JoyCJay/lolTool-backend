package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.OnlineControlDto;
import com.example.demo.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DemoMapper;

@Service
public class DemoService {
	@Autowired
	DemoMapper mapper;
	
	public List<OnlineControlDto> getOnlineControl() {
		return mapper.getOnlineControl();
	}

	public void addOnlineControl(OnlineControlDto OCinformation) {
	    mapper.addOnlineControl(OCinformation);
    }

    public List<Match> getMatchInfo(String match_id){
		return mapper.getMatchInfo(match_id);
	}
}
