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




-- Clients, Doctor, Reserve table sequence 생성. 
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


Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('유재석',1,'123456-1234567','010-1111-1111');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('신동엽',2,'222222-2222222','010-2222-2222');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강호동',3,'333333-3333333','010-3333-3333');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('김희애',4,'444444-4444444','010-4444-4444');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('박선영',5,'555555-5555555','010-5555-5555');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',53,'900216-101','010-3243-1359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',54,'900216-1123546','01032431359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('김형진',55,'110000-1122334','010-7777-7777');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',56,'900216-101','01032431359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강서곤',57,'900216-','12345679');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강로니',58,'9123456','54684654');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',59,'900216','01032431359');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',60,'900216','10123456');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('서난아',61,'123456-1234567','010-7777-7777');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('조아니',62,'900216','010321654');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',81,'900216','123456');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('곽철용',82,'999999-9999999','010-9999-9999');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',83,'900216','123456789');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',84,'900216','123456789');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('김채나',85,'000727-4444444','010-7777-7777');
Insert into CLIENTS (CLNAME,CLNUMBER,CLPN,CLPHONE) values ('강석환',52,'900216','01032431359');


