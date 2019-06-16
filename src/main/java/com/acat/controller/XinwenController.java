package com.acat.controller;

import com.acat.entity.XinwenDto.Response;
import com.acat.service.XinwenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * top(头条，默认),
 * shehui(社会),
 * guonei(国内),
 * guoji(国际),
 * yule(娱乐),
 * tiyu(体育),
 * junshi(军事),
 * keji(科技),
 * caijing(财经),
 * shishang(时尚)
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/xinwen")
@Api(value = "xinwen",tags = {"通过第三方新闻的接口获取搭建xinwen的信息"})
public class XinwenController {

    private static final Logger logger = LoggerFactory.getLogger(XinwenController.class);

    @Autowired
    private XinwenService xinwenService;

    @ApiOperation(value = "获取新闻的接口",notes = "获取新闻的接")
    @ApiImplicitParam(value = "cityName城市名称",name = "cityName城市名称")
    @GetMapping("/getXinwenResponseByName/{val}")
    public Response getXinwenResponseByName(@PathVariable("val") String val){
        return xinwenService.getWinwenByName(val);
    }

}
