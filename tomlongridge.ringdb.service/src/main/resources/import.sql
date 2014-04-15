INSERT INTO COUNTRIES (name) VALUES ('UK');
INSERT INTO COUNTIES (name, country_id) VALUES ('Somerset', LAST_INSERT_ID());
INSERT INTO TOWERS (dedication, location, city, county_id, num_bells) VALUES ('St Mary the Virgin','Bathwick','Bath',LAST_INSERT_ID(), 10);
INSERT INTO PEALS (date, tower_id) VALUES ('2014-04-01', LAST_INSERT_ID());