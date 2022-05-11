/* ********* ����� ����, ���� *********
-- ����� ���� : CREATE USER
CREATE USER ����ڸ�(������) --"MDGUEST" 
IDENTIFIED BY ��й�ȣ --"mdguest"  
DEFAULT TABLESPACE ���̺����̽� --"USERS"
TEMPORARY TABLESPACE �ӽ��۾����̺����̽� --"TEMP";

-- ����� �뷮 ����(����)
ALTER USER "MDGUEST" QUOTA UNLIMITED ON "USERS";

-- ����� ���� : ALTER USER 
ALTER USER ����ڸ�(������) IDENTIFIED BY ��й�ȣ;

-- ���Ѻο�(�� ��� ���� �ο�, �� �ο�)
GRANT "CONNECT" TO "MDGUEST" ;
GRANT "RESOURCE" TO "MDGUEST" ;

-- ����� ���� : DROP USER
DROP USER ������ [CASCADE];
--CASCADE : ���������� �����(����)�� ������ ��� ����Ÿ ����
*************************************/
--(�����ڰ���-SYSTEM) �������� ������: MDGUEST, ��ȣ: mdguest
-- ��������
CREATE USER "MDGUEST" IDENTIFIED BY "mdguest"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";
-- ��(����) �ο�
GRANT "CONNECT" TO "MDGUEST" ;
GRANT "RESOURCE" TO "MDGUEST" ;
-- ���� �ο�
GRANT CREATE VIEW TO "MDGUEST" ;
----------
-- �������� �뷮����(QUOTAS)
ALTER USER "MDGUEST" QUOTA UNLIMITED ON "USERS";
-------------------------------
--(SYSTEM) CONNECT, RESOURCE ��(ROLE)�� �ִ� ���� Ȯ��
SELECT *
  FROM DBA_SYS_PRIVS
 WHERE GRANTEE IN ('CONNECT', 'RESOURCE')
 ORDER BY GRANTEE, PRIVILEGE
;
GRANT CONNECT, RESOURCE TO MDGUEST ;

--=============================
/****** ���� �ο�(GRANT), ���� ���(REVOKE) **********************
GRANT ���� [ON ��ü] TO {�����|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC�� ��� ����ڿ��� ������ �ǹ�

GRANT ���� TO �����; --������ ����ڿ��� �ο�
GRANT ���� ON ��ü TO �����; -��ü�� ���� ������ ����ڿ��� �ο�
-->> WITH GRANT OPTION :��ü�� ���� ������ ����ڿ��� �ο� 
-- ������ ���� ����ڰ� �ٸ� ����ڿ��� ���Ѻο��� �Ǹ� ����
GRANT ���� ON ��ü TO ����� WITH GRANT OPTION;
--------------------
-->>>���� ���(REVOKE)
REVOKE ���� [ON ��ü] FROM {�����|ROLE|PUBLIC,.., n} CASCADE
--CASCADE�� ����ڰ� �ٸ� ����ڿ��� �ο��� ���ѱ��� ��ҽ�Ŵ
  (Ȯ�� �� ���� �� �۾�)

REVOKE ���� FROM �����; --������ ����ڿ��� �ο�
REVOKE ���� ON ��ü FROM �����; -��ü�� ���� ������ ����ڿ��� �ο�
*************************************************/
--���Ѻο� : MADANG ������ BOOK ���̺� ���� SELECT ������ MDGUEST���� �ο�
----(SYSTEM) ���Ѻο� - MADANG.BOOK �� SELECT �� �� �ִ� ������ MDGUEST���� �ο�
SELECT * FROM MADANG.BOOK;
GRANT SELECT ON MADANG.BOOK TO MDGUEST;
-- ���� ȸ��(MADANG.BOOK SELECT)
REVOKE SELECT ON MADANG.BOOK FROM MDGUEST;

--(MADANG) ���Ѻο�, ����ȸ��(BOOK SELECT ���� MDGUEST ����)
SELECT * FROM BOOK;
GRANT SELECT ON BOOK TO MDGUEST;
----(MADANG) ����ȸ��(���)
REVOKE SELECT ON BOOK FROM MDGUEST;

--(MADANG) CUSTOMER ���̺� ���Ͽ� MDGUEST ��������
---- SELECT, UPDATE ���� �ο�
GRANT SELECT, UPDATE ON CUSTOMER TO MDGUEST; -- ���� �ο�
REVOKE SELECT, UPDATE ON CUSTOMER FROM MDGUEST; -- ���� ȸ��(���)
------------------------------------------
--WITH GRANT OPTION : �ٸ� �������� ���� �ο��� �� �ֵ��� ���
GRANT SELECT, UPDATE ON CUSTOMER TO MDGUEST
    WITH GRANT OPTION;
REVOKE SELECT, UPDATE ON CUSTOMER FROM MDGUEST;    

--(�����ڰ���)��������
drop user "MDGUEST" CASCADE;
