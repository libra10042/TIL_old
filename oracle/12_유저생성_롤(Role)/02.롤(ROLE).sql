/* ********* ����(�� ROLE) ***********
����(��, ROLE) : DB ��ü �� �ý��ۿ� ���� ������ ��Ƶ� ������ �ǹ�
���� ���� : CREATE ROLE �����̸�
���� ���� : DROP ROLE �����̸�
���ҿ� ���� �ο� : GRANT ���� [ON ��ü] TO �����̸�
������ ���� ȸ�� : REVOKE ���� [ON ��ü] FROM �����̸�
����ڿ��� ���� �ο� : GRANT �����̸� TO �����

<���� �������� ����� �߰������� �ܰ�>
CREATE ROLE - ���һ���
GRANT - ������� ���ҿ� ���� �ο�
GRANT - ����ڿ��� ���� �ο�
-->>���� ������ ��� �ݴ�� ����
DROP ROLE - ���� ����(����ڿ��� �ο��� ���ҿ� ���� ���� ���� ���ŵ�)
***************************************/
-- ����� �������� �˻� ����(��) ��ȸ
SELECT * FROM USER_ROLE_PRIVS;

--(DBA����-SYSTEM) CONNECT, RESOURCE �ѿ� ���� ���� Ȯ��
SELECT * FROM dba_sys_privs WHERE GRANTEE IN ('CONNECT', 'RESOURCE');
--------------------
--(�� ���� SYSTEM����) PROGRAMMER(������)��� ����(��, ROLE) ����
CREATE ROLE PROGRAMMER;

--(SYSTEM) PROGRAMMER �ѿ� ���̺�, ��(VIEW) ���� ���� ���
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMMER;

--(SYSTEM) MDGUEST �������� PROGRAMMER �� �ο�
GRANT PROGRAMMER TO MDGUEST;

-- ���� ȸ��(���)
REVOKE PROGRAMMER FROM MDGUEST;








