package com.acat.controller;

import com.acat.entity.IpDto.IpResponse;
import com.acat.service.IpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ip")
@Api(value = "sogou-ip",tags = {"通过第三方搜狗的接口获取本机的外网ip"})
public class IpController {

    private static final Logger logger = LoggerFactory.getLogger(IpController.class);

    @Autowired
    private IpService ipService;

    @ApiOperation(value = "通过第三方搜狗的接口获取本机的外网ip",notes = "通过第三方搜狗的接口获取本机的外网ip")
    @GetMapping("/getIp")
    public IpResponse getIp(){
        return ipService.getIp();
    }

}
