package com.hfut.zngl.dao;

import com.hfut.zngl.entity.WaterTable;
import com.hfut.zngl.entity.WaterTableID;

import java.util.List;

/**
 * Created by 东东 on 2017/2/4.
 */
public interface WaterTableDao {

    public List<WaterTable> findAllByID(WaterTableID waterTableID,String startDate,String endDate);
}
