
-- not null ��������
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
-- unique ��������
--create table unique_test(
--    col1 varchar2(20) unique not null, 
--    col2 varchar2(20) unique,
--    col3 varchar2(20) not null, 
--    col4 varchar2(20) not null, 
--    constraints temp_unique unique(col1, col4) --������ �ؼ� unique�� �����.
--                                -- �ΰ��� �ʵ带 ���� ���� �� unique�ؾ� �Ѵ�. ex)�ֹι�ȣ, �������
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
-- �⺻Ű(primary key) �פӺ� ������ �⺻Ű 
create table primary_test(
    student_id number(10) primary key, /*�ζ��� ���*/
    name varchar2(20),
);
create table primary_test(
    student_id number(10),
    name varchar2(20),
    constraints student_pk primary key(student_id) /*�ƿ����� ���*/
);

create table primary_test(
    student_id number(10),
    name varchar2(20)
);


/* ���̺��� �����ϰ� ���� ���Ŀ� �⺻Ű�� �����ϴ� ��� */
--alter table primary_test
--add constrains "�⺻Ű �̸�" primary key (�ʵ��); 

/* �ܷ�Ű */
create table foreign_key(
    department_id,
    constraints dept_fk
    foreign key (department_id)
    references departments (department_id)
);

/* ���̺��� �����ϰ� ���� �ܷ�Ű�� �����ϴ� ��� */
alter table foreign_key
add constraints dept_fk foreign key (department_id)
reference departments (department_id);


/*check*/
create table check_test(    
    gender varchar2(10) not null
        constraints check_set check (gender in('����', '����'));
);

