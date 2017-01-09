package com.hfut.zngl.dao;

import com.hfut.zngl.entity.Station;

/**
 * Created by 东东 on 2017/1/6.
 */
public interface StationDao {

    public Station findById(String station_id);
    public Station findByName(String station_name);

}
