package com.acat.controller;

import com.acat.entity.AddressDto.AddressResponse;
import com.acat.service.AddressDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/address")
@Api(value = "ip",tags = {"通过第三方ip接口获取搭建所在地理位置的信息"})
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressDataService addressDataService;

    @ApiOperation(value = "通过ip获取地理位置接口",notes = "通过ip获取地理位置接口")
    @ApiImplicitParam(value = "ip",name = "ip")
    @GetMapping("/getAddress/{ip}")
    public AddressResponse getAddress(@PathVariable("ip") String ip){
        return addressDataService.getAddressByIp(ip);
    }
}
