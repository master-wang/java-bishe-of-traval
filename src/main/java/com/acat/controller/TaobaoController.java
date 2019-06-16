package com.acat.controller;

import com.acat.entity.TaobaoDto.DataResponse;
import com.acat.service.TaobaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/taobao")
@Api(value = "ip",tags = {"通过淘宝第三方ip接口获取搭建所在地理位置的信息"})
public class TaobaoController {

    private static final Logger logger = LoggerFactory.getLogger(TaobaoController.class);

    @Autowired
    private TaobaoService taobaoService;

    @ApiOperation(value = "通过ip获取地理位置接口",notes = "通过ip获取地理位置接口")
    @ApiImplicitParam(value = "ip",name = "ip")
    @GetMapping("/getAddress/{ip}")
    public DataResponse getAddress(@PathVariable("ip") String ip){
        return taobaoService.getAddress(ip);
    }

}
