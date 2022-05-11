/* ����ó��
 -- ���� 
    1. ������ ���� : PL/SQL ����� parse�Ǵ� ���ȿ� �߻��ϴ� ���� (����� ��Ÿ..)
    2. ��Ÿ�� ����(=exception) 
       PL/SQL ����� ����Ǵ� ���� �߻��ϴ� ����. 
          a. ����Ŭ ����
             - ����Ŭ���� �����Ǵ� ����
                ��. Predefined ORACLE Exception 
                   ���� ������ ������ ����
                ��. Non - predefined Oracle Exception
                   ������ �������� ���� ����
          b. ����� ���� ����
               ����ڿ� ���� ���ǵǴ� ����
               declare �ο���
               ���ܸ� exception
             begin�� �� exception�ο��� raise ���� �̿��ؼ� ���ܸ� �߻�. 
             
            -- ����ó���� ����
               ����ó���� : ���� �߻��� ��� ó���� �������� ���� ó�������� ����.

                Exception
                    when ���ܸ� then
                        ���๮..
                    when ���ܸ�2 then
                        ���๮..
                    when others then
                        ���๮..

*/
-- predefined oracle Exception 

declare 
    emp_lastname employees.last_name%type;
begin 
    select last_name into emp_lastname
    from employees
    where last_name like 'B%';
    
    dbms_output.put_line('�������' ||emp_lastname ||'�Դϴ�.');
    
exception 
    when no_data_found then 
        dbms_output.put_line('�ش� ����� �����ϴ�.');
    when too_many_rows then 
        dbms_output.put_line('����� �θ� �̻��Դϴ�...');
end;
/
set serveroutput on; 


-- ����� ���� ����ó�� 
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
        dbms_output.put_line('����� �����ϱ� ������ ���� �� �����!!');
end;
/
    
-- raise �̿��� ����ó�� 
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
        dbms_output.put_line('�ش� ����� �����ϴ�....');
end;
/

-- raise_applicatio_error ���ν��� �̿� (�̿밡���� ��ȣ : 20000~20999)

declare
    emp_id employees.employee_id%type;
    emp_name employees.last_name%type;
    
    begin
        delete employees
        where employee_id = &empid;
        
        if sql%notfound then
            raise_application_error(-20111, '����� �����ϴ�..'); 
        end if;
end;
/ 