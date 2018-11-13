use ad_pre;
set global event_scheduler = on;
-- show procedure status;
-- show grants;
create table IF NOT EXISTS user(
id int primary key auto_increment,
name varchar(20),
sex varchar(2),
type varchar(10),
age tinyint(10)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- 删除存储过程
-- DROP PROCEDURE IF EXISTS `insertdata`;
-- 清除表的数据
truncate table user;


-- 创建存储过程
-- delimiter //
-- create procedure `insertdata` ()
-- BEGIN
-- 	declare count1 int default 1;
-- 	WHILE (count1<=500) DO
-- 		insert into user(name,sex,type,age) values('liewisong','1','student','21');
-- 		set count1=count1+1;
-- 	END WHILE;
-- END;

-- call和上面的创建存储过程不能同时使用
call insertdata();

