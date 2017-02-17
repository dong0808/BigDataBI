package com.hfut.zngl.service.Impl;

import com.hfut.zngl.entity.PMTable;
import com.hfut.zngl.entity.PMTableID;
import com.hfut.zngl.dao.PMTableDao;
import com.hfut.zngl.service.PMTableService;

import java.util.List;

/**
 * Created by jiakai on 2017/2/17.
 */
public class PMTableServiceImpl implements PMTableService{

    private PMTableDao pmTableDao;

    public void setPmTableDao(PMTableDao pmTableDao) {
        this.pmTableDao = pmTableDao;
    }

    public List<PMTable> findPMByID(PMTableID pmTableID,String startDate,String endDate){
        return pmTableDao.findPMByID(pmTableID,startDate,endDate);
    }
}
