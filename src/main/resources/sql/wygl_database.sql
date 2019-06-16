drop database if exists wygl_database;
create database wygl_database;

use wygl_database;

drop table if exists users;
create table `users`(
    `id` int(10) not null auto_increment,
    `yh` varchar(50) null,
    `name` varchar(50) null,
    `dep` varchar(50) null,
    `password` varchar(50) null,
    `acl` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.wyfee;
create table `dbo.wyfee`(
    `id` int(10) not null auto_increment,
    `feenum` varchar(50) null,
    `buildnum` varchar(50) null,
    `cellnum` varchar(50) null,
    `roomnum` varchar(50) null,
    `ispayment` varchar(50) null,
    `shouqurq` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.build;
create table `dbo.build`(
    `id` int(10) not null auto_increment,
    `buildnum` varchar(50) not null,
    `name` varchar(10) not null,
    `addr` varchar(50) not null,
    `info` varchar(50) not null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.fee;
create table `dbo.fee`(
    `id` int(10) not null auto_increment,
    `feenum` varchar(50) null,
    `feename` varchar(10) null,
    `moneynum` varchar(50) null,
    `shouqutime` varchar(50) null,
    `info` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.lodgecomplaint;
create table `dbo.lodgecomplaint`(
    `id` int(10) not null auto_increment,
    `buildnum` varchar(50) null,
    `cellnum` varchar(10) null,
    `roomnum` varchar(50) null,
    `lodgeusername` varchar(50) null,
    `reason` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.news;
create table `dbo.news`(
    `id` int(10) not null auto_increment,
    `title` varchar(50) null,
    `contant` varchar(10) null,
    `senddate` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.resident;
create table `dbo.resident`(
    `id` int(10) not null auto_increment,
    `residentnum` varchar(50) null,
    `name` varchar(10) null,
    `buildnum` varchar(50) null,
    `cellnum` varchar(50) null,
    `roomnum` varchar(50) null,
    `area` varchar(50) null,
    `otherinfo` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists dbo.sendrepair;
create table `dbo.sendrepair`(
    `id` int(10) not null auto_increment,
    `buildnum` varchar(50) null,
    `cellnum` varchar(50) null,
    `roomnum` varchar(50) null,
    `repairgoods` varchar(50) null,
    `repairpersonname` varchar(50) null,
    `repairtime` varchar(50) null,
    `isrepair` varchar(50) null,
    `repairedtime` varchar(50) null,
    `isrepaired` varchar(50) null,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;