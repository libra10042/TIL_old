# 자료선언
# 변수 < 콜렉션 (리스트, 튜플, 집합, 딕셔너리) <
# 함수 < 클래스 < 모듈(파일단위) < 패키지(폴더 단위)

# 모듈(Module)이란?
# 함수, 클래스의 집합 => 별도의 파일(*.py)로 생성
# 모듈의 종류
# - 내부모듈 : 파이썬에서 기본적으로 제공
# - 외부 모듈 : pip/pip3(파이썬), conda(아나콘다)를 이용해서 별도 설치
# - 사용자정의 모듈 : 필요에 의해서 직접 모듈로 등록한 후 사용

# 모듈의 호출방법 1
# import 모듈이름
# 모듈이름.함수(인자)

# 모듈의 호출방법 2
# import 모듈이름 as 별칭
# 호출된 모듈의 함수 호출방법2
# 별칭.함수(인자)

# 모듈의 호출방법 3
# from 모듈이름 import 모듈함수
# 호출된 모듈의 함수 호출방법3
# 모듈함수(인자)

# ---->
# 모듈 이용방법 1
# math 모듈
# : 내부모듈, 수학함수 sin(), cos(), tan(), pi ...
# import math
# print('sin(10) => ', math.sin(10))
# print('pi => ', math.pi
# print(dir(math))



# 모듈 이용방법 2 : 별칭(Alias) 방식
import math as m
print('sin(10) => ', m.sin(10))
print('pi => ', m.pi)




# 모듈 이용방법 3 : from 방식
# 주의사항 : 함수이름만 import 뒤에 쉼표(,)를 이용하여 나열
from math import sin, pi, tan
print('sin(10) => ', sin(10))
print('pi =>' , pi)
print('#'*30)

# -------------->
# 난수(random) 발생 모듈 => 내부 모듈
# 모듈 임포트
# import random
# 관련 함수
# random.random() : 0~1 사이의 소수점 방식으로 난수 발생
# random.randrange(star,end,step)
# : 범위를 지정해서 정수 난수 발생
# : 짝수와 홀수로 조건 제한 가능
# random.randint(star,end) : 0~숫자까지 정수난수 발생
# random.choice(리스트) : 리스트요소를 무작위로 추출
# random.shuffle(리스트) : 리스트안의 아이템을 무작위로 섞는다.
import random

print(random.random())  #0.7968228198322396
print(random.randrange(1,30))  #2
print(random.randint(50, 100))  #93

print(random.choice(['꽝', '꽝', '이마트 10만원', '스타벅스 20만원'])) #하나만 리턴한다.

myList =[30, 60, 89, 78, 56]
print(random.shuffle([30, 60, 89, 78, 56])) #None
random.shuffle(myList)
print(myList[1])
# 퀴즈 : 로또번호 생성하기
# 조건 :
# 1~45 의 숫자중에서 6개로 구성
# 숫자는 중복되면 안된다.
# 로또리스트는 빈 리스트 생성
# 반복문에서
#   : 번호의 갯수가 6개라면 반복문 탈출
#   : 1~45까지 번호중에서 1개 생성
#   : 리스트안에 이미 번호가 있다면 다시 번호 생성
#   : 중복번호가 아니라면 리스트에 추가
# 로또 리스트를 출력한다.

lottoList = []
random.randrange(1, 45)

while True:
    cnt = 0
    # 탈출 조건 : 번호 6개인지 확인
    if len(lottoList) >=6:
        break
    else :
        # 로또번호 생성.
        data = random.randint(1,45)
        # 로또번호가 리스트에 있는지 없는지 확인
        if data not in lottoList:
            lottoList.append(data)
print('금주의 로또번호 : ', lottoList)


print('▼함수로 변경')
def lotto_make(n):
    while True:
        cnt = 0
        # 탈출 조건 : 번호 6개인지 확인
        if len(lottoList) >= n:
            break
        else:
            # 로또번호 생성.
            data = random.randint(1, 45)
            # 로또번호가 리스트에 있는지 없는지 확인
            if data not in lottoList:
                lottoList.append(data)
    print('금주의 로또번호 : ', lottoList)
lotto_make(8) # 8자리 로또 생성. 
lotto_make(5) # 5가지 로또 생성




# ----------------------
# calendar 모듈 => 특정 년도의 월 출력, 내부 모듈
# import calendar as c
# 특정 년도의 전체 달력 출력
# calendar(년도)
# prcal(년도,월)  prcal(년도)

import calendar as c
print(c.calendar(2020))
print(c.prcal(2020, 12))
print(type(c.calendar(2020)))  #<class 'str'>


# 특정 년도의 특정 월 출력
# prmonth(년도, 월)
# print() 구문안에 삽입시 마지막에 None 출력
# print(c.prmonth(2020,1))
print(c.prmonth(2020,1))  #None  ...print가 기본적으로 내장 되어 있기 때문에  print를 또쓰면 none이 나온다.
c.prmonth(2020,1)



# 요일을 인덱스로 출력
# weekday(년도,월,일) => 0~6 숫자로 표기
# 0은 월요일
print('2020년 1월 1일은 무슨요일?', c.weekday(2020,1,1))

dayList = ['월','화','수','목','금','토','일']
print(dayList[c.weekday(2020, 1, 3)],'요일')

# 퀴즈
# 다음과 같이 출력
# 2020년 크리스마스는 무슨요일일까요?
# 목요일 입니다.
























