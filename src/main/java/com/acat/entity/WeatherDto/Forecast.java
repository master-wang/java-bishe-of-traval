package com.acat.entity.WeatherDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

}
