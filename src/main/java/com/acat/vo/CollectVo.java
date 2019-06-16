package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class CollectVo implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer bishe_register_id;

    private Integer bishe_collect_tour_id;

}
