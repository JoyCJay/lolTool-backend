package com.example.demo.controller;

import com.example.demo.domain.OnlineControlDto;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/control")
public class OnlineController {

    @Autowired
    DemoService demoService;

    @PostMapping("/online")
    public void onlineControl(@RequestBody OnlineControlDto OCinformation) {
        demoService.addOnlineControl(OCinformation);
    }
}
