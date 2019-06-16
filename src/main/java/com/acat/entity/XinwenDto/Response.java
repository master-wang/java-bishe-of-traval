package com.acat.entity.XinwenDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class Response implements Serializable {

    private static final long serialVersionUID = 2L;

    private String reason;

    private Result result;

    private Integer error_code;
}
