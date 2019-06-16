package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class RegisterVo implements Serializable {

    private static final long serialVersionUID = 2L;

    private String bishe_register_username;

    private String bishe_register_password;

    private String bishe_register_repassword;
}

