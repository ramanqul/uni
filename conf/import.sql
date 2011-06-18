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

insert into courses values(1,"Math");
insert into courses values(2,"Physics");

/*
 * 
 * ALTER TABLE `uni`.`courses` CHANGE COLUMN `couse_id` `course_id` BIGINT(20) NOT NULL AUTO_INCREMENT;
 *
 * ALTER TABLE `uni`.`subjects` MODIFY COLUMN `course_id` BIGINT(20);
 *  
 */


