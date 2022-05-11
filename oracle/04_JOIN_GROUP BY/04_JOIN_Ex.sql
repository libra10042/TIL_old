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
   
   select sum(sal) as "급여 총합",
          avg(sal) as "평균",
          max(sal) as "최고 급여",
          min(sal) as "최소 급여" from emp3;
   
   commit;
   
   
   select distinct job from emp3;
   
   --최고급여
   select max(sal) from  emp3;
   
   --5000받는 직원의 이름
   select ename from emp3 where sal = 5000;
   
   --서브 쿼리 적용
   -- 서브 쿼리는 비교 연산자 오른쪽에 기술해야 하고 괄호를 감싸야 함. 
   select ename from emp3 where sal = (select max(sal) from emp3);
   
   
   -- scott과 같은 부서에 근무하는 사원의 이름과 부서번호 출력
   select deptno from emp3 where ename ='scott'; --20
   select ename, deptno from emp3 where deptno = 20;
   
   --서브 쿼리 적용
select ename, deptno from emp3 where deptno = (select deptno from emp3 where ename= 'scott');

--scott과 동일한 직급을 가진 사원을 출력
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'scott');

--scott과 동일한 직급을 가진 사원을 출력
select * from emp3 where job = (select job from emp3 where ename = 'scott');


--scott과 급여가 동일하거나 더 많이 받는 직원의 이름과 급여
select ename, sal from emp3 where sal >= (select sal from emp3 where ename = 'scott');

commit;


/*
    데이터 그룹 사용하기
    group by : 특정 컬럼을 기준으로 그룹을 나눔. 
*/
select deptno, avg(sal) from emp3 group by deptno;

--부서별 사원수, 커미션을 받은 사원수
select deptno, count(*) from emp3 group by deptno;


--부서별 총 급여
select deptno, sum(sal) from emp3 group by deptno;
select deptno, sum(sal) from emp3 where sal>25000 group by deptno;
select sal from emp3 where sal>2500;


/*
   레코드를 그룹화 하기전에 조건에 따라 걸러짐
   급여가 2500초과인 직원의 레코드만 골라서 부서별로 그룹핑한 후 총급여 계산.
*/
select deptno, sum(sal) from emp3 group by deptno having sum(sal) >2500;


--부서별 평균급여가 2000이상인 부서의 번호와 평균급여 출력
select deptno, avg(sal) from emp3 group by deptno having avg(sal)>=2000;


select * from emp3 where job not like '%manager%';



/*
  직업이 매니저가 아닌 직원들에 대해서 
  직업별로 나눠서 총 급여가 5000이상인 직업, 직업별 사원수, 직업별 급여 총합 구하기
*/
select job, count(*), sum(sal)
from emp3 where job not like '%manager%'
group by job
having sum(sal) >= 5000;



commit;

--절대값
select 100, abs(100), abs(-100) from dual;

--나머지
select 123, 10, mod(123,10) from dual; 

--반올림
--round(수, 반올림 자릿수)
select round(15.931,1) from dual;

--문자열 연결 : ||
select 'abc' ||'efg' from dual;

--문자열 치환
select replace('JACK and JUE', 'J', 'BL') FROM DUAL;


CREATE TABLE CUSTOMER(
    NAME VARCHAR2(20),
    SSN VARCHAR2(20),
    CAR_YN CHAR(1)
    );
    
desc customer;

commit;

insert into customer values('홍길동', '910111-1234567','y');
insert into customer values('홍길자', '810111-2222222', 'N');

SELECT * FROM CUSTOMER;

COMMIT;

select substr(ssn,8,1) from customer;
select decode(substr(ssn,8,1),'1', '남자', '2', '여자') from customer;
/*
decode : 값을 비교하여 해당하는 값을 돌려주는 함수. 
단, 비교시에는 정확히 같은 값만 비교 가능.
*/




/*
    조인
    JOIN
        두개 이상의 릴레이션(테이블) 들의 공통적인 특성을 중심으로 합쳐
        하나의 릴레이션(테이블)로 표현
        두개 이상의 릴레이션으로 부터 정보를 조합하기 위해 사용하는 가장 일반적인 방법. 
        
    JOIN의 필요성
        특정 부서에 대한 부서이름, 부서위치등의 정보는 DEPT테이블에 있음. 
        특정 사원에 대한 부서이름, 부서위치 등의 정보를 알고 싶다면 DEPT테이블에서 정보를 알아와야 함. 
        
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
    동등 조인
    가장 많이 사용하는 조인방법
    조인 대상이 되는 두 테이블에서 공통적으로 존재하는 칼럼의 값이
    일치되는 행을 연결하여 결과를 생성하는 조인 방법.
*/
select * from emp3, dept where emp3.deptno = dept.deptno;
select * from emp3 e, dept d where e.deptno = d.deptno;
commit;


-- scott의 이름과 부서명을 출력하세요.
select ename, dname from emp3 e, dept d
where e.deptno = d.deptno and ename = 'scott';

select * from emp3;
select * from dept;
commit;



select * from emp3 e, dept d where e.deptno = d.deptno;


--뉴욕에서 근무하는 사원의 이름과 급여 출력
select ename, sal from emp3 e, dept d
where e.deptno = d.deptno and dloc = 'new york';



--accounting 부서 소속 사원의 이름과 입사일 
select ename, hiredate from emp3 e, dept d
where e.deptno = d.deptno and dname = 'accounting';



--사원테이블과 부서테이블을 조인해서 사원의 이름과 부서번호와 부서명을 출력
select ename, e.deptno, dname from emp3 e, dept d
where e.deptno = d.deptno;

/*
    비동등 조인
        조인 조건이 특정 범위 내에 있는지 조사하기 위해 where절에 조건을 = 연산자 이외의
        비교 연산자를 사용하는 조인
*/


commit;
