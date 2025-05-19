create table USERS (
	userId smallserial primary key,
	userEmail varchar(20) not null unique,
	password varchar(20) not null,
	name varchar(20) not null,
	role varchar(20) not null
)