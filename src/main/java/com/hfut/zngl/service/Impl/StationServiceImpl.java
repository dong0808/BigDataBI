package com.hfut.zngl.service.Impl;

import com.hfut.zngl.dao.StationDao;
import com.hfut.zngl.entity.Station;
import com.hfut.zngl.service.StationService;

/**
 * Created by 东东 on 2017/1/6.
 */
public class StationServiceImpl implements StationService {

    private StationDao stationDao;

    public StationDao getStationDao() {
        return stationDao;
    }

    public void setStationDao(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    public Station findById(String station_id){

        return stationDao.findById(station_id);

    };
    public Station findByName(String station_name){

        return stationDao.findByName(station_name);

    };
}
