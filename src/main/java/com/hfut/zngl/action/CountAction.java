package com.hfut.zngl.action;

import com.hfut.zngl.entity.Station;
import com.hfut.zngl.entity.WaterTable;
import com.hfut.zngl.entity.WaterTableID;
import com.hfut.zngl.service.StationService;
import com.hfut.zngl.service.WaterTableService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 东东 on 2017/2/4.
 */
/*统计模块中Ajax的后台处理程序*/
public class CountAction extends ActionSupport{

    /*
    * @param station_id 站名
    * @param cityName 地市名称
    * @param startYear 开始年份
    * @param endYear 结束年份
    * @param year 年份
    * @param startMonth 开始月份
    * @param endMonth 结束月份
    * @param jsonResult json格式的结果
    */
    private String station_name;
    private String cityName;
    private String startYear;
    private String endYear;
    private String year;
    private String startMonth;
    private String endMonth;
    private WaterTableService waterTableService;
    private StationService stationService;
    private String jsonResult;
    private Map<String, Object> resultMap;


    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    /*set方法用于接收前台传递过来的参数*/
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    public void setWaterTableService(WaterTableService waterTableService) {
        this.waterTableService = waterTableService;
    }


    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    //降水量同比
    public String precipitationTB(){
        //查询表获取stationID
        Station stationTemp = stationService.findByName(station_name);
        String stationID = stationTemp.getStation_id();
        WaterTableID waterTableID = new WaterTableID();
        waterTableID.setStation_id(stationID);
        //根据前台参数拼接成方法需要参数
        String startDate = year+"0"+startMonth;
        String endDate = year+endMonth;
        //获取所有符合条件的WaterTable实体
        List<WaterTable> list = waterTableService.findAllByID(waterTableID,startDate,endDate);

        //获取前一年的相关数据
        int yearInt = Integer.parseInt(year)-1;
        String startDateF = yearInt+"0"+startMonth;
        String endDateF = yearInt+endMonth;
        List<WaterTable> list1 = waterTableService.findAllByID(waterTableID,startDateF,endDateF);

        //做同比处理 （今年降水量-去年降水量）/去年降水量*100%
        List<Double> listT = new ArrayList<Double>();
        //构建List存储日期，降水量
        List<String> dateList = new ArrayList<String>();
        List<Float> TList = new ArrayList<Float>();
        List<Float> FList = new ArrayList<Float>();

        //NumberFormat nf   =   NumberFormat.getPercentInstance();
        for(int i=0;i<list1.size();i++){

            listT.add((double)(list.get(i).getRainFall()-list1.get(i).getRainFall())/list1.get(i).getRainFall());
            TList.add(list.get(i).getRainFall());
            FList.add(list1.get(i).getRainFall());
            dateList.add(list.get(i).getWaterTableID().getTimeID().substring(4));

        }

        //json格式转换
        resultMap = new HashMap<String, Object>();
        resultMap.put("TB",listT);
        resultMap.put("date",dateList);
        resultMap.put("TRain",TList);
        resultMap.put("FRain",FList);
        jsonResult = JSONArray.fromObject(resultMap).toString();

      return "tb";

    }

    //降水量环比
    public String precipitationHB(){
        //查询表获取stationID
        Station stationTemp = stationService.findByName(station_name);
        String stationID = stationTemp.getStation_id();
        WaterTableID waterTableID = new WaterTableID();
        waterTableID.setStation_id(stationID);
        //根据前台参数拼接成方法需要参数
        String startDate = year+"0"+startMonth;
        String endDate = year+endMonth;
        //获取所有符合条件的WaterTable实体
        List<WaterTable> list = waterTableService.findAllByID(waterTableID,startDate,endDate);

        //做环比处理 （本月降水量-上月降水量）/上月降水量*100%
        List<Double> listH = new ArrayList<Double>();
        //构建List存储日期，降水量
        List<String> dateList = new ArrayList<String>();
        List<Float> TList = new ArrayList<Float>();

        //NumberFormat nf   =   NumberFormat.getPercentInstance();
        for(int i=0;i<list.size();i++){
            if(i==0){
                listH.add(0.0);
                TList.add(list.get(i).getRainFall());
                dateList.add(list.get(i).getWaterTableID().getTimeID().substring(4));
            }else {

                listH.add((double) (list.get(i).getRainFall() - list.get(i-1).getRainFall()) / list.get(i-1).getRainFall());
                TList.add(list.get(i).getRainFall());
                dateList.add(list.get(i).getWaterTableID().getTimeID().substring(4));
            }
        }

        //json格式转换
        resultMap = new HashMap<String, Object>();
        resultMap.put("HB",listH);
        resultMap.put("date",dateList);
        resultMap.put("TRain",TList);
        jsonResult = JSONArray.fromObject(resultMap).toString();

        return "hb";

    }

    //降水量汇总
    public String precipitationHZ(){
        //查询表获取地级市下面各个站点ID
        List<Station> listS = stationService.findStationByCityName(cityName);
        //定义地市降水量总和
        double totalP = 0.0;
        //定义存储各地市降水量之和的list
        List<Double> listP = new ArrayList<Double>();

        //定义存储各地市名称的List
        List<String> listName = new ArrayList<String>();
        //循环得到各个站点的降水量之和
        for(int i=0;i<listS.size();i++){
            String stationID = listS.get(i).getStation_id();
            String stationName = listS.get(i).getStation_name();
            WaterTableID waterTableID = new WaterTableID();
            waterTableID.setStation_id(stationID);
            //根据前台参数拼接成方法需要参数
            String startDate;
            if(Integer.parseInt(startMonth)<10){
                startDate = startYear+"0"+startMonth;
            }else{
                startDate = startYear+startMonth;
            }
            String endDate;
            if(Integer.parseInt(endMonth)<10){
                endDate = endYear+"0"+endMonth;
            }else{
                endDate = endYear+endMonth;
            }
            //获取所有符合条件的WaterTable实体
            List<WaterTable> list = waterTableService.findAllByID(waterTableID,startDate,endDate);
            //本站点做降水量汇总处理
            double sum = 0.0;
            for(int j=0;j<list.size();j++){
                sum = sum + list.get(j).getRainFall();
            }
            listName.add(stationName);
            listP.add(sum);
            totalP = totalP + sum;
        }


        //json格式转换
        resultMap = new HashMap<String, Object>();
        resultMap.put("HZ",listP);
        resultMap.put("sName",listName);
        resultMap.put("total",totalP);
        jsonResult = JSONArray.fromObject(resultMap).toString();

        return "hz";

    }
}
