create table oct02_gallery (
	o_no number(5) primary key,
	o_title varchar2(20 char) not null,
	o_file varchar2(100 char) not null,
	o_date date not null
);

create sequence oct02_gallery_seq;

insert into oct02_gallery values (oct02_gallery_seq.nextval, 'text', 'text.png', to_date(sysdate, 'YYYY-MM-DD'));
						
insert into oct02_gallery values (oct02_gallery_seq.nextval, to_date(sysdate, ));

select * from oct02_gallery;
