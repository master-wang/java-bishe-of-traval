package com.acat.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

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
 *     `bishe_tour_count` int(100) default 0 COMMENT '旅游景点点击的次数',
 *     `bishe_tour_time` varchar(30) not null COMMENT '发布的旅游的时间',
 *     `bishe_tour_register_id` int(10) not null COMMENT '发布的旅游的人的id',
 *     `bishe_tour_type` varchar(10) not null COMMENT '景点对应的类型,例如大山，大河，地标建筑，自然景观，革命纪念旅游胜地，人文景观，其他',
 *     primary key (`bishe_tour_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
public class TourEntityVo implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * 发布的旅游信息的名称
     */
    private String bishe_tour_name;

    /**
     * 发布的旅游信息的省份,此处是一个下拉列表
     */
    private String bishe_tour_province_name;

    /**
     * 发布的旅游信息的市区,此处是一个下拉列表
     */
    private String bishe_tour_city_name;

    /**
     * 发布的旅游信息的照片
     */
    private String bishe_tour_image;

    /**
     * 发布的旅游信息的简介
     */
    private String bishe_tour_desc;

    /**
     * 发布的旅游的时间
     */
    private String bishe_tour_time;

    /**
     * 发布的旅游的人的id
     */
    private Integer bishe_tour_register_id;

    /**
     * 景点对应的类型,例如大山，大河，地标建筑，自然景观，革命纪念旅游胜地，人文景观，其他
     */
    private String bishe_tour_type;
}
