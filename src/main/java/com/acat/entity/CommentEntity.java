package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #旅游景点的评论表
 * drop table if exists bishe_comment;
 * create table `bishe_comment`(
 *     `bishe_comment_id` int(10) not null auto_increment,
 *     `bishe_comment_content` varchar(100) not null COMMENT '旅游景点的评论内容',
 *     `bishe_comment_register_id` int(10) not null COMMENT '评论人的id',
 *     `bishe_comment_user_info_nick` varchar(20) not null COMMENT '评论人的昵称',
 *     `bishe_comment_tour_id` int(10) not null COMMENT '评论的旅游景点的id',
 *     primary key (`bishe_comment_id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "bishe_comment")
public class CommentEntity implements Serializable {

    /**
     * bishe_comment_id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bishe_comment_id;

    /**
     * 旅游景点的评论内容
     */
    private String bishe_comment_content;

    /**
     * 评论人的id
     */
    private Integer bishe_comment_register_id;

    /**
     * 评论人的昵称
     */
    private String bishe_comment_user_info_nick;

    /**
     * 评论的旅游景点的id
     */
    private Integer bishe_comment_tour_id;
}
