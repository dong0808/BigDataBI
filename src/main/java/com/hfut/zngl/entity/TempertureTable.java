package com.hfut.zngl.entity;

/**
 * Created by jiakai on 2017/2/13.
 */
public class TempertureTable {

    private TempertureTableID tempertureTableID;
    private float tempHigh;
    private float tempLow;
    //private float tempAverage;

    public TempertureTableID getTempertureTableID() {
        return tempertureTableID;
    }

    public void setTempertureTableID(TempertureTableID tempertureTableID) {
        this.tempertureTableID = tempertureTableID;
    }

    public float getTempHigh() {
        return tempHigh;
    }

    public void setTempHigh(float tempHigh) {
        this.tempHigh = tempHigh;
    }

    public float getTempLow() {
        return tempLow;
    }

    public void setTempLow(float tempLow) {
        this.tempLow = tempLow;
    }

    //public float getTempAverage() {
       // return tempAverage;
   // }

    //public void setTempAverage(float tempAverage) {
       // this.tempAverage = tempAverage;
    //}
}
