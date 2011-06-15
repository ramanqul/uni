create if not exists database uni character set utf8 collate utf8_general_ci;

create table students(student_id bigint not null auto_increment primary key, student_sid varchar(32) not null, username varchar(50) not null, firstname varchar(50),lastname varchar(50));