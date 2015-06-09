CREATE DATABASE pic_manager;

GRANT select,insert,delete,update ON pic_manager.* to neuq IDENTIFIED by '123';

use pic_manager;

CREATE TABLE admin(user_name varchar(20) primary key,password varchar(20));

CREATE TABLE users(user_name varchar(20) primary key,password varchar(20),name varchar(20),sex varchar(6),age varchar(20),tel varchar(30),address varchar(40),email varchar(30),icon_path varchar(40));

CREATE TABLE pictures(picture_id varchar(256) primary key,picture_title varchar(256),user_name varchar(20),favourite int,path varchar(256));

CREATE TABLE messages(id varchar(256) primary key,content varchar(256),sender varchar(20),receiver varchar(20),time varchar(256));

insert into admin(user_name,password) values('admin','admin');
