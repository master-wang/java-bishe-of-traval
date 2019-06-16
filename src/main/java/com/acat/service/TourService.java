package com.acat.service;

import com.acat.entity.TourEntity;
import com.acat.vo.TourEntityVo;

import java.util.List;

public interface TourService{

    /**
     * 发布旅游信息
     * @param tourEntityVo
     */
    void addTour(TourEntityVo tourEntityVo);

    /**
     * 删除旅游信息
     * @param bishe_tour_id
     */
    void deleteTour(Integer bishe_tour_id);

    /**
     * 修改旅游信息
     * @param tour
     */
    void updateTour(TourEntity tour);

    /**
     * 根据发布的旅游信息id查找该记录的全部信息
     * @param bishe_tour_id
     * @return
     */
    TourEntity getTourById(Integer bishe_tour_id);


    /**
     * 查找登录用户发布的全部旅游信息
     * @param bishe_tour_register_id
     * @return
     */
    List<TourEntity> getTourByRegisterId(Integer bishe_tour_register_id);

    /**
     * 查找所有的旅游信息
     * @return
     */
    List<TourEntity> getTourAll();

    /**
     * 根据一个城市名称获取该城市的景点
     * @return
     */
    List<TourEntity> getTourListByCity(String bishe_tour_city_name);

    /**
     * 根据tour的name名称进行模糊查询
     * @param bishe_tour_name
     * @return
     */
    List<TourEntity> getTourListByTourName(String bishe_tour_name);

}
