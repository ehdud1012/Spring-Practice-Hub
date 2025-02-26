create table sep30_product (
	p_name varchar2(10 char) primary key,
	p_price number(5) not null
);

insert into sep30_product values ('마이크', 20000);
insert into sep30_product values ('볼펜', 2000);

select * from sep30_product;

