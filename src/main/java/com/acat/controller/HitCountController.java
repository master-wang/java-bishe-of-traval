package com.acat.controller;

import com.acat.entity.HitcountEntity;
import com.acat.service.HitCountService;
import com.acat.vo.HitCountVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hitCount")
@Api(value = "hitCount表",tags = {"搭建hitCount表的所有接口"})
public class HitCountController {

    private static final Logger logger = LoggerFactory.getLogger(HitCountController.class);

    @Autowired
    private HitCountService hitCountService;

    @ApiOperation(value = "添加旅游景点点击的次数",notes = "添加旅游景点点击的次数")
    @ApiImplicitParam(value = "hitCountVo",name = "hitCountVo")
    @PostMapping("/saveHitCount")
    public void saveHitCount(@RequestBody HitCountVo hitCountVo){

        HitcountEntity hitcountEntity = new HitcountEntity();

        hitcountEntity.setBishe_hitcount_tour_id(hitCountVo.getBishe_hitcount_tour_id());

        hitCountService.saveHitCount(hitcountEntity);
    }

}
