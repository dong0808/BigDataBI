package com.hfut.zngl.service.Impl;

import com.hfut.zngl.dao.WaterTableDao;
import com.hfut.zngl.entity.WaterTable;
import com.hfut.zngl.entity.WaterTableID;
import com.hfut.zngl.service.WaterTableService;

import java.util.List;

/**
 * Created by 东东 on 2017/2/4.
 */
public class WaterTableServiceImpl implements WaterTableService {

    private WaterTableDao waterTableDao;

    public void setWaterTableDao(WaterTableDao waterTableDao) {
        this.waterTableDao = waterTableDao;
    }

    public List<WaterTable> findAllByID(WaterTableID waterTableID, String startDate, String endDate) {
        return waterTableDao.findAllByID(waterTableID,startDate,endDate);
    }
}
