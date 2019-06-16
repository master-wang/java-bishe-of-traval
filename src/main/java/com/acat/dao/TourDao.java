package com.acat.dao;

import com.acat.entity.TourEntity;
import com.acat.vo.TourEntityVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
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

public interface TourDao extends JpaRepository<TourEntity,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into bishe_tour(bishe_tour_name,bishe_tour_province_name,bishe_tour_city_name,bishe_tour_image,bishe_tour_desc,bishe_tour_time,bishe_tour_register_id,bishe_tour_type) values(?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
    void addTour(String bishe_tour_name,String bishe_tour_province_name,String bishe_tour_city_name,String bishe_tour_image,String bishe_tour_desc,String bishe_tour_time,Integer bishe_tour_register_id,String bishe_tour_type);

    @Transactional
    @Modifying
    @Query(value = "update bishe_tour set bishe_tour_name=?2,bishe_tour_province_name=?3,bishe_tour_city_name=?4,bishe_tour_image=?5,bishe_tour_desc=?6,bishe_tour_time=?7,bishe_tour_register_id=?8,bishe_tour_type=?9 where bishe_tour_id=?1",nativeQuery = true)
    void updateTour(Integer bishe_tour_id,String bishe_tour_name,String bishe_tour_province_name,String bishe_tour_city_name,String bishe_tour_image,String bishe_tour_desc,String bishe_tour_time,Integer bishe_tour_register_id,String bishe_tour_type);

    /**
     * 删除旅游信息
     * @param bishe_tour_id
     */
    @Transactional
    @Modifying
    @Query(value = "delete from TourEntity en where en.bishe_tour_id=?1")
    void deleteTour(Integer bishe_tour_id);


    /**
     * 根据发布的旅游信息id查找该记录的全部信息
     * @param bishe_tour_id
     * @return
     */
    @Query(value = "select en from TourEntity en where en.bishe_tour_id=?1")
    TourEntity getTourById(Integer bishe_tour_id);

    /**
     * 查找所有的旅游信息
     * @return
     */
    @Query(value = "select en from TourEntity en")
    List<TourEntity> getTourAll();

    /**
     * 查找登录用户发布的全部旅游信息
     * @param bishe_tour_register_id
     * @return
     */
    @Query(value = "select en from TourEntity en where en.bishe_tour_register_id=?1")
    List<TourEntity> getTourByRegisterId(Integer bishe_tour_register_id);

    /**
     * 根据一个城市名称获取该城市的景点
     * @return
     */
    @Query(value = "select en from TourEntity en where en.bishe_tour_city_name LIKE concat('%',?1,'%')")
    List<TourEntity> getTourListByCity(String bishe_tour_city_name);


    /**
     * 根据tour的name名称进行模糊查询
     * @param bishe_tour_name
     * @return
     */
    @Query(value = "select en from TourEntity en where en.bishe_tour_name LIKE concat('%',?1,'%')")
    List<TourEntity> getTourListByTourName(String bishe_tour_name);

    /**
     * 根据tour的id查询他所属的类型
     * @param bishe_tour_id
     * @return
     */
    @Query(value = "select en.bishe_tour_type from TourEntity en where en.bishe_tour_id=?1")
    String getTourType(Integer bishe_tour_id);

    @Query(value = "select en from TourEntity en where en.bishe_tour_type=?1")
    List<TourEntity> getTourEntityByType(String bishe_tour_type);
}
