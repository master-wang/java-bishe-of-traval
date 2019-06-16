package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #百度ocr识别照片接口需要上传的照片的存储位置
 * drop table if exists bishe_baiduimg;
 * create table `bishe_baiduimg`(
 *     `bishe_baiduimg_id` int(10) not null auto_increment,
 *     `bishe_baiduimg_image` varchar(300) not null COMMENT '上传的照片的路径',
 *     primary key (`bishe_baiduimg_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_baiduimg")
public class BaiduImgEntity implements Serializable {


    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_baiduimg_id;

    private String bishe_baiduimg_image;

}
