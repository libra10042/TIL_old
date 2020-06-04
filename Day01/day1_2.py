#멀티라인 출력문
# - 개행문자 \n 이용
# - ''' 문자열 내용 '''이용

print('안\n녕\n**')
print('''
 안녕**'''
)

# 정의된 변수 삭제
# del 변수명
# a = 200
# print('a는?', a)
# a2 = 100
# print('a는?', a2)
# del a2
# # # NAME 에러 발생.
# print('a는?', a2)


# 데이터형 확인하기
# type(변수/값)

# 자료형의 종류
# : 기본자료형 : 숫자형(정수, 실수, 16진수, 8진수)
# : 문자열
# : boolean (True / False)
# 집합자료형
# : 리스트, 튜플, 딕셔너리, 클래스

print(type(True))
print(type(100))
print(type(34.5))
print(type("Python"))


# 입력문
# 변수명 = input(메세지)
# 입력받은 변수는 데이터형이 문자열이다.
# message = input('메시지를 입력하세요? ...\n')
# print('message =', message)
# print(type(message))

# 16진수 : 숫자0 알파벳x
# 8진수 : 숫자0 알파벳0
print('16진수 : ', 0x11)  #16진수 : 17
print('8진수: ', 0o11) #8진수 : 9
# 결과치는 10진수로 표시


# 자료형 변환 - Casting
# int(값 /수식/ 변수) : 정수형 데이터형으로 변환
# float(값/ 수식/ 변수) : 실수형 데이터으로 변환
# str(값/ 수식/ 변수) : 문자열 데이터형으로 변환
var1 = "1234"
var2 = 1234
var3 = 12.34

print('var1 : ', var1, str(var1), type(var1))
print('var2 : ', var2, str(var2), type(var2))
print('var3 : ', var3, str(var3), type(var3))

print('var1 : ', var1, float(var1))
print('var2 :' , var2, type(str(var2)))
print('var3 :' , var3, int(var3))



# 퀴즈 : 2개의 숫자값을 입력받은 사칙 연산을 수행하라.
'''
첫번째 숫자를 입력하세요...10
두번째 숫자를 입력하세요...20
--------
10 + 20 = ?
10 - 20 = ?
10 * 20 = ?
10 / 20 = ?
'''
num1 = (int)(input('첫번째 숫자를 입력하세요...\n'))
num2 = (int)(input('두번째 숫자를 입력하세요...\n'))

print(num1, '+' ,num2 ,'=', num1+num2)
print(num1, '-' ,num2 ,'=', num1-num2)
print(num1, '*' ,num2 ,'=', num1*num2)
print(num1, '/' ,num2 ,'=', num1/num2)


# 산술연산자
# +, -, *, /, //(정수형 몫), %(나머지), **(제곱)
print(1000/7)
print(1000//7)
print(1000%7)
print(10**3)


# 연산자 우선순위
# 괄호()
# *, /
# +, -

print(100+20*40) #900
print((100+20)*40) #4800

# 대입연산자
# 변수명 += / -= / *= /
myNum3 = 100
print('myNum3 = ', myNum3)
myNum3 += 100
print('myNum3 =', myNum3)
myNum3 /= 100
print('myNum3 =', myNum3)

# 관계 연산자
# 결과값이 True/ False
# ==, !=, >, <, >=, <=
print(100>10)
print(100<=100)
print(100==100)
print(100!=10)

#논리연산자
# 결과 값이 True, False
# and, or, not
# 관계연산자를 이용한 수식1 논리 연산자 관계연산자를 이용한 수식2
# not(관계연산자를 이용한 수식)
# True and True => True
# True and False => False
# False or False => False
# True or False => True
# not(True) => False
# not(False) => True
x =10
y =100
print((x<y) and (x==y)) #F
print((x<y) or (x==y)) #T
print(not(x<y)) #F

print("-"*20)

# is, is not 연산자
# 값이 같은지 비교한다.
# 결과값이 True/ False
stName1 = 'Maria'
stName2 = 'Bill'
print(stName1 is stName2)  #F
print(stName1 is not stName2) #T