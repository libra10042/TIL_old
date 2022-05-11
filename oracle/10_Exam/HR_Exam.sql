/* ***** HR DB ������ ��ȸ �ǽ� *****************
��1 HR �μ����� ���� �� ������ �޿� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
  �������(Employees) ���̺��� �޿��� $7,000~$10,000 ���� �̿��� ����� 
  �̸��� ��(Name���� ��Ī) �� �޿��� �޿��� ���� ������ ����Ͻÿ�
*/
SELECT * FROM EMPLOYEES
WHERE SALARY BETWEEN 7000 AND 10000 ORDER BY SALARY ASC;

SELECT * FROM EMPLOYEES;

/*
��2 HR �μ������� �޿�(salary)�� ������(commission_pct)�� ���� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
  ������ �޴� ��� ����� �̸��� ��(Name���� ��Ī), �޿�, ����, �������� ����Ͻÿ�. 
  �̶� �޿��� ū ������� �����ϵ�, �޿��� ������ �������� ū ������� �����Ͻÿ�
*/
SELECT LAST_NAME||' '||FIRST_NAME, SALARY, JOB_ID, COMMISSION_PCT FROM EMPLOYEES 
ORDER BY SALARY ASC, COMMISSION_PCT DESC;


/*  
��3 �̹� �б⿡ 60�� IT �μ������� �ű� ���α׷��� �����ϰ� �����Ͽ� ȸ�翡 �����Ͽ���. 
  �̿� �ش� �μ��� ��� �޿��� 12.3% �λ��ϱ�� �Ͽ���. 
  60�� IT �μ� ����� �޿��� 12.3% �λ��Ͽ� ������(�ݿø�) ǥ���ϴ� ������ �ۼ��Ͻÿ�. 
  ������ �����ȣ, ���� �̸�(Name���� ��Ī), �޿�, �λ�� �޿�(Increase Salary�� ��Ī)������ ����Ͻÿ�
  */
SELECT EMPLOYEE_ID, LAST_NAME||' '||FIRST_NAME AS NAME, DEPARTMENT_ID, SALARY, 
 CASE DEPARTMENT_ID
 WHEN 60 THEN  (SALARY + SALARY *0.123) 
 END
FROM EMPLOYEES;
  
/*
��4 �� ����� ��(last_name)�� 's'�� ������ ����� �̸��� ������ �Ʒ��� ���� ���� ����ϰ��� �Ѵ�. 
  ��� �� �̸�(first_name)�� ��(last_name)�� ù ���ڰ� �빮��, ������ ��� �빮�ڷ� ����ϰ� 
  �Ӹ���(��ȸ�÷���)�� Employee JOBs.�� ǥ���Ͻÿ�
  ��) FIRST_NAME  LAST_NAME  Employee JOBs.
      Shelley     Higgins    AC_MGR
*/
SELECT * FROM EMPLOYEES;
SELECT FIRST_NAME, LAST_NAME, UPPER(JOB_ID) AS Employee_jobs
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%s';





/*
��5 ��� ����� ������ ǥ���ϴ� ������ �ۼ��Ϸ��� �Ѵ�. 
  ������ ����� �̸��� ��(Name���� ��Ī), �޿�, ���翩�ο� ���� ������ �����Ͽ� ����Ͻÿ�. 
  ���翩�δ� ������ ������ "Salary + Commission", ������ ������ "Salary only"��� ǥ���ϰ�, 
  ��Ī�� ������ ���̽ÿ�. ���� ��� �� ������ ���� ������ �����Ͻÿ�
*/
select* from employees;
select first_name||' '||last_name as name, salary * 12 AS Y_SALARY, 
case when commission_pct like null
then 'salary+commission'
else 'Salary_only' 
end as result
from employees ORDER BY Y_SALARY DESC;




/*  
��6 �� ����� �Ҽӵ� �μ����� �޿� �հ�, �޿� ���, �޿� �ִ�, �޿� �ּڰ��� �����ϰ��� �Ѵ�. 
  ���� ��°��� ���� �ڸ��� �� �ڸ� ���б�ȣ, $ǥ�ÿ� �Բ� ���($123,456) 
  ��, �μ��� �Ҽӵ��� ���� ����� ���� ������ �����ϰ�, ��� �� �Ӹ����� ��Ī(alias) ó���Ͻÿ�
    
    */
SELECT DEPARTMENT_ID,
TO_CHAR(MIN(SALARY), '$00,000'), 
TO_CHAR(SUM(SALARY), '$99,999'),
TO_CHAR(AVG(SALARY), '$99,999'), 
TO_CHAR(MAX(SALARY), '$99,999')
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID;

    
/*
��7 ������� ������ ��ü �޿� ����� $10,000���� ū ��츦 ��ȸ�Ͽ� ������ �޿� ����� ����Ͻÿ�. 
  �� ������ CLERK�� ���Ե� ���� �����ϰ� ��ü �޿� ����� ���� ������� ����Ͻÿ�
*/
SELECT JOB_ID ,AVG(SALARY)
FROM EMPLOYEES
WHERE JOB_ID NOT LIKE '%CLERK%' 
GROUP BY JOB_ID
HAVING AVG(SALARY) > 10000 ORDER BY AVG(SALARY) DESC;


/*
��8 HR ��Ű���� �����ϴ� Employees, Departments, Locations ���̺��� ������ �ľ��� �� 
  Oxford�� �ٹ��ϴ� ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �����̸��� ����Ͻÿ�. 
  �̶� ù ��° ���� ȸ���̸��� 'HR-Company'�̶�� ������� ��µǵ��� �Ͻÿ�
*/
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
select * from locations where street_address like '%Oxford%';  -- LOCATION_ID Ȯ��. 2500
-- DEPARTMENTS���� LOCATION_ID Ȯ��.
SELECT * FROM DEPARTMENTS D, (SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE '%Oxford%') J, EMPLOYEES E
WHERE D.LOCATION_ID LIKE J.LOCATION_ID;
-- EMPLOYEE_ID���� DEPARTMENT_ID ��ȸ


SELECT FIRST_NAME||' '||LAST_NAME FROM (select * from locations where street_address like '%Oxford%') J, EMPLOYEES E, DEPARTMENTS D
WHERE J.LOCATION_ID = D.LOCATION_ID AND E.DEPARTMENT_ID = D.DEPARTMENT_ID;

/*
��9 HR ��Ű���� �ִ� Employees, Departments ���̺��� ������ �ľ��� �� ������� �ټ� �� �̻��� 
  �μ��� �μ��̸��� ��� ���� ����Ͻÿ�. �̶� ��� ���� ���� ������ �����Ͻÿ�
*/
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;

SELECT  E.JOB_ID, COUNT(E.JOB_ID) FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY E.JOB_ID
HAVING COUNT(E.JOB_ID) >= 5 ORDER BY COUNT(E.JOB_ID) DESC;




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
*/

SELECT * FROM EMPLOYEES;
SELECT * FROM JOB_GRADES;
SELECT E.FIRST_NAME||' '||E.LAST_NAME, E.JOB_ID, E.HIRE_DATE, E.SALARY, J.GRADE_LEVEL,
CASE WHEN E.SALARY  BETWEEN J.LOWEST_SAL AND J.HIGHEST_SAL THEN J.GRADE_LEVEL
ELSE '�ش�ȵ�'
END
FROM JOB_GRADES J, EMPLOYEES E;

