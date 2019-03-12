package com.example.spamdetector.controller;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spamdetector.service.SpamDetectorService;
import com.opencsv.CSVReader;

@RestController
@RequestMapping("/api")
public class BaseController
{

    @Autowired
    SpamDetectorService service;


    @GetMapping
    public String sayHello()
    {
        return "It Works!!!";
    }


    @GetMapping("/readcsv")
    public String readCsv() throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader("cunique.csv"), ',', '\'', 1);

        String[] nextLine;
        String[] data = null;
        int count = 0;
        while ((nextLine = reader.readNext()) != null)
        {
            data = nextLine[0].split(";");
            service.createRecords(data);
            count++;
        }

        reader.close();

        return "Successfuly read...";
    }
}
