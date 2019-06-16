package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #登录注册表
 * drop table if exists bishe_register;
 * create table `bishe_register`(
 *     `bishe_register_id` int(10) not null auto_increment,
 *     `bishe_register_username` varchar(20) not null COMMENT '用户名',
 *     `bishe_register_password` varchar(35) not null COMMENT '用户密码',
 *     `bishe_register_flag` int(2) not null COMMENT '是一个判断的标志，判断是管理员还是普通的用户',
 *     primary key (`bishe_register_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_register")
public class RegisterEntity implements Serializable {


    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_register_id;

    /**
     * 用户名
     */
    private String bishe_register_username;

    /**
     * 用户密码
     */
    private String bishe_register_password;

    /**
     * 是一个判断的标志，判断是管理员还是普通的用户
     */
    private Integer bishe_register_flag;
}
