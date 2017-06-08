CREATE DATABASE `readmunity`  
CHARACTER SET 'utf8'  
COLLATE 'utf8_general_ci';

USE readmunity;

SET NAMES utf8;

CREATE TABLE IF NOT EXISTS user (
	id SMALLINT(6) NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	avator VARCHAR(255) NOT NULL,
	address VARCHAR(255),
	email VARCHAR(50),
	qq VARCHAR(50),
	weibo VARCHAR(50),
	github VARCHAR(50),
	twitter VARCHAR(50),
	score SMALLINT(6),
	reputation VARCHAR(12),
	PRIMARY KEY(id)
)ENGINE = InnoDB DEFAULT CHAR SET = utf8;

INSERT INTO user(name,password,address,email,qq,score,reputation) VALUES ('赖文强','123','China','1260091093@qq.com','1260091093',1000,'将军');