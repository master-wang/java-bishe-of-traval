package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #个人投诉,支持匿名投诉
 * drop table if exists bishe_complain;
 * create table `bishe_complain`(
 *     `bishe_complain_id` int(10) not null auto_increment,
 *     `bishe_complain_content` TEXT COMMENT '投诉的内容',
 *     primary key (`bishe_complain_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_complain")
public class ComplainEntity implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * bishe_complain_id
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_complain_id;

    /**
     *投诉的内容
     */
    private String bishe_complain_content;
}
