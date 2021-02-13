drop database springau;
create database springau;
use springau;
select database();
create table category
(
	cacode varchar(50) not null,
	caname varchar(100),
  primary key(cacode)
);
create table product
(
	pcode int not null,
	pname varchar(100),
	unitprice int,
	cacode varchar(50) not null,
	primary key(pcode),
  foreign key(cacode) references category(cacode)
);
create table location
(
  lcode int,
	lname varchar(100),
  primary key(lcode)
);
create table customer
(
	cid int,
	cname varchar(100),
	cdob date,
	cphone int,
	cgender varchar(10),
  lcode int(100),
  primary key(cid),
  foreign key(lcode) references location(lcode)
);
create table salesexecutive
(
	sid int,
	sname varchar(100),
	sdob date,
	sphone int,
	sgender varchar(10),
  lcode int,
  primary key(sid),
  foreign key(lcode) references location(lcode)
);
create table purchases
(
dop date,
noofunits int,
pcode int,
cid int
);

insert into category values('g1','CAT1');
insert into category values('g2','CAT2');
insert into category values('g3','CAT3');
select * from category;

insert into product values(1,'tekken1',100,'g1');
insert into product values(2,'tekken2',200,'g1');
insert into product values(3,'tekken3',300,'g2');
insert into product values(4,'tekken4',400,'g2');
select * from product;



insert into location values(501,'Hyderabad');
insert into location values(502,'nalgonda');
insert into location values(503,'vijayawada');
insert into location values(504,'warangal');
select * from location;

insert into salesexecutive values(10,'s1','2000-01-20',123,'male',501);
insert into salesexecutive values(20,'s2','2000-02-21',234,'female',501);
insert into salesexecutive values(30,'s3','2000-03-12',345,'male',502);
insert into salesexecutive values(40,'s4','2000-04-23',145,'female',503);
select * from salesexecutive;

insert into customer values(100,'c1','2000-04-11',678,'Female',501);
insert into customer values(200,'c2','1999-12-15',768,'Female',502);
insert into customer values(300,'c3','2000-03-11',789,'Male',501);
insert into customer values(400,'c4','2000-04-11',987,'Male',502);
select * from customer;


insert into purchases values('2021-04-01',2,1,100);
insert into purchases values('2021-05-11',3,1,200);
insert into purchases values('2021-03-12',1,1,300);
insert into purchases values('2021-01-15',5,2,200);
insert into purchases values('2021-03-21',5,2,100);
insert into purchases values('2021-05-22',5,3,400);
select * from purchases;
