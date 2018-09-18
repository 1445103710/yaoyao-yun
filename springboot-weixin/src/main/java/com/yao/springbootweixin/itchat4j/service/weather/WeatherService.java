package com.yao.springbootweixin.itchat4j.service.weather;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.log.XxlJobLogger;
import com.yao.springbootweixin.itchat4j.beans.WeatherInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-17 21:17
 **/
@Slf4j
public class WeatherService {
    public static void json() throws Exception {
        //参数url化
        String city = java.net.URLEncoder.encode("北京", "utf-8");

        //拼地址
        String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
        //开始请求
        URL url = new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
        //这里转换为String，带上包名，怕你们引错包
        String result = org.apache.commons.io.IOUtils.toString(input, "utf-8");
        //输出
        System.out.println(result);
    }
    public static List<WeatherInfo> getjson(String citys) throws Exception {
        List<WeatherInfo> maps = new LinkedList<>();
        //参数url化
        String city = java.net.URLEncoder.encode(citys, "utf-8");

        //拼地址
        String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
        //开始请求
        URL url = new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
        //这里转换为String，带上包名，怕你们引错包
        String result = org.apache.commons.io.IOUtils.toString(input, "utf-8");
        //输出
        XxlJobLogger.log("请求天气---->"+result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String status = jsonObject.getString("status");
        if(!"200".equals(status)){
            return null;
        }else {
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray forecast = data.getJSONArray("forecast");
            for(int i=0;i<forecast.size();i++){
                JSONObject weatherjson = forecast.getJSONObject(i);
                WeatherInfo weatherInfo = JSON.parseObject(weatherjson.toJSONString(), WeatherInfo.class);
                log.warn(weatherInfo.toString());
                maps.add(weatherInfo);
            }
            return maps;
        }
    }


    public static void main(String[] args) {
        try {
            getjson("合肥");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
