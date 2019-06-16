package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #市级单位表
 * drop table if exists bishe_city;
 * create table `bishe_city`(
 *     `bishe_city_id` int(10) not null auto_increment,
 *     `bishe_city_name` varchar(10) not null COMMENT '市级名称',
 *     `bishe_city_provinceId` int(10) not null COMMENT '市级对应省份',
 *     primary key (`bishe_city_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Getter
@Setter
@Entity
@Table(name = "bishe_province")
public class ProvinceEntity implements Serializable {

    private static final long serialVersionUID = 2L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_province_id;

    /**
     * 省级名称
     */
    private String bishe_province_name;

}
