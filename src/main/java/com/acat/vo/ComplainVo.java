package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *#个人投诉,支持匿名投诉
 * drop table if exists bishe_complain;
 * create table `bishe_complain`(
 *     `bishe_complain_id` int(10) not null auto_increment,
 *     `bishe_complain_content` TEXT COMMENT '投诉的内容',
 *     primary key (`bishe_complain_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Getter
@Setter
public class ComplainVo implements Serializable {

    /**
     * 投诉的内容
     */
    private String bishe_complain_content;

}
