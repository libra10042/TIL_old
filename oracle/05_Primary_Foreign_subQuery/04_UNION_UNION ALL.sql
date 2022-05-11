/* UNION, UNION ALL : 합집합 처리
- UNION : 중복데이터를 제외하고 합해줌
- UNION ALL : 중복데이터를 포함해서 합해줌
  단, 조회하는 컬럼의 이름, 순서, 숫자, 타입이 일치하도록 작성
******************************/
-- UNION 사용 예제
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
;
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
;
---- UNION 으로 합하기
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --박지성, 김연아, 장미란
UNION --동일데이터는 1개 선택
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --장미란, 추신수, 박세리
; 
-- UNION ALL 합하기
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --박지성, 김연아, 장미란
UNION ALL --동일데이터도 모두 선택
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --장미란, 추신수, 박세리
ORDER BY NAME -- ORDER BY 절은 마지막에 작성
; 
--------------------------
-- MINUS : 차집합(빼기 연산)
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --박지성, 김연아, 장미란
MINUS
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --장미란, 추신수, 박세리
; 
--------------------------
-- INTERSECT : 교집합(중복데이터 조회) - 조인문의 동등비교 결과와 동일
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3) --박지성, 김연아, 장미란
INTERSECT
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5) --장미란, 추신수, 박세리
; 
-- 조인문(JOIN문)
SELECT A.*
  FROM (SELECT CUSTID, NAME FROM CUSTOMER
         WHERE CUSTID IN (1, 2, 3)) A,
       (SELECT CUSTID, NAME FROM CUSTOMER
         WHERE CUSTID IN (3, 4, 5)) B
 WHERE A.CUSTID = B.CUSTID
   AND A.NAME = B.NAME
;








