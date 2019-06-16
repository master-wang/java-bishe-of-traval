package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #旅游景点的点击次数表
 * drop table if exists bishe_hitcount;
 * create table `bishe_hitcount`(
 *     `bishe_hitcount_id` int(10) not null auto_increment,
 *     `bishe_hitcount_count` int(10) not null COMMENT '旅游景点的点击次数',
 *     `bishe_hitcount_tour_id` int(10) not null COMMENT '对应的旅游景点的id',
 *     primary key (`bishe_hitcount_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "bishe_hitcount")
public class HitcountEntity implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * bishe_hitcount_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_hitcount_id;

    /**
     * 旅游景点的点击次数
     */
    private Integer bishe_hitcount_count;

    /**
     * 对应的旅游景点的id
     */
    private Integer bishe_hitcount_tour_id;

}
