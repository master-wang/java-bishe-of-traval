package com.acat.controller;

import com.acat.entity.TourEntity;
import com.acat.service.HitCountService;
import com.acat.service.TourService;
import com.acat.util.FileUtil;
import com.acat.util.TimeUtil;
import com.acat.vo.AddTourVo;
import com.acat.vo.TourEntityVo;
import com.acat.vo.UpdateTourVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tour")
@SuppressWarnings("all")
@Slf4j
@Api(value = "tour表",tags = {"搭建tour表的所有接口"})
public class TourController {

    private static final Logger logger = LoggerFactory.getLogger(TourController.class);

    @Autowired
    private TourService tourService;

    @Autowired
    private HitCountService hitCountService;

    TourEntityVo tour = new TourEntityVo();

    TourEntity tourEntity = new TourEntity();

    @PostMapping("/addTour")
    @ApiOperation(value = "上传用旅游信息普通字段接口",notes = "上传用旅游信息普通字段接口")
    @ApiImplicitParam(value = "addTourVo的vo层",name = "addTourVo的vo层")
    public void addTour(@RequestBody AddTourVo addTourVo,HttpSession session){

        //RegisterEntity register = (RegisterEntity)session.getAttribute("registerEntity");

        tour.setBishe_tour_name(addTourVo.getBishe_tour_name());
        tour.setBishe_tour_province_name(addTourVo.getBishe_tour_province_name());
        tour.setBishe_tour_city_name(addTourVo.getBishe_tour_city_name());
        tour.setBishe_tour_desc(addTourVo.getBishe_tour_desc());
        tour.setBishe_tour_register_id(addTourVo.getBishe_register_id());
        tour.setBishe_tour_type(addTourVo.getBishe_tour_type());
    }

    @PostMapping("/addTourImage")
    @ApiOperation(value = "上传用旅游信息图片接口",notes = "上传用旅游信息图片接口")
    @ApiImplicitParam(value = "MultipartFile file",name = "MultipartFile file")
    public void addTourImage(MultipartFile file, HttpSession session){
//        String path = request.getServletContext().getRealPath("/");
//        System.out.println(path);
//
//        String fileName = file.getOriginalFilename();
//        System.out.println(fileName);
//
//        File targetFile = new File(path,fileName);
//        System.out.println("************"+targetFile.getAbsolutePath()+"************");
//
//        String zuizhongName = targetFile.getAbsolutePath();
//
//        try{
//            file.transferTo(targetFile);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        tour.setBishe_tour_image(zuizhongName);
//        System.out.println(tour);
//        System.out.println("-----------------------------");
//        tourService.addTour(tour);
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static" + "/upload/";

        String filename = UUID.randomUUID() + file.getOriginalFilename();

        System.out.println(filename);

        try{
            // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
            FileUtil.fileupload(file.getBytes(), path, filename);
        }catch (IOException e){
            e.printStackTrace();
        }

        tour.setBishe_tour_image("http://localhost:8080/" + "upload/" + filename);

        System.out.println("-----------------------------");
        System.out.println(tour);
        System.out.println("-----------------------------");

        tourService.addTour(tour);
    }
    @PostMapping("/updateTour")
    @ApiOperation(value = "修改用旅游信息普通字段接口",notes = "修改用旅游信息普通字段接口")
    @ApiImplicitParam(value = "addTourVo的vo层",name = "addTourVo的vo层")
    public void updateTour(@RequestBody UpdateTourVo updateTourVo){
        tourEntity.setBishe_tour_id(updateTourVo.getBishe_tour_id());
        tourEntity.setBishe_tour_name(updateTourVo.getBishe_tour_name());
        tourEntity.setBishe_tour_province_name(updateTourVo.getBishe_tour_province_name());
        tourEntity.setBishe_tour_city_name(updateTourVo.getBishe_tour_city_name());
        tourEntity.setBishe_tour_desc(updateTourVo.getBishe_tour_desc());
        tourEntity.setBishe_tour_register_id(updateTourVo.getBishe_tour_register_id());
        tourEntity.setBishe_tour_type(updateTourVo.getBishe_tour_type());
        log.info("tour====================="+tour);
    }

    @PostMapping("/UpdateTourImage")
    @ApiOperation(value = "修改用旅游信息图片接口",notes = "修改用旅游信息图片接口")
    @ApiImplicitParam(value = "MultipartFile file",name = "MultipartFile file")
    public void UpdateTourImage(MultipartFile file, HttpSession session){
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static" + "/upload/";

        String filename = UUID.randomUUID() + file.getOriginalFilename();

        System.out.println(filename);

        try{
            // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
            FileUtil.fileupload(file.getBytes(), path, filename);
        }catch (IOException e){
            e.printStackTrace();
        }

        tourEntity.setBishe_tour_image("http://localhost:8080/" + "upload/" + filename);

        System.out.println("-----------------------------");
        System.out.println(tourEntity);
        System.out.println("-----------------------------");

        tourService.updateTour(tourEntity);
    }

    @GetMapping("/deleteTour/{bishe_tour_id}")
    @ApiOperation(value = "删除旅游信息接口",notes = "删除旅游信息接口")
    @ApiImplicitParam(value = "bishe_tour_id",name = "bishe_tour_id")
    public void deleteTour(@PathVariable("bishe_tour_id") Integer bishe_tour_id){
        if(bishe_tour_id != null){
            tourService.deleteTour(bishe_tour_id);
        }
    }

    @GetMapping("/getTourById/{bishe_tour_id}")
    @ApiOperation(value = "通过id获取旅游信息接口",notes = "通过id获取旅游信息接口")
    @ApiImplicitParam(value = "bishe_tour_id",name = "bishe_tour_id")
    public TourEntity getTourById(@PathVariable("bishe_tour_id") Integer bishe_tour_id){
        TourEntity tou = null;
        if(bishe_tour_id != null){
            tou = tourService.getTourById(bishe_tour_id);
        }
        return tou;
    }

    @GetMapping("/getTourByRegisterId/{bishe_tour_registerId}")
    @ApiOperation(value = "通过id获取RegisterId接口",notes = "通过id获取RegisterId接口")
    @ApiImplicitParam(value = "bishe_tour_id",name = "bishe_tour_id")
    public List<TourEntity> getTourByRegisterId(@PathVariable("bishe_tour_registerId") Integer bishe_tour_registerId){

        List<TourEntity> list = null;

        if(bishe_tour_registerId != null){
            list = tourService.getTourByRegisterId(bishe_tour_registerId);
        }
        return list;
    }

    @GetMapping("/getTourAll")
    @ApiOperation(value = "获取所有的旅游信息接口",notes = "获取所有的旅游信息接口")
    public List<TourEntity> getTourAll(){
        List<TourEntity> list = tourService.getTourAll();
        return list;
    }

    @GetMapping("/getTourListByCity/{bishe_tour_city_name}")
    @ApiOperation(value = "通过bishe_tour_city_name获取所在省份的所有的旅游信息接口",notes = "通过bishe_tour_cityName获取所在省份的所有的旅游信息接口")
    @ApiImplicitParam(value = "bishe_tour_city_name",name = "bishe_tour_city_name")
    public List<TourEntity> getTourListByCity(@PathVariable("bishe_tour_city_name") String bishe_tour_city_name){
        List<TourEntity> list = null;

        if(bishe_tour_city_name != null && !"".equals(bishe_tour_city_name)){
            list = tourService.getTourListByCity(bishe_tour_city_name);
        }
        return list;
    }

    @GetMapping("/getTourEntityByHitCount")
    @ApiOperation(value = "通过点击次数的多少返回点击次数前四的四个",notes = "通过点击次数的多少返回点击次数前四的四个")
    public List<TourEntity> getTourEntityByHitCount(){

        List<TourEntity> tourList = new ArrayList<>();

        //首先获取点击次数最高的四个，找到他们的bishe_hitcount_tourId
        List<Integer> idList = hitCountService.getBishe_hitcount_tour_id();
        for(Integer id:idList){
            tourList.add(tourService.getTourById(id));
        }
        return tourList;
    }

    @GetMapping("/getTourListByMohuName/{info}")
    public List<TourEntity> getTourListByMohuName(@PathVariable("info") String info){
        if(info == null){
            return tourService.getTourAll();
        }else{
            return tourService.getTourListByTourName(info);
        }
    }


}
