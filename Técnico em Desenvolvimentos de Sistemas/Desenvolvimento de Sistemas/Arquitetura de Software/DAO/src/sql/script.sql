create schema if not exists db_dao;

create table users(
	id int auto_increment primary key,
    name varchar(45) not null
);