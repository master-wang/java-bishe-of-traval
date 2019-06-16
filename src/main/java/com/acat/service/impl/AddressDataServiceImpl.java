package com.acat.service.impl;

import com.acat.entity.AddressDto.AddressResponse;
import com.acat.service.AddressDataService;
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

@Service("addressDataService")
public class AddressDataServiceImpl implements AddressDataService {

    private static final Logger logger = LoggerFactory.getLogger(AddressDataServiceImpl.class);

    private static final long TIME_OUT = 1800L;

    private static final String ADDRESS_URI = "https://restapi.amap.com/v3/ip?key=af85e8acba9f8b5fc1131299292c32cd&";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private AddressResponse doGetAddress(String uri){

        ObjectMapper mapper = new ObjectMapper();
        String strBody = null;
        AddressResponse resp = null;

        String key = uri;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();

        //从缓存中取数据
        if(stringRedisTemplate.hasKey(key)) {
            logger.info("Regis has data");

            strBody = ops.get(key);
        }else{
            logger.info("Redis don`t has data");

            ResponseEntity<String> respString = restTemplate.getForEntity(uri,String.class);
            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
            }

            //数据写入缓存
            ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
        }

        try{
            resp = mapper.readValue(strBody,AddressResponse.class);
        }catch (IOException e){
            logger.error("Error!",e);
        }

        return resp;
    }

    public AddressResponse getAddressByIp(String ip){
        String uri = ADDRESS_URI + "ip=" + ip;
        return this.doGetAddress(uri);
    }

}
