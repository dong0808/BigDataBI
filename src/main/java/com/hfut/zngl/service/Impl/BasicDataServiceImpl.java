package com.hfut.zngl.service.Impl;

import com.hfut.zngl.dao.BasicDataDao;
import com.hfut.zngl.entity.BasicData;
import com.hfut.zngl.service.BasicDataService;

import java.util.List;

/**
 * Created by 东东 on 2017/1/6.
 */
public class BasicDataServiceImpl implements BasicDataService {

    private BasicDataDao basicDataDao;

    public BasicDataDao getBasicDataDao() {
        return basicDataDao;
    }

    public void setBasicDataDao(BasicDataDao basicDataDao) {
        this.basicDataDao = basicDataDao;
    }




    public List<BasicData> findAllByStationID(String stationID) {
        return basicDataDao.findAllByStationID(stationID);
    }

    public List<BasicData> findAllByIDAndDate(String stationID, String startDate, String endDate) {
        return basicDataDao.findAllByIDAndDate(stationID,startDate,endDate);
    }


}
