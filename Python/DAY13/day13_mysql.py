# MySQL 설치 후 아래 파일로 DB 연결되는지 테스트
import pymysql

# DB 연결
# password = '루트계정비번'
# world는 MySQL 설치시 샘플 DB이므로 자동 설치됨.
conn = pymysql.connect(host='localhost',
        port=3306, user='root',
        password='1234',
        db='world',
        charset='utf8')

print('연결완료')
print(type(conn))
# <class 'pymysql.connections.Connection'>


# cursor 생성.
cursor = conn.cursor()
print(type(cursor))
# <class 'pymysql.cursors.Cursor'>

# sql 명령 실행
# cursor.excute(SQL)
# world.city 테이블 출력
cursor.execute('SELECT * FROM city;')
# 파이썬 자료구조로 저장
# 리스트명 = cursor.fetchall()
# 리스트명 = cursor.fetchmany(갯수)
# 리스트명 = cursor.fetchone()
cityList = cursor.fetchall()
print(cityList, '\n', type(cityList)); # 튜플 안의 튜플
cityList = list(cityList);
print(type(cityList));
print(cityList); # 리스트 안의 튜플

# world.country 첫번째 레코드만 출력
cursor.execute('SELECT * FROM country;')
result = cursor.fetchone()
print(result) # tuple
print(list(result)) # list
print(list(result)[0])
print('-'*50)
# 특정 갯수만큼 레코드 출력
cursor.execute('SELECT * FROM country;')
resultList2 = cursor.fetchmany(5)
for row in resultList2:
    print(row)

# 퀴즈
# 1. world.city 테이블의 CountryCode값이 JPN인 레코드 정보 출력하기.
# 2. world.country에서 gnp가 가장 높은 10개 레코드 출력하기
# 3. world.city 테이블에서 district(국가명)이 H로 시작하는 레코드 수 출력하기.
print('-'*30)
cursor.execute('SELECT * FROM city WHERE countryCode = "JPN";')
result2 = cursor.fetchall()
print(result2)
print('-'*30)
cursor.execute('SELECT * FROM country order by gnp limit 10;')
result3 = cursor.fetchmany(1)
print(result3)
print('-'*30)
cursor.execute('select count(*) from city where district like "H%";')
result4 = cursor.fetchone()
print(result4) # turple

# DB닫기
conn.close()

