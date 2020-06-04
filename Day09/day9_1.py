# 관련 모듈 임포트
import sqlite3
# DB 연결변수 : 없는 경우에는 새로 생성
conn = sqlite3.connect('c:/pyclass/MySQL/data/book1.db')
# 작업변수(cursor 생성)
cursor = conn.cursor()
# sql 명령 실행
# 작업변수.execute( SQL 명령)
# 테이블 생성
cursor.execute('''
        CREATE TABLE IF NOT EXISTS book1 (
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

# cursor.execute(''' INSERT INTO book1 (title,writer, page, price )
#                 VALUES ("파이썬", "한빛", 400, 23000);
#             ''')


# 레코드 삽입2
# sql명령변수 = 'INSERT INTO 테이블명 (컬럼명1, 컬럼명2..)
# #                   VALUES (?, ? ...);'
# cursor.execute(sql명령변수, (값1, 값2....))

# sql = '''INSERT INTO book1 (title,writer, page, price )
#                 VALUES (?, ?, ?, ?); '''
#
# cursor.execute(sql, ('자바', '영진', 350, 40000))

# 레코드 삽입3 - 값리스트, executemany() 실행

# sql명령변수 = 'INSERT INTO 테이블명 (컬럼명1, 컬럼명2..)
# #                   VALUES (?, ? ...);'
# 리스트안의 튜플 구조
# 값리스트 = [(값1, 값2...), (값1, 값2...)....]

# cursor.executemany(sql명령변수, 리스트변수)

# sql = '''INSERT INTO book1 (title, writer, page, price )
#                 VALUES (?, ?, ?, ?); '''
#
# booklist = [('포토샵', '한빛', 500, 20000),
#             ('mySQL', '위키북스', 600, 45000)]
#
# cursor.executemany(sql, booklist)

# -------- 레코드 출력
# sql명령실행 => 리스트의튜플로저장 => print문으로 출력
# cursor.execute(''' SELECT * FROM book1;   ''')
#
# # 결과리스트로 저장
# # 리스트변수 = cursor.fetchone() : 한개의 레코드
# # 리스트변수 = cursor.fetchmany(레코드수) : 레코드수만큼
# # 리스트변수 = cursor.fetchall() : 모든 레코드
# resultList = cursor.fetchall()
#
#
# # 전체 레코드 갯수
# print(f' 전체 레코드 갯수 : {len(resultList)}')
# print('-'*30)
# for row in resultList:
#     print(row)

# -------- 레코드 출력 함수
def printTable():
    cursor.execute(''' SELECT * FROM book1;   ''')
    resultList = cursor.fetchall()
    print(f' 전체 레코드 갯수 : {len(resultList)}')
    print('-'*30)
    for row in resultList:
        print(row)
    print('-'*30)

printTable()

# -------- 레코드 삭제 1
# 레코드 삭제 sql 명령 실행
# cursor.execute(''' DELETE FROM 테이블명
#                     WHERE 절 ''')
# conn.commit()

# id 값이 5인 레코드 삭제하기
# cursor.execute(''' DELETE FROM book1  WHERE id=1; ''')
# # 실제 데이타베이스에 반영
# conn.commit()
#
# printTable()

# -------- 레코드 삭제 2
# 레코드 삭제 sql 명령 => 변수
# sql명령변수 = ''' DELETE FROM 테이블명
#                     WHERE 절 '''
# where 절의 값은 리스트로 받는다.
# cursor.execute(sql명령변수, [값])
# conn.commit()

# id 값이 2인 레코드 삭제하기
# sql = "DELETE FROM book1  WHERE id=?;"
# cursor.execute(sql, [2])
# conn.commit()

printTable()

# -------- 레코드 수정1
# 레코드 수정 sql 명령 실행
# cursor.execute(''' UPDATE 테이블명 SET 컬럼명=값
#                     WHERE 절 ''' ;)
# conn.commit()

# id 3인 레코드에서 가격(price) 수정 => 20000
cursor.execute(''' UPDATE book1 SET price=20000
                    WHERE id = 3; ''')
conn.commit()
printTable()

# -------- 레코드 수정2
# sql명령변수 = ''' UPDATE 테이블명 SET 컬럼명=?
# #                     WHERE 절  조건=? '''
# ? 데이값은 튜플구조로 한다.
# cursor.execute(sql명령변수, (값1, 값2))
# conn.commit()

# id가 4번인 레코드에서 책제목(title) 컬럼값 수정하기

sql = '''UPDATE book1 SET title=? 
            WHERE id=?;'''

cursor.execute(sql, ('일러스트레이터', 4))
printTable()

'''
퀴즈 : day9_product.py
1) 데이타베이스 생성 - productDB
2) 테이블 생성 - productTB
   모든 필드는 NOT NULL
   제품코드(pCode) - TEXT, Primary Key
   제품명(pName) - TEXT,
   가격(pPrice) - INTEGER
   재고수량(pAmount) - INTEGER
3) 레코드 삽입 5개 정도 
4) 레코드 출력함수 정의 
5) 레코드의 데이타 수정 
  예) p001 레코드의 가격을 220으로 수정해라 
6) 레코드 삭제 
  예) 첫번째 레코드 삭제  
'''



# DB 종료
conn.close()