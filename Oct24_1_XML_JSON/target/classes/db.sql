create table oct24_1_snack(
	s_name varchar2(10 char) primary key,
	s_price number(4) not null
);

insert into oct24_1_snack values('새우깡', '1500');
insert into oct24_1_snack values('양파깡', '1700');
insert into oct24_1_snack values('감자깡', '1300');

select * from oct24_1_snack;

create table oct25_1_book(
	b_title varchar2(20 char) primary key,
	b_price number(5) not null
);

insert into oct25_1_book values('어서오세요 휴남동 서점입니다', '15000');
insert into oct25_1_book values('오늘은 이만 좀 쉴게요', '14000');
insert into oct25_1_book values('잘했고 잘하고 있고 잘될 것이다', '18000');

select * from oct25_1_book;

drop table oct25_1_book;