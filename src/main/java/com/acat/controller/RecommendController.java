package com.acat.controller;

import com.acat.entity.TourEntity;
import com.acat.service.RecommendService;
import com.acat.service.TourService;
import com.acat.util.RecommendUtil.GeXingUtil;
import com.acat.vo.RecommendVo.RecommendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recommend")
@SuppressWarnings("all")
@Api(value = "recommend",tags = {"个性化推荐表的所有的接口"})
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private TourService tourService;

    /**
     * 按照两重标准去推荐，
     * 一个是按照定位所在城市进行推荐
     * 二个是按照收藏里面的景点进行分析，获取最多的
     * @param recommendVo
     * @return
     */
    @ApiOperation(value = "个性化推荐的接口", notes = "个性化推荐的接口")
    @ApiImplicitParam(value = "RecommendVo", name = "RecommendVo")
    @PostMapping("/getTourEntityByRecommend")
    public List<TourEntity> getTourEntityByRecommend(@RequestBody RecommendVo recommendVo) {

        List<TourEntity> bigList = new ArrayList();

        List<String> list = new ArrayList<>();

        int bishe_collect_register_id = recommendVo.getBishe_collect_register_id();
        String cityName = recommendVo.getCity();

        List<TourEntity> tourList1 = tourService.getTourListByCity(cityName);

        List<Integer> tourIds = recommendService.getTourEntityByRecommend(bishe_collect_register_id);

        if (tourIds.size() == 0) {
            return tourService.getTourAll();
        }

        for (Integer id : tourIds) {
            String TypeName = recommendService.getTourType(id);
            list.add(TypeName);
        }

        Map<String, Integer> map = GeXingUtil.calcCountsOfListElements(list);
        System.out.println("map是" + map);

        int maxNum = Integer.parseInt(GeXingUtil.gerMinValue(map).toString());
        System.out.println("最多的是:" + maxNum);

        String key = (String) GeXingUtil.getKey(map, maxNum);
        System.out.println("最多的类型是:" + key);

        List<TourEntity> tourList2 = recommendService.getTourEntityByType(key);

        for(int i=0;i<tourList1.size();i++){
            bigList.add(tourList1.get(i));
        }

        for(int i=0;i<tourList2.size();i++){
            bigList.add(tourList2.get(i));
        }

        System.out.println("去重前bigList是："+bigList);

        GeXingUtil.removeDup(bigList);

        System.out.println("去重后bigList是："+bigList);

        return bigList;
    }

}



//    @ApiOperation(value = "个性化推荐的接口",notes = "个性化推荐的接口")
//    @ApiImplicitParam(value = "bishe_collect_register_id",name = "bishe_collect_register_id")
//    @GetMapping("/getTourEntityByRecommend/{bishe_collect_register_id}")
//    public List<TourEntity> getTourEntityByRecommend(@PathVariable("bishe_collect_register_id") Integer bishe_collect_register_id){
//
//        List<String> list = new ArrayList<>();
//
//        List<Integer> tourIds = recommendService.getTourEntityByRecommend(bishe_collect_register_id);
//
//        if(tourIds.size()==0){
//            return tourService.getTourAll();
//        }
//
//        for(Integer id:tourIds){
//            String TypeName = recommendService.getTourType(id);
//            list.add(TypeName);
//        }
//
//        Map<String,Integer> map = GeXingUtil.calcCountsOfListElements(list);
//        System.out.println("map是"+map);
//
//        int  maxNum= Integer.parseInt(GeXingUtil.gerMinValue(map).toString());
//        System.out.println("最多的是:"+maxNum);
//
//        String key = (String)GeXingUtil.getKey(map,maxNum);
//        System.out.println("最多的类型是:"+key);
//
//        List<TourEntity> tourList = recommendService.getTourEntityByType(key);
//
//        return tourList;
//    }

