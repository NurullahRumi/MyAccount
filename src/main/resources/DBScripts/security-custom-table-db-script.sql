drop table if exists nr_roles;
drop table if exists nr_users;


create table nr_users(

                         user_name varchar(100) not null,
                         ur_id varchar(50) primary key not null,
                         pw char(68) not null,
                         enabled int not null,
                         user_email varchar(50) not null,
                         user_ph varchar(20),
                         user_address varchar(1000)

);

insert into nr_users
values
    ('Md Nurullah Rumi','NURULLAH','{bcrypt}$2a$12$XITWIHJIvyro53f98XAX3.EekDE2GNfurR/v/rgGbr4XU.yAudh82',1, 'nurullah@gmail.com','0122342323','Kendua, Netrakona'),
    ('Tanjina Rubaida Munni','MUNNI','{bcrypt}$2a$10$MKchM/RaZUyP48ccmvGxYeK.L66QxkibfO7yo.tGCP1V/MDMlxVYi',1,'munni@gmail.com','1234234235','Rajibpur,Kendua, Netrakona'),
    ('Nujaira','NUJU','{bcrypt}$2a$10$X6DREaEDmcV7/Dtv9z6lsuKeekbebvDWS/sx3MZbJA3qEzz2O8wOS',1,'nuju@gmail.com','235346354','Santibag,Kendua,Netrakona');



Create table nr_roles(

                         ur_id varchar(50) not null,
                         roles varchar(50) not null,

                         unique (ur_id,roles),
                         CONSTRAINT fk_customer
                             FOREIGN KEY(ur_id)
                                 REFERENCES nr_users(ur_id)
);

insert into nr_roles
values
    ('NURULLAH','ROLE_EMPLOYEE'),
    ('NURULLAH','ROLE_MANAGER'),
    ('NURULLAH','ROLE_ADMIN'),
    ('MUNNI','ROLE_EMPLOYEE'),
    ('MUNNI','ROLE_MANAGER'),
    ('NUJU','ROLE_EMPLOYEE');


select * from nr_users;
select * from nr_roles ;