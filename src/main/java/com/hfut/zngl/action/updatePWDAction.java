package com.hfut.zngl.action;

import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by 东东 on 2016/12/5.
 */
public class updatePWDAction extends ActionSupport {

    private String oldPWD;
    private String newPWD1;
    private String newPWD2;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getOldPWD() {
        return oldPWD;
    }

    public void setOldPWD(String oldPWD) {
        this.oldPWD = oldPWD;
    }

    public String getNewPWD1() {
        return newPWD1;
    }

    public void setNewPWD1(String newPWD1) {
        this.newPWD1 = newPWD1;
    }

    public String getNewPWD2() {
        return newPWD2;
    }

    public void setNewPWD2(String newPWD2) {
        this.newPWD2 = newPWD2;
    }

    @Override
    public String execute() throws Exception {
        ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        User user = userService.findByName((String)session.get("user"));
        if(oldPWD.equals(user.getPwd())){
            if(newPWD1.equals(newPWD2)){
                user.setUserID(user.getUserID());
                user.setUserName(user.getUserName());
                user.setPwd(newPWD1);
                user.setSex(user.getSex());
                user.setUserType(user.getUserType());
                user.setPhone(user.getPhone());
                userService.update(user);
                return SUCCESS;
            }else{
                System.out.print("两次密码不匹配！！");
                return ERROR;
            }
        }else{
            return ERROR;
        }

    }
}
