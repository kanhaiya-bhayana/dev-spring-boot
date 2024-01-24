DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS members;

-- table structure for table users

CREATE TABLE members(
    user_id NVARCHAR(50) PRIMARY KEY NOT NULL,
    password NVARCHAR(68) NOT NULL,
    active TINYINT NOT NULL
);

-- 
-- Fro Bcrypting the password: https://www.bcryptcalculator.com/
-- 
INSERT INTO members VALUES
    ('john','{bcrypt}$2a$10$GquiMbLFCnwsDEzUKIdDROsW6NxqrvHwbLxpx3r0Wktxixlr8Yhmq',1),
    ('mary','{bcrypt}$2a$10$GquiMbLFCnwsDEzUKIdDROsW6NxqrvHwbLxpx3r0Wktxixlr8Yhmq',1),
    ('susan','{bcrypt}$2a$10$GquiMbLFCnwsDEzUKIdDROsW6NxqrvHwbLxpx3r0Wktxixlr8Yhmq',1)

CREATE TABLE roles(
    user_id NVARCHAR(50) NOT NULL,
    role NVARCHAR(50) NOT NULL
)

ALTER TABLE roles ADD CONSTRAINT
FK_USERID_TBLROLES FOREIGN KEY(user_id) REFERENCES members(user_id)


ALTER TABLE roles ADD CONSTRAINT
CK_USERID_ROLE_TBLROLES UNIQUE(user_id,role)

INSERT INTO roles VALUES
    ('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN')
    