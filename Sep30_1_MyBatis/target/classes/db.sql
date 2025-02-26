create table sep30_product (
	p_name varchar2(10 char) primary key,
	p_price number(5) not null
);

insert into sep30_product values ('마이크', 20000);
insert into sep30_product values ('볼펜', 2000);
insert into sep30_product values ('사탕', 250);
insert into sep30_product values ('마이쮸', 1000);
insert into sep30_product values ('스티커', 1900);
insert into sep30_product values ('샤프', 2500);
insert into sep30_product values ('형광펜', 2500);

select * from sep30_product;
select * from sep30_product where p_name like '%마%';



update sep30_product set p_price = ${p_price} where p_price = ${p_price};