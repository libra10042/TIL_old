# break
# 제어문 안에서 사용
# 명령문 실행시 제어문에서 탈출한다.
# 명령문이 실행되면 하단 명령문들은 실행되지 않는다.
# 무한루프의 종료 조건시 사용

# continue
# 제어문 안에서 사용
# 명령문이 사용되면 하단 명령문들은 실행되지 않는다.

count = 0
while count<2:
    print('hello Python1')
    count += 1
    break
    print('hello Python2')

print('-'*40)

count = 0
while count < 2:
    print('hello Python1')
    count += 1
    continue
    print('hello Python2')




# while True조건 : 
#   if 블록을 빠져나갈 조건:
#       break
# while True:
#     ans = input('아무값이나 입력. 종료시 x....?').strip()     # strip 좌우 여백을 삭제하는 함수.
#     # while 블록을 탈출하는 조건.
#     if ans  == 'x':
#         break
# print('입력 종료')



# 입력받은 값을 리스트에 추가한다.
# q 입력시 입력문 종료후 리스트 출력
# 리스트에 아이템 추가
# 리스트변수.append(값)
# 리스트변수.insert(인덱스,값)
# 빈 리스트 생성.
# resultList = []
# while True:
#     item = input('리스트에 추가할 요소를 입력하세요... (q:종료)').strip()
#
#     if item == 'q':
#         break
#     resultList.append(item)
#
# print('무한루프 종료')
# print('리스트 출력', resultList)




# 1~10까지 숫자중에서 5만 빼고 출력하여라
j = 0
while j<11:
    j += 1
    if j == 5:
        continue
    print(j)







