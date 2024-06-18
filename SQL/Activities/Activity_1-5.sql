REM   Script: Activity_1-5
REM   Activity_1-5

create table salesman( 
  salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int   
);

describe salesman


create table salesman( 
  salesman_id int primary key, 
    salesman_name varchar2(32) not null, 
    salesman_city varchar2(32), 
    commission int);

describe salesman


drop table salesman;

create table salesman( 
  salesman_id int primary key, 
    salesman_name varchar2(32) not null, 
    salesman_city varchar2(32), 
    commission int);

describe salesman


INSERT ALL 
    INTO salesman VALUES(5001, 'James Hoog', 'New York', 15) 
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

alter table salesman add grade int;

update salesman set grade=100;

select * from salesman;

update salesman set grade=200 where salesman_city='Rome';

update salesman set grade=300 where salesman_name='James Hoog';

update salesman set salesman_name='Pierre' where salesman_name='McLyon';

select * from salesman;

