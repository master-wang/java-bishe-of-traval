package com.acat.entity.IpDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * {
 *     "response":{
 *         "level":11,
 *         "y":4039281,
 *         "ip":"222.24.6.92",
 *         "x":12127500,
 *         "city":"西安"
 *     },
 *     "status":"ok"
 * }
 */

@ToString
@Getter
@Setter
public class IpResponse implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * "level":11,
     * "y":4039281,
     * "ip":"222.24.6.92",
     * "x":12127500,
     * "city":"西安"
     */
    private Response response;

    /**
     * ok
     */
    private String status;
}
