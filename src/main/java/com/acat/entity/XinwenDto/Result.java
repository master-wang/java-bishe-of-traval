package com.acat.entity.XinwenDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Setter
@Getter
public class Result implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer stat;

    private List<Data> data;

}
