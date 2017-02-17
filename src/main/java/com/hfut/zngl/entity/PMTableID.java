package com.hfut.zngl.entity;

import java.io.Serializable;

/**
 * Created by jiakai on 2017/2/17.
 */

public class PMTableID implements Serializable{

    private String timeID;
    private String station_id;

    public String getTimeID() {
        return timeID;
    }

    public void setTimeID(String timeID) {
        this.timeID = timeID;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
