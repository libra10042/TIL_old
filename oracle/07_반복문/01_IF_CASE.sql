/* ��� : ���ǹ�, �ݺ���
      - ���ǹ� : if��, case ��
      - �ݺ��� : basic loop��, while��(�ݺ�Ƚ���� ������ ���� ���)
                 for��(�ݺ�Ƚ���� ������ ���)
      // if�� : if ~end if ��
         if(����) then 
            ������; 
         end if; 
*/

set serveroutput on; 


declare
    emp_id emloyees.employee_id%type;
    emp_name employees.last_name%type;
    emp_dept employees.department_id%type; 
    dept_name varchar2(20):= null; 

begin 
    select employee_id, last_name, department_id, depart_id
    into emp_id, emp_name, emp_dept
    from employees
    where employee_id = 124;
    
    if(emp_dept = 50) then  --if�� ���� 
        dept_name := 'Shipping';
    end if;
    
    if(emp_dept = 60) then  --if�� ���� 
        dept_name := 'IT';
    end if;
    
     if(emp_dept = 70) then  --if�� ���� 
        dept_name := 'Public Relation';
    end if;
    
    if(emp_dept = 80) then  --if�� ���� 
        dept_name := 'Sales';
    end if;

    dbms_output.put_line(emp_id||' '||emp_name||' '||emp_dept||' '||dept_name);
end;
/

--------------------------------------------------------------------------------
declare
    emp_id emloyees.employee_id%type;
    emp_name employees.last_name%type;
    emp_dept employees.department_id%type; 
    dept_name varchar2(20):= null; 

begin 
    select employee_id, last_name, department_id, depart_id
    into emp_id, emp_name, emp_dept
    from employees
    where employee_id = 103;
    
    if(emp_dept=50) then 
        dept_name :='Shiipping';
        elsif(emp_dept =60) then
        dept_name :='Shipping';
        elsif(emp_dept = 70) then 
        dept_name :='Public Relation';
        elsif(emp_dept =80) then
        dept_name :='Sales';
    
    end if;
    dbms_output.put_line(emp_id||' '||emp_name||' '||emp_dept||' '||dept_name);
end;
/

declare
    emp_id employees.employee_id%type;
    emp_name employees.last_name%type;
    emp_comm employees.comminission_pct%type :=null;
begin
    select employee_id, last_name, commission_pct
    into emp_id, emp_name, emp_comm
    from employees
    where employee_id = 155; 
    
    if(emp_comm > 0) then
        dbms_output.put_line(emp_name||' �� ���ʽ��� '||emp_comm||'�Դϴ�.'); 
    else
        dbms_output.put_line(emp_name||' �� ���ʽ��� �����ϴ�.'); 
    end if;   
    
end;
/


/*case�� case��*/
 declare
    emp_id employees.employee_id%type;
    emp_name employees.last_name%type;
    emp_dept employees.department_id%type;
    dept_name varchar2(20):=null; 
begin
    select employee_id, last_name, department_id
    into emp_id, emp_name, emp_dept
    from employees
    where employee_id = &empno; 
    dept_name := case emp_dept
                when 50 then 'Shipping'
                when 60 then 'IT'
                when 70 then 'Public Relation'
                when 80 then 'Sales'
                end; 
    dbms_output.put_line(emp_id||' '||emp_name||emp_dept||' ');
    end;
    /
    


