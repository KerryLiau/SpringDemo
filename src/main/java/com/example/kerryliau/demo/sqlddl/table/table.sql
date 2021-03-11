SET search_path TO grand_sages_demo;

DROP TYPE IF EXISTS dog CASCADE;

CREATE TYPE dog AS (
	name VARCHAR(32),
	age INTEGER,
	weight INTEGER
);

DROP TABLE IF EXISTS people CASCADE;

CREATE TABLE people (
	roc_id CHAR(10),
	name VARCHAR (32),
	dogs dog[]
);


INSERT INTO people VALUES ('A123456789')


