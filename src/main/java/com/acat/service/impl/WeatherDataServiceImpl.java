package com.acat.service.impl;

import com.acat.entity.WeatherDto.WeatherResponse;
import com.acat.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service("weatherDataService")
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final long TIME_OUT = 1800L;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private WeatherResponse doGetWeather(String uri){
        ObjectMapper mapper = new ObjectMapper();
        String strBody = null;
        WeatherResponse resp = null;

        String key = uri;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();

        //从缓存中取数据
        if(stringRedisTemplate.hasKey(key)){
            logger.info("Redis has data");

            strBody = ops.get(key);
        }else {
            logger.info("Redis don`t has data");

            ResponseEntity<String> respString = restTemplate.getForEntity(uri,String.class);

            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
            }

            //写入缓存
            ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
        }

        try{
            resp = mapper.readValue(strBody,WeatherResponse.class);
        }catch (IOException e){
            logger.error("Error!!!",e);
        }

        return resp;
    }

    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city="+cityName;
        return this.doGetWeather(uri);
    }

}
