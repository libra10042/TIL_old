-- rowtype ������ Ȱ���� �������� ����
declare
c_rec row_test2%rowType;
begin 
    select * into c_rec
    from row_test2
    where no = 3; 
    
    c_rec.name :='������'; 
    
    update row_test2
    set row=c_rec
    where no = 3;
    
    end;
    /


    select * from row_test2;   
    
    -----------------------------------------------------
    -- ����ڷκ��� 2���� ���ڸ� �Է¹޾Ƽ� ���� ���ϴ� ��. 
    -- ġȯ������ & ���
    
    declare 
     no1 number:= &no1; 
     no2 number:= &no2;
     sum1 number; 
    begin
     sum1 := no1+no2; 
     dbms_output.put_line('ù��° ��'||no1||', �ι�° ��:'||no2||', ��:'||sum1||'�Դϴ�.');
    end;
    / 
    set serveroutput on; --off �����̸� ȭ���� ��µ��� ���� ���� �ִ�.
    
    
/* ���� ���� 
  record Type ���� ���� ���. 
  1. type Ÿ�Ը� is record 
  2. �ĺ��� Ÿ�Ը�
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
    
    dbms_output.put_line('���     �̸�      �������̵�');
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
    select employee_id, last_name, nvl(email, '����')
    
