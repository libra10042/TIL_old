# MySQL 설치 후 아래 파일로 DB 연결되는지 테스트
import pymysql

# DB 연결
# password = '루트계정비번'
# world는 MySQL 설치시 샘플 DB이므로 자동 설치됨.
conn = pymysql.connect(host='localhost',
        port=3306, user='root',
        password='1234',
        charset='utf8')
print('연결완료')
print(type(conn))

# cursor 생성
cursor = conn.cursor()

# 데이터베이스 만들기.
cursor.execute('CREATE DATABASE IF NOT EXISTS sqldb2')

# 데이터베이스 접속하기
cursor.execute('USE sqldb2')

# 테이블 만들기.
# bookTbl
# id primary key auto_increment
# title next
# writer text
# page integer
# price
cursor.execute('''
                CREATE TABLE IF NOT EXISTS bookTbl
                (id integer not null primary key auto_increment,
                 title text not null,
                 writer text not null,
                 page integer not null,
                 price integer not null
                 );

                     ''')


cursor.execute('DESC bookTbl');

# DB닫기
conn.close()

