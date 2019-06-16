package com.acat.entity.TaobaoDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * {
 *     "code":0,
 *     "data":{
 *         "ip":"117.32.216.50",
 *         "country":"中国",
 *         "area":"",
 *         "region":"陕西",
 *         "city":"西安",
 *         "county":"XX",
 *         "isp":"电信",
 *         "country_id":"CN",
 *         "area_id":"",
 *         "region_id":"610000",
 *         "city_id":"610100",
 *         "county_id":"xx",
 *         "isp_id":"100017"
 *     }
 * }
 */

@ToString
@Setter
@Getter
public class DataResponse implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer code;

    private Data data;
}
