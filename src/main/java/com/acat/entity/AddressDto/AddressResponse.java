package com.acat.entity.AddressDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class AddressResponse implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * 1
     */
    private Integer status;

    /**
     * OK
     */
    private String info;

    /**
     *10000
     */
    private String infocode;

    /**
     * 陕西省
     */
    private String province;

    /**
     * 西安市
     */
    private String city;

    /**
     * 610100
     */
    private String adcode;

    /**
     * 108.6664045,34.10936173;109.2156243,34.43880538
     */
    private String rectangle;
}
