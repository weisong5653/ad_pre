
create table login_mark(
`login_mark_id` int auto_increment primary key,
 `schoolId` int(11) NOT NULL,
`teacherName` varchar(20) NOT NULL,
`password` varchar(40) NOT NULL
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;