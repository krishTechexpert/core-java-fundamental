package com.krish.securityProjectwithJPA.config;

/*
* create database securityDemo;
show databases;
use securityDemo;


*
select * from user;
*
* /*
*
#   username krish password---root   and it is admin
#   username simran password ---123  and it is user
*
*
*
select * from role;

1. ROLE_ADMIN
2. ROLE_USER

insert into user(password,username) values(
	'$2a$12$05TSJ8Eo7kuAbEJxySQvNOrj1tZWNyYsl0UrCh14MKul1yGPd/h5O',
    'simran'
);

insert into role (name) values('USER');

update role set name='ROLE_USER' where id=2;

insert into user_roles(user_id,role_id) values ('1','1'),('2','2');

select * from user_roles;
*
* */


public class SQLQuery {
}
