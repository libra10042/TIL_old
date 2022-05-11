/* 상호연관 서브쿼리(상관서브쿼리)
- 메인쿼리의 값을 서브쿼리가 사용하고, 서브쿼리의 결과값을 메인쿼리가 사용
- 메인쿼리와 서브쿼리가 서로 조인된 형태로 동작
*******************************/
-- SELECT절에 사용된 서브쿼리
SELECT O.ORDERID, O.CUSTID,
       (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) 고객명,
       O.BOOKID,
       (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) 책제목
  FROM ORDERS O
;
---출판사별로 출판사별 평균 도서가격보다 비싼 도서 목록을 구하시오
SELECT * FROM BOOK;
---- 굿스포츠 출판사 책중에서 굿스포츠 출판사의 평균 금액보다 비싼 책
SELECT * FROM BOOK WHERE PUBLISHER = '굿스포츠';
SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = '굿스포츠';
SELECT * FROM BOOK
 WHERE PUBLISHER = '굿스포츠'
   AND PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = '굿스포츠')
;
SELECT * FROM BOOK;
-- 메인쿼리의 BOOK 테이블 데이터 중 PUBLISHER 값을 
-- 서브쿼리에서 가져다 사용하고 그 결과값으로 메인쿼리의 PRICE 값과 비교
SELECT * FROM BOOK B
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK 
                 WHERE PUBLISHER = B.PUBLISHER)
;
-- 조인문(JOIN문)
---- 출판사별 평균 도서 가격
SELECT PUBLISHER, AVG(PRICE)
  FROM BOOK
 GROUP BY PUBLISHER
;
---------
SELECT B.BOOKID, B.BOOKNAME, B.PUBLISHER, B.PRICE,
       AVG.AVG_PRICE
--SELECT *       
  FROM BOOK B,
       (SELECT PUBLISHER, AVG(PRICE) AVG_PRICE
          FROM BOOK
         GROUP BY PUBLISHER) AVG
 WHERE B.PUBLISHER = AVG.PUBLISHER
   AND B.PRICE > AVG.AVG_PRICE
;
-----------------------------------
-- EXISTS : 존재여부 확인시 사용(있으면 TRUE)
-- NOT EXISTS : 존재하지 않으면 TRUE
SELECT *
  FROM BOOK
 WHERE BOOKNAME IN (SELECT BOOKNAME FROM BOOK
                     WHERE BOOKNAME LIKE '%축구%')
;
SELECT *
  FROM BOOK B
 WHERE EXISTS (SELECT 1 FROM BOOK
                WHERE B.BOOKNAME LIKE '%축구%')
;
--주문내역이 있는 고객의 이름과 전화번호를 찾으시오
SELECT *
  FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS)
;
-- ===> EXISTS 적용
SELECT *
  FROM CUSTOMER C
 WHERE EXISTS (SELECT 1 FROM ORDERS
                WHERE CUSTID = C.CUSTID)
;
-- NOT EXISTS
SELECT *
  FROM CUSTOMER C
 WHERE NOT EXISTS (SELECT 1 FROM ORDERS
                WHERE CUSTID = C.CUSTID)
;
