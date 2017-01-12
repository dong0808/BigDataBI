package com.hfut.zngl.action;

import com.hfut.zngl.entity.BasicData;
import com.hfut.zngl.entity.Station;
import com.hfut.zngl.service.BasicDataService;
import com.hfut.zngl.service.StationService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 东东 on 2017/1/6.
 */
public class QueryDataAction extends ActionSupport {

    private BasicDataService basicDataService;
    private StationService stationService;
    private String station_name;
    private String startDate;
    private String endDate;
    private String jsonResult;

    private Map<String, Object> resultMap;

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public StationService getStationService() {
        return stationService;
    }

    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public BasicDataService getBasicDataService() {
        return basicDataService;
    }

    public void setBasicDataService(BasicDataService basicDataServiceService) {
        this.basicDataService = basicDataServiceService;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String tempertureQuery() throws Exception {

        List<Double> maxTList = new ArrayList<Double>();
        List<Double> minTList = new ArrayList<Double>();
        List<Double> avTList = new ArrayList<Double>();
        List<String> dataList = new ArrayList<String>();
        Station stationTemp = stationService.findByName(station_name);
        String stationID = stationTemp.getStation_id();
        List<BasicData> list = basicDataService.findAllByIDAndDate(stationID, startDate, endDate);
        for (BasicData b : list) {
            dataList.add(b.getObservation_time());
            maxTList.add(b.getMax_temperture());
            minTList.add(b.getMin_temperture());
            avTList.add(b.getAve_temperture());
        }

        resultMap = new HashMap<String, Object>();

        resultMap.put("dateResult", dataList);
        resultMap.put("stationName", station_name);
        resultMap.put("maxTList",maxTList);
        resultMap.put("minTList",minTList);
        resultMap.put("avTList",avTList);


        jsonResult = JSONArray.fromObject(resultMap).toString();
        return "temp";
    }


    public String precipitationQuery() throws Exception {
        List<Double> preList = new ArrayList<Double>();
        List<String> dataList = new ArrayList<String>();
        Station stationTemp = stationService.findByName(station_name);
        String stationID = stationTemp.getStation_id();
        List<BasicData> list = basicDataService.findAllByIDAndDate(stationID, startDate, endDate);
        for (BasicData b : list) {
            preList.add(b.getPrecipitation());
            dataList.add(b.getObservation_time());
            //System.out.println(b.getPrecipitation());
        }
//        System.out.print();
        resultMap = new HashMap<String, Object>();
        resultMap.put("preResult", preList);
        resultMap.put("dateResult", dataList);
        resultMap.put("stationName", station_name);


        jsonResult = JSONArray.fromObject(resultMap).toString();
        return "prec";
    }

    public String pmQuery() throws Exception {
        List<Double> pmList = new ArrayList<Double>();
        List<String> dataList = new ArrayList<String>();
        Station stationTemp = stationService.findByName(station_name);
        String stationID = stationTemp.getStation_id();
        List<BasicData> list = basicDataService.findAllByIDAndDate(stationID, startDate, endDate);
        for (BasicData b : list) {
            pmList.add(b.getPM());
            dataList.add(b.getObservation_time());
            //System.out.println(b.getPrecipitation());
        }
//        System.out.print();
        resultMap = new HashMap<String, Object>();
        resultMap.put("pmResult", pmList);
        resultMap.put("dateResult", dataList);
        resultMap.put("stationName", station_name);


        jsonResult = JSONArray.fromObject(resultMap).toString();
        return "pm";
    }
}
