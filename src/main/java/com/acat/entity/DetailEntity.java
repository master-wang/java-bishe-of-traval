package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #12.旅游景点的详情信息
 * drop table if exists bishe_tour_detail;
 * create table `bishe_tour_detail`(
 *     `bishe_tour_detail_id` int(10) not null auto_increment,
 *     `bishe_tour_detail_starnum` int(10) not null COMMENT '旅游景点的几个星',
 *     `bishe_tour_detail_message` varchar(300) not null COMMENT '旅游景点的友情提示',
 *     `bishe_tour_id` int(10) not null COMMENT '对应的旅游景点的id',
 *     primary key (`bishe_tour_detail_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_tour_detail")
public class DetailEntity implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * bishe_tour_detail_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_tour_detail_id;

    /**
     * 旅游景点的几个星
     */
    private Integer bishe_tour_detail_starnum;

    /**
     * 旅游景点的友情提示
     */
    private String bishe_tour_detail_message;

    /**
     * 对应的旅游景点的id
     */
    private Integer bishe_tour_id;
}
