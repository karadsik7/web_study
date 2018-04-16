create table guestbook(
    id number constraint gb_id_pk primary key,
    password varchar2(10) constraint gb_pw_nn not null,
    msg clob,
    writer varchar2(20) constraint gb_wt_nn not null,
    ip varchar2(15) constraint gb_ip_nn not null,
    writedate timestamp constraint gb_time_nn not null
);

create sequence seq_guestbook_id;