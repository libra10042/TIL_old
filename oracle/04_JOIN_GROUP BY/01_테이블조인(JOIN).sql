--������ ��ID
SELECT CUSTID FROM CUSTOMER WHERE NAME = '������'; --CUSTID : 1
--�������� ������ å�� �հ�ݾ�
SELECT * FROM ORDERS WHERE CUSTID = 1;

--��������(sub query) ���
SELECT * FROM ORDERS 
WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '������');

----------------------
--���̺� ����(join) ���
SELECT * FROM CUSTOMER WHERE CUSTID = 1;
SELECT * FROM ORDERS WHERE CUSTID = 1;

-- CUSTOMER, ORDERS ���̺� ������ ���� ��ȸ
SELECT *
FROM CUSTOMER, ORDERS --������ ���̺�
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID --��������
;
----
--���̺� ���� ��Ī ������� �����ϰ� ǥ���ϰ� ���
SELECT *
FROM CUSTOMER C, ORDERS O  --���̺� ���� ��Ī ���
WHERE C.CUSTID = O.CUSTID --��������
AND C.NAME = '������'  --�˻�����
;
--ANSI ǥ�� ���� ����
SELECT *
FROM CUSTOMER C
    INNER JOIN ORDERS O
    ON C.CUSTID = O.CUSTID  --��������
WHERE C.NAME = '������' --�˻�����
;
--------------
--�������� ������ �հ�ݾ�
SELECT SUM(O.SALEPRICE)
--SELECT *
FROM CUSTOMER C, ORDERS O --������ ���̺�
WHERE C.CUSTID = O.CUSTID  --���� ����
AND C.NAME = '������'  --�˻� ����
;
----------------------
--���ε� �����Ϳ��� �÷� ��ȸ�� : ���̺��(��Ī).�÷��� ���·� ���
SELECT C.CUSTID, C.NAME, C.ADDRESS,
    O.CUSTID AS ORD_CUSTID, --���� �÷����� �ִ� ��� ��Īó���ؼ� �ٸ� �̸����� ���
    O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O --������ ���̺�
WHERE C.CUSTID = O.CUSTID  --���� ����
AND C.NAME = '������'  --�˻�����
;
-----------------
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
--������ å�� �Ǹŵ� å ���(�̵��� ������ ���ǻ�)
SELECT O.ORDERID, O.BOOKID, 
    B.BOOKNAME, B.PUBLISHER, B.PRICE, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, ORDERS O
WHERE b.bookid = o.bookid  --��������
--AND B.PUBLISHER = '�½�����'
AND B.PUBLISHER LIKE '%�̵��'
ORDER BY B.PUBLISHER, B.BOOKNAME
;
--=============================
--(�����ذ�) ���̺� ������ ���ؼ� ��û�� ������ ã��
--�ǽ� : '�߱��� ��Ź��'��� å�� �ȸ� ������ Ȯ��(å����, �Ǹűݾ�, �Ǹ�����)
--�ǽ� : '�߱��� ��Ź��'��� å�� �� ���� �ȷȴ��� Ȯ��
------
--�ǽ� : '�߽ż�'�� ������ å���� �������ڸ� Ȯ��(å��, ��������)
--�ǽ� : '�߽ż�'�� ������ �հ�ݾ��� Ȯ��
--�ǽ� : ������, �߽ż��� ������ ������ Ȯ��(�̸�, �Ǹűݾ�, �Ǹ�����)
--==================================================
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
--�ǽ� : '�߱��� ��Ź��'��� å�� �ȸ� ������ Ȯ��(å����, �Ǹűݾ�, �Ǹ�����)
SELECT B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
  FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
   AND B.BOOKNAME = '�߱��� ��Ź��'
;
--�ǽ� : '�߱��� ��Ź��'��� å�� �� ���� �ȷȴ��� Ȯ��
SELECT '�߱��� ��Ź�� �ǸŰǼ�', COUNT(*)
  FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
   AND B.BOOKNAME = '�߱��� ��Ź��'
;
------
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
--�ǽ� : '�߽ż�'�� ������ å���� �������ڸ� Ȯ��(å��, ��������)
SELECT '�߽ż� ���Գ���', o.saleprice, o.orderdate
FROM CUSTOMER C, ORDERS O
WHERE c.custid = o.custid
AND C.NAME = '�߽ż�'
;
--�ǽ� : '�߽ż�'�� ������ �հ�ݾ��� Ȯ��
SELECT '�߽ż� �����հ�', SUM(O.SALEPRICE)
FROM CUSTOMER C, ORDERS O
WHERE c.custid = o.custid
AND C.NAME = '�߽ż�'
;
--�ǽ� : ������, �߽ż��� ������ ������ Ȯ��(�̸�, �Ǹűݾ�, �Ǹ�����)
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME IN ('������', '�߽ż�')  -- AND C.NAME = '������' OR C.NAME = '�߽ż�'
ORDER BY C.NAME, O.ORDERDATE
;
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND (C.NAME = '������' OR C.NAME = '�߽ż�')
ORDER BY C.NAME, O.ORDERDATE
;
--=======================================
--����, å����, �ǸŰ���, �Ǹ�����, ���ǻ��(3�� ���̺� ����)
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID
   AND O.CUSTID = C.CUSTID
;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE B.BOOKID = O.BOOKID
   AND O.CUSTID = C.CUSTID
;
------------------------------------
--(�ǽ�) BOOK, CUSTOMER, ORDERS ���̺� �����͸� ��ȸ
-- ��̶��� ������ å����, ���԰���, ��������, ���ǻ�
-- ��̶��� ������ å �߿� 2014-01-01 ~ 2014-07-08���� ������ ����
-- '�߱��� ��Ź��'��� å�� ������ ����� �������ڸ� Ȯ��
-- �߽ż�, ��̶��� ������ å����, ���Աݾ�, �������� Ȯ��
---- (���� : ����, �������� ������)
------------------------------------
-- ��̶��� ������ å����, ���԰���, ��������, ���ǻ�
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID --���� ����
   AND O.CUSTID = C.CUSTID --���� ����
   AND C.NAME = '��̶�'
;
-- ��̶��� ������ å �߿� 2014-01-01 ~ 2014-07-08���� ������ ����
SELECT ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD HH24:MI:SS')
  FROM ORDERS
;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --��������
   AND C.NAME = '��̶�'
   AND O.ORDERDATE >= TO_DATE('2014-01-01', 'YYYY-MM-DD')
   AND O.ORDERDATE < TO_DATE('2014-07-09', 'YYYY-MM-DD')
;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --��������
   AND C.NAME = '��̶�'
   AND O.ORDERDATE BETWEEN TO_DATE('20140101', 'YYYYMMDD')
                       AND TO_DATE('2014/07/08', 'YYYY/MM/DD')
;
-- '�߱��� ��Ź��'��� å�� ������ ����� �������ڸ� Ȯ��
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --��������
   AND B.BOOKNAME = '�߱��� ��Ź��'
;
-- �߽ż�, ��̶��� ������ å����, ���Աݾ�, �������� Ȯ��
---- (���� : ����, �������� ������)
SELECT C.NAME, B.BOOKNAME, B.PRICE, O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --��������
   AND C.NAME IN ('�߽ż�', '��̶�')
 ORDER BY C.NAME, O.ORDERDATE
-- ORDER BY 1, 4
;
--================================
--�߽ż��� ������ å����, �հ�ݾ�, ��հ�, ���� ���å�ݾ�, �ΰ��ְ�� �ݾ�
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), ROUND(AVG(O.SALEPRICE)), 
       MAX(O.SALEPRICE), MIN(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
--   AND C.NAME = '�߽ż�'
;




