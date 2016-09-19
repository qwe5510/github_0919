drop table tcomment;
drop table tuser;
drop sequence seq_comment;

create table Tcomment(
  Comment_no number PRIMARY key,
  User_id VARCHAR2(20) not null,
  Content VARCHAR2(500) not null
);

create table Tuser(
  User_id VARCHAR2(20) PRIMARY key,
  Pass VARCHAR2(20) not null
);

alter table tcomment add constraint tcomment_tuser_fk
 foreign key(user_id) references tuser(user_id);

create SEQUENCE SEQ_COMMENT;
