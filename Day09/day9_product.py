'''
퀴즈 : day9_product.py
1) 데이타베이스 생성 = productDB
2) 테이블 생성 - productTB
   모든 필드는 NOT FULL
   제품코드(pCode) - TEXT, Primary key
   제품명(pName) - TEXT,
   가격(pPrice) - INTEGER
   제고수량
3) 레코드 삽입 5개 정도
4) 레코드 출력함수 정의
5) 레코드의 데이타 수정.
   예) p001 레코드의 가격을 220으로 수정해라.
6) 레코드 삭제
   예) 첫번째 레코드 삭제
'''

import sqlite3

conn = sqlite3.connect('c:/pyclass/MySQL/data/productDB.db')

cursor = conn.cursor()
cursor.execute('''
        CREATE TABLE IF NOT EXISTS productDB (
	        id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	        title TEXT NOT NULL,
	        writer	TEXT NOT NULL,
	        page INTEGER NOT NULL,
	        price	INTEGER NOT NULL
                );
        ''')

conn.commit()
def insert_row():
    title = input("책 제목 : ")
    writer = input("출판사 : ")
    page = input("페이지 수 : ")
    price = input("가격 : ")

    sql = '''INSERT INTO productDB (title, writer, page, price) values(?, ?, ?, ?);'''
    cursor.execute(sql, (title, writer, page, price))
    conn.commit()
    print('레코드가 정상적으로 삽입되었습니다.')

def print_row():
    cursor.execute("SELECT * FROM productDB")
    data_list = cursor.fetchall()
    if len(data_list) == 0:
        print('레코드가 없습니다.')
    else:
        for row in data_list:
            print(row)

def delete_row():
    # 레코드 모두 출력하기
    # 입력문으로 삭제할 레코드 번호 받기
    # sql 명령 실행하기
    # 레코드 정상 삭제 메세지
    cursor.execute("SELECT * FROM productDB")
    data_list = cursor.fetchall()
    for row in data_list:
        print(row)

    sql = ("DELETE FROM productDB WHERE id = ?;")
    choice = (int)(input('삭제할 id 선택...'))
    if cursor.execute(sql, [choice]):
        print(f'{choice}번 레코드가 정상적으로 삭제되었습니다.')
    else:
        print('Error!')
    conn.commit()

def update_row():

    # 레코드 모두 출력하기
    # 입력문으로 수정할 레코드 번호 받기
    # 선택한 레코드 번호에 대한 데이타 출력
    # 입력문으로 수정할 필드 번호 받기
    # sql 명령 실행하기
    # 레코드 수정 메세지
    cursor.execute("SELECT * FROM productDB")
    data_list = cursor.fetchall()
    for row in data_list:
        print(row)

    ans = (int)(input('수정하고 싶은 레코드 입력 ...'))
    sql = '''UPDATE productDB SET title =? 
            WHERE id=?'''
    sql2 = '''UPDATE productDB SET writer =?
            WHERE id=?'''
    sql3 = '''UPDATE productDB SET page =?
            WHERE id=?'''
    sql4 = '''UPDATE productDB SET price =?
            WHERE id=?'''

    choice = (int)(input('수정하고 싶은 내용(1.제목   2.저자   3.페이지   4.가격).....'))
    if choice == 1:
        ans2 = input('제목수정:')
        cursor.execute(sql, (ans2, ans))
    elif choice == 2:
        ans2 = input('저자수정:')
        cursor.execute(sql2, (ans2, ans))
    elif choice ==3:
        ans2 = (int)(input('페이지수정:'))
        cursor.execute(sql3, (ans2, ans))
    elif choice ==4:
        ans2 = (int)(input('가격수정:'))
        cursor.execute(sql4, (ans2, ans))
    else:
        print('Error 1~4사이의 숫자를 입력해주세요.')
    conn.commit()
# 메뉴 선택.
while True:
    choice = input('[[-----메뉴 선택-----]] \n (1.모두보기   2.삽입   3.삭제   4.수정   5.종료)........')
    if choice == '1':
        print_row()
    elif choice == '2':
        insert_row()
    elif choice == '3':
        delete_row()
    elif choice == '4':
        update_row()
    elif choice == '5':
        print('프로그램 종료')
        break
    else :
        print('1~5 사이의 숫자만 입력 가능합니다.')