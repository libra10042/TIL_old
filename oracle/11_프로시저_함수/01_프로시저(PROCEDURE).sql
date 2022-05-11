--PL/SQL ���ν���(procedure)
SET SERVEROUTPUT ON; -- ���� ������� ǥ�� ����

DECLARE -- ��������
    V_EMPID NUMBER;
    V_NAME VARCHAR2(30);
BEGIN --���๮ ����
    V_EMPID := 100; --ġȯ��(���Թ�) ��ȣ :=
    V_NAME := 'ȫ�浿';
    
    --100 : ȫ�浿
    DBMS_OUTPUT.PUT_LINE(V_EMPID || ' : ' || V_NAME);
END; --���๮�� ��

-----------------------
-- BOOK ���̺� ������ �� �Ϻθ� ȭ�� ���
DECLARE 
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN
    --SELECT ~ INTO ~ FROM ���·� DB������ �����ϰ� INTO���� ������ ����
    --1���� �����͸� ó�� ����
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
      INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
      FROM BOOK
     WHERE BOOKID = 1;  
    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ', ' || V_BOOKNAME ||', '
            || V_PUBLISHER || ', ' || V_PRICE);
END;

--=====================================
/* �������ν���(Stored  procedure)
�Ű�����(�Ķ����,parameter) ����
- IN : �Է��� �ޱ⸸ �ϴ� ����(�⺻��)
- OUT : ��¸� �ϴ� ����
      (���� ���� �� ����, ���ν��� ���� �� ȣ���� ������ ������ ���� �� ����)
- IN OUT : �Էµ� �ް�, ���� ������ ���� ��µ� ��
*********************************/
CREATE OR REPLACE PROCEDURE BOOK_DISP --���ν��� �����
--�Ű����� ����� : ( )�ȿ� �ۼ�, ���й��� �޸�(,)
(
    IN_BOOKID IN NUMBER
)
AS -- ���� �����(AS �Ǵ� IS ~ BEGIN �� ����)
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
      INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
      FROM BOOK
     WHERE BOOKID = IN_BOOKID;  
     
    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ', ' || V_BOOKNAME ||', '
            || V_PUBLISHER || ', ' || V_PRICE);     
END;
---------------------------
-- ���ν��� ���� : EXECUTE ���ν�����
EXECUTE BOOK_DISP(3);
EXEC BOOK_DISP(4);

-- ���ν��� ����
DROP PROCEDURE BOOK_DISP;

--==================================
-- ���ν��� �Ķ���� ���� : IN, OUT ���
CREATE OR REPLACE PROCEDURE GET_BOOKINFO ( 
    IN_BOOKID IN NUMBER, --�Ű����� ����� Ÿ�Ը� ����
    OUT_BOOKNAME OUT VARCHAR2,
    OUT_PUBLISHER OUT VARCHAR2,
    OUT_PRICE OUT NUMBER
) AS 
    -- %TYPE ��� : ���̺��.�÷���%TYPE
    -- ���̺� �÷��� ������ Ÿ������ ����(����ÿ��� ����)
    V_BOOKID BOOK.BOOKID%TYPE;
    V_BOOKNAME BOOK.BOOKNAME%TYPE;
    V_PUBLISHER book.publisher%TYPE;
    V_PRICE BOOK.PRICE%TYPE;
BEGIN
    --IN, OUT �Ű����� �� ���
    DBMS_OUTPUT.PUT_LINE('�Ű�������: ' ||IN_BOOKID || ', ' || OUT_BOOKNAME ||', '
        || OUT_PUBLISHER || ', ' || OUT_PRICE);  
        
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
    FROM BOOK
    WHERE BOOKID = IN_BOOKID;
    
    --�����͸� ȣ���� ������ �����ϱ� ���� OUT ���� ������ ����
    OUT_BOOKNAME := V_BOOKNAME;
    OUT_PUBLISHER := V_PUBLISHER;
    OUT_PRICE := V_PRICE;
    
    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ' : ' || V_BOOKNAME ||' : '
        || V_PUBLISHER || ' : ' || V_PRICE);  
END GET_BOOKINFO;

--===========================
-- ���ν��� OUT �Ű����� �� Ȯ�ο� ���ν���
CREATE OR REPLACE PROCEDURE GET_BOOKINFO_TEST (
    IN_BOOKID IN NUMBER
) AS
    V_BOOKNAME book.bookname%TYPE;
    V_PUBLISHER book.publisher%TYPE;
    V_PRICE book.price%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('�Է¹��� ��(ID) : ' || IN_BOOKID);
    
    -- GET_BOOKINFO ���ν��� ����(ȣ��)
    GET_BOOKINFO(IN_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE);
    
    --���ν����� ���� ���޹��� ��(OUT) ȭ�� ���
    DBMS_OUTPUT.PUT_LINE('>>BOOKINFO OUT�� - ' || IN_BOOKID
            ||'/'|| V_BOOKNAME ||'/'|| V_PUBLISHER ||'/'|| V_PRICE);
END;

--=================================
/* (�ǽ�) ���ν��� �ۼ��ϰ� �����ϱ�
�����̺�(CUSTOMER)�� �ִ� ������ ��ȸ ���ν��� �ۼ�
- ���ν����� : GET_CUSTINFO
- �Է¹޴� �� : ��ID
- ó�� : �Է¹��� ��ID�� �ش��ϴ� �����͸� ã�Ƽ� ȭ�� ���
- ����׸� : ��ID, ����, �ּ�, ��ȭ��ȣ
********************************************/











