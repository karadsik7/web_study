select * from tabs;

create table product(
    id number primary key,
    category varchar2(30),
    model varchar2(30) unique,
    manufacturer varchar2(30) not null,
    price number not null,
    retail_pct number not null,
    image_s varchar2(100) not null,
    image_l varchar2(100) not null,
    content clob not null,
    regdate date not null
);

create sequence seq_product_id;

create table cart(
    id number primary key,
    p_id number references product(id),
    u_id varchar2(30)
    
);

alter table cart add count number not null;
drop table cart;
create sequence seq_cart_id;

insert into PRODUCT values(SEQ_PRODUCT_ID.NEXTVAL, 'sports', 'helmet-18', 'hellg', 50000, 0.10, 
'helmet-09_s.jpg', 'helmet-09_l.jpg', '우수한 안정성의 사이클 헬멧', sysdate);
select * from product;
select * from cart;
insert into cart values(SEQ_CART_ID.NEXTVAL, 1, 'brb', 2);
delete from cart;
delete from product where id <= 10;
commit;
insert into cart values(seq_cart_id.nextval, 23, 'admin', 2);
