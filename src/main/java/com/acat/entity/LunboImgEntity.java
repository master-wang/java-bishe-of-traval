package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 轮播图对应的数据库
 * drop table if exists bishe_lunbo_img;
 * create table `bishe_lunbo_img`(
 *     `bishe_lunboimg_id` int(10) not null auto_increment,
 *     `bishe_lunboimg_image` varchar(300) not null COMMENT '轮播的照片的路径',
 *     primary key (`bishe_lunboimg_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_lunbo_img")
public class LunboImgEntity implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_lunboimg_id;

    private String bishe_lunboimg_image;
}
