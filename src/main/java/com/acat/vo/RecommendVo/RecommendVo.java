package com.acat.vo.RecommendVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class RecommendVo implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer bishe_collect_register_id;

    private String city;

}
