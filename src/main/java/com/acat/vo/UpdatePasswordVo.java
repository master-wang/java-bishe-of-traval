package com.acat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class UpdatePasswordVo implements Serializable {

    /**
     *
     */
    private Integer bishe_register_id;

    /**
     * 原密码
     */
    private String bishe_register_password;

    /**
     * 新密码
     */
    private String bishe_register_newpassword;

    /**
     * 重复新密码
     */
    private String bishe_register_renewpassword;
}
