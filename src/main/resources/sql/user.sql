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
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `avator` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `weibo` varchar(50) DEFAULT NULL,
  `github` varchar(50) DEFAULT NULL,
  `twitter` varchar(50) DEFAULT NULL,
  `score` smallint(6) DEFAULT NULL,
  `reputation` varchar(12) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '状态位，注册之后是否激活',
  `validateCode` varchar(50) DEFAULT NULL COMMENT '验证码注册和密码重置的时候用到',
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `resetPassTime` timestamp  NULL DEFAULT NULL COMMENT '修改密码的时间',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user(username,password,address,email,qq,score,reputation,status) VALUES ('赖文强','123','China','1260091093@qq.com','1260091093',1000,'将军',1);
INSERT INTO user(username,password,email,status) VALUES ('admin','admin','readtest@sina.com',1);
