package com.hfut.zngl.action;

import com.hfut.zngl.util.CheckPermission;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by 东东 on 2016/12/2.
 */
public class HrefAction extends ActionSupport implements ConstantAction {

    public String queryParam;
    public String countParam;

    public String getCountParam() {
        return countParam;
    }

    public void setCountParam(String countParam) {
        this.countParam = countParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String userManager() throws Exception{

        ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        String userType = (String)session.get("userType");
        String permission = CheckPermission.check(userType,"userManager");
        if(permission.equals("manager")){
            return USERMANAGER;
        }else if(permission.equals("professor")){
            return USERPROFESSOR;
        }else if(permission.equals("common")){
            return  USERCOMMON;
        }


        return ERROR;

    }

    public String query() throws Exception{



        if(queryParam.equals("info")){
            return "query_info";
        }else{
            return "query_data";
        }

    }

    public String count() throws Exception{

        if(countParam.equals("dataCount")){
            return "count_data";
        }else{
            return "count_damage";
        }
    }

    public String evaluate() throws Exception{

        return EVALUATE;

    }

    public String warn() throws Exception{

        return WARNING;

    }

    public String defense() throws Exception{

        return DEFENSE;

    }

    public String loginout() throws Exception{

        ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        session.remove("user");
        return LOGINOUT;


    }

    public String userQuery() throws Exception{

        return USERQUERY;
    }

    public String precipitationQuery(){

        return SUCCESS;
    }

    public String tempQuery(){

        return SUCCESS;
    }

    public String pmQuery(){

        return SUCCESS;
    }

    public String coQuery(){

        return SUCCESS;
    }

    public String noQuery(){

        return SUCCESS;
    }

}
