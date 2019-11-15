package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.utils.MessageUtils;

@RestController
@CrossOrigin(origins = "*")
public class MainController {

	
//	@RequestMapping("/getDemo")
//	public List<OnlineControlDto> getAllDemoTable1Entity() {
//		return demoService.getOnlineControl();
//	}
	
	@RequestMapping("/getProp")
	public String getProp() {
		NeoProperties np = new NeoProperties();
		np.setTitle("title");
		return np.getTitle();
	}

	@RequestMapping("/ping")
	public String test() {
		return "pong!";
	}

	@RequestMapping("/i18n")
	public String i18n() {
		return MessageUtils.get("user.title");
	}
}
