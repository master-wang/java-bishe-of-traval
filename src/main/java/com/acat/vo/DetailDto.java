package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class DetailDto implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * 旅游景点的几个星
     */
    private Integer bishe_tour_detail_starnum;

    /**
     * 旅游景点的友情提示
     */
    private String bishe_tour_detail_message;

    /**
     * 对应的旅游景点的id
     */
    private Integer bishe_tour_id;
}
