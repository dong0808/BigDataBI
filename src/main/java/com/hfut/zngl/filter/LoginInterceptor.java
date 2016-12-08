package com.hfut.zngl.filter;

/**
 * Created by 东东 on 2016/11/30.
 */

import com.hfut.zngl.action.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {


        //排除登录Action
        Object action = invocation.getAction();
        if (action instanceof LoginAction) {
            //System.out.println("exit check login, because this is login action.");
            return invocation.invoke();
        }
        // 取得请求相关的ActionContext实例
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        String user = (String) session.get("user");

        // 如果没有登陆返回重新登陆

        if (user != null) {
           // System.out.println("test");
            return invocation.invoke();
        }else{
            return Action.LOGIN;
        }
    }

}
