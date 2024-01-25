DROP TABLE IF EXISTS authorities;

DROP TABLE IF EXISTS users;

-- table structure for table users

CREATE TABLE users(
    username NVARCHAR(50) PRIMARY KEY NOT NULL,
    password NVARCHAR(68) NOT NULL,
    enabled TINYINT NOT NULL
);

-- 
-- Fro Bcrypting the password: https://www.bcryptcalculator.com/
-- 
INSERT INTO users VALUES
    ('john','{bcrypt}$2a$10$GquiMbLFCnwsDEzUKIdDROsW6NxqrvHwbLxpx3r0Wktxixlr8Yhmq',1),
    ('mary','{bcrypt}$2a$10$GquiMbLFCnwsDEzUKIdDROsW6NxqrvHwbLxpx3r0Wktxixlr8Yhmq',1),
    ('susan','{bcrypt}$2a$10$GquiMbLFCnwsDEzUKIdDROsW6NxqrvHwbLxpx3r0Wktxixlr8Yhmq',1)

CREATE TABLE authorities(
    username NVARCHAR(50) NOT NULL,
    authority NVARCHAR(50) NOT NULL
)

ALTER TABLE authorities ADD CONSTRAINT
FK_USERNAME_TBLAUTHORITIES FOREIGN KEY(username) REFERENCES users(username)


ALTER TABLE authorities ADD CONSTRAINT
CK_USERNAME_AUTHORITY_TBLAUTHORITY UNIQUE(username,authority)

INSERT INTO authorities VALUES
    ('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN')
    