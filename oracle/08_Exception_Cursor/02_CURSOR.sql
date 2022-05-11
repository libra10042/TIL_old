/* Ŀ��(cursor) : �������� ���ؼ� ��ȯ�Ǵ� ������� �����ϴ� �޸� ����.
    Fetch : Ŀ������ ���ϴ� ������� �����ϴ� ��. 
    
    - Ŀ���� ���� 
      . �����(Explicit) Ŀ�� : ����ڰ� �����ؼ� ���� �� ����ϴ� 
        SQL Ŀ��, �ַ� �������� ���� ó���ϰ��� �� ��� ���. 
      . ������(implicit) Ŀ�� : ����Ŭ���� �ڵ����� �������ִ� SQLĿ��. 
        ����ڴ� ���� ������ �� �� ����. 
    
      . Ŀ���� �Ӽ� : 
        %Found - �Ҵ��� ���ڵ尡 �ִ� ���. ->(true ��ȯ)
        %isOpen - Ŀ���� ���� ������ ��� true ��ȯ.
        %NotFound - �Ҵ��� ���ڵ尡 ���� ���. ->(true ��ȯ)
        %RowCount - ī���� ������ �Ѵ�. ���� ���� ��� 0, ��ġ�߻��� �� ���� 
                    1�� ������. 
         
     - Ŀ���� ó���ܰ�(����� Ŀ��)
       1. ����� Ŀ�� ����.      --> Cursor Ŀ���̸�
       2. ����� Ŀ�� ����.      --> Open Ŀ�� �̸�.
       3. Ŀ������ ������ ����.   --> Fetch Ŀ���̸�
       4. Ŀ�� ����.            --> Close Ŀ���̸�. 
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
    
    dbms_output.put_line('���      �̸�       �޿�');
    
    loop
        fetch cu1 into emp_id, emp_name, emp_salary;
        exit when cu1%notFound; --notFound : �� �̻� �Ҵ��� ������ ���� �� ���. 
        
        dbms_output.put_line(emp_id||' '||emp_name||' '||emp_salary);
    end loop;
    close cu1;
end;

set serveroutput on; 


/* Ŀ���� �ݺ���(For��)
   ��� ����
   For ���ڵ� ���� IN Ŀ���̸� LOOP
     ����� Ŀ���� OPEN, FETCH�� �ڵ����� ����. 
     ���� �����. 
   END LOOP; -- ��Ǫ���� ���� ���� �� �ڵ������� Ŀ���� �����. 
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
-- Ŀ���� �������� �ʴ� ���. 
declare 
begin
    for emp in(select employee_id, last_name, salary
                from employees)
    loop 
      dbms_output.put_line(emp.employee_id||' '||emp.last_name||' '||emp.salary);
    end loop;     
    
end;



/* ������ Ŀ�� ��� �� : �Ӽ����� SQL%notfound, SQL%rowcount, 
                        SQL%found, SQL%isopen*/
declare 
    cnt1 number;
    cnt2 number;
begin
    select count(*) into cnt1
    from employees
    where department_id =120;
    
    cnt2 := sql%rowcount;
    
    




        
        
    
    
    
    
    
    
    