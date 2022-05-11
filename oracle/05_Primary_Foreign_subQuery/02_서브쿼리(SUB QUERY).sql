--��������(�μ�����, SUB QUERY)
--SQL��(SELECT,INSERT,UPDATE,DELETE) ���� �ִ� ������
--------------------------------------------------
---�������� ������ ������ �˻�
SELECT * FROM ORDERS;
SELECT CUSTID FROM CUSTOMER WHERE NAME = '������'; --CUSTID : 1
SELECT * FROM ORDERS
 WHERE CUSTID = 1
;
--�������� ���
SELECT * FROM ORDERS
 WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '������')
;
--���ι����� ó��
SELECT C.NAME, O.*
  FROM ORDERS O, CUSTOMER C --�������̺�
 WHERE O.CUSTID = C.CUSTID --��������
   AND C.NAME = '������' --�˻�����
;
----------------------
-- WHERE ������ �������� ���� ��ȸ����� 2�� �̻��� ��� IN ���
--������, �迬�� ���Գ���(��������)
SELECT * FROM ORDERS
 WHERE CUSTID IN (SELECT CUSTID
                   FROM CUSTOMER
                  WHERE NAME IN ('������', '�迬��') );
---------------------
-- å�� ������ ���� ��� ������ �̸��� ���Ͻÿ�
SELECT MAX(PRICE) FROM BOOK; --���� ��� å�� ���� : 35000
SELECT * FROM BOOK WHERE PRICE = 35000;
---
SELECT * FROM BOOK 
 WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK);
--------------------
--���������� FROM���� ����ϴ� ���
SELECT B.*
  FROM BOOK B,
       (SELECT MAX(PRICE) MAX_PRICE FROM BOOK) M
 WHERE B.PRICE = M.MAX_PRICE       
;
-----
--������, �迬�� ���Գ���(��������)
SELECT *
  FROM ORDERS O,
       (SELECT * FROM CUSTOMER WHERE NAME IN ('������', '�迬��')) C
 WHERE O.CUSTID = C.CUSTID
;
----------
SELECT *
  FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
   AND C.NAME IN ('������', '�迬��')
;
--------------------------
--SELECT ���� �������� ��뿹
SELECT O.ORDERID, O.CUSTID, O.BOOKID,
       (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUSTNAME,
       (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID ) BOOKNAME,
       O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O
;
------------------
--�������� ������ å ���(å����)
--�� ����SQL --> �߰�SQL --> �ٱ��� SQL�� ����
SELECT *
  FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID
                    FROM ORDERS
                   WHERE CUSTID IN (SELECT CUSTID
                                      FROM CUSTOMER
                                     WHERE NAME = '������')
                 )                    
;
---------------------------
--(�ǽ�) �������� �̿�(��������, ���ι�)
--1. �� ���̶� ������ ������ �ִ� ���
---- (�Ǵ� �� ���� �������� ���� ���)
--2. 20000�� �̻�Ǵ� å�� ������ �� ��� ��ȸ
--3. '���ѹ̵��' ���ǻ��� å�� ������ ���̸� ��ȸ
--4. ��ü å���� ��պ��� ��� å�� ��� ��ȸ
---------------
--1. �� ���̶� ������ ������ �ִ� ���
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT DISTINCT CUSTID FROM ORDERS);
---- (�Ǵ� �� ���� �������� ���� ���)
SELECT * FROM CUSTOMER
 WHERE CUSTID NOT IN (SELECT DISTINCT CUSTID FROM ORDERS);
--JOIN ��
SELECT DISTINCT C.* --DISTINCT : �ߺ������ʹ� �ϳ��� ǥ��
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
;
--JOIN �� : �� ���� �������� ���� ���
SELECT C.*
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID(+)
   AND O.ORDERID IS NULL
;
SELECT C.*
  FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
       ON C.CUSTID = O.CUSTID
 WHERE O.ORDERID IS NULL
;
--2. 20000�� �̻�Ǵ� å�� ������ �� ��� ��ȸ(�̸�, ��ȭ��ȣ)
SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000;
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS 
                   WHERE SALEPRICE >= 20000)
;
--- ���ι�(JOIN)
SELECT C.*, O.SALEPRICE
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
   AND O.SALEPRICE >= 20000
;
---- ANSI ǥ��
SELECT *
  FROM CUSTOMER C INNER JOIN ORDERS O --���ι�İ� �������̺�
       ON C.CUSTID = O.CUSTID --��������
 WHERE O.SALEPRICE >= 20000
;   
-- �ֹ�(�Ǹ�) ���̺��� 2���� �̻��� �����͸� �������
SELECT *
  FROM CUSTOMER C,
       (SELECT * FROM ORDERS WHERE SALEPRICE >= 20000) O
 WHERE C.CUSTID = O.CUSTID
;
--3. '���ѹ̵��' ���ǻ��� å�� ������ ���̸� ��ȸ
SELECT *
  FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS
                   WHERE BOOKID IN (SELECT BOOKID FROM BOOK
                                     WHERE PUBLISHER = '���ѹ̵��')
                  )
;
--���ι�(JOIN)
SELECT C.*, B.BOOKNAME, O.SALEPRICE, o.orderdate
  FROM CUSTOMER C, ORDERS O, BOOK B
 WHERE C.CUSTID = O.CUSTID
   AND O.BOOKID = B.BOOKID
   AND B.PUBLISHER = '���ѹ̵��'
; 
--4. ��ü å���� ��պ��� ��� å�� ��� ��ȸ
SELECT AVG(PRICE) FROM BOOK; --��հ��� : 14450
SELECT * FROM BOOK
 WHERE PRICE > 14450
;
SELECT * FROM BOOK
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK)
;
----���ι�
SELECT * 
  FROM BOOK B,
       (SELECT AVG(PRICE) AVG_PRICE FROM BOOK) AVG
 WHERE B.PRICE > AVG.AVG_PRICE
;



