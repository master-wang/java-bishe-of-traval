package com.acat.controller;

import com.acat.entity.CollectEntity;
import com.acat.entity.RegisterEntity;
import com.acat.entity.TourEntity;
import com.acat.service.CollectService;
import com.acat.service.TourService;
import com.acat.vo.CollectVo;
import com.acat.vo.CollecttVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/collect")
@Api(value = "collect表",tags = {"搭建collect表的所有接口"})
public class CollectController {

    private static final Logger logger = LoggerFactory.getLogger(CollectController.class);

    @Autowired
    private CollectService collectService;

    @Autowired
    private TourService tourService;

    @PostMapping("/addCollect")
    @ApiOperation(value = "添加收藏的接口",notes = "添加收藏的接口")
    @ApiImplicitParam(value = "CollectVo的vo层",name = "CollectVo的vo层")
    private String addCollect(@RequestBody CollectVo collectVo){

//        RegisterEntity registerEntity = (RegisterEntity)session.getAttribute("registerEntity");
//
//        if(registerEntity == null){
//            return "1";//没有登录,请先登录
//        }

        System.out.println("^^^^^");
        System.out.println(collectVo);
        System.out.println("^^^^^");

        CollectEntity collectEntity = new CollectEntity();

        collectEntity.setBishe_collect_tour_id(collectVo.getBishe_collect_tour_id());
        collectEntity.setBishe_collect_register_id(collectVo.getBishe_register_id());
        collectService.addCollect(collectEntity);

        return "2";//收藏成功
    }

    @ApiOperation(value = "取消收藏的接口",notes = "取消收藏的接口")
    @ApiImplicitParam(value = "CollecttVo",name = "CollecttVo")
    @PostMapping("/deleteCollect")
    public String deleteCollect(@RequestBody CollecttVo collecttVo){

        System.out.println("^^^^^^^^^");
        System.out.println(collecttVo);
        System.out.println("^^^^^^^^^");
//        RegisterEntity registerEntity = (RegisterEntity)session.getAttribute("registerEntity");
//
//        if(registerEntity == null){
//            return "1";//没有登录,请先登录
//        }

        collectService.deleteByBishe_collect_id(collecttVo.getBishe_collect_tour_id(),collecttVo.getBishe_collect_register_id());

        return "2";//取消收藏成功
    }

    @ApiOperation(value = "显示我的收藏的接口",notes = "显示我的收藏的接口")
    @ApiImplicitParam(value = "bishe_collect_register_id",name = "bishe_collect_register_id")
    @GetMapping("/showCollect/{bishe_collect_register_id}")
    public List<TourEntity> showCollect(@PathVariable("bishe_collect_register_id") Integer bishe_collect_register_id){

        List<TourEntity> list = new ArrayList<>();

        List<Integer> tourIdList = collectService.showCollect(bishe_collect_register_id);
        if(tourIdList.size()>0){
            for(Integer ids:tourIdList){
                TourEntity tourEntity = tourService.getTourById(ids);
                list.add(tourEntity);
            }
        }

        return list;
    }

}
