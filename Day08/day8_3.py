# 관련 모듈 임포트
import sqlite3
# DB 연결변수
# 연결변수 = sqlite3.connect(데이타베이스경로)
conn = sqlite3.connect('c:/pyclass/data/test.db')
# 작업변수(cursor 생성)
# 작업변수 = 연결변수.cursor()
cursor = conn.cursor()
# sql 명령 실행
# 작업변수.execute( SQL 명령)
cursor.execute('SELECT * FROM customers;')
# 결과리스트로 저장
# 작업변수.fetchone() : 한개의 레코드
# 작업변수.fetchmany(레코드수) : 레코드수만큼
# 작업변수.fetchall() : 모든 레코드

# customers 테이블의 모든 레코드 => 리스트안의 튜플로 저장

resultList = cursor.fetchall()
print(type(resultList)) # <class 'list'>
print(resultList)
for row in resultList:
    print(row)
print(type(resultList[0]))
# <class 'tuple'>
print('-'*30)

# albums 테이블에서 5개의 레코드만 저장하기
cursor.execute('SELECT * FROM albums LIMIT 5;')
resultList2 = cursor.fetchall()
for row in resultList2:
    print(row)
print(len(resultList2))
print('-'*30)
# playlists 테이블에서 1개의 레코드만 저장하기
cursor.execute('SELECT * FROM playlists;')
resultList3 = cursor.fetchone()
print(resultList3)
print(len(resultList3), type(resultList3))
# (1, 'Music')
print('-'*30)
# customers 테이블에서 firstname, lastname, city, country
#  레코드 5개 저장하기
cursor.execute('SELECT firstname, lastname, city, country FROM customers;')
resultList4 = cursor.fetchmany(5)
print(resultList4)
print(len(resultList4), type(resultList4))
print('-'*30)

# playlists 테이블에서 Name 필드값이 Music 인 레코드 저장하기
cursor.execute('SELECT * FROM playlists WHERE name="Music";')
resultList5 = cursor.fetchall()
print(resultList5)
print(len(resultList5))

print('-'*30)
# employees 테이블에서 title이 IT Staff 가 아닌 레코드 저장하기
cursor.execute('SELECT * FROM employees WHERE NOT title="IT Staff";')
resultList6 = cursor.fetchall()
print(resultList6)
for row in resultList6:
    print(row)
print(len(resultList6))
print('-'*30)








# DB 종료
conn.close()