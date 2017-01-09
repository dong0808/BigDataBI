package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.dao.BasicDataDao;
import com.hfut.zngl.entity.BasicData;
import org.hibernate.*;

import java.util.List;

/**
 * Created by 东东 on 2017/1/6.
 */
public class BasicDataDaoImpl implements BasicDataDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public Session currentSession(){
        return sessionFactory.openSession();
    }

    public List<BasicData> findAllByStationID(String stationID){

        Session session = null;
        List<BasicData> list = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from BasicData b where b.station_id = :stationID";
            Query query = session.createQuery(hsql);
            query.setParameter("stationID",stationID);
            list = (List<BasicData>)query.list();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;

    }

    public List<BasicData> findAllByIDAndDate(String stationID,String startDate,String endDate){

        Session session = null;
        List<BasicData> list = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from BasicData b where b.station_id = :stationID and b.observation_time between :firstDate and :secondDate";
            Query query = session.createQuery(hsql);
            query.setParameter("stationID",stationID);
            query.setParameter("firstDate",startDate);
            query.setParameter("secondDate",endDate);
            list = (List<BasicData>)query.list();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;

    }

}
