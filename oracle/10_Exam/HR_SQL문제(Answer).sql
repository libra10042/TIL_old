/* ***** HR DB ������ ��ȸ �ǽ� *****************
��1 HR �μ����� ���� �� ������ �޿� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
  �������(Employees) ���̺��� �޿��� $7,000~$10,000 ���� �̿��� ����� 
  �̸��� ��(Name���� ��Ī) �� �޿��� �޿��� ���� ������ ����Ͻÿ�
*/
SELECT FIRST_NAME||' '||LAST_NAME AS NAME, SALARY
  FROM employees
 WHERE SALARY < 7000 OR SALARY > 10000
 ORDER BY SALARY
;
SELECT FIRST_NAME||' '||LAST_NAME AS NAME, SALARY
  FROM employees
 WHERE SALARY NOT BETWEEN 7000 AND 10000
 ORDER BY SALARY
;
/*
��2 HR �μ������� �޿�(salary)�� ������(commission_pct)�� ���� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
  ������ �޴� ��� ����� �̸��� ��(Name���� ��Ī), �޿�, ����, �������� ����Ͻÿ�. 
  �̶� �޿��� ū ������� �����ϵ�, �޿��� ������ �������� ū ������� �����Ͻÿ�
*/
SELECT FIRST_NAME||' '||LAST_NAME AS NAME, SALARY, JOB_ID, COMMISSION_PCT
  FROM employees
 WHERE commission_pct IS NOT NULL
 ORDER BY SALARY DESC, commission_pct DESC
;
/*  
��3 �̹� �б⿡ 60�� IT �μ������� �ű� ���α׷��� �����ϰ� �����Ͽ� ȸ�翡 �����Ͽ���. 
  �̿� �ش� �μ��� ��� �޿��� 12.3% �λ��ϱ�� �Ͽ���. 
  60�� IT �μ� ����� �޿��� 12.3% �λ��Ͽ� ������(�ݿø�) ǥ���ϴ� ������ �ۼ��Ͻÿ�. 
  ������ �����ȣ, ���� �̸�(Name���� ��Ī), �޿�, �λ�� �޿�(Increase Salary�� ��Ī)������ ����Ͻÿ�
*/  
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME AS NAME, SALARY,
       ROUND(SALARY * 0.123) AS "�λ��",
       ROUND(SALARY + (SALARY * 0.123)) AS "Increase Salary",
       ROUND(SALARY * 1.123) AS "Increase Salary2"
  FROM employees
 WHERE department_id = 60
;
/*
��4 �� ����� ��(last_name)�� 's'�� ������ ����� �̸��� ������ �Ʒ��� ���� ���� ����ϰ��� �Ѵ�. 
  ��� �� �̸�(first_name)�� ��(last_name)�� ù ���ڰ� �빮��, ������ ��� �빮�ڷ� ����ϰ� 
  �Ӹ���(��ȸ�÷���)�� Employee JOBs.�� ǥ���Ͻÿ�
  ��) FIRST_NAME  LAST_NAME  Employee JOBs.
      Shelley     Higgins    AC_MGR
*/
SELECT FIRST_NAME, LAST_NAME, JOB_ID AS "Employee JOBs."
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE '%s'
;
SELECT FIRST_NAME, LAST_NAME, JOB_ID AS "Employee JOBs."
     , INITCAP(FIRST_NAME), INITCAP(LAST_NAME)
     , UPPER(FIRST_NAME), UPPER(LAST_NAME)
     , LOWER(FIRST_NAME), LOWER(LAST_NAME)
  FROM EMPLOYEES
 WHERE LOWER(LAST_NAME) LIKE '%s'
;
/*
��5 ��� ����� ������ ǥ���ϴ� ������ �ۼ��Ϸ��� �Ѵ�. 
  ������ ����� �̸��� ��(Name���� ��Ī), �޿�, ���翩�ο� ���� ������ �����Ͽ� ����Ͻÿ�. 
  ���翩�δ� ������ ������ "Salary + Commission", ������ ������ "Salary only"��� ǥ���ϰ�, 
  ��Ī�� ������ ���̽ÿ�. ���� ��� �� ������ ���� ������ �����Ͻÿ�
*/
SELECT FIRST_NAME||' '||LAST_NAME AS NAME, SALARY, COMMISSION_PCT
     , SALARY * NVL(COMMISSION_PCT, 0) AS COMMISSION
     , SALARY + (SALARY * NVL(COMMISSION_PCT, 0)) AS SALARY_COM
     , (SALARY + (SALARY * NVL(COMMISSION_PCT, 0))) * 12 AS SALARY12
     , DECODE(COMMISSION_PCT, NULL, 'Salary only', 'Salary + Commission')
       AS COMISSION_YN
  FROM EMPLOYEES
 ORDER BY SALARY12 DESC
;
/*
��6 �� ����� �Ҽӵ� �μ����� �޿� �հ�, �޿� ���, �޿� �ִ�, �޿� �ּڰ��� �����ϰ��� �Ѵ�. 
  ���� ��°��� ���� �ڸ��� �� �ڸ� ���б�ȣ, $ǥ�ÿ� �Բ� ���($123,456) 
  ��, �μ��� �Ҽӵ��� ���� ����� ���� ������ �����ϰ�, ��� �� �Ӹ����� ��Ī(alias) ó���Ͻÿ�
*/    
SELECT DEPARTMENT_ID
     , COUNT(*) AS CNT
     , TO_CHAR(SUM(SALARY), '$999,999') AS SALARY_SUM
     , TO_CHAR(AVG(SALARY), '$000,000') AS SALARY_AVG
     , TO_CHAR(MAX(SALARY), '$999,999') AS SALARY_MAX
     , TO_CHAR(MIN(SALARY), '$999,999') AS SALARY_MIN
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID
 ORDER BY 3 DESC
;
/*
��7 ������� ������ ��ü �޿� ����� $10,000���� ū ��츦 ��ȸ�Ͽ� 
    ������ �޿� ����� ����Ͻÿ�. 
  �� ������ CLERK�� ���Ե� ���� �����ϰ� ��ü �޿� ����� ���� ������� ����Ͻÿ�
*/
SELECT DISTINCT JOB_ID FROM EMPLOYEES WHERE JOB_ID LIKE '%CLERK%';

SELECT JOB_ID, AVG(SALARY) AVG_SALARY
  FROM EMPLOYEES
 WHERE JOB_ID NOT LIKE '%CLERK%'
 GROUP BY JOB_ID
 HAVING AVG(SALARY) > 10000
 ORDER BY 2 DESC
;
/*
��8 HR ��Ű���� �����ϴ� Employees, Departments, Locations ���̺��� ������ �ľ��� �� 
  Oxford�� �ٹ��ϴ� ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �����̸��� ����Ͻÿ�. 
  �̶� ù ��° ���� ȸ���̸��� 'HR-Company'�̶�� ������� ��µǵ��� �Ͻÿ�
*/
SELECT 'HR-Company' AS COMPANY_NAME, 
       E.FIRST_NAME||' '||LAST_NAME AS NAME,
       E.JOB_ID, d.department_name, l.city
  FROM Employees E, Departments D, Locations L
 WHERE e.department_id = d.department_id --��������
   AND d.location_id = l.location_id --��������
   --AND L.CITY = 'Oxford'
   AND L.CITY = INITCAP('OXFORD') --oxford, oxFORD, ....
;
--HR������ �ִ� ��(VIEW - EMP_DETAILS_VIEW) ���
SELECT 'HR-Company' AS COMPANY_NAME, 
       FIRST_NAME||' '||LAST_NAME AS NAME,
       JOB_ID, DEPARTMENT_ID, CITY
  FROM EMP_DETAILS_VIEW
 WHERE CITY = INITCAP('OXFORD')
;
/*
��9 HR ��Ű���� �ִ� Employees, Departments ���̺��� ������ �ľ��� �� 
  ������� �ټ� �� �̻��� �μ��� �μ��̸��� ��� ���� ����Ͻÿ�. 
  �̶� ��� ���� ���� ������ �����Ͻÿ�
*/
SELECT E.DEPARTMENT_ID, d.department_name, COUNT(*) AS EMP_CNT
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY E.DEPARTMENT_ID, d.department_name
 HAVING COUNT(*) >= 5
 ORDER BY EMP_CNT DESC
;
---
SELECT d.department_name, CNT.EMP_CNT
  FROM (SELECT DEPARTMENT_ID, COUNT(*) AS EMP_CNT
          FROM employees
         GROUP BY DEPARTMENT_ID
       ) CNT,
       DEPARTMENTS D
 WHERE cnt.department_id = d.department_id
   AND CNT.EMP_CNT >= 5
 ORDER BY CNT.EMP_CNT DESC
;
-- HR������ VIEW ���
SELECT DEPARTMENT_NAME, COUNT(*) AS EMP_CNT
  FROM EMP_DETAILS_VIEW
 GROUP BY DEPARTMENT_NAME
 HAVING COUNT(*) >= 5
 ORDER BY EMP_CNT DESC
;
/*
��10 �� ����� �޿��� ���� �޿� ����� �����Ϸ��� �Ѵ�. 
  �޿� ����� Job_Grades ���̺� ǥ�õȴ�. �ش� ���̺��� ������ ���캻 �� 
  ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �Ի���, �޿�, �޿������ ����Ͻÿ�.
  
CREATE TABLE JOB_GRADES (
    GRADE_LEVEL VARCHAR2(3),
    LOWEST_SAL NUMBER,
    HIGHEST_SAL NUMBER
);
INSERT INTO JOB_GRADES VALUES ('A', 1000, 2999);
INSERT INTO JOB_GRADES VALUES ('B', 3000, 5999);
INSERT INTO JOB_GRADES VALUES ('C', 6000, 9999);
INSERT INTO JOB_GRADES VALUES ('D', 10000, 14999);
INSERT INTO JOB_GRADES VALUES ('E', 15000, 24999);
INSERT INTO JOB_GRADES VALUES ('F', 25000, 40000);
COMMIT;
********************************/
--�� ���
SELECT FIRST_NAME||' '||LAST_NAME AS NAME, JOB_ID,
       department_name, SALARY, 
       G.LOWEST_SAL, G.HIGHEST_SAL, G.GRADE_LEVEL,
       (SELECT HIRE_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID = V.EMPLOYEE_ID) HIRE_DATE
  FROM EMP_DETAILS_VIEW V, JOB_GRADES G
 WHERE V.SALARY BETWEEN G.LOWEST_SAL AND G.HIGHEST_SAL
 ORDER BY V.EMPLOYEE_ID
;
