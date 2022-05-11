# 관련 모듈 임포트
import sqlite3
# DB 연결변수
# 연결변수 = sqlite3.connect(데이타베이스경로)
# DB 파일이 없는 경우에는 새로 생성
conn = sqlite3.connect('c:/pyclass/mySQL/data/book.db')
# 작업변수(cursor 생성)
# 작업변수 = 연결변수.cursor()
cursor = conn.cursor()
# sql 명령 실행
# 작업변수.execute( SQL 명령)

# 테이블 명 : book1
# id int => 기본키, 필수항목(NOT NULL), AUTOINCREMENT;
# # title text => 필수항목(NOT NULL)
# # writer text => 필수항목(NOT NULL)
# # page int => 필수항목(NOT NULL)
# # price int => 필수항목(NOT NULL)
cursor.execute('''
        CREATE TABLE IF NOT EXISTS book5 (
	        id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	        title TEXT NOT NULL,
	        writer	TEXT NOT NULL,
	        page INTEGER NOT NULL,
	        price	INTEGER NOT NULL
                );
        ''')

# 레코드 삽입 1
# cursor.execute(''' INSERT INTO 테이블명 (컬럼명1, 컬럼명2..)
#                   VALUES (값1, 값2 ...);
#   ''')

cursor.execute(''' INSERT INTO book5 (title,writer, page, price )
                VALUES ("파이썬", "한빛", 400, 23000);
            ''')


# 실제 데이타베이스에 반영
conn.commit()

# DB 종료
conn.close()