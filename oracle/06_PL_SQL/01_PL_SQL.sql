/* ����
  - ������ ���� ��Ģ
  1. �ݵ�� ���ڷ� �����ؾ� �Ѵ�. 
  2. ���ڳ� ����, Ư�����ڸ� ������ �� �ִ�. 
  3. �������� 30bytes ���Ͽ��� �Ѵ�.
  4. �����(Ű����)�� ����ϸ� �ȵȴ�.
  
 - ������ ������ �����(declare)���� ����ǰ�, 
   ������ �ʱ�ȭ�� �����ϴ�.  
 - ����ο��� ����ɰ�� ���� �Ҵ� �ȴ�.
 - �������α׷��� �Ķ���ͷ� ���޵Ǳ⵵ �ϸ�, �������α׷���
   ��� ����� �����ϱ⵵ �Ѵ�.
 
 ����> emp_no number(6,3) : ���ڸ� �����ϴ� ������ ��6�ڸ��� �ǹ��ϸ�,
                            �Ҽ��� ���� 3�ڸ��� �ǹ��Ѵ�.
                            
        emp_name varchar2(5) : ���ڸ� �����ϴ� ������ �� ����Ʈ ���̰� 
                              5����Ʈ�� ������ �� �ִ�.
                              
        emp_date date : ��¥�� �����ϴ� ����. 
        
    
 ������ ������ Ÿ��>
   char : ���������� ���ڸ� ����, �⺻�ּҰ� 1~32,767����Ʈ�� ����. 
   varchar2: ���������� ���ڸ� ����, �⺻���� ����.
            �ִ� 32,767����Ʈ ���� ����. 
   number(��ü�ڸ���, �Ҽ������� �ڸ��� ) :��ü�ڸ����� �Ҽ������� �ڸ� ���� ���� ���ڸ� ����. 
                                      ��ü �ڸ��� ������ 1~38���� �����ϰ�, 
                                      �Ҽ��� �ڸ����� ������ -83~127���� ����
   binary_double : �ε� �Ҽ��� ���� ����, 9����Ʈ �ʿ���.
   date : ��¥ �� �ð��� ����, �ʴ����� ����. 
          ��¥�� ������ 4712 B.C ~  9999 A.D
   timestamp : date Ÿ���� Ȯ��, ����, ��, ��, ��, ��, �� �� �Ҽ��� ǥ�õǴ� �ʴ����� ����. 
               (�ڸ����� ǥ���ҋ��� 0~9������ ������ ���.) 
   


*** ���� ���� ***
      ���̺��.�ʵ��%Type
empNo employees.employee_id%TYPE
: employees ���̺��� employee_id�� ������ ������ Ÿ������ ����. 


emp_name employees.first_name%TYPE
: employees���̺��� first_name�� ������ ������ Ÿ������ ����. 

empRow employees%ROWTYPE 
: employees���̺��� ��� �÷��� �Ѳ����� �����ϱ� ���� ������ ����. 
      
*/
-- employees���� 3���� ���� employees1�� �����Ѵ�.
create table employees1 as 
select employee_id, salary, deparment_id
from employees;


set serveroutput on; --PL/SQL�� ����ϱ� ���� ��ɾ�
declare
empNo employees.employee_id%TYPE;
empSalary employees_salary%TYPE; 
begin
    select employees_id, salary
    into empNO, empSalary
    from employees1 
    where department_id =20; 

    -- ����� ����ϱ� ���� ��ɾ�
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
-- RowType�� �̿��� ������ �Է�
create table row_test(
    no number,
    name varchar2(20),
    hdate date
);

-- row_Test�� ����.
create table row_test2 as select * from row_test;

insert into row_test
values(1,'�ƹ���', sysdate);

insert into row_test
values(2,'ȫ�浿', sysdate);

insert into row_test
values(3, '��浿', sysdate);

select * from row_test;

commit;

declare
c_rec row_test%rowtype; -- row_test�� ��� ������ c_rec�� ���� �ϰڴ�.
begin   
    select * into c_rec
    from row_test
    where no=3;
    
    insert into row_test2
    values



