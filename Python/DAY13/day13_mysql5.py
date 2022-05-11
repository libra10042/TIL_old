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
print('연결완료')
print(type(conn))

# cursor 생성
cursor = conn.cursor()


def showBook():
    print('-'* 30)
    print('Book list')
    print('-'*30)
    cursor.execute('SELECT FROM bookTbl')
    bookList = cursor.fetchall()
    for row in bookList:
        print(row)
    print('-'*30)
def insertBook():
    print('-'*30)
    print(' INSERT BOOK DATA')
    print('-'*30)
    title = input("책이름 =>")
    writer = input("저자 및 출판사 =>")
    page = int(input("페이지 수 =>"))
    price = int(input("가격 =>"))

    sql = '''
        INSERT INTO bookTBL
        (title, writer, page, price)
            VALUES(%s, %s, %s, %s)
    '''
    cursor.execute(sql, (title, writer, page, price))
    conn.commit()
    print('1개의 레코드가 추가되었습니다.')
    print('-'*30)

# 데이터유효성 검사
# - 페이지수와 가격은 숫자만 들어갈 수 있게.
# - 정규표현식/ 유효성검사 함수/ 예외처리.
# 삭제와 수정시 책번호가 없는 경우 메세지 출력.
# 1월 19일까지 메일로 전송 : coderecipe@naver.com

#
# def updateBook():
#     # 수정할 책 번호는?
#     # 선택? (1. 책제목    2. 저자    3. 페이지수    4. 가격...)
#     # 1
#     # 변경내용 => 파이썬
#     # 내용이 수정되었습니다.
#     print('수정할 책 번호는?')
#     choice = input('선택? (1. 책제목   2.저자    3.페이지수    4.가격....')
#     if choice '1':
#         cursor(sql, )
#         choice1 = input('변경내용 =>')
#     elif choice '2':
#
#     elif choice '3':
#
#     elif choice '4':
#
#     else :
#
#     sql ='''
#         UDDATE booktbl SET choice =%s
#     '''
#

def deleteBook():
    pass
def end():
    pass
    conn.close()


while True:
    choice = int(input('1.목록보기   2.추가   3.수정   4.삭제   0.종료......'))
    if choice == 1:
        showBook()
    elif choice == 2:
        insertBook()
    elif choice == 3:
        updateBook()
    elif choice == 4:
        deleteBook()
    elif choice == 5:
        end()
        break





