drop database if exists hou;
create database hou;

use hou;

#房产表
drop table if exists house;
create table `house`(
    `id` bigint(20) unsigned not null auto_increment COMMENT '主键id',
    `name` varchar(20) not null default '' COMMENT '房产名称',
    `type` tinyint(1) not null default '0' COMMENT '1:销售，2:出租',
    `price` int(11) not null COMMENT '单位元',
    `images` varchar(1024) not null default '' COMMENT '图片地置',
    `area` int(11) not null default '0' COMMENT '面积',
    `beds` int(11) not null default '0' COMMENT 'wopu数量',
    `baths` int(11) not null default '0' COMMENT '卫生间数量',
    `rating` double not null default '0' COMMENT '评级',
    `remarks` varchar(512) not null default '' COMMENT '房产描述',
    `properties` varchar(512) not null default '' COMMENT '属性',
    `floor_plan` varchar(250) not null default '' COMMENT '户型图',
    `tags` varchar(20) not null default '' COMMENT '标签',
    `create_time` date not null COMMENT '创建时间',
    `city_id` int(11) not null default '0' COMMENT '城市名称',
    `community_id` int(11) not null default '0' COMMENT '小区名称',
    `address` varchar(20) not null default '0' COMMENT '房产地置',
    `state` tinyint(1) default '1' COMMENT '1-上jia,2-下jia',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#小区表
drop table if exists community;
create table `community`(
    `id` int(11) unsigned not null auto_increment,
    `city_code` varchar(11) not null default '' COMMENT '城市编码',
    `name` varchar(50) not null default '' COMMENT '小区名称',
    `city_name` varchar(11) not null default '' COMMENT '城市名称',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#用户表
drop table if exists userr;
create table `userr`(
    `id` bigint(20) unsigned not null auto_increment COMMENT '主键',
    `name` varchar(20) not null default '' COMMENT '姓名',
    `phone` char(13) not null default '' COMMENT '手机号',
    `email` varchar(90) not null default '' COMMENT '电子email',
    `aboutme` varchar(250) not null default '' COMMENT '自我介绍',
    `passwd` varchar(512) not null default '' COMMENT '经过md5加密过的密码',
    `avatar` varchar(512) not null default '' COMMENT '图像照片',
    `type` tinyint(1) not null COMMENT '1:普通用户,2:房产经济人',
    `create_time` date not null COMMENT '创建时间',
    `enable` tinyint(1) not null COMMENT '是否启用,1:启用,0:停用',
    `agency_id` int(11) not null default '0' COMMENT '所属经济机构',
    primary key(`id`),
    unique key `idx_email` (`email`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#房产用户表
drop table if exists house_user;
create table `house_user`(
    `id` bigint(20) unsigned not null auto_increment,
    `house_id` bigint(20) not null COMMENT '房屋的id',
    `user_id` bigint(20) not null COMMENT '用户的id',
    `create_time` date not null COMMENT '创建时间',
    `type` tinyint(1) not null COMMENT '1:售卖,2:收藏',
    primary key(`id`),
    unique key `house_id_user_id_type` (`house_id`,`user_id`,`type`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#房产留言表
drop table if exists house_msg;
create table `house_msg`(
    `id` bigint(20) unsigned not null auto_increment,
    `msg` varchar(512) not null default '' COMMENT '消息',
    `create_time` date not null COMMENT '创建时间',
    `agent_id` bigint(20) not null COMMENT '经纪人id',
    `house_id` bigint(20) not null COMMENT '房屋的id',
    `user_name` varchar(20) not null default '' COMMENT '用户姓名',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#经纪机构表
drop table if exists agency;
create table `agency`(
    `id` int(11) unsigned not null auto_increment,
    `name` varchar(20) not null default '' COMMENT '经纪机构名称',
    `address` varchar(100) not null default '' COMMENT '地置',
    `phone` varchar(30) not null default '' COMMENT '手机',
    `email` varchar(50) not null default '' COMMENT '电子又见',
    `about_us` varchar(100) not null default '' COMMENT '描述',
    `mobile` varchar(11) not null default '' COMMENT '电话',
    `web_site`varchar(20) not null default '' COMMENT '网站',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#评论表
drop table if exists comment;
create table `comment`(
    `id` bigint(20) unsigned not null auto_increment,
    `content` varchar(512) not null default '' COMMENT '评论内容',
    `house_id` bigint(20) not null COMMENT '房屋的id',
    `create_time` date not null COMMENT '发布时间',
    `blog_id` int(11) not null COMMENT '博客的id',
    `type` tinyint(1) not null COMMENT '类型1-房屋评论,2-博客评论',
    `user_id` bigint(20) not null COMMENT '评论用户',
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#百科表
drop table if exists blog;
create table `blog`(
    `id` int(11) unsigned not null auto_increment,
    `tags` varchar(20) not null default '' COMMENT '标签',
    `content` text not null COMMENT '内容',
    `create_time` date not null COMMENT '日期',
    `title` varchar(20) not null default '' COMMENT '标题',
    `cat` int(11) default null COMMENT '分类1-准备买房，2-看房/选房，3-签约/定房，4-全款/贷款，5-浇水/过户，6-入住/交接，7-买房风险',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;