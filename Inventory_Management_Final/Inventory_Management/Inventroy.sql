-- 관리자 로그인 테이블(관리자 정보)
CREATE TABLE ADMIN (
    adminId VARCHAR2(30) PRIMARY KEY,
    adminName VARCHAR2(30) NOT NULL,
    adminPw VARCHAR2(30) NOT NULL,
    adminPhone VARCHAR2(30) NOT NULL,
    adminAddress VARCHAR2(30) NOT NULL
);


-- 관리자가 회원정보 및 입출고량, 날짜 등 확인 테이블
CREATE TABLE MANAGEMENT(
    adminNum VARCHAR2(30) PRIMARY KEY, 

    adminId VARCHAR2(30) NOT NULL, 
    FOREIGN KEY(adminId) REFERENCES ADMIN(adminId), --ADNMIN테이블의 관리자아이디를 받음
    
    userNo VARCHAR2(30) NOT NULL,
    FOREIGN KEY(userNo) REFERENCES MEMBER(userNo), --MEMBER테이블의 회원일련번호를 받음
    
    pCode VARCHAR2(30) NOT NULL, 
    FOREIGN KEY(pCode) REFERENCES InOut(pCode), -- 입출고테이블에서 상품코드를 받음. 
   
    pId VARCHAR2(30) NOT NULL, 
    FOREIGN KEY(pId) REFERENCES InOut(pId);  -- 상품 통합 페이지에서 상품 코드를 받음. 
);

-- 회원 정보 테이블
CREATE TABLE MEMBER(--회원정보 테이블
    userNo VARCHAR2(30) PRIMARY KEY, 
    userId VARCHAR2(30) NOT NULL, 
    userPw VARCHAR2(30) NOT NULL, 
    name VARCHAR2(30) NOT NULL, 
    email VARCHAR2(30) NOT NULL, 
    address VARCHAR2(30) NOT NULL,
    gubun VARCHAR2(30) NOT NULL
);

CREATE TABLE PRODUCT(
   pId VARCHAR2(30) PRIMARY KEY,
   userNo VARCHAR2(30),
   FOREIGN KEY(userNo) REFERENCES MEMBER(userNo), -- MEMBER테이블에서 회원 일련번호를 받는다.
   pName VARCHAR2(30) NOT NULL, 
   price NUMBER NOT NULL, 
   introduct VARCHAR2(30) NOT NULL,
   gubun VARCHAR2(30) NOT NULL,   
);

CREATE TABLE INOUT(
   pCode VARCHAR2(30) PRIMARY KEY, 
   pId VARCHAR2(30),
   FOREIGN KEY(pId) REFERENCES PRODUCT(pId),
   
   DATE DATE DEFAULT SYSDATE,
   AMOUNT NUMBER(30)
); 
   


-- Q) 참조하는 키도 NOT NULL을 받아야 하는지. 






