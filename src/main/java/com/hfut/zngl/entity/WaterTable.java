package com.hfut.zngl.entity;

/**
 * Created by 东东 on 2017/2/4.
 */
public class WaterTable {

    private WaterTableID waterTableID;
    private float rainRequ;
    private float rainFall;

    public WaterTableID getWaterTableID() {
        return waterTableID;
    }

    public void setWaterTableID(WaterTableID waterTableID) {
        this.waterTableID = waterTableID;
    }

    public float getRainRequ() {
        return rainRequ;
    }

    public void setRainRequ(float rainRequ) {
        this.rainRequ = rainRequ;
    }

    public float getRainFall() {
        return rainFall;
    }

    public void setRainFall(float rainFall) {
        this.rainFall = rainFall;
    }
}
