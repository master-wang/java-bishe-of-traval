package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #用户收藏表
 * drop table if exists bishe_collect;
 * create table `bishe_collect`(
 *     `bishe_collect_id` int(10) not null auto_increment,
 *     `bishe_collect_tour_id` int(10) not null COMMENT '收藏旅游景点的id',
 *     `bishe_collect_register_id` int(10) not null COMMENT '对应的登录的人的收藏表',
 *     primary key (`bishe_collect_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Getter
@Setter
@Entity
@Table(name = "bishe_collect")
public class CollectEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * bishe_collect_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_collect_id;

    /**
     * 收藏旅游景点的id
     */
    private Integer bishe_collect_tour_id;

    /**
     * 对应的登录的人的收藏表
     */
    private Integer bishe_collect_register_id;
}
