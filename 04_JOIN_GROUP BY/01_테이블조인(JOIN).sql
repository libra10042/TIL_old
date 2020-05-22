--박지성 고객ID
SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성'; --CUSTID : 1
--박지성이 구입한 책의 합계금액
SELECT * FROM ORDERS WHERE CUSTID = 1;

--서브쿼리(sub query) 방식
SELECT * FROM ORDERS 
WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성');

----------------------
--테이블 조인(join) 방식
SELECT * FROM CUSTOMER WHERE CUSTID = 1;
SELECT * FROM ORDERS WHERE CUSTID = 1;

-- CUSTOMER, ORDERS 테이블 데이터 동시 조회
SELECT *
FROM CUSTOMER, ORDERS --조인할 테이블
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID --조인조인
;
----
--테이블에 대한 별칭 사용으로 간단하게 표시하고 사용
SELECT *
FROM CUSTOMER C, ORDERS O  --테이블에 대한 별칭 사용
WHERE C.CUSTID = O.CUSTID --조인조건
AND C.NAME = '박지성'  --검색조건
;
--ANSI 표준 조인 쿼리
SELECT *
FROM CUSTOMER C
    INNER JOIN ORDERS O
    ON C.CUSTID = O.CUSTID  --조인조건
WHERE C.NAME = '박지성' --검색조건
;
--------------
--박지성이 구입한 합계금액
SELECT SUM(O.SALEPRICE)
--SELECT *
FROM CUSTOMER C, ORDERS O --조인할 테이블
WHERE C.CUSTID = O.CUSTID  --조인 조건
AND C.NAME = '박지성'  --검색 조건
;
----------------------
--조인된 데이터에서 컬럼 조회시 : 테이블명(별칭).컬럼명 형태로 사용
SELECT C.CUSTID, C.NAME, C.ADDRESS,
    O.CUSTID AS ORD_CUSTID, --동일 컬럼명이 있는 경우 별칭처리해서 다른 이름으로 사용
    O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O --조인할 테이블
WHERE C.CUSTID = O.CUSTID  --조인 조건
AND C.NAME = '박지성'  --검색조건
;
-----------------
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
--출판한 책중 판매된 책 목록(미디어로 끝나는 출판사)
SELECT O.ORDERID, O.BOOKID, 
    B.BOOKNAME, B.PUBLISHER, B.PRICE, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, ORDERS O
WHERE b.bookid = o.bookid  --조인조건
--AND B.PUBLISHER = '굿스포츠'
AND B.PUBLISHER LIKE '%미디어'
ORDER BY B.PUBLISHER, B.BOOKNAME
;
--=============================
--(문제해결) 테이블 조인을 통해서 요청한 데이터 찾기
--실습 : '야구를 부탁해'라는 책이 팔린 내역을 확인(책제목, 판매금액, 판매일자)
--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인
------
--실습 : '추신수'가 구입한 책값과 구입일자를 확인(책값, 구입일자)
--실습 : '추신수'가 구입한 합계금액을 확인
--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 판매금액, 판매일자)
--==================================================
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
--실습 : '야구를 부탁해'라는 책이 팔린 내역을 확인(책제목, 판매금액, 판매일자)
SELECT B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
  FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
   AND B.BOOKNAME = '야구를 부탁해'
;
--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인
SELECT '야구를 부탁해 판매건수', COUNT(*)
  FROM BOOK B, ORDERS O
 WHERE B.BOOKID = O.BOOKID
   AND B.BOOKNAME = '야구를 부탁해'
;
------
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
--실습 : '추신수'가 구입한 책값과 구입일자를 확인(책값, 구입일자)
SELECT '추신수 구입내역', o.saleprice, o.orderdate
FROM CUSTOMER C, ORDERS O
WHERE c.custid = o.custid
AND C.NAME = '추신수'
;
--실습 : '추신수'가 구입한 합계금액을 확인
SELECT '추신수 구입합계', SUM(O.SALEPRICE)
FROM CUSTOMER C, ORDERS O
WHERE c.custid = o.custid
AND C.NAME = '추신수'
;
--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 판매금액, 판매일자)
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME IN ('박지성', '추신수')  -- AND C.NAME = '박지성' OR C.NAME = '추신수'
ORDER BY C.NAME, O.ORDERDATE
;
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND (C.NAME = '박지성' OR C.NAME = '추신수')
ORDER BY C.NAME, O.ORDERDATE
;
--=======================================
--고객명, 책제목, 판매가격, 판매일자, 출판사명(3개 테이블 조인)
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID
   AND O.CUSTID = C.CUSTID
;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE B.BOOKID = O.BOOKID
   AND O.CUSTID = C.CUSTID
;
------------------------------------
--(실습) BOOK, CUSTOMER, ORDERS 테이블 데이터를 조회
-- 장미란이 구입한 책제목, 구입가격, 구입일자, 출판사
-- 장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
-- '야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
-- 추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
---- (정렬 : 고객명, 구입일자 순으로)
------------------------------------
-- 장미란이 구입한 책제목, 구입가격, 구입일자, 출판사
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID --조인 조건
   AND O.CUSTID = C.CUSTID --조인 조건
   AND C.NAME = '장미란'
;
-- 장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
SELECT ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD HH24:MI:SS')
  FROM ORDERS
;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --조인조건
   AND C.NAME = '장미란'
   AND O.ORDERDATE >= TO_DATE('2014-01-01', 'YYYY-MM-DD')
   AND O.ORDERDATE < TO_DATE('2014-07-09', 'YYYY-MM-DD')
;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --조인조건
   AND C.NAME = '장미란'
   AND O.ORDERDATE BETWEEN TO_DATE('20140101', 'YYYYMMDD')
                       AND TO_DATE('2014/07/08', 'YYYY/MM/DD')
;
-- '야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --조인조건
   AND B.BOOKNAME = '야구를 부탁해'
;
-- 추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
---- (정렬 : 고객명, 구입일자 순으로)
SELECT C.NAME, B.BOOKNAME, B.PRICE, O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID AND O.CUSTID = C.CUSTID --조인조건
   AND C.NAME IN ('추신수', '장미란')
 ORDER BY C.NAME, O.ORDERDATE
-- ORDER BY 1, 4
;
--================================
--추신수가 구입한 책갯수, 합계금액, 평균값, 가장 비싼책금액, 싸게주고산 금액
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), ROUND(AVG(O.SALEPRICE)), 
       MAX(O.SALEPRICE), MIN(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
--   AND C.NAME = '추신수'
;




