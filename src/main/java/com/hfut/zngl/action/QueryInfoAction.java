package com.hfut.zngl.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 东东 on 2016/12/7.
 */
public class QueryInfoAction extends ActionSupport {

    private String damageType;
    private String dataType;

    /*public String getPrecipitationQuery() {
        return precipitationQuery;
    }

    public void setPrecipitationQuery(String precipitationQuery) {
        this.precipitationQuery = precipitationQuery;
    }

    private String precipitationQuery;*/


    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

    public String dataQuery() throws Exception {

        if(dataType.equals("precipitation")){
            return "precipitation";
        }else if(dataType.equals("temperture")){
            return "temperture";
        }else{
            return "pm";
        }
    }


}
