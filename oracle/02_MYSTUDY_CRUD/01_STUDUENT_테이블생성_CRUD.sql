/*STUDENT ���̺� ����
�÷��� ������ �����Ƿ� �ߺ������� ����
�÷��� �����Ͱ� �Էµ��� �ʾƵ� ��
*/
CREATE TABLE STUDENT (
    ID VARCHAR2(20),
    NAME VARCHAR2(30),
    KOR NUMBER(3),
    ENG NUMBER(3,0),
    MATH NUMBER (3),
    TOT NUMBER (3),
    AVG NUMBER (5,2)
);
-- ---------------------------------
-- CRUD : INSERT, SELECT, UPDATE, DELETE
SELECT * FROM STUDENT;

-- ������ �߰�(�Է�) : INSERT
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('1111', 'ȫ�浿', 100, 90, 80);
COMMIT;
ROLLBACK; -- �۾����(���� COMMIT ��ġ�� ���� ����� �۾� ���)

-- INSERT : 2222, ������, 90, 80, 70
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2222', '������', 90, 80, 70);
----------------------------------------
-- ���� : ������ ����(UPDATE)
-- ������ �������� : 70 -> 77 ����
UPDATE STUDENT
SET MATH = 77
WHERE NAME = '������';
SELECT * FROM STUDENT WHERE NAME = '������';
-------------------------------------
-- ������ ���� : DELETE FROM
SELECT * FROM STUDENT WHERE ID = '2222';
DELETE FROM STUDENT WHERE ID = '2222';
DELETE FROM STUDENT WHERE NAME = '������';