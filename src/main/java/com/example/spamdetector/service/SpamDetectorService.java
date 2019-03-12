package com.example.spamdetector.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spamdetector.bean.ResultBean;
import com.example.spamdetector.model.SpamDetector;
import com.example.spamdetector.repository.BaseRepository;
import com.example.spamdetector.repository.SpamDetectorDao;

@Service
public class SpamDetectorService
{
    @Autowired
    BaseRepository spamRepository;

    @Autowired
    SpamDetectorDao dao;


    @Transactional(readOnly = false)
    public void createRecords(String[] data)
    {
        SpamDetector spamDetector = new SpamDetector();
        try
        {
            if (null != data && data.length > 0)
            {
                spamDetector.setMessage(data[1]);
                spamDetector.setTruth(data[4]);
                spamDetector.setCube(data[5]);
                spamDetector.setGoogle(data[6]);
                spamDetector.setGoogle_spam(data[7]);
                spamDetector.setGoogle_not_spam(data[8]);
                spamDetector.setIbm(data[9]);
                spamDetector.setIbm_spam(data[10]);
                spamDetector.setIbm_not_spam(data[11]);
                spamRepository.save(spamDetector);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public Map<String, ResultBean> getDataByMsg(String key)
    {
        try
        {
            if (key.matches("[A-Za-z0-9]+"))
            {
                return createResultMap(dao.getDataByMsg(key));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    private Map<String, ResultBean> createResultMap(List<SpamDetector> results)
    {
        Map<String, ResultBean> resultMap = new HashMap<>();
        int cubeS = 0;
        int googleS = 0;
        int ibmS = 0;
        int truthS = 0;

        double googleAvgPrcntg = 0.0d;
        double ibmSAvgPrcntg = 0.0d;
        for (SpamDetector row : results)
        {
            if (row.getCube().equals("spam"))
            {
                ++cubeS;
            }
            if (row.getGoogle().equals("spam"))
            {
                ++googleS;
                if (null != row.getGoogle_spam())
                {
                    googleAvgPrcntg = googleAvgPrcntg + Double.parseDouble(row.getGoogle_spam());
                }
            }
            if (row.getIbm().equals("spam"))
            {
                ++ibmS;
                if (null != row.getGoogle_spam())
                {
                    ibmSAvgPrcntg = ibmSAvgPrcntg + Double.parseDouble(row.getIbm_spam());
                }
            }

            if (row.getTruth().equals("spam"))
            {
                ++truthS;
            }
        }
        resultMap.put("CUBE", new ResultBean(cubeS, 0.0, results.size()));
        resultMap.put("IBM", new ResultBean(ibmS, ibmSAvgPrcntg, results.size()));
        resultMap.put("GOOGLE", new ResultBean(googleS, googleAvgPrcntg, results.size()));
        resultMap.put("TRUTH", new ResultBean(truthS, 0.0, results.size()));

        return resultMap;
    }

}
