package com.acat.controller;


import com.acat.entity.CityEntity;
import com.acat.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/city")
@Api(value = "city表",tags = {"搭建city表的所有接口"})
public class CityController {

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "通过省名获取所有的市名接口",notes = "通过省名获取所有的市名接口")
    @ApiImplicitParam(value = "bishe_city_province_id",name = "bishe_city_province_id")
    @GetMapping("/getCityList/{bishe_city_province_id}")
    public List<CityEntity> getCityList(@PathVariable("bishe_city_province_id") Integer bishe_city_province_id){

        System.out.println("------------------");
        System.out.println(bishe_city_province_id);
        System.out.println("------------------");

        List<CityEntity> list = cityService.getCityList(bishe_city_province_id);

        System.out.println("***********");
        System.out.println(list);
        System.out.println("***********");
        return list;
    }
}
