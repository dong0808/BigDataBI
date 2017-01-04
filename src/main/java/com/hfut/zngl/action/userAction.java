package com.hfut.zngl.action;

import com.hfut.zngl.entity.User;
import com.hfut.zngl.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 东东 on 2016/12/3.
 */
public class userAction extends ActionSupport {

    public String USERQUERY = "userQuery";
    public String USEREDIT = "userEdit";
    public String USERDELETE = "userDelete";
    public String USERADD = "userAdd";
    public String MANAGERINFOEDIT = "managerInfoEdit";
    public String UPDATEPWD = "updatePWD";
    public UserService userService;
    public int userID;
    public String QUserName;
    public String queryParam;

    public String getQUserName() {
        return QUserName;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public void setQUserName(String QUserName) {
        this.QUserName = QUserName;
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String userQuery() throws Exception{


        if(queryParam==null||queryParam.equals("")) {
            List<User> list = userService.findAllUser();
            ActionContext ac = ActionContext.getContext();
            ac.put("userList", list);
        }else if(queryParam.equals("query")){
            List<User> list  = new ArrayList<User>();
            User u  = (User)userService.findByName(QUserName);
            if(u!=null){
                list.add(u);
            }

            ActionContext ac = ActionContext.getContext();
            ac.put("userList", list);
        }
        return USERQUERY;
    }

    public String userEdit() throws Exception{

        ActionContext ac = ActionContext.getContext();
        User user = userService.findById(userID);
        ac.put("userID",userID);
        ac.put("userName",user.getUserName());
        ac.put("pwd",user.getPwd());
        ac.put("sex",user.getSex());
        ac.put("userType",user.getUserType());
        ac.put("phone",user.getPhone());

        return USEREDIT;
    }

    public String userDelete() throws Exception{

        ActionContext ac = ActionContext.getContext();
        userService.delete(userID);

        return USERDELETE;
    }

    public String userAdd() throws Exception{

        return USERADD;
    }

    public String managerInfoEdit() throws Exception{

        ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        String userName = (String) session.get("user");
        User user = userService.findByName(userName);
        setUserID(Integer.valueOf(user.getUserID()));
        ac.put("userName",userName);
        ac.put("phone",user.getPhone());
        ac.put("sex",user.getSex());
        ac.put("userID",user.getUserID());
        ac.put("userType",user.getUserType());
        //System.out.println("用户ID:"+user.getUserID());
        return MANAGERINFOEDIT;
    }

    public String updatePWD() throws Exception{
        return UPDATEPWD;
    }
}
