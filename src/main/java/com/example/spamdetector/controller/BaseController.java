package com.example.spamdetector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spamdetector.service.SpamDetectorService;

@RestController
@RequestMapping("/")
public class BaseController
{

    @Autowired
    SpamDetectorService service;


    @GetMapping
    public String sayHello()
    {
        return "It Works!!!";
    }

}
