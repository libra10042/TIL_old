# 집합
# {값1, 값2, 값3....}
# CRUD :
# Create
# Read(전체조회만 가능)
# Update, Delete
# 집합의 생성.
# 집합변수 = set(리스트/문자열/튜플)
# 순서가 없다. 랜덤하게 출력된다.
# 인덱싱이 불가능하다. 따라서 슬라이싱도 불가능하다.
set1 = set('abcd')   #문자열
set2 = set([100, 200, 400, 500])  #리스트
set3 = set(('장미', '백합', '개나리')) #튜플
# print(f' set1 = {set1}, {type(set1)}')
# print(f' set2 = {set2},{type(set2)}')
# print(f' set3 = {set3}, {type(set3)}')
print('set1 ={},{}' .format(set1, type(set1)))
print('set2 ={},{}' .format(set2, type(set2)))
print('set3 ={},{}' .format(set3, type(set3)))
'''
set1 ={'a', 'b', 'c', 'd'},<class 'set'>    .... set은 컴퓨터가 랜덤하게 찍어낸다.
set2 ={200, 500, 100, 400},<class 'set'>         ...딕셔너리, 튜플, 리스튼는 순차적으로 뽑지만,
set3 ={'백합', '장미', '개나리'},<class 'set'>
'''

# 중복값을 허용할까요?  --> 1개만 표시
set4 = set([100, 200, 100, 50, 100])
print('set4 ={},{}'.format(set4, type(set4)))
# set4 ={200, 50, 100},<class 'set'>
# TypeError : 인덱싱 불가능. 인덱싱이 안되면 슬라이싱도 안된다.
# print(set4[0]) ... 불가능.


# 집합의 요소 추가
# 집합변수.add(값)
# 집합변수.update([값1, 값2...])
print('set1 ={}'.format(set1))
set1.add('abc')
print('set1 ={}'.format(set1))
set1.update(['python', 'mySQL'])
print('set1 ={}'.format(set1))
'''
set1 ={'c', 'a', 'd', 'b'}
set1 ={'c', 'b', 'abc', 'a', 'd'}
set1 ={'mySQL', 'c', 'python', 'b', 'abc', 'a', 'd'}
'''
print('-'*50)

# 집합의 요소 삭제
# 집합변수.remove(값)
print('\n\n set1 ={}'.format(set1))
set1.remove('python')
set1.remove('a')
print('\n\n set1 ={}'.format(set1))

#del 집합변수 => 메모리에서 삭제.
del set1
#print('set1 ={}'.format(set1))   #메모리에서 삭제 되었기 때문에 name에러 발생.




# 집합의 연산
# +, *
userSet1 = set({'박', '이', '신', '최'})
userSet2 = set(['박', '김', '선우', '최'])
print('userSet1 = {}'.format(userSet1))
print('userSet2 = {}'.format(userSet2))
# + : 불가능
# print('userSet1 + userSet2 : '.format((userSet1 + userSet2)))
# 집합 합치기 = 합집합
# 집합변수3 = 집합변수1|집합변수2
# 집합변수3 = 집합변수1.union(집합변수2)               ...set은 중복값을 허용하지 않는다.
userSet3 = userSet1|userSet2
userSet4 = userSet1.union(userSet2)
print('userSet3 = {}'.format(userSet3))
print('userSet4 = {}'.format(userSet4))
'''
userSet3 = {'최', '박', '이', '선우', '김', '신'}
userSet4 = {'최', '박', '이', '선우', '김', '신'}
'''


# 서로 다른 집합에서 중복되는 값만 표시 = 교집합
# 집합변수3 = 집합변수1&집합변수
# 집합변수3 = 집합변수1.intersection(집합변수2)
userSet5 = userSet1&userSet2
userSet6 = userSet1.intersection(userSet2)
print('userSet5 = {}'.format(userSet5))
print('userSet6 = {}'.format(userSet6))
'''
userSet5 = {'박', '최'}
userSet6 = {'박', '최'}
'''


# 차집합
# 집합변수3 = 집합변수1-집합변수2
# 집합변수3 = 집합변수1.difference(집합변수2)
userSet7 = userSet1-userSet2
userSet8 = userSet1.difference(userSet2)
print('userSet7 ={}'.format(userSet7))
print('userSet8 ={}'.format(userSet8))
'''
userSet7 ={'이', '신'}
userSet8 ={'이', '신'}
'''
# TypeError : * 불가능.
# print(userSet1*3)


# 캐스팅
# 집합 => 리스트
# list(집합변수)
print('userSet4 ={}'.format(userSet4))
user4List =list(userSet4)
print('user4List ={}'.format(user4List))
'''
userSet4 ={'이', '김', '박', '선우', '최', '신'}
user4List =['이', '김', '박', '선우', '최', '신']
'''

# 리스트, 문자열, 튜플 => 집합
# set(리스트, 문자열, 튜플)

# 집합 => 튜플
print('userSet4 = {}'.format(userSet4))
user4Tuple = tuple(userSet4)
print('user4Tuple ={}'.format(user4Tuple))
'''
user4Tuple =('이', '박', '선우', '최', '김', '신')
'''


# 퀴즈
# 다음 캐스팅이 되는지 확인해 보세요.
# 집합 => 문자열
# 집합 => 딕셔너리(키는 숫자로 생성)

# day2/Quiz2.py
# 교재 p112 ~ 115

