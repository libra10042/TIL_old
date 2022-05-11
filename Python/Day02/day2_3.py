# 튜플
# CRUD : Create Read Update(add)
# 튜플 생성 (초기값 지정)
# 튜플 변수 = (값1, 값2...)
t1 = (100,200,300)
t2 = ('a')
print(f't1 = {t1}')
print(f't2 = {t2}')

print(f't1 = {t1}, type={type(t1)}')
print(f't2 = {t2}, type={type(t2)}')
'''
t1 = (100, 200, 300)
t2 = a
t1 = (100, 200, 300), type=<class 'tuple'>
t2 = a, type=<class 'str'>
'''


# 튜플 생성2 (초기값 지정)
# 튜플변수 = 값1, 값2...
t3 = '가', '나', '다'
print(f't3={t3}, type={type(t3)}')
'''
t3=('가', '나', '다'), type=<class 'tuple'>
'''

# 튜플 생성3 (빈 튜플)
# 튜플변수 = ()
t4 = ()
print(f't4={t4}, type={type(t4)}')
'''
t4=(), type=<class 'tuple'>
'''

print('-'*30)

# 튜플 인덱싱
# 튜플[인덱싱위치번호], 0부터 시작
# 튜플 슬라이싱
# 튜플변수[start:end:step]
t1 = (100,200,300,400,500)
print(f't1 = {t1}')
print(f't1[0] = {t1[0]}')
print(f't1[-1] = {t1[-1]}')
print(f't1[::1] = {t1[0:2]}')
print(f't1[:3] = {t1[:3]}')
print(f't1[::2] = {t1[::2]}')
'''
t1 = (100, 200, 300, 400, 500)
t1[0] = 100
t1[-1] = 500
t1[::1] = (100, 200)
t1[:3] = (100, 200, 300)
t1[::2] = (100, 300, 500)
'''


# # 튜플의 값은 교체가 가능한가?
# t2 = ('a')
# print(f't2 = {t2}')
# t2[0] = '파이썬'
# print(f't2 = {t2}')
# #TypeError, 내용 교체가 불가능하다.


# 하지만, 튜플의 값은 새로 추가 할 수 있다.
# 튜플 변수 += (값1,)   //값이 하나이면 string으로 인식하기 때문에 , 를 해주어야 한다.
# 한개 추가시에는 쉼표(,) 주의
# 튜플 변수 += (값1, 값2...)
print(f't4 = {t4}')
t4+=('도',)
print(f't4 ={t4}')
t4+=('레',)
print(f't4 = {t4}')
t4+=('미','파', '솔')
print(f't4 = {t4}')



# 튜플의 값은 삭제가 가능한가?
# 튜플 요소 각각의 값 삭제는 불가능.
# 튜플변수 전체 삭제는 가능.
# del 튜플변수
# del t4
# # NameError
# print(t4)


# 튜플의 연산자 + : 튜플끼리 더하기
# 튜플의 연산자 * : 튜플 요소 반복.
t5 = ('파이썬', '자바')
t6 = ('c',)
print(f't5+t6 = {(t5+t6)}')
print(f't5*3 = {t5*3}')
'''
t5+t6 = ('파이썬', '자바', 'c')
t5*3 = ('파이썬', '자바', '파이썬', '자바', '파이썬', '자바')
'''


# 각각 튜플 변수 정의하기
# 튜플전체변수 = (변수1, 변수2...) = (값1, 값2...)
colorTuple = (c1, c2) = ('red', 'blue')
print(f'colorTuple = {colorTuple}')
print(f'colorTuple[0] = {colorTuple[0]}')
print(f'c1 = {c1}')
print(f'c2 = {c2}')
'''
colorTuple = ('red', 'blue')
colorTuple[0] = red
c1 = red
c2 = blue
'''


# 튜플 함수
# 튜플변수.count(값)
# 튜플변수.index(값)
# 튜플변수.sort()    가능한가?   AttributeError    튜플을 리스트로 바꾼후  다시 리스트를 튜플로 바꾸어야 한다.
# 튜플변수.reverse() 가능한가?   AttributeError  튜플을 리스트르로 바꾾 ㅜ 다시 리스트를 튜플로 바꾸어야 ㅎ한다.
numberTuple = (100,1,2,50,777,1,1)
print(f'numberTuple = {numberTuple}')
print(f'numberTuple에서 1의 갯수 = {numberTuple.count(1)}')
print(f'100의 위치값= {numberTuple.index(100)}')
'''
numberTuple = (100, 1, 2, 50, 777, 1, 1)
numberTuple에서 1의 갯수 = 3
100의 위치값= 0
'''

# 캐스팅
# 문자열=> 튜플  : tuple(문자열변수나 값)
# 리스트 => 튜플 : tuple(리스트변수나 값)
txt1 = "우리나라 좋은나라"
list1 = [100, 20, 50, 80]
print(f'txt1 = {txt1}, type ={type(txt1)}' )
print(f'txt1 = {list1}, type ={type(list1)}' )
txt1Tuple =tuple(txt1)
print(f'txt1Tuple = {txt1Tuple}, type = {type(txt1Tuple)}')
list1Tuple =tuple(list1)
print(f'list1Tuple = {list1Tuple}, type = {type(list1Tuple)}')
'''
txt1 = 우리나라 좋은나라, type =<class 'str'>
txt1 = [100, 20, 50, 80], type =<class 'list'>
txt1Tuple = ('우', '리', '나', '라', ' ', '좋', '은', '나', '라'), type = <class 'tuple'>
list1Tuple = (100, 20, 50, 80), type = <class 'tuple'>
txt2 =우리나라 좋은나라, type =<class 'str'>
'''

print('-'*40)

# 튜플 => 문자열 : str(튜플변수나 값) or 구분자.join(튜플변수나 값)
                                        #조인 사용시 주의 사항은 튜플의 자료형이 같아야 한다.
myTuple = (100, 'abc', True)            #myTuple은 자료형이 다르다.  join은 다른 자료형에서 사용할 수 없다.
myTuple2 = ('100','abc','True')
print(f'myTuple : {myTuple}, type= {type(myTuple)}')
print(f'myTuple2 : {myTuple2}, type= {type(myTuple2)}')
myTupleTxt1 = str(myTuple)
print(f'myTupleTxt1 = {myTupleTxt1}, type={type(myTupleTxt1)}')
#myTupleTxt2 = '/'.join(myTuple)
myTupleTxt2 = '/'.join(myTuple2)
print(f'myTupleTxt2 = {myTupleTxt2}, type={type(myTupleTxt2)}')
myTupleList = list(myTuple)
print(f'myTupleList = {myTupleList}, type = {type(myTupleList)}')




# 튜플 => 리스트 : list(튜플변수나 값)
# 리스트안에 튜플이 삽입되어 있는 구조
foodT1 = ('고구마', '감자')
foodT2 = ('짬뽕', '짜장면', '라면')
foodList = [foodT1, foodT2]
print(f'foodT1 = {foodT1},{type(foodT1)}')
print(f'foodT2 = {foodT2},{type(foodT2)}')
print(f'foodTList = {foodList},{type(foodList)}')
print(f'foodList[0] = {foodList[0]},{type(foodList[0])}')
print(f'foodList[-1][1] = {foodList[-1][-1]},{type(foodList[-1][-1])}')
'''
foodT1 = ('고구마', '감자'),<class 'tuple'>
foodT2 = ('짬뽕', '짜장면', '라면'),<class 'tuple'>
foodTList = [('고구마', '감자'), ('짬뽕', '짜장면', '라면')],<class 'list'>
foodList[0] = ('고구마', '감자'),<class 'tuple'>
foodList[-1][1] = 라면,<class 'str'>
'''

# 퀴즈
'''
아래와 같이 튜플을 정의한 후 출력한다. 
튜플 리스트 : ('강아지', '토끼', '돼지', '곰')
튜플 요소 추가 후 : ('강아지', '토끼', '돼지', '곰', '호랑이')
튜플의 0-3번째 요소 표시 : ('강아지', '토끼', '돼지', '곰')
'강아지' 요소의 위치값은?
튜플을 문자열로 변환하여 출력 : 강아지, 토끼, 돼지...
튜플을 리스트로 변환하여 출력.
'''

animal = ('강아지', '토끼', '돼지', '곰')
print(f'튜플 리스트 : {animal}')
animal +=('호랑이',)
print(f'튜플 리스트 : {animal}')
print(f'튜플 리스트 : {animal[0:4]}')
print(f'강아지 요소의 위치값은? {animal.index("강아지")}')
myAnimal = str(animal)
print(f'튜플을 문자열로 변환하여 출력 : {myAnimal}, {type(myAnimal)}')
myAnimal2 = [myAnimal]
print(f'튜플을 문자열로 변환하여 출력 : {myAnimal2}, {type(myAnimal2)}')
