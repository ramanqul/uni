create database uni character set utf8 collate utf8_general_ci;

create table students(student_id bigint not null auto_increment primary key, student_sid varchar(32) not null, username varchar(50) not null, firstname varchar(50),lastname varchar(50));
create table courses(course_id bigint not null auto_increment primary key, name varchar(256) not null);
create table subjects(subject_id bigint not null auto_increment primary key, subject_code varchar(50) not null
, title varchar(512) not null
, description varchar(2048) not null
, course_id bigint not null);

create table catalogs(catalog_id bigint not null auto_increment primary key, credits int not null,subject_id bigint not null, faculty_id bigint not null,term_id bigint not null);
create table faculties(faculty_id bigint not null auto_increment primary key, name varchar(128) not null,faculty_code varchar(50) not null);
create table terms(term_id bigint not null auto_increment primary key, name varchar(128) not null,start_date datetime,end_date datetime);

create table classes(class_id bigint not null auto_increment primary key, subject_id bigint not null, faculty_id bigint not null,term_id bigint not null,seat_number int not null, credits int not null,comments varchar(256));
create table class_enroll(class_enroll_id bigint not null auto_increment primary key, 
	class_id bigint not null, 
	student_id bigint not null,
	group_name varchar(100) not null, 
	apply_date datetime not null,
	enroll_date datetime,
	enroll_status varchar(50) not null);


insert into courses values(1,"Math");
insert into courses values(2,"Physics");
insert into courses values(6,"Programming");

insert into faculties values(1,"Faculty Of Engineering","EN");
insert into terms values(1,"Fall 2010/2011",null,null);
insert into students values(1,"sid123","student1","StudentF","StudentL");
insert into subjects values(1,"CS302","Software Engineering","Some Description",6);
insert into classes values(1,1,1,1,5,4,"Some Comment");

/*
 * 
 * ALTER TABLE `uni`.`courses` CHANGE COLUMN `couse_id` `course_id` BIGINT(20) NOT NULL AUTO_INCREMENT;
 *
 * ALTER TABLE `uni`.`subjects` MODIFY COLUMN `course_id` BIGINT(20);
 *  
 */


