create database BankManagementSystem;

show databases;

use BankManagementSystem;

create table signup (formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(30), city varchar(20), state varchar(25), pin varchar(20));

create table signupTwo (Formno varchar(20), religion varchar(20), Category varchar(20), Income varchar(20), Education varchar(20), Occupation varchar(20), Pan varchar(20), Aadhar varchar(20), SeniorCitizen varchar(20), ExistingAccount varchar(20));

create table  signupThree (Formno varchar(20), AccountType varchar(20), CardNnumber varchar(25), Pin varchar(10), Facility varchar(100));

create table login (formno varchar(20), CardNumber varchar(25), Pin varchar(10));

show tables;

select * from signup;
SELECT * FROM signuptwo;
select * from signupthree;
select * from login;

create table bank (pin varchar(20), date varchar(50), type varchar(20), amount varchar(20));

drop table bank;

select * from bank