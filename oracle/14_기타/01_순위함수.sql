/* �����Լ�
RANK()  : �ߺ� ���� ������ŭ ���� ���� ���� ���� ��Ŵ(1,2,2,4,5)
DENSE_RANK() : �ߺ� ������ �����ص� ���������� ���� ���� ���� ǥ����(1,2,2,3,4)
ROW_NUMBER() : �Ϸù�ȣ ǥ��(1,2,3,4,5)
***************************************/
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
     , RANK() OVER (ORDER BY SALARY DESC) AS RANK
     , DENSE_RANK() OVER (ORDER BY SALARY DESC) AS DENSE_RANK
     , ROW_NUMBER() OVER (ORDER BY SALARY DESC) AS ROW_NUMBER
  FROM EMPLOYEES
;
----------------
-- PARTITION BY : �׷��� ����� ���� ����
SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY
     , RANK() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_DEPT_SAL
FROM EMPLOYEES;







