package com.hfut.zngl.service;

import com.hfut.zngl.entity.PMTable;
import com.hfut.zngl.entity.PMTableID;

import java.util.List;

/**
 * Created by jiakai on 2017/2/17.
 */
public interface PMTableService {

    public List<PMTable> findPMByID(PMTableID pmTableID,String startDate,String endDate);

}
