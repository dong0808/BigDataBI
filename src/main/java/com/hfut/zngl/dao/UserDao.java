package com.hfut.zngl.dao;

import com.hfut.zngl.entity.User;

import java.util.List;

/**
 * Created by 东东 on 2016/11/8.
 */
public interface UserDao {

    public void add(User user);
    public void update(User user);
    public void delete(int id);
    public User findByName(String name);
    public User findById(int id);
    public List<User> findAllUser();

}
