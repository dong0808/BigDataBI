package com.hfut.zngl.dao;

import com.hfut.zngl.entity.BasicData;

import java.util.List;

/**
 * Created by 东东 on 2017/1/6.
 */
public interface BasicDataDao {

    public List<BasicData> findAllByStationID(String stationID);
    public List<BasicData> findAllByIDAndDate(String stationID,String startDate,String endDate);

}
