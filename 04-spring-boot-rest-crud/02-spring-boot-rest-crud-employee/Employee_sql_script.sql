DROP TABLE IF EXISTS employee

CREATE TABLE employee(
	id INT PRIMARY KEY IDENTITY(101,1),
	first_name NVARCHAR(50),
	last_name NVARCHAR(50),
	email NVARCHAR(50)
);

INSERT INTO employee values
						('Leslie','Andrews','leslie@andrews.com'),
						('Emma','Baumgarten','emma@baumgarten.com'),
						('Avani','Gupta','avani@gupta.com'),
						('Yuri','Petrov','yuri@petrov.com'),
						('Juan','Vega','juan@vega.com')