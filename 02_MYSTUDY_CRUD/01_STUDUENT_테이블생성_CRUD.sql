/*STUDENT 테이블 생성
컬럼에 제약이 없으므로 중복데이터 가능
컬럼에 데이터가 입력되지 않아도 됨
*/
CREATE TABLE STUDENT (
    ID VARCHAR2(20),
    NAME VARCHAR2(30),
    KOR NUMBER(3),
    ENG NUMBER(3,0),
    MATH NUMBER (3),
    TOT NUMBER (3),
    AVG NUMBER (5,2)
);
-- ---------------------------------
-- CRUD : INSERT, SELECT, UPDATE, DELETE
SELECT * FROM STUDENT;

-- 데이터 추가(입력) : INSERT
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('1111', '홍길동', 100, 90, 80);
COMMIT;
ROLLBACK; -- 작업취소(최종 COMMIT 위치로 부터 진행된 작업 취소)

-- INSERT : 2222, 김유신, 90, 80, 70
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2222', '김유신', 90, 80, 70);
----------------------------------------
-- 수정 : 데이터 수정(UPDATE)
-- 김유신 수학점수 : 70 -> 77 수정
UPDATE STUDENT
SET MATH = 77
WHERE NAME = '김유신';
SELECT * FROM STUDENT WHERE NAME = '김유신';
-------------------------------------
-- 데이터 삭제 : DELETE FROM
SELECT * FROM STUDENT WHERE ID = '2222';
DELETE FROM STUDENT WHERE ID = '2222';
DELETE FROM STUDENT WHERE NAME = '김유신';