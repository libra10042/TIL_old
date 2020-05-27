/* 예외처리
 -- 에러 
    1. 컴파일 에러 : PL/SQL 블록이 parse되는 동안에 발생하는 에러 (사용자 오타..)
    2. 런타임 에러(=exception) 
       PL/SQL 블록이 실행되는 동안 발생하는 에러. 
          a. 오라클 예외
             - 오라클에서 제공되는 예외
                ㄱ. Predefined ORACLE Exception 
                   예외 사전에 정해진 예외
                ㄴ. Non - predefined Oracle Exception
                   사전에 정해지지 않은 예외
          b. 사용자 정의 예외
               사용자에 의해 정의되는 예외
               declare 부에서
               예외명 exception
             begin부 나 exception부에서 raise 문을 이용해서 예외를 발생. 
             
            -- 예외처리부 형식
               예외처리부 : 예뵈 발생이 어떻게 처리할 것인지에 예외 처리내용이 들어간다.

                Exception
                    when 예외명 then
                        실행문..
                    when 예외명2 then
                        실행문..
                    when others then
                        실행문..

*/
-- predefined oracle Exception 

declare 
    emp_lastname employees.last_name%type;
begin 
    select last_name into emp_lastname
    from employees
    where last_name like 'B%';
    
    dbms_output.put_line('사원명은' ||emp_lastname ||'입니다.');
    
exception 
    when no_data_found then 
        dbms_output.put_line('해당 사원이 없습니다.');
    when too_many_rows then 
        dbms_output.put_line('사원이 두명 이상입니다...');
end;
/
set serveroutput on; 


-- 사용자 정의 예외처리 
-- pragma
declare 
    emp_exist exception; 
    pragma exception_init(emp_exist, -2292);
begin
    delete departments
    where department_id = &deptno;
    commit;
exception
    when emp_exist then
        dbms_output.put_line('사원이 존재하기 때문에 지울 수 없어요!!');
end;
/
    
-- raise 이용한 예외처리 
declare 
    emp_id employees.employee_id%type;
    emp_name employees.last_name%type;
    
    no_emp exception;
    
begin
    delete employees
    where employee_id = &empid;
    
    if sql%notfound then
        raise no_emp; 
    end if;
exception
    when no_emp then
        dbms_output.put_line('해당 사원이 없습니다....');
end;
/

-- raise_applicatio_error 프로시저 이용 (이용가능한 번호 : 20000~20999)

declare
    emp_id employees.employee_id%type;
    emp_name employees.last_name%type;
    
    begin
        delete employees
        where employee_id = &empid;
        
        if sql%notfound then
            raise_application_error(-20111, '사원이 없습니다..'); 
        end if;
end;
/ 