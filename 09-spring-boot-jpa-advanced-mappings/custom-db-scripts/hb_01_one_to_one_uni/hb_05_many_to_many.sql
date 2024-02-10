DROP SCHEMA IF EXISTS hb_05_many_to_many;

CREATE DATABASE hb_05_many_to_many;

use hb_05_many_to_many;

DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail (
  id int primary key Identity,
  youtube_channel nvarchar(128) DEFAULT NULL,
  hobby nvarchar(45) DEFAULT NULL,
);

DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
  id int Primary key Identity,
  first_name nvarchar(45) DEFAULT NULL,
  last_name nvarchar(45) DEFAULT NULL,
  email nvarchar(45) DEFAULT NULL,
  instructor_detail_id int Foreign key References instructor_detail(id)
);


DROP TABLE IF EXISTS course;

CREATE TABLE course (
  id int primary key IDENTITY,
  title nvarchar(128) UNIQUE DEFAULT NULL,
  instructor_id int DEFAULT NULL Foreign Key References instructor(id)
);

DROP TABLE IF EXISTS review;

CREATE TABLE review (
    id int PRIMARY key IDENTITY,
    comment NVARCHAR(256) DEFAULT NULL,
    course_id int DEFAULT NULL FOREIGN KEY REFERENCES course(id)
);

DROP TABLE IF EXISTS student;

CREATE TABLE student (
  id int Identity Primary Key,
  first_name nvarchar(45) DEFAULT NULL,
  last_name nvarchar(45) DEFAULT NULL,
  email nvarchar(45) DEFAULT NULL
);

DROP TABLE IF EXISTS course_student;

CREATE TABLE course_student (
  course_id int NOT NULL Foreign Key References course(id),
  student_id int NOT NULL Foreign key References student(id)
  CONSTRAINT PK_Course_Student PRIMARY Key(course_id,student_id) 
);

