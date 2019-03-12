package com.example.spamdetector.bean;

public class ResultBean
{
    int spam;
    int notSpam;
    double avgSpamProb;
    double avgNotSpamProb;


    public ResultBean(int spam, double avgSpamProb, int total)
    {
        this.spam = spam;
        this.notSpam = total - spam;
        if (avgSpamProb != 0.0)
        {
            this.avgSpamProb = avgSpamProb / total;
            this.avgNotSpamProb = 1 - this.avgSpamProb;
        }

    }


    public int getSpam()
    {
        return spam;
    }


    public void setSpam(int spam)
    {
        this.spam = spam;
    }


    public int getNotSpam()
    {
        return notSpam;
    }


    public void setNotSpam(int notSpam)
    {
        this.notSpam = notSpam;
    }


    public double getAvgSpamProb()
    {
        return avgSpamProb;
    }


    public void setAvgSpamProb(double avgSpamProb)
    {
        this.avgSpamProb = avgSpamProb;
    }


    public double getAvgNotSpamProb()
    {
        return avgNotSpamProb;
    }


    public void setAvgNotSpamProb(double avgNotSpamProb)
    {
        this.avgNotSpamProb = avgNotSpamProb;
    }


    @Override
    public String toString()
    {
        return "ResultBean [spam=" + spam + ", notSpam=" + notSpam + ", avgSpamProb=" + avgSpamProb + ", avgNotSpamProb=" + avgNotSpamProb + "]";
    }

}
