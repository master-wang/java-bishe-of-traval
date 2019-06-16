package com.acat.controller;


import com.acat.entity.ProvinceEntity;
import com.acat.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/province")
@Api(value = "province表",tags = {"搭建province表的所有接口"})
public class ProvinceController {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

    @Autowired
    private ProvinceService provinceService;

    @ApiOperation(value = "获取省名的接口",notes = "获取省名的接口")
    @GetMapping("/getProvinceList")
    public List<ProvinceEntity> getProvinceList(){

        List<ProvinceEntity> list = provinceService.getProvinceList();
        System.out.println("***********");
        System.out.println(list);
        System.out.println("***********");
        return list;
    }
}
