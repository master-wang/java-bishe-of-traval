package com.acat.entity.XinwenDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class Data implements Serializable {

    private static final long serialVersionUID = 2L;

    private String uniquekey;

    private String title;

    private String date;

    private String category;

    private String author_name;

    private String url;

    private String thumbnail_pic_s;

    private String thumbnail_pic_s02;

    private String thumbnail_pic_s03;
}
