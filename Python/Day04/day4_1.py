
#
# 함수의 종류 출력문
# # 문자열
# # 집합자료형(리스트, 딕셔너리, 튜플, 집합)
# # 제어문(반복문, 조건문)
# '''-----------------------------'''
#
#
# # 함수(function)
#
# # 함수란?
# # 명령문의 조합
# # 함수 < 클래스 < 모듈 < 패키지
# - 내장 함수
# : import 명령없이 사용할 수 있는 함수
#   len(리스트, 문자열...)
#   type(변수, 값, 리스트, 클래스...)
# : import 명령을 실행해야만 사용할 수 있는 함수 .

# - 사용자 정의 함수
#   def  명령으로 정의하는 함수


# 함수의 종류
# # 결과값은 return 문으로 전달.
# # 인자 x, 결과값 x => 단순함수
# # 인자0, 결과값 x
# # 인자0, 결과값 0


# 인자의 종류
# 단순인자
# 초기값 지정 인자
# 가변인자
# 딕셔너리 가변인자.

# 사용자정의함수 정의
# 함수정의
'''
def 함수이름(인자1, 인자2...):
   명령문
   return 문
'''

# 호출시
# 함수명(값1, 값2...)


# 함수 정의 1
# 인자도 없고 return문도 없음.


# 함수 호출시 특정 메세지 3번 출력.
# 함수 정의
def helloWorld():
    print('Hello world\t'*3)


# 함수 호출
helloWorld()
helloWorld()




# 함수 정의 2
# 인자가 있다. return이 없다.
'''
def 함수명(인자1, 인자2...):
    인자가 있는 명령문
'''
# 호출
# 함수명(값1, 값2...)

# 메세지를 인자로 념거서 3번 출력하는 함수 정의
def messagePrint(e):
    print(e*3)

# 값 전달 함수 호출.
messagePrint('Hello Python')
# TypeError 발생 : 정의된 인자의 갯수가 달라서 에러 발생.
# messagePrint('Hello MySQL', 'Hello Python')


# 두수의 합을 구하는 함수 정의
def addNum(x, y):
    print(f'두수의 합은 : {x+y}')

addNum(1,5)
addNum(10203103, 329412931)
addNum('ajdjf', 'alsd')
addNum(1.2346, 128374.1757)
addNum(1.123, 3)



# 함수 정의 3
# 인자가 있다. return이 없다.
# return 문은 함수를 탈출하는 용도로도 사용
# return 문 아래의 명령은 실행이 되지 않는다.
'''
def 함수명():
    명령문...
    return 결과값/수식/명령문
'''
# 호출
# 함수명(값1, 값2...)

def classPrint():
    return 'MySQL, SQLite'

# 함수 호출
print(classPrint())

print('-'*30)


def classPrint2():
    # 함수 내부에서 2개의 변수 정의
    message1 = 'MySQL1'
    message2 = 'SQLite2'
    # return message2    # SQLite2
    message2 += message1
    return message2 #SQLite2MySQL1

# 함수 호출
print(classPrint2())


# 퀴즈
# 2개의 인자를 받아서 +,-,/,* 출력하기
'''
def cal(인자정의):
    ....
cal(2,3)

2 + 3 = ?
2 - 3 = ?
2 * 3 = ? 
2 / 3 = ?
'''


def add(x,y):
    print(f' 두수의 합은 : {x+y}')
def minus(x,y):
    print(f' 두수의 차는 : {x+y}')
def multi(x,y):
    print(f' 두수의 곱은 : {x+y}')
def divi(x,y):
    print(' 두수를 나누면 %.2f' % (x/y) )

add(2,3)
minus(2,3)
multi(2,3)
divi(2,3)




# 함수정의 4
# 인자가 있다. return이 있다.
'''
def 함수명(인자1, 인자2...):
    인자에 관련된 명령문...
    return 결과값/수식/명령문
'''

# 호출
# 함수명(값1, 값2...)
def messagePrint2(m):
    return 'Happy New Year.\t' + m + '님'

print(messagePrint2('홍길동'))



# 숫자를 받아서 1~ 숫자까지의 합구하기.
# sum = 0
# for i in range(1,101):
#     sum += i
# print(sum)

def sum(n):
    sum = 0
    for i  in range(1,n+1):
        sum +=i
    return sum

print(f'1부터 100까지의 합 : {sum(100)}')
print(f'1부터 50까지의 합 : {sum(50)}')

'''
퀴즈1
2개의 수 x, y를 인자로 전달하여 누적합 구하기
x~y 까지의 합 함수로 변경.
'''

def add3(x,y):
    sum = 0
    for i in range(x, y+1):
        sum +=i
    return sum

print(f' x~y까지의 합 :  {add3(1,10)}')

'''
퀴즈2
n개의 입력을 받아서 리스트에 저장하는 함수 정의

printList(5) #5개로 구성된 리스트로 반환
printList(3) #3개로 구성된 리스트로 반환

# '''
# def list1(n):
#     arrayList1 = []
#     print(f'\n\n{n}개 입력')
#     for i in range(0, n):
#         temp = input('리스트 아이템을 입력해주세요...')
#         arrayList1.append(temp)
#     return print(arrayList1)
#
# list1(5)
# list1(3)





# 함수 정의5
# 인자가 있다. return 값이 다중인 경우
# 다중 return 값인 경우 자료형은 튜플
# (결과값1, 결과값2)
# 각각의 결과값은 인덱싱으로 접근할 수 있다.
'''
def 함수명(인자1, 인자2...):
    인자에 관련된 명령문...
    return 결과값1, 결과값2...
'''
# 호출
# 함수명(값1, 값2...)

# 두개의 인자를 전달한 후 합과 차의 결과를 리턴한다.
def multiReturn(n, m):
    return n+m, n-m

print(multiReturn(50, 20), type(multiReturn(50, 20)))
'''
(70, 30) <class 'tuple'>
'''

result = multiReturn(50,20)
print(f'두수의 합? {result[0]}')
print(f'두수의 차는? {result[1]}')




#함수 정의 6
# 인자의 초기값 설정
'''
def 함수명(인자1 =값1, 인자2=값2):
    인자에 관련된 명령문...
    return 값/변수/수식/명령문
'''
# 호출
# 함수명()
# 함수명(값1)
# 함수명(값1, 값2...)


# 두수의 합 리턴. 초기값 있음.
def sum3(n=0, m=10):
    return print(n+m)

sum3() #10
sum3(20) #30
sum3(20,30) #50

print('-'*30)


# 함수 정의 7
# 인자의 초기값 설정 (인자의 일부만 초기값이 있는 경우)
# 주의 사항은 마지막 인자에는 초기값이 있어야 한다.
'''
def 함수명(인자1, 인자2=값2):
    인자에 관련된 명령문...
    return 값/변수/수식/명령문

'''
# 호출
# 함수명(값1)
# 함수명(값1, 값2)

# 두수의 곱을 리턴한다.
# def mul(n=1, m):  SystaxError 문법에러 발생.    .
def mul(n, m=10):
    return print(n*m)

# mul()  :  TypeError발생.
mul(7)  # 7 x 10 = 7
mul(7, 8)   # 7 x 8 = 56











