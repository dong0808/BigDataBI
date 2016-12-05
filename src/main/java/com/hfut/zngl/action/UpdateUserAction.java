package com.hfut.zngl.action;

import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 东东 on 2016/11/8.
 */
public class UpdateUserAction extends ActionSupport {

    public String UPDATAMANAGER = "updateManager";

    private User user;
    private UserService userService;

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(user.getUserID());
        System.out.println(user.getPwd());
        user.setUserID(Integer.valueOf(user.getUserID()));
        user.setUserName(user.getUserName());
        user.setPwd(user.getPwd());
        user.setPhone(user.getPhone());
        user.setSex(user.getSex());
        user.setUserType(user.getUserType());
        userService.update(user);
        return SUCCESS;

    }

    public String updateManager() throws Exception{

        user.setUserID(Integer.valueOf(user.getUserID()));
        User u = userService.findById(Integer.valueOf(user.getUserID()));
        user.setUserName(user.getUserName());
        user.setPhone(user.getPhone());
        user.setPwd(u.getPwd());
        user.setUserType(u.getUserType());
        user.setSex(user.getSex());
        userService.update(user);

        return UPDATAMANAGER;

    }
}
