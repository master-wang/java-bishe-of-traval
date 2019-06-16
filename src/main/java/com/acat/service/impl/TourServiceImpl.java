package com.acat.service.impl;

import com.acat.dao.TourDao;
import com.acat.entity.TourEntity;
import com.acat.service.TourService;
import com.acat.util.TimeUtil;
import com.acat.vo.TourEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * #3.发布旅游信息的表
 * drop table if exists bishe_tour;
 * create table `bishe_tour`(
 *     `bishe_tour_id` int(10) not null auto_increment,
 *     `bishe_tour_name` varchar(20) not null COMMENT '发布的旅游信息的名称',
 *     `bishe_tour_province_name` varchar(10) not null COMMENT '发布的旅游信息的省份,此处是一个下拉列表',
 *     `bishe_tour_city_name` varchar(15) not null COMMENT '发布的旅游信息的市区,此处是一个下拉列表',
 *     `bishe_tour_image` varchar(300) not null COMMENT '发布的旅游信息的照片',
 *     `bishe_tour_desc` text not null COMMENT '发布的旅游信息的简介',
 *     `bishe_tour_time` varchar(30) not null COMMENT '发布的旅游的时间',
 *     `bishe_tour_register_id` int(10) not null COMMENT '发布的旅游的人的id',
 *     `bishe_tour_type` varchar(10) not null COMMENT '景点对应的类型,例如大山，大河，地标建筑，自然景观，革命纪念旅游胜地，人文景观，其他',
 *     primary key (`bishe_tour_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@Service("tourService")
public class TourServiceImpl implements TourService {

    @Autowired
    private TourDao tourDao;

    /**
     * 发布旅游信息
     * @param tourEntityVo
     */
    public void addTour(TourEntityVo tourEntityVo){
        tourEntityVo.setBishe_tour_time(TimeUtil.orderNum());
        tourDao.addTour(tourEntityVo.getBishe_tour_name(),tourEntityVo.getBishe_tour_province_name(),tourEntityVo.getBishe_tour_city_name(),
                tourEntityVo.getBishe_tour_image(),tourEntityVo.getBishe_tour_desc(),tourEntityVo.getBishe_tour_time(),
                tourEntityVo.getBishe_tour_register_id(),tourEntityVo.getBishe_tour_type());

    }
    /**
     * 删除旅游信息
     * @param bishe_tour_id
     */
    public void deleteTour(Integer bishe_tour_id){
        tourDao.deleteTour(bishe_tour_id);
    }

    /**
     * 修改旅游信息
     * @param tour
     */
    public void updateTour(TourEntity tour){
        tour.setBishe_tour_time(TimeUtil.orderNum());
        tourDao.updateTour(tour.getBishe_tour_id(),tour.getBishe_tour_name(),tour.getBishe_tour_province_name(),
                tour.getBishe_tour_city_name(),tour.getBishe_tour_image(),tour.getBishe_tour_desc(),
                tour.getBishe_tour_time(), tour.getBishe_tour_register_id(),tour.getBishe_tour_type());
        tourDao.save(tour);
    }

    /**
     * 根据发布的旅游信息id查找该记录的全部信息
     * @param bishe_tour_id
     * @return
     */
    public TourEntity getTourById(Integer bishe_tour_id){
        return tourDao.getTourById(bishe_tour_id);
    }


    /**
     * 查找登录用户发布的全部旅游信息
     * @param bishe_tour_register_id
     * @return
     */
    public List<TourEntity> getTourByRegisterId(Integer bishe_tour_register_id){
        return tourDao.getTourByRegisterId(bishe_tour_register_id);
    }

    /**
     * 查找所有的旅游信息
     * @return
     */
    public List<TourEntity> getTourAll(){
        return tourDao.getTourAll();
    }

    /**
     * 根据一个城市名称获取该城市的景点
     * @return
     */
    public List<TourEntity> getTourListByCity(String bishe_tour_city_name){
        return tourDao.getTourListByCity(bishe_tour_city_name);
    }

    /**
     * 根据tour的name名称进行模糊查询
     * @param bishe_tour_name
     * @return
     */
    public List<TourEntity> getTourListByTourName(String bishe_tour_name){
        return tourDao.getTourListByTourName(bishe_tour_name);
    }
}

