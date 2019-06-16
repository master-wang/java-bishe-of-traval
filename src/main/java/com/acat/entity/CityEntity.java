package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #市级单位表
 * create table `bishe_city`(
 *     `bishe_city_id` int(10) not null auto_increment,
 *     `bishe_city_name` varchar(10) not null COMMENT '市级名称',
 *     `bishe_city_province_id` int(10) not null COMMENT '市级对应的省份',
 *     primary key (`bishe_city_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_city")
public class CityEntity implements Serializable {

    private static final long serialVersionUID =2L;

    /**
     * bishe_city_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_city_id;

    /**
     * 市级名称
     */
    private String bishe_city_name;

    /**
     * 市级对应的省份
     */
    private Integer bishe_city_province_id;

}
