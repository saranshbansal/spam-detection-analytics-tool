package com.example.spamdetector.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_table")
public class SpamDetector
{
    private int id;
    private String message;
    private String truth;
    private String cube;
    private String google;
    private String google_spam;
    private String google_not_spam;
    private String ibm;
    private String ibm_spam;
    private String ibm_not_spam;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }


    public void setId(int id)
    {
        this.id = id;
    }


    @Column
    public String getMessage()
    {
        return message;
    }


    public void setMessage(String message)
    {
        this.message = message.replace("\"", "");
    }


    public String getGoogle_not_spam()
    {
        return google_not_spam;
    }


    public void setGoogle_not_spam(String google_not_spam)
    {
        this.google_not_spam = google_not_spam.replace("\"", "");
    }


    @Column
    public String getTruth()
    {
        return truth;
    }


    public void setTruth(String truth)
    {
        this.truth = truth.replace("\"", "");
    }


    @Column
    public String getCube()
    {
        return cube;
    }


    public void setCube(String cube)
    {
        this.cube = cube.replace("\"", "");
    }


    @Column
    public String getGoogle()
    {
        return google;
    }


    public void setGoogle(String google)
    {
        this.google = google.replace("\"", "");
    }


    @Column
    public String getGoogle_spam()
    {
        return google_spam;
    }


    public void setGoogle_spam(String google_spam)
    {
        this.google_spam = google_spam.replace("\"", "");
    }


    @Column
    public String getIbm()
    {
        return ibm;
    }


    public void setIbm(String ibm)
    {
        this.ibm = ibm.replace("\"", "");
    }


    @Column
    public String getIbm_spam()
    {
        return ibm_spam;
    }


    public void setIbm_spam(String ibm_spam)
    {
        this.ibm_spam = ibm_spam.replace("\"", "");
    }


    @Column
    public String getIbm_not_spam()
    {
        return ibm_not_spam;
    }


    public void setIbm_not_spam(String ibm_not_spam)
    {
        this.ibm_not_spam = ibm_not_spam.replace("\"", "");
    }

}
