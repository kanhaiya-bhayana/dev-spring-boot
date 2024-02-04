DROP DATABASE IF EXISTS hb_01_one_to_one_uni;

CREATE DATABASE hb_01_one_to_one_uni;

use hb_01_one_to_one_uni;


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

