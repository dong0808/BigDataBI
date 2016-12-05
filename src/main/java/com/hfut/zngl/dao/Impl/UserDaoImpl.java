package com.hfut.zngl.dao.Impl;

import com.hfut.zngl.dao.UserDao;
import com.hfut.zngl.entity.User;
import org.hibernate.*;

import java.util.List;

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
    public User findByName(String name) {
        Session session = null;
        User user = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from User u where u.userName = :uname";
            Query query = session.createQuery(hsql);
            query.setParameter("uname",name);
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

    @SuppressWarnings("JpaQlInspection")
    public List<User> findAllUser() {
        Session session = null;
        List<User> list = null;
        try{
            session = currentSession();
            Transaction tx = session.beginTransaction();
            String hsql = "from User u";
            Query query = session.createQuery(hsql);
            list = (List<User>)query.list();
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}

