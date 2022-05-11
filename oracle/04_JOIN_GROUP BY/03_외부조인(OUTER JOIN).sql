--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
---- CUSTOMER 테이블에는 있고, ORDERS 테이블에는 없는 사람
------------
--(방법1) MINUS : 차집합 처리
SELECT CUSTID FROM CUSTOMER -- 1,2,3,4,5
MINUS
SELECT CUSTID FROM ORDERS; --1,1, 3, 2, 4,4
--------------
--(방법2) 서브쿼리(SUB QUERY)
SELECT *
  FROM CUSTOMER
 WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS)
;
-----------------------
--(방법3) 외부조인(OUTER JOIN)
--동등조인(JOIN)
SELECT DISTINCT C.CUSTID, C.NAME
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID --조인조건(EQUIE JOIN - 동등조인)
;
--외부조인(좌측기준)
SELECT C.*
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID(+) --조인조건(좌측기준)
   AND O.ORDERID IS NULL
;
-- ANSI 표준 SQL(LEFT OUTER JOIN)
SELECT *
  FROM CUSTOMER C LEFT OUTER JOIN ORDERS O --조인조건(좌측기준)
       ON C.CUSTID = O.CUSTID
 WHERE O.ORDERID IS NULL --검색조건
;
-- ANSI 표준 SQL(RIGHT OUTER JOIN)
SELECT *
  FROM ORDERS O 
       RIGHT OUTER JOIN CUSTOMER C --조인방식(우측기준 외부조인)
       ON C.CUSTID = O.CUSTID --조인조건
 WHERE O.ORDERID IS NULL --검색조건
;
--외부조인(우측기준)
SELECT C.*
  FROM CUSTOMER C, ORDERS O
 WHERE O.CUSTID(+) = C.CUSTID --조인조건(우측기준)
   AND O.ORDERID IS NULL
;
-----------------
-- 조인(JOIN, INNER JOIN, 동등조인) : 조인테이블 모두에 존재하는 데이터 검색
-- 외부조인(OUTER JOIN) : 어느 한 쪽 테이블에 데이터가 존재하지 않는 데이터 검색
---- 모든 데이터 표시하고, 일치하지 않는 데이터 찾을 때 사용
------------------------------
CREATE TABLE DEPT (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT VALUES ('10', '총무부');
INSERT INTO DEPT VALUES ('20', '급여부');
INSERT INTO DEPT VALUES ('30', 'IT부');
COMMIT;
-----
CREATE TABLE DEPT_1 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT_1 VALUES ('10', '총무부');
INSERT INTO DEPT_1 VALUES ('20', '급여부');
COMMIT;
-----
CREATE TABLE DEPT_2 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT_2 VALUES ('10', '총무부');
INSERT INTO DEPT_2 VALUES ('30', 'IT부');
COMMIT;
-------------------------------
SELECT * FROM DEPT;
SELECT * FROM DEPT_1;
SELECT * FROM DEPT_2;
--------
-- DEPT = DEPT_1
SELECT *
  FROM DEPT D, DEPT_1 D1
 WHERE D.ID = D1.ID
;
--
SELECT *
  FROM DEPT D, DEPT_2 D2
 WHERE D.ID = D2.ID
;
---------------------
-- DEPT 에는 있고, DEPT_1 에는 없는 데이터(부서) 조회
-- LEFT OUTER JOIN : 좌측 테이블 기준
---- 전체 데이터 표시하고, 우측에 없으면 NULL 표시
SELECT *
  FROM DEPT D, DEPT_1 D1
 WHERE D.ID = D1.ID(+) --조인조건(좌측기준)
;
-- 좌측에만 있는 데이터 찾기
SELECT *
  FROM DEPT D, DEPT_1 D1
 WHERE D.ID = D1.ID(+) --조인조건(좌측기준)
   AND D1.ID IS NULL
;
---- ANSI 표준 SQL
SELECT *
  FROM DEPT D LEFT OUTER JOIN DEPT_1 D1 --조인 방식(좌측기준 외부조인)
       ON D.ID = D1.ID --조인조건
 WHERE D1.ID IS NULL
;
------------------------
--RIGHT OUTER JOIN : 우측 테이블 기준
SELECT *
  FROM DEPT_1 D1, DEPT D
 WHERE D1.ID(+) = D.ID --조인조건(우측기준)
   AND D1.ID IS NULL
;
--표준 SQL
SELECT *
  FROM DEPT_1 D1 
       RIGHT OUTER JOIN DEPT D --조인방식 : 우측기준 외부조인
       ON D1.ID = D.ID --조인조건
 WHERE D1.ID IS NULL
;
--------------------------
--(실습) DEPT_1, DEPT_2 테이블을 사용해서
-- DEPT_1 에는 있고, DEPT_2 테이블에는 없는 데이터 찾기(LEFT OUTER JOIN)
-- DEPT_2 에는 있고, DEPT_1 테이블에는 없는 데이터 찾기(RIGHT OUTER JOIN)
-----------------






