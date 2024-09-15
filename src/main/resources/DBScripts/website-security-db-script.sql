drop table if exists authorities;
drop table if exists users;

create table users(

	username varchar(50) primary key not null,
	password char(68) not null,
	enabled int not null

);

insert into users
values
('rumi','{bcrypt}$2a$10$Dip4RHdyRZCtfE5ypMrfguuyDpV3bRYA8G7.sBZKQ6FOK3qbVGPNy',1),
('munni','{bcrypt}$2a$10$MKchM/RaZUyP48ccmvGxYeK.L66QxkibfO7yo.tGCP1V/MDMlxVYi',1),
('nuju','{bcrypt}$2a$10$X6DREaEDmcV7/Dtv9z6lsuKeekbebvDWS/sx3MZbJA3qEzz2O8wOS',1);


Create table authorities(

	username varchar(50) not null,
	authority varchar(50) not null,

	unique (username,authority),
	CONSTRAINT fk_customer
      FOREIGN KEY(username)
        REFERENCES users(username)
);

insert into authorities
values
('rumi','ROLE_EMPLOYEE'),
('rumi','ROLE_MANAGER'),
('rumi','ROLE_ADMIN'),
('munni','ROLE_EMPLOYEE'),
('munni','ROLE_MANAGER'),
('nuju','ROLE_EMPLOYEE');

