drop database if exists bishe;
create database bishe;

use bishe;

#1.登录注册表
drop table if exists bishe_register;
create table `bishe_register`(
    `bishe_register_id` int(10) not null auto_increment,
    `bishe_register_username` varchar(20) not null COMMENT '用户名',
    `bishe_register_password` varchar(35) not null COMMENT '用户密码',
    `bishe_register_flag` int(2) not null COMMENT '是一个判断的标志，判断是管理员还是普通的用户',
    primary key (`bishe_register_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#2.用户完善信息表
drop table if exists bishe_user_info;
create table `bishe_user_info`(
    `bishe_user_info_id` int(10) not null auto_increment,
    `bishe_user_info_nike` varchar(20) not null COMMENT '用户昵称',
    `bishe_user_info_sex` varchar(2) not null COMMENT '用户性别',
    `bishe_user_info_email` varchar(20) not null COMMENT '用户email',
    `bishe_user_info_image` varchar(300) not null COMMENT '用户上传图像',
    `bishe_user_info_register_id` int(10) not null COMMENT '上传信息的所属人id',
    primary key (`bishe_user_info_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#3.发布旅游信息的表
drop table if exists bishe_tour;
create table `bishe_tour`(
    `bishe_tour_id` int(10) not null auto_increment,
    `bishe_tour_name` varchar(20) not null COMMENT '发布的旅游信息的名称',
    `bishe_tour_province_name` varchar(10) not null COMMENT '发布的旅游信息的省份,此处是一个下拉列表',
    `bishe_tour_city_name` varchar(15) not null COMMENT '发布的旅游信息的市区,此处是一个下拉列表',
    `bishe_tour_image` varchar(300) not null COMMENT '发布的旅游信息的照片',
    `bishe_tour_desc` text not null COMMENT '发布的旅游信息的简介',
    `bishe_tour_time` varchar(30) not null COMMENT '发布的旅游的时间',
    `bishe_tour_register_id` int(10) not null COMMENT '发布的旅游的人的id',
    `bishe_tour_type` varchar(10) not null COMMENT '景点对应的类型,例如大山，大河，地标建筑，自然景观，革命纪念旅游胜地，人文景观，其他',
    primary key (`bishe_tour_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#4.省级单位表
drop table if exists bishe_province;
create table `bishe_province`(
    `bishe_province_id` int(10) not null auto_increment,
    `bishe_province_name` varchar(10) not null COMMENT '省级名称',
    primary key (`bishe_province_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#5.市级单位表
drop table if exists bishe_city;
create table `bishe_city`(
    `bishe_city_id` int(10) not null auto_increment,
    `bishe_city_name` varchar(10) not null COMMENT '市级名称',
    `bishe_city_provinceId` int(10) not null COMMENT '市级对应省份',
    primary key (`bishe_city_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#6.用户收藏表
drop table if exists bishe_collect;
create table `bishe_collect`(
    `bishe_collect_id` int(10) not null auto_increment,
    `bishe_collect_tour_id` int(10) not null COMMENT '收藏旅游景点的id',
    `bishe_collect_register_id` int(10) not null COMMENT '对应的登录的人的收藏表',
    primary key (`bishe_collect_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#7.旅游景点的点击次数表
drop table if exists bishe_hitcount;
create table `bishe_hitcount`(
    `bishe_hitcount_id` int(10) not null auto_increment,
    `bishe_hitcount_count` int(10) default 0 COMMENT '旅游景点的点击次数',
    `bishe_hitcount_tour_id` int(10) not null COMMENT '对应的旅游景点的id',
    primary key (`bishe_hitcount_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#8.旅游景点的评论表
drop table if exists bishe_comment;
create table `bishe_comment`(
    `bishe_comment_id` int(10) not null auto_increment,
    `bishe_comment_content` varchar(100) not null COMMENT '旅游景点的评论内容',
    `bishe_comment_register_id` int(10) not null COMMENT '评论人的id',
    `bishe_comment_user_info_nick` varchar(20) not null COMMENT '评论人的昵称',
    `bishe_comment_tour_id` int(10) not null COMMENT '评论的旅游景点的id',
    primary key (`bishe_comment_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#9.个人投诉,支持匿名投诉
drop table if exists bishe_complain;
create table `bishe_complain`(
    `bishe_complain_id` int(10) not null auto_increment,
    `bishe_complain_content` TEXT COMMENT '投诉的内容',
    primary key (`bishe_complain_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#10.百度ocr识别照片接口需要上传的照片的存储位置
drop table if exists bishe_baiduimg;
create table `bishe_baiduimg`(
    `bishe_baiduimg_id` int(10) not null auto_increment,
    `bishe_baiduimg_image` varchar(300) not null COMMENT '上传的照片的路径',
    primary key (`bishe_baiduimg_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#11.轮播图对应的数据库
drop table if exists bishe_lunbo_img;
create table `bishe_lunbo_img`(
    `bishe_lunboimg_id` int(10) not null auto_increment,
    `bishe_lunboimg_image` varchar(300) not null COMMENT '轮播的照片的路径',
    primary key (`bishe_lunboimg_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#12.旅游景点的详情信息
drop table if exists bishe_tour_detail;
create table `bishe_tour_detail`(
    `bishe_tour_detail_id` int(10) not null auto_increment,
    `bishe_tour_detail_starnum` int(10) not null COMMENT '旅游景点的几个星',
    `bishe_tour_detail_message` varchar(300) not null COMMENT '旅游景点的友情提示',
    `bishe_tour_id` int(10) not null COMMENT '对应的旅游景点的id',
    primary key (`bishe_tour_detail_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;