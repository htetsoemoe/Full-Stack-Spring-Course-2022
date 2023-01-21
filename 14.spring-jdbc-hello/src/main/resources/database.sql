drop table if exists member;

create table if not exists member(
	loginId varchar(20) primary key,
	password varchar(20) not null,
	name varchar(25) not null,
	phone varchar(15),
	email varchar(40)
);