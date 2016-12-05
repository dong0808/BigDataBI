package com.hfut.zngl.action;

import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 东东 on 2016/11/8.
 */
public class AddUserAction extends ActionSupport {

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
        user.setUserID(Integer.valueOf(user.getUserID()));
        System.out.println(user.getUserID());
        user.setUserName(user.getUserName());
        user.setPwd(user.getPwd());
        user.setUserType(user.getUserType());
        user.setPhone(user.getPhone());
        user.setSex(user.getSex());
        userService.add(user);
        return SUCCESS;

    }
}
