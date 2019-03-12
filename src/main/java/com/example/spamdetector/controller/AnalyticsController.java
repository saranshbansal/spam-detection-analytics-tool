package com.example.spamdetector.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spamdetector.bean.ResultBean;
import com.example.spamdetector.service.SpamDetectorService;
import com.opencsv.CSVReader;

@RestController
@RequestMapping("/api")
public class AnalyticsController
{
    @Autowired
    SpamDetectorService service;


    @GetMapping("/read-csv")
    public String readCsv() throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader("cunique.csv"), ',', '\'', 1);

        String[] nextLine;
        String[] data = null;
        int count = 0;
        while ((nextLine = reader.readNext()) != null) // && count < 1000 (for part reading csv and save time)
        {
            data = nextLine[0].split(";");
            service.createRecords(data);
            count++;
        }

        reader.close();

        return "Successfuly read...";
    }


    @GetMapping("/estimate")
    public Map<String, ResultBean> queryData(@RequestParam("key") String msg)
    {
        return service.getDataByMsg(msg);
    }

}
