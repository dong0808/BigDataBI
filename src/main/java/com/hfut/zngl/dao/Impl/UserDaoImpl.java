package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.dao.UserDao;
import com.hfut.zngl.entity.User;
import org.hibernate.*;

/**
 * Created by 东东 on 2016/11/8.
 */
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public Session currentSession(){
        return sessionFactory.openSession();
    }


    public void add(User user) {
        Session session = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(User user) {
        Session session = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    public void delete(int id) {
        Session session = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            User user = (User) session.get(User.class,id);
            session.delete(user);
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @SuppressWarnings("JpaQlInspection")
    public User findByName(String name, String pwd) {
        Session session = null;
        User user = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from User u where u.userName = :name and u.pwd = :pwd";
            Query query = session.createQuery(hsql);
            query.setParameter("name",name);
            query.setParameter("pwd",pwd);
            user = (User)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @SuppressWarnings("JpaQlInspection")
    public User findById(int id) {
        Session session = null;
        User user = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from User u where u.userID = :id";
            Query query = session.createQuery(hsql);
            query.setParameter("id",id);
            user = (User)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }
}

