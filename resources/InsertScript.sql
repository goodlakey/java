insert into mydb_10.satellites(satellite_name,satellite_radius,planet_id,distance) values
				('луна',1737,1,384467),
				('фобос',11,2,9400),
				('ио',1821,3,421600),
				('европа',1560,4,670900),
				('ганимед',2634,5,930500),
				('калисто',2410,6,1882000),
				('мимас',198,7,185000),
				('тефия',531,8,234500);

insert into mydb_10.planets(planet_name,planet_radius,temp_core,atmosphere,life,satellite_count)values
                ('меркурий',2439,2400,'есть','нет',null),
                ('Венера',6051,5000,'есть','нет',null),
                ('Земля',6371,5960,'есть','yes',1),
                ('Марс',3389,6000,'есть','нет',null),
                ('Юпитер',69911,24000,'есть','нет',3),
                ('Юпитер',69911,24000,'есть','нет',4),
                ('Юпитер',69911,24000,'есть','нет',5),
                ('Юпитер',69911,24000,'есть','нет',6),
                ('Сатурн',58232,11700,'есть','нет',7),
                ('Сатурн',58232,11700,'есть','нет',8);



insert into mydb_10.galaxy(galaxy_name,planets_id)values
                ('Млечный путь',1),
                ('Млечный путь',2),
                ('Млечный путь',3),
                ('Млечный путь',4),
                ('Млечный путь',5),
                ('Млечный путь',6);