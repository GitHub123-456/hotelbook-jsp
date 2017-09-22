# 新建hotelbook数据库
CREATE DATABASE `hotelbook` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- 新建表loginhb，此表的用处是登录数据的存储表，与项目中其余表无联系 
CREATE TABLE `loginhb` (
  `id`      INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '唯一标示号',
  `name`    VARCHAR(45) NOT NULL
  COMMENT '登录账户的用户名，在数据库中不打算做太多的限制。\n长度的限制打算放到前后端来实现。',
  `pwd`     VARCHAR(45) NOT NULL
  COMMENT '密码，同用户名数据库中不做限制。',
  `purview` INT(11)     NOT NULL
  COMMENT '权限，初步打算是权限分级使用。\n看最终实现是否确定启用。',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

-- 为loginhb表插入一条默认的管理员账户 
INSERT INTO `hotelbook`.`loginhb` (`name`, `pwd`, `purview`) VALUE ("root", "toor", 0);

