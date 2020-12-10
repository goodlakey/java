create TABLE IF NOT EXISTS satellites (
id INT NOT NULL AUTO_INCREMENT,
satellite_name VARCHAR(45) NOT NULL,
satellite_radius int NOT NULL,
planet_id int NOT NULL,
distance int NOT NULL,
PRIMARY KEY (id));

create TABLE IF NOT EXISTS planets (
id INT NOT NULL AUTO_INCREMENT,
planet_name VARCHAR(30) NOT NULL,
planet_radius INT NULL,
temp_core INT NULL,
atmosphere VARCHAR(30) NULL,
life VARCHAR(30) NULL,
satellite_count INT null,
PRIMARY KEY (id),
FOREIGN KEY (satellite_count) references satellites(id));

create TABLE IF NOT EXISTS galaxy (
id INT NOT NULL auto_increment,
galaxy_name varchar(45) not null,
planets_id int null,
PRIMARY KEY (id),
FOREIGN KEY (planets_id) references planets(id));