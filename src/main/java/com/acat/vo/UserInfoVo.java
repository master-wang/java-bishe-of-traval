package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * #普通用户信息表
 * drop table if exists bishe_userInfo;
 * create table `bishe_userInfo`(
 *     `bishe_userInfo_id` int(10) not null auto_increment,
 *     `bishe_userInfo_nike` varchar(20) not null COMMENT '用户昵称',
 *     `bishe_userInfo_sex` varchar(2) not null COMMENT '用户性别',
 *     `bishe_userInfo_email` varchar(20) not null COMMENT '用户email',
 *     `bishe_userInfo_image` varchar(30) not null COMMENT '用户上传图像',
 *     `bishe_userInfo_registerId` int(10) not null COMMENT '上传信息的所属人id',
 *     primary key (`bishe_userInfo_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Getter
@Setter
public class UserInfoVo implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * bishe_register_id
     */
    private Integer bishe_register_id;

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
}
