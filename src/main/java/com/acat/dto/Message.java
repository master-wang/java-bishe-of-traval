package com.acat.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Setter
@Getter
public class Message implements Serializable {

    public static final long serialVersionUID = 2L;

    private  String  alert;
    private List<String> names;
    private  String  sendMsg;
    private String  from;
    private String  date;

}
