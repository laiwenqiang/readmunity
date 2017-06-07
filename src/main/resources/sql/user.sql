CREATE DATABASE `readmunity`  
CHARACTER SET 'utf8'  
COLLATE 'utf8_general_ci';

use readmunity;

set names utf8;

create table user (
	id smallint(6) not null auto_increment,
	name varchar(50) not null,
	address varchar(255),
	email varchar(50),
	qq varchar(50),
	weibo varchar(50),
	github varchar(50),
	twitter varchar(50),
	score smallint(6),
	reputation varchar(12),
	primary key(id)
)engine=InnoDB Default charset=utf8;

insert into user(name,address,email,qq,score,reputation)values('赖文强','China','1260091093@qq.com','1260091093',1000,'将军');