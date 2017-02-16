package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.dao.TempertureTableDao;
import com.hfut.zngl.entity.TempertureTable;
import com.hfut.zngl.entity.TempertureTableID;
import org.hibernate.*;

import java.util.List;
/**
 * Created by jiakai on 2017/2/13.
 */
public class TempertureTableDaoImpl implements TempertureTableDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.openSession();
    }

    public List<TempertureTable> findTempByID(TempertureTableID tempertureTableID,String startDate,String endDate){
        Session session = null;
        List<TempertureTable> list = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from TempertureTable t where t.tempertureTableID.station_id = :stationID and t.tempertureTableID.timeID between :firstDate and :secondDate";
            Query query = session.createQuery(hsql);
            query.setParameter("stationID",tempertureTableID.getStation_id());
            query.setParameter("firstDate",startDate);
            query.setParameter("secondDate",endDate);
            list = (List<TempertureTable>)query.list();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}
