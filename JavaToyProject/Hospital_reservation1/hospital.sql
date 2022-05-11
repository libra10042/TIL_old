CREATE TABLE CLIENTS (
 CLNUMBER NUMBER PRIMARY KEY,
 CLNAME VARCHAR2(30) NOT NULL,
 CLPN VARCHAR2(30) NOT NULL,
 CLPHONE VARCHAR2(30) NOT NULL
 );

CREATE TABLE RESERVE (
 RENUMBER INT PRIMARY KEY,
 CLNUMBER NUMBER NOT NULL,
 SYMPTOM VARCHAR2(30) NOT NULL,
 SCHEDULE DATE NOT NULL,
 DONUMBER NUMBER NOT NULL
);
 
 
CREATE TABLE DOCTOR (
 DONUMBER NUMBER PRIMARY KEY,
 PARTNUMBER NUMBER NOT NULL,
 DONAME VARCHAR2(30) NOT NULL,
 PASSWORD VARCHAR2(30) NOT NULL,
 INFO_DOCTOR VARCHAR2(100) NOT NULL
 );
 

CREATE TABLE PART (
 PARTNUMBER NUMBER PRIMARY KEY,
 PARTNAME VARCHAR2(100) NOT NULL
 );
 
 COMMIT;
 
 
ALTER TABLE RESERVE
ADD CONSTRAINTS FK_1 FOREIGN KEY(CLNUMBER)
REFERENCES CLIENTS(CLNUMBER);


ALTER TABLE RESERVE
ADD CONSTRAINTS FK_2 FOREIGN KEY(DONUMBER)
REFERENCES DOCTOR(DONUMBER);

ALTER TABLE DOCTOR
ADD CONSTRAINTS FK_3 FOREIGN KEY(PARTNUMBER)
REFERENCES PART(PARTNUMBER);

COMMIT;




-- Clients, Doctor, Reserve table sequence ����. 
CREATE SEQUENCE CLIENTS_SEQ
START WITH 1
INCREMENT BY 1;


CREATE SEQUENCE DOCTOR_SEQ
START WITH 10001
INCREMENT BY 1; 

CREATE SEQUENCE RESERVE_SEQ
START WITH 1
INCREMENT BY 1; 
COMMIT;


Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('���缮',1,'123456-1234567','010-1111-1111');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('�ŵ���',2,'222222-2222222','010-2222-2222');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('��ȣ��',3,'333333-3333333','010-3333-3333');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('�����',4,'444444-4444444','010-4444-4444');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('�ڼ���',5,'555555-5555555','010-5555-5555');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',53,'900216-101','010-3243-1359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',54,'900216-1123546','01032431359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('������',55,'110000-1122334','010-7777-7777');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',56,'900216-101','01032431359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('������',57,'900216-','12345679');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('���δ�',58,'9123456','54684654');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',59,'900216','01032431359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',60,'900216','10123456');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('������',61,'123456-1234567','010-7777-7777');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('���ƴ�',62,'900216','010321654');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',81,'900216','123456');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('��ö��',82,'999999-9999999','010-9999-9999');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',83,'900216','123456789');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',84,'900216','123456789');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('��ä��',85,'000727-4444444','010-7777-7777');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('����ȯ',52,'900216','01032431359');




-- �ǻ� ���� ����
-- 1.����   2.�ܰ�   3.�Ҿư�   4.�����ܰ�   5.�Ȱ�
insert into doctor values(10001, 1, '������', '1111', '����� ����/����������� 10����');
insert into doctor values(10002, 2, '�����', '1111', '����� ����/������15����');
insert into doctor values(10003, 3, '�����', '1111', '������ ����/����������� 5����');
insert into doctor values(10004, 4, '�����', '1111', '�Ѿ�� ����/�Ѿ�뺴�� 15�� ���');
insert into doctor values(10005, 5, '�Ŵ���', '1111', '����� ����/������ 1����');
insert into doctor values(10006, 1, '�迵��', '1111', '�Ǳ��� ����/�Ǵ뺴�� 5����');
insert into doctor values(10007, 2, '������', '1111', '����� ����/������ 10����');
insert into doctor values(10008, 3, '���켺', '1111', '������ ����/������ 30����');
insert into doctor values(10009, 4, '�ձ⿵', '1111', '�Ѿ�� ����/������ 10����');
insert into doctor values(10010, 5, '��ȫ��', '1111', '�Ǳ��� ����/�Ǵ뺴�� 5����');

desc part;
insert into part values(1, '����');
insert into part values(2, '�ܰ�');
insert into part values(3, '�Ҿư�');
insert into part values(4, '�����ܰ�');
insert into part values(5, '�Ȱ�');
commit;


desc part; 



