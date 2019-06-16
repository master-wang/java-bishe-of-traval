package com.acat.service.impl;

import com.acat.entity.IpDto.IpResponse;
import com.acat.entity.WeatherDto.WeatherResponse;
import com.acat.service.IpService;
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

@Service("ipService")
public class IpServiceImpl implements IpService {

    private static final Logger logger = LoggerFactory.getLogger(IpServiceImpl.class);

    private static final long TIME_OUT = 1800L;

    private static final String GET_IP_URI = "http://api.go2map.com/engine/api/ipcity/json";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private IpResponse doGetIp(String uri){
        ObjectMapper mapper = new ObjectMapper();
        String strBody = null;
        IpResponse resp = null;

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
            resp = mapper.readValue(strBody,IpResponse.class);
        }catch (IOException e){
            logger.error("Error!!!",e);
        }

        return resp;
    }

    public IpResponse getIp(){
        String uri = GET_IP_URI;
        return this.doGetIp(uri);
    }
}
