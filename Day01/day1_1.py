# 한줄 주석
'''
    여러줄 주석1
    여러줄 주석2
'''

#print(문)
# print(값/ 수식 /변수, end= '대체문자나 공백')문
print(100)
print(100+200)
print(100+300)

#쉼표를 이용한 출력문.
print(100, ' + ', 200, '=', 100+200)
print(100, '-', 200, '=', 100-200)

#end 옵션을 이용한 한줄 출력문.
print(True, end='')
print(False)
print(True, False)

# 문자열 연산자  +(연결), *(반복)
# 문자열1 + 문자열2
# 문자열 * 숫자

# 변수 = 수식 또는 값.
# 파이썬은 자료형 없이 변수명만 정의
txt1 = 'hello'
txt2 = ' world'

print(txt1 + txt2)
print('-------------')
print('-' *20)

#이스케이프 코드 : p48 참조
# \n, \t : 줄 바꿈, 탭 간격
#\\ (\표시) : 문자 \를 그대로 표현할 때
#\', \" (인용부호 사용) : 작은 따옴표, 큰따옴표를 그대로 표시하고 싶을 때
print('\n\n\t점심 시간 안내')
print('-'*20, '\n\n', '**\t12시-1시')
print('-'*20)
print('\'인용부호표시\'')
print('\"인용부호 표시\"')
print('\\슬러시 표시\\')


# 변수 할당 선언.
# 변수 = 수식 또는 값.
# 서로 다른 변수에 동일한 값 할당.
'''
num1 = 100
num2 = 100
'''
num1=num2=100
print('num1 = ', num1)
print('num2 =', num2)

#쉼표(,)를 이용한 변수 할당.
#변수1, 변수2 = 값1, 값2
num3, num4= 100,200
print('num3 =', num3)
print('num4 =', num4)

#퀴즈 : user1, user2의 변수값을 서로 변경하여라.
user1 = "영희"
user2 = "철수"
print('user1 =', user1)
print('user2 =', user2)
#명령어 입력
#방법01. 중간변수 설정.
#방법02. 쉼표를 이용한 변수 교체
temp = user1
user1 = user2
user2 = temp
#01.
print('user1 =', user1)
print('user2 =', user2)

#02.
user1, user2 = '철수', '영희'
print('user1 =',user1)
print('user2=', user2)


# 변수명 규칙 정의 방식.
# 카멜표 기법 : 대문자소문자로 단어 분리
# userAge
# 스네이크 기법 : _, - 단어 연결
# user_age
# 클래스명은 첫글자를 대문자로 표시
# 함수명은 소문자로 표시
# 변수명은 소문자로 시작.
# 예약어는 변수명으로 사용할 수 없다.
# 예약어(keyword)
import keyword
print(keyword.kwlist)
print('키워드 갯수 =', len(keyword.kwlist))