package com.acat.controller;

import com.acat.entity.DetailEntity;
import com.acat.service.DetailService;
import com.acat.vo.DetailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value = "detail",tags = {"detail表的所有接口"})
@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @PostMapping("/addDetail")
    @ApiOperation(value = "添加景点的详情信息",notes = "添加景点的详情信息")
    @ApiImplicitParam(value = "DetailDto",name = "DetailDto")
    public String addDetail(@RequestBody DetailDto detailDto){
        DetailEntity detailEntity = new DetailEntity();
        detailEntity.setBishe_tour_detail_starnum(detailDto.getBishe_tour_detail_starnum());
        detailEntity.setBishe_tour_detail_message(detailDto.getBishe_tour_detail_message());
        detailEntity.setBishe_tour_id(detailDto.getBishe_tour_id());

        detailService.addDetail(detailEntity);

        return "1";//添加成功
    }

    @GetMapping("/getDetailEntity/{bishe_tour_id}")
    @ApiOperation(value = "旅游景点的id获取该景点的详情信息",notes = "旅游景点的id获取该景点的详情信息")
    @ApiImplicitParam(value = "bishe_tour_id",name = "bishe_tour_id")
    public DetailEntity getDetailEntity(@PathVariable("bishe_tour_id") Integer bishe_tour_id){
        DetailEntity detailEntity = detailService.getDetailByTourId(bishe_tour_id);
        return detailEntity;
    }

}
