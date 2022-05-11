/* PL/SQL �������α׷� : �����ͺ��̽��� ����� PL/SQL��
    - �������α׷��� ����� �Լ��� ���ν����� �ִ�. 
    
    <�͸����� Ư¡>
        - �̸��� ���� PL/SQL ���
        - ����ҋ����� �������� �ʿ�
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

/*���ν����� �����Ű�� ���� ����
    exec �Ǵ� execute ���ν�����; 
*/
execute update_emp;


create or replace procedure up_sal
(emp_id employees.employee_id%type)
is 
begin
    update employees set salary = 3500
    where employee_id = emp_id;
    end;
/

select salary from employees
where employee_id = 130;


exec up_sal(130);         
        
select * from employees;
        

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


        
