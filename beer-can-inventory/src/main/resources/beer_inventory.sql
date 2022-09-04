drop database beercan;
create database if not exists beercan;

use beercan;

drop table if exists beer;
drop table if exists brewery;
drop table if exists tub;

CREATE TABLE beer (
		beer_id VARCHAR (5) NOT NULL,
		beer_name VARCHAR(30),
		PRIMARY KEY (beer_id)
        );


CREATE TABLE brewery (
		brewery_id VARCHAR(5) NOT NULL,
        beer_id VARCHAR (5) NOT NULL,
		brewery_name VARCHAR(20),
		PRIMARY KEY (brewery_id),
        FOREIGN KEY (beer_id) REFERENCES beer(beer_id)ON DELETE CASCADE
        
);			


CREATE TABLE tub (
		tub_id VARCHAR (5),
        brewery_id VARCHAR (5) ,
        beer_id VARCHAR(5), 
		tub_name VARCHAR(5),
        can_quantity VARCHAR(5),
		PRIMARY KEY (tub_id),
		FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)ON DELETE CASCADE,
		FOREIGN KEY (beer_id) REFERENCES beer(beer_id)ON DELETE CASCADE
);		

