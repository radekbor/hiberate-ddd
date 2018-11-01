CREATE TABLE House (
  id INTEGER  PRIMARY KEY not null,
  city varchar(25) not null ,
  street varchar(25) not null,
  buildingNumber INTEGER not null,
  subNumber INTEGER
);

INSERT INTO House (id, city, street, buildingNumber) VALUES (1, 'Washington', 'Pennsylvania Ave', 1600);