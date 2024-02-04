DROP DATABASE IF EXISTS hb_03_one_to_many;

CREATE DATABASE hb_03_one_to_many;

use hb_03_one_to_many;

DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail (
  id int primary key Identity,
  youtube_channel nvarchar(128) DEFAULT NULL,
  hobby nvarchar(45) DEFAULT NULL,
);


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
