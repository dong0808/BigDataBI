package com.hfut.zngl.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 东东 on 2016/12/7.
 */
public class QueryInfoAction extends ActionSupport {

    private String damageType;

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    @Override
    public String execute() throws Exception {

        if(damageType.equals("honglao")){
            return "honglao";
        }else if(damageType.equals("ganhan")){
            return "ganhan";
        }else{
            return "wumai";
        }
    }
}
