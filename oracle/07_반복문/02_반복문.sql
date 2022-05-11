/* basic loop��
   loop
      pl/sql����;
      exit(����);
    end loop; 
*/
set serveroutput on;

declare 
    num number :=0;
begin
    loop
        dbms_output.put_line(num);  
        num := num + 1; 
    
        exit when num > 10;
    end loop;
end; 
/

/* while��
while ���� loop
    ���� ����; 
end loop;
 */
declare
    num number :=0; 
begin
    while num < 11 loop 
        dbms_output.put_line(num);
        num :=num+1; 
    end loop;
end;
/

declare
    num number:=10; 
begin
    loop
        dbms_output.put_line(num);
        num:=num-1;
        exit when num =-1;
    end loop;
end; 
/


declare 
    num number:=10;

begin
    while num >= 0 loop
        dbms_output.put_line(num);
        num:=num-1;
    end loop;
end;
/



/* For �� : �ݺ�Ƚ���� ������ �� �ִ�. 
    ����
    FOR n(ī���� Ƚ��) IN start..end LOOP
        ���๮��;
    end loop; 
*/

begin 
    for n in 0..10 loop 
        dbms_output.put_line(n); 
    end loop;
end; 
/

begin
    for n in reverse 0..10 loop
        dbms_output.put_line(n);
    end loop;
end;
/

/* ��� id�� �Է¹޾Ƽ� ��� �̸��� ���ڼ���ŭ # ��� 
   pl/sql ���� �ۼ��غ���(employees���̺��� �̿�)
*/
declare 
   emp_id employees_employee_id&type := &emp_no;
   emp_name employees.last_name&type; 
   v_no number; 
   v_char varchar2(30);
begin 
   select last_name, length(last_name) into emp_name, v_no
   from employees
   where employee_id = emp_id; 
   for i in 1...v_no loop
     v_char := v_char||'#';
     dbms_output.put_line(v_char);
   end loop; 
end;
/
 
/*
    continue�� :  ���� ���(11g���� �߰��� ���.)
*/
declare 
    tot number :=0; 
begin
    for i in 1...10 loop
        tot :=tot+1;
        dbms_output.put_line('tot :'||tot);
        continue when(i>5);
        tot := tot +i; 
        dbms_output.put_line('tot2 : '||tot); 
    end loop;
end; 
/

