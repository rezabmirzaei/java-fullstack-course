-- DUMMY DATA

DROP TABLE IF EXISTS tb_dummy;

CREATE TABLE tb_dummy (
	id int4 NOT NULL,
	code varchar(5) NOT NULL,
	CONSTRAINT tb_dummy_pkey PRIMARY KEY (id)
);