package com.acat.entity;

/**
 * #用户完善信息表
 * drop table if exists bishe_user_info;
 * create table `bishe_user_info`(
 *     `bishe_user_info_id` int(10) not null auto_increment,
 *     `bishe_user_info_nike` varchar(20) not null COMMENT '用户昵称',
 *     `bishe_user_info_sex` varchar(2) not null COMMENT '用户性别',
 *     `bishe_user_info_email` varchar(20) not null COMMENT '用户email',
 *     `bishe_user_info_image` varchar(30) not null COMMENT '用户上传图像',
 *     `bishe_user_info_register_id` int(10) not null COMMENT '上传信息的所属人id',
 *     primary key (`bishe_user_info_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_user_info")
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * bishe_userInfo_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_user_info_id;

    /**
     * 用户昵称
     */
    private String bishe_user_info_nike;

    /**
     * 用户性别
     */
    private String bishe_user_info_sex;

    /**
     * 用户email
     */
    private String bishe_user_info_email;

    /**
     * 用户上传的图像
     */
    private String bishe_user_info_image;

    /**
     * 上传信息的所属人的id',
     */
    private Integer bishe_user_info_register_id;
}
