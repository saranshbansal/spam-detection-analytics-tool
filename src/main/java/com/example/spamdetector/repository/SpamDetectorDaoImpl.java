package com.example.spamdetector.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.spamdetector.constants.ErrorCode;
import com.example.spamdetector.exceptions.DatabaseException;
import com.example.spamdetector.model.SpamDetector;

@Repository
public class SpamDetectorDaoImpl extends GenericDaoImpl<SpamDetector> implements SpamDetectorDao
{

    public SpamDetectorDaoImpl()
    {
        super(SpamDetector.class);
    }

    private static final String GET_SPAMS_BY_MSG = "select s FROM com.example.spamdetector.model.SpamDetector s where s.message like :msg";


    @Override
    public List<SpamDetector> getDataByMsg(String msg) throws DatabaseException
    {
        List<SpamDetector> results = new ArrayList<>();
        try
        {
            TypedQuery<SpamDetector> query = getEntityManager().createQuery(GET_SPAMS_BY_MSG, SpamDetector.class);
            query.setParameter("msg", "%" + msg + "%");
            results = query.getResultList();
        }
        catch (Exception ex)
        {
            throw new DatabaseException(ErrorCode.COMMON_DB_ERROR_CODE, ex.getMessage(), ex);
        }
        return results;
    }

}
