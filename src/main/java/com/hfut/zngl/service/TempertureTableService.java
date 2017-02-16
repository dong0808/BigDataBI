package com.hfut.zngl.service;

import com.hfut.zngl.entity.TempertureTable;
import com.hfut.zngl.entity.TempertureTableID;

import java.util.List;
/**
 * Created by jiakai on 2017/2/13.
 */



public interface TempertureTableService {
    public List<TempertureTable> findTempByID(TempertureTableID tempertureTableID,String startDate,String endDate);

}
