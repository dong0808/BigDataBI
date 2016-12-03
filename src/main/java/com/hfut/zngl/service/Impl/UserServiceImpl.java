package com.hfut.zngl.service.Impl;

import com.hfut.zngl.dao.UserDao;
import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;

/**
 * Created by 东东 on 2016/11/9.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public User add(User user) {
        if(userDao.findById(user.getUserID())==null){
            userDao.add(user);
        }
        return user;
    }

    public void update(User user) {
        if(userDao.findById(user.getUserID())!=null){
            userDao.update(user);
        }
    }

    public void delete(int id) {
        if(userDao.findById(id)!=null){
            userDao.delete(id);
        }

    }

    public User findByName(String name, String pwd) {
        return userDao.findByName(name,pwd);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }
}
