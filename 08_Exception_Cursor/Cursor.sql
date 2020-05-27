/* 커서(cursor) : 쿼리문에 의해서 반환되는 결과값을 저장하는 메모리 공간.
    Fetch : 커서에서 원하는 결과값을 추출하는 것. 
    
    - 커서의 종류 
      . 명시적(Explicit) 커서 : 사용자가 선언해서 생성 후 사용하는 
        SQL 커서, 주로 여러개의 행을 처리하고자 할 경우 사용. 
      . 묵시적(implicit) 커서 : 오라클에서 자동으로 선언해주는 SQL커서. 
        사용자는 생성 유무를 알 수 없다. 
    
      . 커서의 속성 : 
        %Found - 할당할 레코드가 있는 경우. ->(true 반환)
        %isOpen - 커서가 오픈 상태일 경우 true 반환.
        %NotFound - 할당할 레코드가 없는 경우. ->(true 반환)
        %RowCount - 카운터 역할을 한다. 오픈 됬을 경우 0, 패치발생할 때 마다 
                    1씩 증가함. 
         
     - 커서의 처리단계(명시적 커서)
       1. 명시적 커서 선언.      --> Cursor 커서이름
       2. 명시적 커서 오픈.      --> Open 커서 이름.
       3. 커서에서 데이터 추출.   --> Fetch 커서이름
       4. 커서 종료.            --> Close 커서이름. 
*/


declare 
    emp_id number(4);
    emp_name varchar2(10);
    emp_salary number(10);
    
 Cursor cu1 is 
    select employee_id, last_name, salary
    from employees
    where department_id = 10;
    
begin
    open cu1;
    
    dbms_output.put_line('사번      이름       급여');
    
    loop
        fetch cu1 into emp_id, emp_name, emp_salary;
        exit when cu1%notFound; --notFound : 더 이상 할당할 변수가 없을 때 사용. 
        
        dbms_output.put_line(emp_id||' '||emp_name||' '||emp_salary);
    end loop;
    close cu1;
end;

set serveroutput on; 


/* 커서와 반복문(For문)
   사용 형식
   For 레코드 네임 IN 커서이름 LOOP
     명시적 커서의 OPEN, FETCH가 자동으로 수행. 
     실행 문장들. 
   END LOOP; -- 루푸문을 빠져 나갈 때 자동적으로 커서가 종료됨. 
*/



declare 
    cursor emp_cur is 
        select employee_id, last_name
        from employees; 
        
        
begin
    for emp_rec in emp_cur loop 
        dbms_output.put_line(emp_rec.employee_id||' '||emp_rec.last_name); 
    end loop; 
end;
/


declare 
    emp emp%rowtype; 
    
    cursor cur1 is
        select employee_id, last_name, salary
        from employees;
    
begin 
    for emp is cur1 loop
     exit when cur1%notfound;
      dbms_output.put_line(emp.employee_id||' '||emp.last_name||' '||emp.salary);
    end loop; 
end;
/

---------------------------------------------------
-- 커서를 선언하지 않는 방법. 
declare 
begin
    for emp in(select employee_id, last_name, salary
                from employees)
    loop 
      dbms_output.put_line(emp.employee_id||' '||emp.last_name||' '||emp.salary);
    end loop;     
    
end;



/* 묵시적 커서 사용 예 : 속성사용시 SQL%notfound, SQL%rowcount, 
                        SQL%found, SQL%isopen*/
declare 
    cnt1 number;
    cnt2 number;
begin
    select count(*) into cnt1
    from employees
    where department_id =120;
    
    cnt2 := sql%rowcount;
    
    




        
        
    
    
    
    
    
    
    