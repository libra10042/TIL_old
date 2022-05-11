/* PL/SQL �������α׷� : �����ͺ��̽��� ����� PL/SQL��
    - �������α׷��� ����� �Լ��� ���ν����� �ִ�. 
    
    <�͸����� Ư¡>
        - �̸��� ���� PL/SQL ���
        - ����Ҷ����� �������� �ʿ�
        - �����ͺ��̽��� ����Ǿ� ���� �ʴ�.
        - �ٸ� �������α׷����� ����� �� ����. 
        - ���� ��ȯ�� �� ����.
        - �Ű������� ����� �� ����. 
        
    <�������α׷��� Ư¡>
        - �̸��� �ִ� PL/SQL ���
        - ���� ����� �� �ѹ��� ������ �Ѵ�.
        - �����ͺ��̽��� ����Ǿ� �ִ�. 
        - �ٸ� �������α׷����� ����� �� �ִ�. 
        - �Լ��� ��� ���� ��ȯ �� �� �ִ�. 
        - �Ű������� ����� �� �ִ�.
        
    
*/
        
-- ���ν��� : Ư�� ó���� ���� ���� ���α׷��� �� ����
--          �ܵ����� ���� �����ϸ�, �ٸ� �������α׷����� ȣ�� �Ǿ� ���� ����.

/* ���� ���� 
   create procedure ���ν����� 
     �Ķ����1[in, out, in out] ������Ÿ��, 
     �Ķ����2[in, out, in out] ������Ÿ��
     
    is [as]
      ���� �����
    begin 
      ���ν��� ���� ó����;
    exception
      ����ó����;
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


/*���ν����� �����Ű�� ���� ����
    exec �Ǵ� execute ���ν�����; 
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
        

-- IN ��� ��) : �Ű������� �������α׷����� ���´�.
create or replace procedure emp_name_sal
    (emp_id employees.employee_id%type)
is 
    emp_name employees.last_name%type;
    emp_salary employees.salary%type;
begin
    select last_name, salary into emp_name, emp_salary
    from employees
    where employee_id = emp_id;
        
    dbms_output.put_line('����� : '||emp_name);
    dbms_output.put_line('�޿� :'||emp_salary);
end;
/

set serveroutput on;
exec emp_name_sal(124);



-- out��� ��� �� 
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
 dbms_output.put_line(emp_name||'����� �޿���'||salary||'�Դϴ�.');
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
            emp_salary => salary);    --������ =>�� �̿��ؼ� ���� ����.
 dbms_output.put_line(emp_name||'����� �޿���'||salary||'�Դϴ�');
end;
/


