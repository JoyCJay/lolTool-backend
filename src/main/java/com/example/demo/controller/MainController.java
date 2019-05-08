package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.*;
import com.example.demo.service.DemoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/getDemo")
	public List<DemoTable1Entity> getAllDemoTable1Entity() {
		return demoService.getAllDemoTable1Entity();
	}
	
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
}
