package com.hfut.zngl.service.Impl;

import com.hfut.zngl.dao.TempertureTableDao;
import com.hfut.zngl.entity.TempertureTable;
import com.hfut.zngl.entity.TempertureTableID;
import com.hfut.zngl.service.TempertureTableService;

import java.util.List;

/**
 * Created by jiakai on 2017/2/13.
 */
public class TempertureTableServiceImpl implements TempertureTableService{

    private TempertureTableDao tempertureTableDao;

    public void setTempertureTableDao(TempertureTableDao tempertureTableDao) {
        this.tempertureTableDao = tempertureTableDao;
    }

    public List<TempertureTable> findTempByID(TempertureTableID tempertureTableID,String startDate,String endDate){
        return tempertureTableDao.findTempByID(tempertureTableID,startDate,endDate);
    }
}
