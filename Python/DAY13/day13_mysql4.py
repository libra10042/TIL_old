# MySQL 설치 후 아래 파일로 DB 연결되는지 테스트
import pymysql

# DB 연결
# password = '루트계정비번'
# world는 MySQL 설치시 샘플 DB이므로 자동 설치됨.
conn = pymysql.connect(host='localhost',
        port=3306, user='root',
        password='1234',
        db = 'sqldb2',
        charset='utf8')
conn.character_set('utf8')
print('연결완료')
print(type(conn))

# cursor 생성
cursor = conn.cursor()

# 레코드 삽입1 - 필드명 생략
# 필드가 auto_increment 라면 null로 지정.
# INSERT INTO 테이블명 VALUES(값1, 값2...);
cursor.execute('''INSERT INTO bookTbl
                VALUES (NULL, '자바의 정석', '한빛', 500, 15000);
                ''')




conn.commit()

# 레코드 삽입2 - %s
# sql 명령은 별도로 지정.
sql = ''' INSERT INTO bookTbl (title, writer, page, price)
        VALUES (%s, %s, %s, %s ); '''
cursor.execute(sql, ('c언어', '영진', 700, 20000));
conn.commit()


# 레코드 삽입 3 - 다중 레코드 삽입
# 데이타 변수 = 튜플안의 튜플
# sql 명령어 변수
# cursor.executemany(sql명령어변수, 데이터변수)
data = ( ('파이썬', '영진2', 500, 23000),
         ('My SQL', '정보문화사', 300, 18000),
         ('판다스', '영진', 300, 22000))

sql = '''
    INSERT INTO bookTbl (title, writer, page, price)
        VALUES(%s, %s, %s, %s);'''

cursor.executemany(sql, data)
conn.commit()



# 삽입레코드 확인
cursor.execute('SELECT *FROM bookTbl;')
result = cursor.fetchall();
# print(result)
for i in result:
    print(i)


# ------------------------------------------------------
# 레코드 수정 : % 방식
# sql변수 =update 명령
# cursor.execute (sql변수, (값1, 값2..))

# 1번의 가격을 변경.  36000 => 20000
sql = '''UPDATE bookTbl
            SET price = %s
            WHERE id = %s        
    '''

cursor.execute(sql , (20000, 1))
conn.commit()




# -----------------------------------------------------
# 레코드 삭제 : % 방식
# sql변수 = delete 명령
# cursor.execute (sql변수, (값1..))
#   5번 레코드 삭제
sql = '''
        DELETE FROM bookTbl WHERE id=%s;
        '''

cursor.excute(sql, (1,))
conn.commit()







# DB닫기
conn.close()

