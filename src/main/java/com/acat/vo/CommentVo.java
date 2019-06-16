package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class CommentVo implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer bishe_register_id;

    /**
     * 旅游景点的评论内容
     */
    private String bishe_comment_content;

    /**
     * 评论的旅游景点的id
     */
    private Integer bishe_comment_tour_id;

}
