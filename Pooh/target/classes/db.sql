create table pooh2_member(
	pm_id varchar2(10 char) primary key,
	pm_pw varchar2(10 char) not null,
	pm_name varchar2(10 char) not null,
	pm_photo varchar2(100 char) not null,
	pm_birthday date not null
);

create table pooh2_sns(
	ps_no number(3) primary key,
	ps_txt varchar2(100 char) not null,
	ps_date date not null,
	ps_writer varchar2(10 char) not null,
	constraint sns_writer
		foreign key(ps_writer) references pooh2_member(pm_id)
		on delete cascade
);

create table pooh2_sns_reply(
	psr_no number(4) primary key,
	psr_ps_no number(3) not null,
	psr_writer varchar2(10 char) not null,
	psr_txt varchar2(100 char) not null,
	psr_date date not null,
	constraint sns_no
		foreign key(psr_ps_no) references pooh2_sns(ps_no)
		on delete cascade,
	constraint sns_r_writer
		foreign key(psr_writer) references pooh2_member(pm_id)
		on delete cascade
);

create sequence pooh2_sns_reply_seq;


create sequence pooh2_sns_seq;

delete from pooh2_sns where ps_no = '41';


select ps_writer from pooh2_sns;

select *
from (
	select rownum as rn, ps_no, ps_txt, ps_date, ps_writer
	from (
		select * from pooh2_sns
	)
) 
where rn >= 5 and rn <= 8;


select pm_photo
from pooh2_member 
where pm_id in (select ps_writer
	from (
		select rownum as rn, ps_writer
		from (
			select ps_writer from pooh2_sns
		)
	) 
	where rn >= 5 and rn <= 8);

select *
from (
	select rownum as rn, ps_no, ps_txt, ps_date, ps_writer
	from (
		select ps_no, ps_txt, ps_date, ps_writer from pooh2_sns
	)
) 
where rn >= 5 and rn <= 8

select * 
from 
	(
		select ps_no, ps_txt, ps_date, ps_writer
		from 
			(
			select rownum as rn, ps_no, ps_txt, ps_date, ps_writer
			from (
				select * 
				from pooh2_sns
				where ps_writer like '%'||#{search}||'%' or ps_txt like '%'||#{search}||'%'
				order by ps_date desc
				)
			) 
			where rn &gt;= #{start} and rn &lt;= #{end}
			), 
			(
			select pm_photo, pm_id
			from pooh2_member 
			where pm_id in (
							select ps_writer
							from (
								select rownum as rn, ps_no, ps_txt, ps_date, ps_writer
								from (
									select * 
									from pooh2_sns
									where ps_writer like '%'||#{search}||'%' or ps_txt like '%'||#{search}||'%'
									order by ps_date desc
								)
							) 
							where rn &gt;= #{start} and rn &lt;= #{end}
					)
	)
where ps_writer = pm_id
order by ps_date desc


select *
from pooh2_sns_reply 
where psr_ps_no in (
			select ps_no
			from (
				select rownum as rn, ps_no
				from (
					select * 
					from pooh2_sns
					where ps_writer like '%'||#{search}||'%' or ps_txt like '%'||#{search}||'%'
					order by ps_date desc
				)
			) 
			where rn &gt;= #{start} and rn &lt;= #{end}



select * 
from (
	select rownum as rn,  ps_no, ps_txt, ps_date, ps_writer, pm_photo 
	from (
		select * 
		from pooh2_sns, pooh2_member
		where ps_writer = pm_id and ps_writer like '%'||#{search}||'%' or ps_txt like '%'||#{search}||'%'
		order by ps_date desc
	)
) 
where rn &gt;= #{start} and rn &lt;= #{end}

select * from pooh2_member;
select * from pooh2_sns;
select * from pooh2_gallery;








create table pooh2_gallery(
	pg_no number(4) primary key,
	pg_writer varchar2(10 char) not null,
	pg_title varchar2(20 char) not null,
	pg_file varchar2(100 char) not null,
	pg_date date not null,
	constraint pg_wwriter
		foreign key(pg_writer) references pooh2_member(pm_id)
		on delete cascade
);

create sequence pooh2_gallery_seq;


insert into pooh2_gallery values(pooh2_gallery_seq.nextval, #{pg_writer}, #{pg_title}, #{pg_file}, sysdate)



select pg_writer, pg_title, pg_file, pg_date
from (
	select rownum as rn, pg_writer, pg_title, pg_file, pg_date
	from (
		select pg_writer, pg_title, pg_file, pg_date 
		from pooh2_gallery
		where pg_title like '%'||#{search}||'%'
		order by pg_date desc
	)
) 
where rn >= 1 and rn &lt;= #{g_end}



'%'||#{search}||'%'
select * from pooh2_gallery order by pg_date desc


