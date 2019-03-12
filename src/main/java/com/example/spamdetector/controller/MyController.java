package com.example.spamdetector.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spamdetector.bean.ResultBean;
import com.example.spamdetector.service.SpamDetectorService;

@RestController
@RequestMapping("/api")
public class MyController
{
    @Autowired
    SpamDetectorService service;


    @GetMapping("/search")
    public Map<String, ResultBean> queryData(@RequestParam("query") String msg)
    {
        return service.getDataByMsg(msg);
    }

}
