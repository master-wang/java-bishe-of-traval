package com.acat.controller;

import com.acat.service.AreaMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/map")
@Api(value = "map",tags = {"通过百度地图的第三方接口获取搭建当地地图的信息"})
public class AreaMapController {

    private static final Logger logger = LoggerFactory.getLogger(AreaMapController.class);

    @Autowired
    private AreaMapService areaMapService;

    @ApiOperation(value = "通过地名获取当地地图的接口",notes = "通过地名获取当地地图的接口")
    @ApiImplicitParam(value = "address",name = "address")
    @GetMapping("/getMapURL/{address}")
    public String getMapURL(@PathVariable("address") String address){
        return areaMapService.getAreaMapUrl(address);
    }
}
