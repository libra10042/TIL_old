/* 함수
   /프로시저와의 차이점/
  프로시저는 in, out, in out 모드 사용해서 값을 반환하기도 하고, 
  반환하지 않고 종료 할 수 있다. 
  함수는 작업을 수행한 후에 결과를 반환을 한다.
  
  
  /함수의 구문 형식/ 
    create [or replace] function 함수명
    파라미터 파라미터데이터타입, 
    파라미터1 파라미터데이터타입1,....
    
    return datatype 
    is [as] 
    PL/SQL 블럭; 
    
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

select distinct department_id, cnt_member(department_id) 부서별인원수 from employees; 



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


select distinct department_id, avg_sal(department_id) 부서별평균급여
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
                        