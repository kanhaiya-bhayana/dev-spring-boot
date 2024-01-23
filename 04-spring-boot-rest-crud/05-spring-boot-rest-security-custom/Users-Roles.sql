DROP TABLE IF EXISTS authorities;

DROP TABLE IF EXISTS users;

-- table structure for table users

CREATE TABLE users(
    username NVARCHAR(50) PRIMARY KEY NOT NULL,
    password NVARCHAR(50) NOT NULL,
    enables TINYINT NOT NULL
);

INSERT INTO users VALUES
    ('john','{noop}test123',1),
    ('mary','{noop}test123',1),
    ('susan','{noop}test123',1)

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
    