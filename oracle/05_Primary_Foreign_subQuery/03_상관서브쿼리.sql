/* ��ȣ���� ��������(�����������)
- ���������� ���� ���������� ����ϰ�, ���������� ������� ���������� ���
- ���������� ���������� ���� ���ε� ���·� ����
*******************************/
-- SELECT���� ���� ��������
SELECT O.ORDERID, O.CUSTID,
       (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) ����,
       O.BOOKID,
       (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) å����
  FROM ORDERS O
;
---���ǻ纰�� ���ǻ纰 ��� �������ݺ��� ��� ���� ����� ���Ͻÿ�
SELECT * FROM BOOK;
---- �½����� ���ǻ� å�߿��� �½����� ���ǻ��� ��� �ݾ׺��� ��� å
SELECT * FROM BOOK WHERE PUBLISHER = '�½�����';
SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = '�½�����';
SELECT * FROM BOOK
 WHERE PUBLISHER = '�½�����'
   AND PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = '�½�����')
;
SELECT * FROM BOOK;
-- ���������� BOOK ���̺� ������ �� PUBLISHER ���� 
-- ������������ ������ ����ϰ� �� ��������� ���������� PRICE ���� ��
SELECT * FROM BOOK B
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK 
                 WHERE PUBLISHER = B.PUBLISHER)
;
-- ���ι�(JOIN��)
---- ���ǻ纰 ��� ���� ����
SELECT PUBLISHER, AVG(PRICE)
  FROM BOOK
 GROUP BY PUBLISHER
;
---------
SELECT B.BOOKID, B.BOOKNAME, B.PUBLISHER, B.PRICE,
       AVG.AVG_PRICE
--SELECT *       
  FROM BOOK B,
       (SELECT PUBLISHER, AVG(PRICE) AVG_PRICE
          FROM BOOK
         GROUP BY PUBLISHER) AVG
 WHERE B.PUBLISHER = AVG.PUBLISHER
   AND B.PRICE > AVG.AVG_PRICE
;
-----------------------------------
-- EXISTS : ���翩�� Ȯ�ν� ���(������ TRUE)
-- NOT EXISTS : �������� ������ TRUE
SELECT *
  FROM BOOK
 WHERE BOOKNAME IN (SELECT BOOKNAME FROM BOOK
                     WHERE BOOKNAME LIKE '%�౸%')
;
SELECT *
  FROM BOOK B
 WHERE EXISTS (SELECT 1 FROM BOOK
                WHERE B.BOOKNAME LIKE '%�౸%')
;
--�ֹ������� �ִ� ���� �̸��� ��ȭ��ȣ�� ã���ÿ�
SELECT *
  FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS)
;
-- ===> EXISTS ����
SELECT *
  FROM CUSTOMER C
 WHERE EXISTS (SELECT 1 FROM ORDERS
                WHERE CUSTID = C.CUSTID)
;
-- NOT EXISTS
SELECT *
  FROM CUSTOMER C
 WHERE NOT EXISTS (SELECT 1 FROM ORDERS
                WHERE CUSTID = C.CUSTID)
;
