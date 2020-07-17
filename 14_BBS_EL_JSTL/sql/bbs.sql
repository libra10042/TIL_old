--BBS(bulletin board system) : 전자게시판
--2개의 테이블(게시글, 댓글)
--게시글 테이블(BBS_T)
CREATE TABLE BBS_T (
	B_IDX NUMBER(6) CONSTRAINT BBS_T_PK PRIMARY KEY,
	SUBJECT VARCHAR2(50), --글제목
	WRITER VARCHAR2(20), --작성자
	CONTENT CLOB, --글내용
	FILE_NAME VARCHAR2(50), --실제 저장되는 파일명
	ORI_NAME VARCHAR2(50), --원본 파일명
	PWD VARCHAR2(20), --암호
	WRITE_DATE DATE, --작성일시
	IP VARCHAR2(15), --작성자 IP주소
	HIT NUMBER(4) --조회수
);

--게시글에 대한 댓글(COMMENT_T)
CREATE TABLE COMMENT_T (
	C_IDX NUMBER(6) CONSTRAINT COMM_T_PK PRIMARY KEY,
	WRITER VARCHAR2(20),
	CONTENT CLOB,
	PWD VARCHAR2(20),
	WRITE_DATE DATE,
	IP VARCHAR2(15),
	B_IDX NUMBER(6), --게시글 번호
	CONSTRAINT COMM_T_FK FOREIGN KEY (B_IDX) REFERENCES BBS_T(B_IDX)
);

--시퀀스 추가
CREATE SEQUENCE BBS_T_SEQ NOCACHE;
CREATE SEQUENCE COMMENT_T_SEQ NOCACHE;

--------------------------------------------
--글 목록 조회를 위한 샘플 데이타 작성
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트1','테스터','테스트1-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트2','테스터','테스트2-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트3','테스터','테스트3-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트4','테스터','테스트4-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트5','테스터','테스트5-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트6','테스터','테스트6-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트7','테스터','테스트7-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트8','테스터','테스트8-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트9','테스터','테스트9-내용','','','1234',sysdate,'127.0.0.1',0);
insert into bbs_t 
values (bbs_t_seq.nextval, '테스트10','테스터','테스트10-내용','','','1234',sysdate,'127.0.0.1',0);
commit;

INSERT INTO COMMENT_T
VALUES (COMMENT_T_SEQ.NEXTVAL, 'C테스터', 'C-내용1',
        '1234', SYSDATE, '127.0.0.1', 10);
INSERT INTO COMMENT_T
VALUES (COMMENT_T_SEQ.NEXTVAL, 'C테스터', 'C-내용2',
        '1234', SYSDATE, '127.0.0.1', 10); 
INSERT INTO COMMENT_T
VALUES (COMMENT_T_SEQ.NEXTVAL, 'C테스터', 'C-내용3',
        '1234', SYSDATE, '127.0.0.1', 10); 
COMMIT;        




