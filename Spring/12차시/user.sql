CREATE TABLE USERS 
(
	userid     VARCHAR2(30) NOT NULL PRIMARY KEY,
	name       VARCHAR2(100) NOT NULL,
        gender     VARCHAR2(10),
	city       VARCHAR2(30)
);

insert into users values ('gildong','홍길동','남','서울');
commit;