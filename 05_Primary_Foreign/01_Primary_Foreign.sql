
-- not null 제약조건
--create table null_test(
--    col1 varchar2(20) not null, 
--    col2 varchar2(20) null, 
--    col3 varchar2(20)
--
--);

insert into null_test(col1, col2)
values ('aa', 'bb');

select * from null_test;

insert into null_test(col2, col3)
values ('cc', 'dd');
-- unique 제약조건
--create table unique_test(
--    col1 varchar2(20) unique not null, 
--    col2 varchar2(20) unique,
--    col3 varchar2(20) not null, 
--    col4 varchar2(20) not null, 
--    constraints temp_unique unique(col1, col4) --조합을 해서 unique를 만든다.
--                                -- 두개의 필드를 조합 했을 때 unique해야 한다. ex)주민번호, 생년월일
--);

insert into unique_test(col1, col2, col3, col4)
values('aa', 'bb', 'cc', 'dd');

insert into unique_test(col1, col2, col3, col4)
values('a2', 'b2', 'c2', 'd2');

select * from unique_test;

update unique_test
set coll ='aa'
where col2 = 'b2';

insert into unique_test(col1, col2, col3, col4)
values('a3','', 'c3', 'd3');

--------------------------------------------
-- 기본키(primary key) 테ㅣ블 생성시 기본키 
create table primary_test(
    student_id number(10) primary key, /*인라인 방식*/
    name varchar2(20),
);
create table primary_test(
    student_id number(10),
    name varchar2(20),
    constraints student_pk primary key(student_id) /*아웃라인 방식*/
);

create table primary_test(
    student_id number(10),
    name varchar2(20)
);


/* 테이블을 생성하고 나서 이후에 기본키를 생성하는 방법 */
--alter table primary_test
--add constrains "기본키 이름" primary key (필드명); 

/* 외래키 */
create table foreign_key(
    department_id,
    constraints dept_fk
    foreign key (department_id)
    references departments (department_id)
);

/* 테이블을 생성하고 나서 외래키를 지정하는 방법 */
alter table foreign_key
add constraints dept_fk foreign key (department_id)
reference departments (department_id);


/*check*/
create table check_test(    
    gender varchar2(10) not null
        constraints check_set check (gender in('남성', '여성'));
);

