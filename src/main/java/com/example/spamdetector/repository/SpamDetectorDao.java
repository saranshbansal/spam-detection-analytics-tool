/**
 * 
 */
package com.example.spamdetector.repository;

import java.util.List;

import com.example.spamdetector.exceptions.DatabaseException;
import com.example.spamdetector.model.SpamDetector;

public interface SpamDetectorDao extends GenericDao<SpamDetector>
{

    List<SpamDetector> getDataByMsg(String msg) throws DatabaseException;

}
