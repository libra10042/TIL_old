/* UNION, UNION ALL : ������ ó��
- UNION : �ߺ������͸� �����ϰ� ������
- UNION ALL : �ߺ������͸� �����ؼ� ������
  ��, ��ȸ�ϴ� �÷��� �̸�, ����, ����, Ÿ���� ��ġ�ϵ��� �ۼ�
******************************/
-- UNION ��� ����
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
;
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
;
---- UNION ���� ���ϱ�
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --������, �迬��, ��̶�
UNION --���ϵ����ʹ� 1�� ����
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --��̶�, �߽ż�, �ڼ���
; 
-- UNION ALL ���ϱ�
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --������, �迬��, ��̶�
UNION ALL --���ϵ����͵� ��� ����
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --��̶�, �߽ż�, �ڼ���
ORDER BY NAME -- ORDER BY ���� �������� �ۼ�
; 
--------------------------
-- MINUS : ������(���� ����)
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --������, �迬��, ��̶�
MINUS
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --��̶�, �߽ż�, �ڼ���
; 
--------------------------
-- INTERSECT : ������(�ߺ������� ��ȸ) - ���ι��� ����� ����� ����
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --������, �迬��, ��̶�
INTERSECT
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --��̶�, �߽ż�, �ڼ���
; 
-- ���ι�(JOIN��)
SELECT A.*
  FROM (SELECT CUSTID, NAME FROM CUSTOMER
         WHERE CUSTID IN (1, 2, 3)) A,
       (SELECT CUSTID, NAME FROM CUSTOMER
         WHERE CUSTID IN (3, 4, 5)) B
 WHERE A.CUSTID = B.CUSTID
   AND A.NAME = B.NAME
;








