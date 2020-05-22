-- rowtype 변수를 활용한 데이터의 변경
declare
c_rec row_test2%rowType;
begin 
    select * into c_rec
    from row_test2
    where no = 3; 
    
    c_rec.name :='이충진'; 
    
    update row_test2
    set row=c_rec
    where no = 3;
    
    end;
    /


    select * from row_test2;   
    
    -----------------------------------------------------
    -- 사용자로부터 2개의 숫자를 입력받아서 합을 구하는 예. 
    -- 치환연산자 & 사용
    
    declare 
     no1 number:= &no1; 
     no2 number:= &no2;
     sum1 number; 
    begin
     sum1 := no1+no2; 
     dbms_output.put_line('첫번째 수'||no1||', 두번째 수:'||no2||', 합:'||sum1||'입니다.');
    end;
    / 
    set serveroutput on; --off 상태이면 화면이 출력되지 않을 수도 있다.
    
    
/* 복합 변수 
  record Type 변수 지정 방법. 
  1. type 타입명 is record 
  2. 식별자 타입명
*/

declare
type emp_rec is record
   (emp_id employees.employee_id%type, 
    emp_name employees.first_name%type, 
    emp_job employees.job_id%type
   );
   
   rec1 emp_rec; 
   
   begin
    select employee_id, first_name, job_id
    into rec1
    from employees e
    where department_id = 10; 
    
    dbms_output.put_line('사번     이름      업무아이디');
    dbms_output.put_line(rec1.emp_id||' '||rec1.emp_name||' '
                         ||rec1.emp_job);
end;
/
    
declare
type emp_rec2 is record(
    emp_id employees.employee_id%type,
    emp_name employees.last_name%type,
    emp_email employees.email%type,
    emp_salary employees.salary%type
); 

rec2 emp_rec2;

vemp_id employees.employee_id%type := '&empid';

begin
    select employee_id, last_name, nvl(email, '없음')
    
