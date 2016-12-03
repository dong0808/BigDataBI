package com.hfut.zngl.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by 东东 on 2016/12/2.
 */
public class HrefAction extends ActionSupport implements ConstantAction {



    public String userManager() throws Exception{

        return USERMANAGER;

    }

    public String query() throws Exception{

        return QUERY;

    }

    public String count() throws Exception{

        return COUNT;

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

}
