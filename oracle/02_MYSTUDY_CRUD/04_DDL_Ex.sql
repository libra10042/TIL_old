/*
    ���̺� �����ϱ�
    
    create table ���̺��{
        �÷��� �ڷ��� option,
        �÷��� �ڷ��� option,
        �÷��� �ڷ��� option,
        �÷��� �ڷ��� option
    };


    char(n) : �������� ������ ������ Ÿ��
    varchar2(n) : �������� ������ ������ Ÿ��


    char(10)
        ������� 2byte -> 10byte (���� ������ ���� ����)
    varchar2(10)
        ������� 2byte -> 2byte (���� ������ ���� ����)


    number(p,s) : ���� ������ Ÿ��
                  p : ��ü�ڸ� ��ȿ ����
                  s : �Ҽ��� �ڸ� ��ȿ ����
                   - number(4,2)
                   
    date : �������� ��¥
    timestamp : �и���(ms)���� ǥ���� ������ Ÿ��
    
    clob : ��뷮 ����Ʈ ������ Ÿ��
    blob : ��뷮 ���̳ʸ� �����͸� �����ϱ� ���� ������ Ÿ��


*/

CREATE TABLE CAR(
    color varchar2(10),
    mileage number(5),
    speed number(3)

);
desc car;

create table student(
    stuid number(2),
    stuname varchar2(20),
    major varchar2(20),
    score number(3,2),
    phone varchar2(20)
);

desc student;



create table deposit(
    cid number(3),
    cname varchar2(25),
    caddress varchar2(30),
    phone varchar2(20)
    );
    
    
    
    
/*
    �ʵ� �߰�
        alter table ���̺�� add(�÷��� �ڷ���);
    �ʵ� ����
        alter table ���̺�� modify(�÷��� �ڷ���);
    �ʵ� ����
        alter table ���̺�� drop(�÷���);




*/



