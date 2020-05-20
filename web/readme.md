#创建项目数据库

create database servlet_practise;

#创建表
use servlet_practise;
drop table if exists person;
create table person(
    id int primary key auto_increment,  -- id
    name varchar(50),                   -- 姓名
    age int,                            -- 年龄
    gender int,                         -- 性别
    birthday date,                      -- 出生日期
    mobile varchar(25),                 -- 手机号码
    home  varchar(255)                  -- 家庭住址
);