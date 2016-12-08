package com.hfut.zngl.util;

import com.hfut.zngl.entity.Permission;
import org.hibernate.*;

/**
 * Created by 东东 on 2016/12/6.
 */
public class CheckPermission {

    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public static Session currentSession(){
        return sessionFactory.openSession();
    }

    public static String check(String userType,String functionModel){
        Session session = null;
        String permission = null;
        Permission pm = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from Permission p where p.userType = :userType";
            Query query = session.createQuery(hsql);
            query.setParameter("userType",userType);
            pm = (Permission) query.uniqueResult();
            if(functionModel.equals("query")){
                permission = pm.getQuery();
            }else if(functionModel.equals("count")){
                permission = pm.getCount();
            }else if(functionModel.equals("evaluate")){
                permission = pm.getEvaluate();
            }else if(functionModel.equals("warning")){
                permission = pm.getWarning();
            }else if(functionModel.equals("defense")){
                permission = pm.getDefense();
            }else if(functionModel.equals("userManager")){
                permission = pm.getUserManager();
            }
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return permission;

    }
}
