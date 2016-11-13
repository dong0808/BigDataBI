package com.hfut.zngl.action;

import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**AddAction
 * Created by 东东 on 2016/11/8.
 */
public class UpdateAction extends ActionSupport {

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
        User userTemp = userService.findByName(user.getUserName(),user.getPwd());

        if(userTemp!=null){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
}
