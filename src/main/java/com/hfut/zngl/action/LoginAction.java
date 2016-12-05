package com.hfut.zngl.action;

import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by 东东 on 2016/11/8.
 */
public class LoginAction extends ActionSupport {

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
        User userTemp = userService.findByName(user.getUserName());

        if(userTemp!=null){
            ActionContext ac = ActionContext.getContext();
            Map session = ac.getSession();
            session.put("user",userTemp.getUserName());
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
}
