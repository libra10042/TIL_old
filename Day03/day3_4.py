# 다중 while 문
# while 조건1:
#   while 조건2:
#       명령문2
#   명령문1


# 점선 출력 후 문단 3번찍기 반복하기
# num1 = 0
# while num1 <5:
#     print('-'*30)
#     num2 =0
#
#     while num2<3:
#         print('hello python')
#         num2+=1
#
#     num1 +=1

# 2~9단 출력
# x = 2
# while x<10:
#     y = 1
#     while y<10:
#         print('%d x %d = %d' %(x,y,(x*y)))
#         y +=1
#     x += 1
#





# while문을 이용한
# 리스트, 딕셔너리, 문단, 집합, 튜플 아이템 출력
# while문 이용해서 리스트 요소 출력하기
# 인덱싱위치 번째 요소는 인덱싱위치의값.
i = 0
list1 = ['사과', '바나나', '수박', '포도']
while i < len(list1):
    print(i, '번째 요소는', list1[i])
    i += 1
print('*'*30)



# 짝수번째 글자만 출력하기

j = 0
txt1 = '가나다라마바사'
while j < len(txt1):
    print(j, '번째 요소는', txt1[j])
    j += 2



# 딕셔너리 구조에서 키와 값을 분리시켜서 출력하기
# a => africa
# s => say
# c => coffee
# d => drama
# y => yes
dict1 = {'a': 'africa', 's': 'say', 'c' : 'coffee', 'd':'drama', 'y':'yes'}
print(f'전체길이 : {len(dict1)}')
print(dict1['a'])   #africa
keyList = list(dict1)
print(keyList)
k = 0
while k<len(keyList):
    print(f'{keyList[k]} ==> {dict1[keyList[k]]}')
    k += 1




# 리스트에서 가장 큰 값을 구한후 삭제하여라
myNumList = [100, 200, 50, -30, 999, 19, 999]
# 중복값 제거하여 리스트 생성하기

print('myNumList', myNumList)
cnt = 0
# 최대값 저장 변수
target = myNumList[0]
while cnt<len(myNumList):
    if target<myNumList[cnt]:
        target = myNumList[cnt]
    cnt += 1
print(f'최대값은? {target}')


# 리스트에서 요소 삭제
# 리스트변수.pop() : 마지막 삭제
# 리스트변수.pop(인덱싱값) : 인덱싱값에 해당하는 아이템 삭제
# 리스트변수.remove(값) : 값 해당하는 아이템 삭제
myNumList.remove(target)
print(f'myNumList : {myNumList}')  #999가 지워진 결과 값이 나온다.

print('-'*40)

# 값이 중복되었을 경우. 첫번쨰만 remove된다. 중복값이 있으면 set을 쓰면 된다.
# set 사용법.
print(f'myNumlist : {set(myNumList)}')

print('\n\n퀴즈풀이')
# 가장 큰 수와 가장 작은 수를 삭제하여라
myNumList2 = [100, 200, 50, -30, 999, 10, -30]
myNumList2 = []

cnt = 0
while cnt<len(myNumList):
    target = myNumList[cnt]
    if target > myNumList[cnt]:
        target = myNumList[cnt]
    cnt += 1
print(f'최소값은? {target}')

print(f'배열의 중복제거 :  {set(myNumList)}')
myNumList.remove(target)

# 퀴즈 2
# 딕셔너리 값에 'a' 글자가 있는 아이템만 표시하고 총 갯수 출력하기
dict2 = {'a': 'africa', 's': 'say',
        'c': 'coffee', 'd': 'drama', 'y':'yes'}
'''
'a': 'africa'
's': 'say'
'd': 'drama'
총 갯수는? 3
'''

# 딕셔너리 값에 'a' 글자가 있는 아이템만 표시하고 총 갯수 출력하기
count = 0
tot = 0
while count<len(list(dict2)):
    if 'a' in dict2[list(dict2)[count]]:
        print(f'{list(dict2)[count]} => {dict2[list(dict2)[count]]}')
        # print(f'{list(dict2)[count]} =>
              # {dict2[list(dict2)[count]]}')

        tot += 1
    count += 1
print('총 갯수는? ', tot)

print('-'*10,'\n\n')



# 퀴즈3 : # 다음 문자열을 사선으로 한 글자씩 출력하여라.
message = 'Hello'
'''
H
  e
    l
'''
i = 0
while i<len(message):
    print(i*'\t', message[i])
    i += 1

j = len(message)-1
while j >= 0:
    print(j*'\t', message[j])
    j -= 1