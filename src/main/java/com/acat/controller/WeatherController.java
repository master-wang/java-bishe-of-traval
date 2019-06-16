package com.acat.controller;

import com.acat.entity.WeatherDto.WeatherResponse;
import com.acat.service.WeatherDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/weather")
@Api(value = "weather",tags = {"通过第三方weather接口获取搭建weather的信息"})
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherDataService weatherDataService;

    @ApiOperation(value = "获取天气预报接口",notes = "获取天气预报接口")
    @ApiImplicitParam(value = "cityName城市名称",name = "cityName城市名称")
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

}
