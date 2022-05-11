--============================
/* (�ǽ�) ���̺�(TABLE) �����(���̺�� : TEST2)
    NO : ����Ÿ�� 5�ڸ�, PRIMARY KEY ����
    ID : ����Ÿ�� 10�ڸ�(����10�ڸ�), ���� �ݵ�� ����(NULL ������)
    NAME : �ѱ� 10�ڸ� ���尡����� ����, ���� �ݵ�� ����
    EMAIL : ����, ����, Ư������ ���� 30�ڸ�
    ADDRESS : �ѱ� 100��
    IDNUM : ����Ÿ�� ������ 7�ڸ�, �Ҽ��� 3�ڸ� (1234567.123)
    REGDATE : ��¥Ÿ��
***********************/
CREATE TABLE TEST2 (
    NO NUMBER(5) PRIMARY KEY,
    ID VARCHAR2(10) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    EMAIL VARCHAR2(30),
    ADDRESS VARCHAR2(300),
    IDNUM NUMBER(10, 3),
    REGDATE DATE DEFAULT SYSDATE
);
SELECT * FROM TEST2;
INSERT INTO TEST2 
VALUES (11111, 'TEST1', 'ȫ�浿1', 'test1@test.com', 
        '����� ���ʱ�',  1234567.8765, sysdate);
INSERT INTO TEST2 (NO, ID, NAME) --�÷��� �ۼ��� �÷��̸���ġ�� ������ ����
VALUES (22, 'TEST2', 'ȫ�浿2');
INSERT INTO TEST2 (NO, NAME, ID) --�÷��� �ۼ��� �÷��̸���ġ�� ������ ����
VALUES (33, 'ȫ�浿3', 'TEST3');
COMMIT;
--==========================================
-- Ư�� ���̺��� �����Ϳ� �Բ� ���̺� ������ �Բ� ����
CREATE TABLE TEST3
AS
SELECT * FROM TEST2;
---
SELECT * FROM TEST2;
SELECT * FROM TEST3;
-----------------------------------
--Ư�� ���̺��� Ư���÷��� Ư�� �����͸� �����ؼ� ���̺� ����
CREATE TABLE TEST4
AS
SELECT NO, ID, NAME, EMAIL FROM TEST2 WHERE NO = 11111;
------------------------
-- Ư�� ���̺��� ������ ����(�����ʹ� �������� ����)
CREATE TABLE TEST5
AS SELECT * FROM TEST2 WHERE 1 = 2;
--======================================
SELECT * FROM TEST2;
DELETE FROM TEST2 WHERE ID = 'TEST3';

--���̺� ��ü ������ ����
DELETE FROM TEST2; --���̺��� ������ ��ü ����
ROLLBACK; --DELETE ���� ROLLBACK ��ɹ����� ������ ���� ����
--------
-- TRUNCATE ��ɹ� : ���̺� ������ ��ü ���� ó��(ROLLBACK ���� �Ұ�)
TRUNCATE TABLE TEST2; 
SELECT * FROM TEST2;
ROLLBACK;
--===================================
/* ���̺��� ���� : DROP TABLE - �����Ϳ� �Բ� ���̺��� ��� ����ó��
    DROP TABLE ������.���̺��;
    drop table ������.���̺�� cascade constraints PURGE
    - cascade constraints : ���������Ͱ� �־ ���� ó��
    - PURGE : �����뿡 ������� ������ ����
*/
DROP TABLE TEST2;

--==============================
/* ���̺� ���� : �÷� �߰�, ����, ����
DDL : ALTER TABLE
- ADD : �߰�
- MODIFY : ���� - ������ ���¿� ���� ���� ���� ������(������, �������ǵ�)
    -- �÷������� ���� -> ū : ������ ����
    -- �÷������� ū -> ���� : ����� �����Ϳ� ���� �ٸ�
- DROP COLUMN : ����
****************************/
SELECT * FROM TEST3;
-- �÷��߰� TEST3 ���̺� ADDCOL �÷� �߰�
ALTER TABLE TEST3 ADD ADDCOL VARCHAR2(10);

-- �÷����� TEST3 ���̺��� ADDCOL ũ�� -> VARCHAR2(20)
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(20);
UPDATE TEST3 SET ADDCOL = '123456789012345';
SELECT * FROM TEST3;

-- �÷����� TEST3 ���̺��� ADDCOL ũ�� - VARCHAR2(10), VARCHAR2(15)
--���� : ORA-01441: cannot decrease column length because some value is too big
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(10); --�����߻� 10���� ū ������ ����
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(15); --�ִ� ������ ũ��� ����(��������)

-- �÷����� : DROP COLUMN
ALTER TABLE TEST3 DROP COLUMN ADDCOL;
---------------
ALTER TABLE TEST3 RENAME COLUMN ADDCOL TO ADDCOL2;
ALTER TABLE TEST3 MODIFY (ADDCOL2 NOT NULL);
alter table "MYSTUDY"."TEST3" rename to TEST33;






