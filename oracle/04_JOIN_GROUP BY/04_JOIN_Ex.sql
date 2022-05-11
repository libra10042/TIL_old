create table dept(
    deptno number(2),
    dname varchar2(20),
    dloc varchar2(20)
    );
    
    select * from dept;
    
   insert into dept values (10, 'Accounting', 'new york');
   insert into dept values (20, 'research', 'dallas');
   insert into dept values (30, 'sales', 'chicago');
   
   commit;
   
   select * from emp3;
   
   
   insert into emp3 values(7369, 'smith', 'clerk', 7902, to_date('17-12-1980','dd-mm-yyyy'),800,null,20);
   insert into emp3 values(7499, 'allen', 'salesman', 7698, to_date('20-02-1981','dd-mm-yyyy'),1600,300,30);
   insert into emp3 values(7521, 'ward', 'salesman', 7698, to_Date('22-02-1981','dd-mm-yyyy'),1250,500,30);
   insert into emp3 values(7566, 'jones', 'manager', 7839, to_date('02-04-1981','dd-mm-yyyy'),2975, null, 20);
   insert into emp3 values(7654, 'martim', 'salesman', 7698, to_date('28-09-1981','dd-mm-yyyy'),1250, 1400,30);
   insert into emp3 values(7698, 'blake', 'manager', 7839, to_date('01-05-1981','dd-mm-yyyy'),2850, null,30);
   insert into emp3 values(7782, 'clark', 'manager', 7839, to_date('09-06-1981','dd-mm-yyyy'),2450, null,10);
   
   commit;
   
   
   select sal from emp3;
   select sum(sal) from emp3;
   
   select sum(sal) as "�޿� ����",
          avg(sal) as "���",
          max(sal) as "�ְ� �޿�",
          min(sal) as "�ּ� �޿�" from emp3;
   
   commit;
   
   
   select distinct job from emp3;
   
   --�ְ�޿�
   select max(sal) from  emp3;
   
   --5000�޴� ������ �̸�
   select ename from emp3 where sal = 5000;
   
   --���� ���� ����
   -- ���� ������ �� ������ �����ʿ� ����ؾ� �ϰ� ��ȣ�� ���ξ� ��. 
   select ename from emp3 where sal = (select max(sal) from emp3);
   
   
   -- scott�� ���� �μ��� �ٹ��ϴ� ����� �̸��� �μ���ȣ ���
   select deptno from emp3 where ename ='scott'; --20
   select ename, deptno from emp3 where deptno = 20;
   
   --���� ���� ����
select ename, deptno from emp3 where deptno = (select deptno from emp3 where ename= 'scott');

--scott�� ������ ������ ���� ����� ���
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'scott');

--scott�� ������ ������ ���� ����� ���
select * from emp3 where job = (select job from emp3 where ename = 'scott');


--scott�� �޿��� �����ϰų� �� ���� �޴� ������ �̸��� �޿�
select ename, sal from emp3 where sal >= (select sal from emp3 where ename = 'scott');

commit;


/*
    ������ �׷� ����ϱ�
    group by : Ư�� �÷��� �������� �׷��� ����. 
*/
select deptno, avg(sal) from emp3 group by deptno;

--�μ��� �����, Ŀ�̼��� ���� �����
select deptno, count(*) from emp3 group by deptno;


--�μ��� �� �޿�
select deptno, sum(sal) from emp3 group by deptno;
select deptno, sum(sal) from emp3 where sal>25000 group by deptno;
select sal from emp3 where sal>2500;


/*
   ���ڵ带 �׷�ȭ �ϱ����� ���ǿ� ���� �ɷ���
   �޿��� 2500�ʰ��� ������ ���ڵ常 ��� �μ����� �׷����� �� �ѱ޿� ���.
*/
select deptno, sum(sal) from emp3 group by deptno having sum(sal) >2500;


--�μ��� ��ձ޿��� 2000�̻��� �μ��� ��ȣ�� ��ձ޿� ���
select deptno, avg(sal) from emp3 group by deptno having avg(sal)>=2000;


select * from emp3 where job not like '%manager%';



/*
  ������ �Ŵ����� �ƴ� �����鿡 ���ؼ� 
  �������� ������ �� �޿��� 5000�̻��� ����, ������ �����, ������ �޿� ���� ���ϱ�
*/
select job, count(*), sum(sal)
from emp3 where job not like '%manager%'
group by job
having sum(sal) >= 5000;



commit;

--���밪
select 100, abs(100), abs(-100) from dual;

--������
select 123, 10, mod(123,10) from dual; 

--�ݿø�
--round(��, �ݿø� �ڸ���)
select round(15.931,1) from dual;

--���ڿ� ���� : ||
select 'abc' ||'efg' from dual;

--���ڿ� ġȯ
select replace('JACK and JUE', 'J', 'BL') FROM DUAL;


CREATE TABLE CUSTOMER(
    NAME VARCHAR2(20),
    SSN VARCHAR2(20),
    CAR_YN CHAR(1)
    );
    
desc customer;

commit;

insert into customer values('ȫ�浿', '910111-1234567','y');
insert into customer values('ȫ����', '810111-2222222', 'N');

SELECT * FROM CUSTOMER;

COMMIT;

select substr(ssn,8,1) from customer;
select decode(substr(ssn,8,1),'1', '����', '2', '����') from customer;
/*
decode : ���� ���Ͽ� �ش��ϴ� ���� �����ִ� �Լ�. 
��, �񱳽ÿ��� ��Ȯ�� ���� ���� �� ����.
*/




/*
    ����
    JOIN
        �ΰ� �̻��� �����̼�(���̺�) ���� �������� Ư���� �߽����� ����
        �ϳ��� �����̼�(���̺�)�� ǥ��
        �ΰ� �̻��� �����̼����� ���� ������ �����ϱ� ���� ����ϴ� ���� �Ϲ����� ���. 
        
    JOIN�� �ʿ伺
        Ư�� �μ��� ���� �μ��̸�, �μ���ġ���� ������ DEPT���̺� ����. 
        Ư�� ����� ���� �μ��̸�, �μ���ġ ���� ������ �˰� �ʹٸ� DEPT���̺��� ������ �˾ƿ;� ��. 
        
*/
CREATE table dept(
    deptno number(2),
    dname varchar2(20),
    dloc varchar2(20)
);
desc dept;

insert into dept values(10, 'accounting', 'new york');
insert into dept values(20, 'research', 'dallas');
insert into dept values(30, 'sales', 'chicago');

select * from dept;


/*
    ���� ����
    ���� ���� ����ϴ� ���ι��
    ���� ����� �Ǵ� �� ���̺��� ���������� �����ϴ� Į���� ����
    ��ġ�Ǵ� ���� �����Ͽ� ����� �����ϴ� ���� ���.
*/
select * from emp3, dept where emp3.deptno = dept.deptno;
select * from emp3 e, dept d where e.deptno = d.deptno;
commit;


-- scott�� �̸��� �μ����� ����ϼ���.
select ename, dname from emp3 e, dept d
where e.deptno = d.deptno and ename = 'scott';

select * from emp3;
select * from dept;
commit;



select * from emp3 e, dept d where e.deptno = d.deptno;


--���忡�� �ٹ��ϴ� ����� �̸��� �޿� ���
select ename, sal from emp3 e, dept d
where e.deptno = d.deptno and dloc = 'new york';



--accounting �μ� �Ҽ� ����� �̸��� �Ի��� 
select ename, hiredate from emp3 e, dept d
where e.deptno = d.deptno and dname = 'accounting';



--������̺�� �μ����̺��� �����ؼ� ����� �̸��� �μ���ȣ�� �μ����� ���
select ename, e.deptno, dname from emp3 e, dept d
where e.deptno = d.deptno;

/*
    �񵿵� ����
        ���� ������ Ư�� ���� ���� �ִ��� �����ϱ� ���� where���� ������ = ������ �̿���
        �� �����ڸ� ����ϴ� ����
*/


commit;
