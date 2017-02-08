package com.hfut.zngl.service;

import com.hfut.zngl.entity.Station;

import java.util.List;

/**
 * Created by 东东 on 2017/1/6.
 */
public interface StationService {

    public Station findById(String station_id);
    public Station findByName(String station_name);
    public List<Station> findStationByCityName(String cityName);
}
