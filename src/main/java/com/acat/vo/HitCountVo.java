package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class HitCountVo implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * 对应的旅游景点的id
     */
    private Integer bishe_hitcount_tour_id;

}
