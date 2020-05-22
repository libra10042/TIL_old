/* 변수
  - 변수의 생성 규칙
  1. 반드시 문자로 시작해야 한다. 
  2. 문자나 숫자, 특수문자를 포함할 수 있다. 
  3. 변수명은 30bytes 이하여야 한다.
  4. 예약어(키워드)를 사용하면 안된다.
  
 - 변수의 선언은 선언부(declare)에서 선언되고, 
   값으로 초기화가 가능하다.  
 - 실행부에서 실행될경우 값이 할당 된다.
 - 서브프로그램의 파라미터로 전달되기도 하며, 서브프로그램의
   출력 결과를 저장하기도 한다.
 
 선언예> emp_no number(6,3) : 숫자를 저장하는 변수로 총6자리를 의미하며,
                            소수점 이하 3자리를 의미한다.
                            
        emp_name varchar2(5) : 문자를 저장하는 변수로 총 바이트 길이가 
                              5바이트를 저장할 수 있다.
                              
        emp_date date : 날짜를 저장하는 변수. 
        
    
 변수의 데이터 타입>
   char : 고정길이의 문자를 저장, 기본최소값 1~32,767바이트를 저장. 
   varchar2: 가변길이의 문자를 저장, 기본값은 없다.
            최대 32,767바이트 값을 저장. 
   number(전체자릿수, 소수점이하 자리수 ) :전체자리수와 소수점이하 자리 수를 가진 숫자를 저장. 
                                      전체 자리수 범위는 1~38까지 가능하고, 
                                      소수점 자리수의 범위는 -83~127까지 가능
   binary_double : 부동 소수점 수를 저장, 9바이트 필요함.
   date : 날짜 및 시간을 저장, 초단위로 저장. 
          날짜의 범위는 4712 B.C ~  9999 A.D
   timestamp : date 타입을 확장, 연도, 월, 일, 시, 분, 초 및 소수로 표시되는 초단위를 저장. 
               (자리수를 표현할떄는 0~9범위의 정수를 사용.) 
   


*** 참조 변수 ***
      테이블며.필드명%Type
empNo employees.employee_id%TYPE
: employees 테이블의 employee_id와 동일한 데이터 타입으로 선언. 


emp_name employees.first_name%TYPE
: employees테이블의 first_name과 동일한 데이터 타입으로 선언. 

empRow employees%ROWTYPE 
: employees테이블의 모든 컬럼을 한꺼번에 저장하기 위한 변수로 선언. 
      
*/
-- employees에서 3개의 열을 employees1에 복사한다.
create table employees1 as 
select employee_id, salary, deparment_id
from employees;


set serveroutput on; --PL/SQL을 출력하기 위한 명령어
declare
empNo employees.employee_id%TYPE;
empSalary employees_salary%TYPE; 
begin
    select employees_id, salary
    into empNO, empSalary
    from employees1 
    where department_id =20; 

    -- 결과를 출력하기 위한 명령어
    dbms_output.put_line(empNo|| ' '||empSalary); 
end;
/


declare
emp_row employees1%RowType;
begin  
    select * into emp_row
    from employees1
    where employee_id =100; 
    
    dbms_output.put_line(emp_row.employee_id||' '||emp_row.salary||' '||emp_row.department_id);
   
end;     
/

----------------------------
-- RowType을 이용한 데이터 입력
create table row_test(
    no number,
    name varchar2(20),
    hdate date
);

-- row_Test를 복사.
create table row_test2 as select * from row_test;

insert into row_test
values(1,'아무개', sysdate);

insert into row_test
values(2,'홍길동', sysdate);

insert into row_test
values(3, '고길동', sysdate);

select * from row_test;

commit;

declare
c_rec row_test%rowtype; -- row_test의 모든 내용을 c_rec에 복사 하겠다.
begin   
    select * into c_rec
    from row_test
    where no=3;
    
    insert into row_test2
    values



