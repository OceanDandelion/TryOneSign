package com.example.tryf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestController {
    @Autowired
    private HttpSession session;
    @GetMapping("/")
    public Object fhh(){

        if(session.getAttribute("user")==null){
            return "你没有登陆";
        }
        return "这是主界面";
    }

}
