create table member(
    id varchar2(30) primary key,
    password varchar2(30) not null,
    name varchar2(30) not null,
    gender char(1) constraint gender_check check (gender in('f', 'm'))
);

select * from member;
select * from user_constraints;

insert into member values('test', '1234', 'ȫ�浿', 'm');
commit;
delete from member where id = 'karadsik7';