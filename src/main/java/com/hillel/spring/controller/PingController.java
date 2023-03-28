package com.hillel.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ping")
public class PingController {

@RequestMapping("/")
    public String showPing() {
        return "ping";
    }

}
