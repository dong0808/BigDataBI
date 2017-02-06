package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.dao.WaterTableDao;
import com.hfut.zngl.entity.WaterTable;
import com.hfut.zngl.entity.WaterTableID;
import org.hibernate.*;

import java.util.List;

/**
 * Created by 东东 on 2017/2/4.
 */
public class WaterTableDaoImpl implements WaterTableDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public Session currentSession(){
        return sessionFactory.openSession();
    }

    public List<WaterTable> findAllByID(WaterTableID waterTableID1,String startDate,String endDate) {

        Session session = null;
        List<WaterTable> list = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from WaterTable w where w.waterTableID.station_id = :stationID and w.waterTableID.timeID between :firstDate and :secondDate";
            Query query = session.createQuery(hsql);
            query.setParameter("stationID",waterTableID1.getStation_id());
            query.setParameter("firstDate",startDate);
            query.setParameter("secondDate",endDate);
            list = (List<WaterTable>)query.list();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}
