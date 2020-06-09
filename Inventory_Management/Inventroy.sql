
CREATE TABLE product(
code varchar2(10) primary key,
pname varchar2(30) not null,
price number not null
)

CREATE TABLE sales(
num number primary key,
inputdate date default sysdate,
code varchar2(10) not null,
quantity number not null,
FOREIGN KEY (code) references com_product(code));

CREATE SEQUENCE sales_seq;
COMMIT;




CREATE TABLE MEMBER(
    userId varchar2(30) primary key,
    userPw varchar2(30) not null,
    name varchar2(30) not null,
    address varchar2(30) not null,
    phone varchar2(30) not null

);
commit;