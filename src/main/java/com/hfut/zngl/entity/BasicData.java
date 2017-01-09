package com.hfut.zngl.entity;

import java.io.Serializable;

/**
 * Created by 东东 on 2017/1/6.
 */
public class BasicData implements Serializable{

    private int ID;
    private String station_id;
    private String observation_time;
    private double precipitation;
    private double ave_temperture;
    private double max_temperture;
    private double min_temperture;
    private double PM;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getAve_temperture() {
        return ave_temperture;
    }

    public void setAve_temperture(double ave_temperture) {
        this.ave_temperture = ave_temperture;
    }

    public double getMax_temperture() {
        return max_temperture;
    }

    public void setMax_temperture(double max_temperture) {
        this.max_temperture = max_temperture;
    }

    public double getMin_temperture() {
        return min_temperture;
    }

    public void setMin_temperture(double min_temperture) {
        this.min_temperture = min_temperture;
    }

    public double getPM() {
        return PM;
    }

    public void setPM(double PM) {
        this.PM = PM;
    }
}
