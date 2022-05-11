/* PL/SQL 서브프로그램 : 데이터베이스의 저장된 PL/SQL문
    - 서브프로그램은 내장된 함수와 프로시저가 있다. 
    
    <익명블록의 특징>
        - 이름이 없는 PL/SQL 블록
        - 사용할때마다 컴파일이 필요
        - 데이터베이스에 저장되어 있지 않다.
        - 다른 응용프로그램에서 사용할 수 없다. 
        - 값을 반환할 수 없다.
        - 매개변수를 사용할 수 없다. 
        
    <서브프로그램의 특징>
        - 이름이 있는 PL/SQL 블록
        - 최초 실행될 때 한번만 컴파일 한다.
        - 데이터베이스에 저장되어 있다. 
        - 다른 응용프로그램에서 사용할 수 있다. 
        - 함수일 경우 값을 반환 할 수 있다. 
        - 매개변수를 사용할 수 있다.
        
    
*/
        
-- 프로시저 : 특정 처리를 위한 서브 프로그램의 한 유형
--          단독으로 실행 가능하며, 다른 응용프로그램에서 호출 되어 실행 가능.

/* 구문 형식 
   create procedure 프로시저명 
     파라미터1[in, out, in out] 데이터타입, 
     파라미터2[in, out, in out] 데이터타입
     
    is [as]
      변수 선언부
    begin 
      프로시저 본문 처리부;
    exception
      예외처리부;
    end; 
*/


create or replace procedure update_emp
is 
begin
    update employees
    set job_id = 'MK_manager'
    where department_id = 20
    and job_id = 'MK_MAN';
END; 
/
SELECT * FROM EMPLOYEES;


/*프로시저를 실행시키기 위한 구문
    exec 또는 execute 프로시저명; 
*/
execute update_emp;


create or replace procedure up_sal
(emp_id employees.employee_id%type)
is 
begin
    update employees set salary = 4000
    where employee_id = emp_id;
    end;
/

select salary from employees
where employee_id = 130;


exec up_sal(130);         
        
select * from employees;
        

-- IN 모드 예) : 매개변수가 서브프로그램으로 들어온다.
create or replace procedure emp_name_sal
    (emp_id employees.employee_id%type)
is 
    emp_name employees.last_name%type;
    emp_salary employees.salary%type;
begin
    select last_name, salary into emp_name, emp_salary
    from employees
    where employee_id = emp_id;
        
    dbms_output.put_line('사원명 : '||emp_name);
    dbms_output.put_line('급여 :'||emp_salary);
end;
/

set serveroutput on;
exec emp_name_sal(124);



-- out모드 사용 예 
create or replace procedure emp_info
 (emp_id employees.employee_id%type,
  emp_name out employees.last_name%type,
  emp_salary out employees.salary%type
 )
 is
 begin
    select last_name, salary into emp_name, emp_salary
    from employees
    where employee_id = emp_id; 
end;     
/


declare
 emp_name employees.last_name%type;
 salary employees.salary%type;
begin
 emp_info(124, emp_name, salary);
 dbms_output.put_line(emp_name||'사원의 급여는'||salary||'입니다.');
end;
/


variable emp_name varchar2(10)
variable salary number 
execute emp_info(124,:emp_name, :salary);


print emp_name salary;


declare 
  emp_name employees.last_name%type;
  salary employees.salary%type;
begin
  emp_info(emp_id =>124,
            emp_name => emp_name,
            emp_salary => salary);    --연산자 =>를 이용해서 값을 저장.
 dbms_output.put_line(emp_name||'사원의 급여는'||salary||'입니다');
end;
/


