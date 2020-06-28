-- ������ �α��� ���̺�(������ ����)
CREATE TABLE ADMIN (
    adminId VARCHAR2(30) PRIMARY KEY,
    adminName VARCHAR2(30) NOT NULL,
    adminPw VARCHAR2(30) NOT NULL,
    adminPhone VARCHAR2(30) NOT NULL,
    adminAddress VARCHAR2(30) NOT NULL
);


-- �����ڰ� ȸ������ �� �����, ��¥ �� Ȯ�� ���̺�
CREATE TABLE MANAGEMENT(
    adminNum VARCHAR2(30) PRIMARY KEY, 

    adminId VARCHAR2(30) NOT NULL, 
    FOREIGN KEY(adminId) REFERENCES ADMIN(adminId), --ADNMIN���̺��� �����ھ��̵� ����
    
    userNo VARCHAR2(30) NOT NULL,
    FOREIGN KEY(userNo) REFERENCES MEMBER(userNo), --MEMBER���̺��� ȸ���Ϸù�ȣ�� ����
    
    pCode VARCHAR2(30) NOT NULL, 
    FOREIGN KEY(pCode) REFERENCES InOut(pCode), -- ��������̺��� ��ǰ�ڵ带 ����. 
   
    pId VARCHAR2(30) NOT NULL, 
    FOREIGN KEY(pId) REFERENCES InOut(pId);  -- ��ǰ ���� ���������� ��ǰ �ڵ带 ����. 
);

-- ȸ�� ���� ���̺�
CREATE TABLE MEMBER(--ȸ������ ���̺�
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
   FOREIGN KEY(userNo) REFERENCES MEMBER(userNo), -- MEMBER���̺��� ȸ�� �Ϸù�ȣ�� �޴´�.
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
   


-- Q) �����ϴ� Ű�� NOT NULL�� �޾ƾ� �ϴ���. 






