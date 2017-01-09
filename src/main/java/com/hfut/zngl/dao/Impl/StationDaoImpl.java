package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.dao.StationDao;
import com.hfut.zngl.entity.Station;
import org.hibernate.*;

/**
 * Created by 东东 on 2017/1/6.
 */
public class StationDaoImpl implements StationDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public Session currentSession(){
        return sessionFactory.openSession();
    }

    public Station findById(String station_id){
        Session session = null;
        Station station = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from Station s where s.station_id = :station_id";
            Query query = session.createQuery(hsql);
            query.setParameter("station_id",station_id);
            station = (Station)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return station;

    };
    public Station findByName(String station_name){

        Session session = null;
        Station station = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from Station s where s.station_name = :station_name";
            Query query = session.createQuery(hsql);
            query.setParameter("station_name",station_name);
            station = (Station)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return station;

    };
}
