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

# 딕셔너리 구조로 데이타 저장하기
# 딕셔너리 커서 형태로 생성.
cursor = conn.cursor(pymysql.cursors.DictCursor)

# sql 명령 실행
cursor.execute('SELECT * FROM city;')

# 데이터 저장
resultDict = cursor.fetchall()
print(resultDict)
print(type(resultDict))
for row in resultDict:
    print(row, type(row))
print(type(resultDict[0])) #<class 'dict'>


# 키로 출력하기 (키 = 테이블의필드명)
for row in resultDict:
    print(row['Name'] ,'/', row['CountryCode'], '/', row['District'])

# 마지막행의 'Population' 값을 출력하기.
print(resultDict[-1]['Population'])

# 딕셔너리 리스트 전체 레코드수 출력
print(len(resultDict))
# 5, 10, 15, 20 에 해당하는 id, name 값 출력하기
for i in range(1, 21):
    if i % 5 == 0:
        print(resultDict[i-1]['ID'], resultDict[i-1]['Name'])






# DB닫기
conn.close()

