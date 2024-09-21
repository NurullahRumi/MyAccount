drop table if exists nr_roles;
drop table if exists nr_members;

create table nr_members(

                           user_name varchar(50) primary key not null,
                           pw char(68) not null,
                           enabled int not null

);

insert into nr_members
values
    ('rumi','{bcrypt}$2a$12$Xrp4v39BX.Q/M2mNnDwZ/.2Oj6IL0MKNyGYYv6BTIdzOhVW7mu.vq',1),
    ('munni','{bcrypt}$2a$12$XS0/alb6/THMJTtM/c1qw.7d4v/9jh7b3uBDPd6loZXETbEk1YHgm',1),
    ('nuju','{bcrypt}$2a$12$.VByu9Lq3.1m4xVEyT/4/O8EXBRtSIyN7OEWR67fgHEOpKn8Dv5va',1);


Create table nr_roles(

                         user_name varchar(50) not null,
                         role varchar(50) not null,

                         unique (user_name,role),
                         CONSTRAINT fk_customer
                             FOREIGN KEY(user_name)
                                 REFERENCES nr_members(user_name)
);

insert into nr_roles
values
    ('rumi','ROLE_EMPLOYEE'),
    ('rumi','ROLE_MANAGER'),
    ('rumi','ROLE_ADMIN'),
    ('munni','ROLE_EMPLOYEE'),
    ('munni','ROLE_MANAGER'),
    ('nuju','ROLE_EMPLOYEE');


select user_name, pw, enabled from nr_members where user_name =?;
select user_name, role from nr_roles where user_name = ?;
