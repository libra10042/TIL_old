/* *************************
SELECT [* | DISTINCT] {컬럼명, 컬럼명, ...}
  FROM 테이블명
[WHERE 조건절]
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] --ASC : 오름차순(기본/생략가능)
                                      --DESC : 내림차순
***************************/
--GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
--GROUP BY 문을 사용하면 SELECT 항목은 GROUP BY 절에 사용된 컬럼
---- 또는 그룹함수(COUNT, SUM, AVG, MAX, MIN)만 사용할 수 있다.
--============================================
-- 구매 고객별로 구매금액의 합계를 구하시오
SELECT CUSTID, SUM(SALEPRICE)
  FROM ORDERS
 GROUP BY CUSTID
;
------
SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID -- 조인조건
 GROUP BY C.NAME
 ORDER BY C.NAME
;
---
SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID -- 조인조건
 GROUP BY C.NAME
 ORDER BY SUM(O.SALEPRICE) DESC
;
---
SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID -- 조인조건
 GROUP BY C.NAME
 ORDER BY 2 DESC --SELECT 절의 2번째 항목으로 정렬
;
----------------------
-- 주문(판매) 테이블의 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대금액)
SELECT CUSTID, COUNT(*), SUM(SALEPRICE), 
       TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM ORDERS
 GROUP BY CUSTID
;
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), 
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID --조인조건
--   AND C.NAME IN ('추신수', '박지성') --검색조건
 GROUP BY C.NAME
 ORDER BY C.NAME
;
---------------------------------------
--(실습) 고객명 기준으로 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대)
---- 추신수, 장미란 고객 2명만 조회
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
--SELECT *
  FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID --조인조건
   AND C.NAME IN ('추신수', '장미란') --검색조건
 GROUP BY C.NAME
;
-----
-- ANSI 표준 SQL
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
--SELECT *
  FROM ORDERS O INNER JOIN CUSTOMER C
       ON O.CUSTID = C.CUSTID --조인조건
 WHERE C.NAME IN ('추신수', '장미란') --검색조건
 GROUP BY C.NAME
;
-------
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID --조인조건
 GROUP BY C.NAME 
 HAVING C.NAME IN ('추신수', '장미란')
;
---------------------------------
-- HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색조건 부여
-- HAVING 절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께 사용
-------------
-- 3건 이상 구매한 고객 조회
SELECT C.NAME, COUNT(*) AS CNT
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID 
 GROUP BY C.NAME
 HAVING COUNT(*) >= 3 --그룹핑된 데이터에서 원하는 데이터 검색
;
----------
-- 구매한 책중에서 20000원 이상인 책을 구입한 사람의 통계데이터 
---- (건수, 합계, 평균, 최소, 최대)
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 HAVING MAX(O.SALEPRICE) >= 20000 --통계데이터 구한 후 2만원이상 책 구한 사람 찾기
;
--------------------
-- 주의 : WHERE절에 사용되는 찾을 조건(테이블 데이터 기준)
---- HAVING 절에서 사용되는 조건은 그룹핑된 데이터 기준으로 검색
---- (결과값이 다르게 처리되므로 찾을 데이터가 무엇인지 명확히 하고 처리할 것)
-----------------------------
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)),
       MIN(O.SALEPRICE), MAX(O.SALEPRICE)
--SELECT *    
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
   AND O.SALEPRICE >= 20000 -- 2만원 이상인 책만 대상으로
 GROUP BY C.NAME
;
--=====================
--(실습) 필요시 조인과 GROUP BY ~ HAVING 구문을 사용해서 처리
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
---------------------------
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
SELECT COUNT(*) AS "TOTAL COUNT"
     , SUM(SALEPRICE) AS "판매액 합계" --한글 사용할 수 있지만 사용하지 말자
     , AVG(SALEPRICE) 평균값AVG
     , MIN(SALEPRICE) 최저가_MIN --언더바(_) 사용가능
     , MAX(SALEPRICE) "최고가(MAX)"
  FROM ORDERS
;
--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE) AS SUM_PRICE
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
-- ORDER BY SUM(O.SALEPRICE) DESC --적용된 그룹함수로 정렬 사용 가능
-- ORDER BY 3 DESC --컬럼 위치값으로 정렬 사용 가능
 ORDER BY SUM_PRICE DESC --별칭으로 정렬 사용 가능
;
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
SELECT C.NAME, O.SALEPRICE, B.BOOKNAME
  FROM CUSTOMER C, ORDERS O, BOOK B
 WHERE C.CUSTID = O.CUSTID
   AND O.BOOKID = B.BOOKID
;
--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
SELECT C.NAME, SUM(O.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 ORDER BY C.NAME
;
--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), TRUNC(AVG(O.SALEPRICE))
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 GROUP BY C.NAME
 HAVING COUNT(*) < 3
;
--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??











