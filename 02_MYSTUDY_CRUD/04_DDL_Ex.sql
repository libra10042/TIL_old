/*
    테이블 생성하기
    
    create table 테이블명{
        컬럼명 자료형 option,
        컬럼명 자료형 option,
        컬럼명 자료형 option,
        컬럼명 자료형 option
    };


    char(n) : 고정길이 문자형 데이터 타입
    varchar2(n) : 가변길이 문자형 데이터 타입


    char(10)
        실제사용 2byte -> 10byte (실제 데이터 차지 공간)
    varchar2(10)
        실제사용 2byte -> 2byte (실제 데이터 차지 공간)


    number(p,s) : 숫자 데이터 타입
                  p : 전체자리 유효 숫자
                  s : 소수점 자리 유효 숫자
                   - number(4,2)
                   
    date : 고정길이 날짜
    timestamp : 밀리초(ms)까지 표현한 데이터 타입
    
    clob : 대용량 덱스트 데이터 타입
    blob : 대용량 바이너리 데이터를 저장하기 위한 데이터 타입


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
    필드 추가
        alter table 테이블명 add(컬럼명 자료형);
    필드 수정
        alter table 테이블명 modify(컬럼명 자료형);
    필드 삭제
        alter table 테이블명 drop(컬럼명);




*/



