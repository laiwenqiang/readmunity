CREATE DATABASE `readmunity`  
CHARACTER SET 'utf8'  
COLLATE 'utf8_general_ci';

USE readmunity;

SET NAMES utf8;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `avatar` varchar(255) DEFAULT '/img/avatar/default.png',
  `bio` VARCHAR(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `weibo` varchar(50) DEFAULT NULL,
  `github` varchar(50) DEFAULT NULL,
  `twitter` varchar(50) DEFAULT NULL,
  `score` smallint(6) DEFAULT NULL,
  `reputation` varchar(12) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT '0',
  `validateCode` varchar(50) DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user(username,password,address,email,qq,score,reputation,status) VALUES ('赖文强','123','China','1260091093@qq.com','1260091093',1000,'将军',1);
INSERT INTO user(username,password,status) VALUES ('admin','admin',1);