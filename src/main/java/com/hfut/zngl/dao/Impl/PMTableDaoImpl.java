package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.entity.PMTable;
import com.hfut.zngl.entity.PMTableID;
import com.hfut.zngl.dao.PMTableDao;
import org.hibernate.*;

import java.util.List;

/**
 * Created by jiakai on 2017/2/17.
 */
public class PMTableDaoImpl implements PMTableDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.openSession();
    }

    public List<PMTable> findPMByID(PMTableID pmTableID,String startDate,String endDate){
        Session session = null;
        List<PMTable> list = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from PMTable p where p.pmTableID.station_id = :stationID and p.pmTableID.timeID between :firstDate and :secondDate";
            Query query = session.createQuery(hsql);
            query.setParameter("stationID",pmTableID.getStation_id());
            query.setParameter("firstDate",startDate);
            query.setParameter("secondDate",endDate);
            list = (List<PMTable>)query.list();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

}
