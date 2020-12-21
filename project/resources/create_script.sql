CREATE DATABASE mydb;


use mydb;

CREATE TABLE IF NOT EXISTS incomes (
	incomes_id INT NOT NULL AUTO_INCREMENT,
    incomes_name VARCHAR(45) NOT NULL,
    incomes_sum int NOT NULL,
    PRIMARY KEY(incomes_id)
);

CREATE TABLE IF NOT EXISTS expenses (
	expenses_id INT NOT NULL AUTO_INCREMENT,
    expenses_name VARCHAR(64) NOT NULL,
    expenses_sum int NOT NULL,
    PRIMARY KEY(expenses_id)
);

CREATE TABLE IF NOT EXISTS familymember (
	familymember_id INT NOT NULL AUTO_INCREMENT,
    incomes_id INT NOT NULL,
    expenses_id INT NULL,
    familymember_name varchar(45)  NOT NULL,
    PRIMARY KEY(familymember_id),
    FOREIGN KEY (incomes_id) REFERENCES incomes(incomes_id),
    FOREIGN KEY (expenses_id) REFERENCES expenses(expenses_id)
);