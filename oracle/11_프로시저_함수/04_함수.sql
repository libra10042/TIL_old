/* �Լ�
   /���ν������� ������/
  ���ν����� in, out, in out ��� ����ؼ� ���� ��ȯ�ϱ⵵ �ϰ�, 
  ��ȯ���� �ʰ� ���� �� �� �ִ�. 
  �Լ��� �۾��� ������ �Ŀ� ����� ��ȯ�� �Ѵ�.
  
  
  /�Լ��� ���� ����/ 
    create [or replace] function �Լ���
    �Ķ���� �Ķ���͵�����Ÿ��, 
    �Ķ����1 �Ķ���͵�����Ÿ��1,....
    
    return datatype 
    is [as] 
    PL/SQL ��; 
    
*/



create or replace function dept_max_sal
    (dept_id employees.department_id %type)
return number 
is 
    max_sal employees.salary%type;
begin
    select max(salary) into max_sal
    from employees
    where department_id = dept_id;
    return max_sal;
end;
/ 

select dept_max_sal(50) from dual;

    
create or replace function cnt_number
(cnt number)
return number
is 
    total_Cnt number;
begin 
    select count(*) into total_cnt
    from employees
    where department_id = cnt;
    return total_cnt; 
end; 
/


select distinct cnt_number(50) from employees; 

select distinct department_id, cnt_member(department_id) �μ����ο��� from employees; 



create or replace function avg_sal
    (dept_id employees.department_id%type)
    return number 
is 
    avg_salary number;
begin
    select round(avg(salary), 2), into avg_salary
    from employees
    where department_id = dept_id; 
    return avg_salary; 
end; 
/


select distinct department_id, avg_sal(department_id) �μ�����ձ޿�
from employees; 


    
create or replace function emp_dept_name
(emp_id employees.employee_id%type)
return varchar2
is 
    dept_name departments.department_name%type;
begin
    select department_name into dept_name
    from departments
    where department_id = (select department_id from employees
                        where employee_id = emp_id );
    return dept_name; 
end; 
/ 


select last_name, department_id, emp_dept_name(employee_id)
from employees;
                        