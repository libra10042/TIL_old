# 오류?
# 오류의 종류
# NameError: 함수이름, 변수, 리스트 이름등이 잘못된 경우
# IndexError :  튜플,리스트의 잘못된 인덱스 접근
# ZeroDivisionError : 0으로 나눈 경우
# FileNotFoundError : 잘못된 파일 경로
# SyntaxError 제외 => 예외처리 try: ~ Except 구문에서 제외
# ----------------------------------------
# IndexError :  튜플,리스트의 잘못된 인덱스 접근



# 파일입출력, 파일삭제, 디렉도리이동시 경로가 잘못된 경우 발생.
# FileNotFoundError
# : [WinError 2] 지정된 파일을 찾을 수 없습니다.
# import os
# os.remove('test.txt')
# import os
# os.remove('test.txt')
#


# 데이터형 오류
# ValueError
# : invalid literal for int() with base 10 : 'abc'
# temp = int(input('숫자를 입력햊세요 ...'))
# print(temp)



# 문법 오류 :
# SyntaxError
# : EOL while scanning string literal
# print('abc)
# print('abc')

# -----------------------------------------

# 예외처리(Exception) 란?
# 오류가 발생을 하면
# 메세지를 출력하거나 오류를 무시하는 기능

# try... except 명령
# try... except... else 명령
# try... except... else... finally 명령
# raise Exception : 사용자정의 에러
#    ex) 금칙어, 특별한 값 지정. 데이터 유효성

# ------------------------------------------
# 에러처리 문법 1

# try..except 명령1
# try:
#   명령어
# except 에러코드 as e:
#   에러처리명령



# try..except 명령2
# 모든 예외의 에러 메시지를 출력할 때는 Exception 키워드
# 에러코드를 몰라도 된다. => Exception
# try:
#     명령
# except Exception as e:
#     print(e)


# try..except 명령3
# try:
#   명령어
# except:
#   에러처리명령`



# --------------------
# Zerodivision Error
# => 특정 메세지 출력

try :
    print(23/0)
except ZeroDivisionError as e :
    print(e)    # division by zero : 등록된 프로그램 에러 메세지
    print('0으로 나눌 수 없습니다.')


listAlpha = []
try:
    print(listAlpha[3])
except IndexError as e:
    print(f'{e}, 잘못된 접근입니다.') #list index out of range 잘못된 접근입니다.

# -------------------------------------------------
# 퀴즈 1:
#   data/test.txt 가 없다면
#   에러메세지(e)와 함께 '파일이 없습니다.' 메세지 출력
#   있다면 파일의 내용을 출력한다.
# try:
#     a = open('c:/pyclass/Day05/data/result2.txt', 'r', encoding='cp949')
#     print(a.read())
# except FileNotFoundError as e:
#     print('입력된 데이터가 숫자가 아닙니다.', e)

# 퀴즈 2:
# 2개의 숫자글자를 입력받아서 더한다.
# 입력된 글자 숫자글자가 아니라면 에러 메시지 출력
# 입력된 글자가 숫자글자라면 더한후 출력한다.
#
# try:
#     a = input('숫자를 입력 : ')
#     b = input('숫자를 입력 : ')
#     print(f' {a} + {b} = {int(a) + int(b)}')
# except ValueError as e:
#         print('파일이 없습니다. e')


# --------------------------
# 에러처리 문법 2
# try:
#   명령어
# except 에러코드 as e:
#   에러처리명령
# else:
#   에러가 발생하기 않은 경우 명령어


# 에러명을 모를 때
# try :
#   명령어
# except Exception as e:
#   e 출력, 에러 처리명령
# else :
#   에러가 발생하기 않은 경우 명령어.

#
#
# try:
#     a = int(input('숫자를 입력 : '))
#     b = int(input('숫자를 입력 : '))
# except ValueError as e:
#     pass
# else :
#     print(f'{a} + {b} = {a + b}')
#
#


#-----------------------
# try:
#   명령어
# except:
#   에러처리명령
# else:
#   에러가 발생하기 않은 경우 명령어


# --------------------------
# 에러처리 문법 3
# try:
#   명령어
# except 에러코드 as e:
#   print(e)
#   에러처리명령
# else:
#   에러가 발생하기 않은 경우 명령어
# finally:
#   무조건 실행되는 명령어

# try:
#   명령어
# except:
#   에러처리명령
# else:
#   에러가 발생하기 않은 경우 명령어
# finally:
#   무조건 실행되는 명령어


try:
    a = open('c:/pyclass/Day05/data/result2.txt', 'r', encoding='cp949')
except Exception as e:
    print('입력된 데이터가 숫자가 아닙니다.', e)
else :
    print(a.readline())
finally :
    print('-'*20)
    print('파일 읽기 완료')



# --------------------------
# 에러처리 문법 4 : 오류 회피
# 에러 무시 : pass 키워드 사용
# try:
#   명령어
# except:
#   pass

try :
    you = '홍길동'
    print(you)
except:
    pass
else :
    print(you*20)
finally:
    print('-'*20, '예외처리 완료')




# --------------------------
# 에러처리 문법 5
# 여러개의 오류 처리하기
# 먼저 발생한 오류 우선: 뒤에 오류는 실행되지 않음
# '''
# try:
#     ...
# except 발생오류1:
#     에러메세지 출력1
# except 발생오류2:
#     에러메세지 출력2
# finally :
#     테스트완료명령.

# 첫번째 명령에서 에러가 난 경우.


# 테스트 1
# 결과 >> 0으로 나눌 수 없습니다. division by zero
# try :
#     print(40/0)
#     print(me)
# except ZeroDivisionError as e:
#     print('0으로 나눌 수 없습니다. %s' %e)
# except NameError as e :
#     print('변수가 정의되어 있지 않습니다. %s' %e)


#테스트 2
# 결과 >> 변수가 정의되어 있지 않습니다. name 'me' is not defined
try :
    print(me)   # 먼저 발생한 오류임.
    print(40 / 0)
except NameError as e :
    print('변수가 정의되어 있지 않습니다. %s' %e)
except ZeroDivisionError as e:
    print('0으로 나눌 수 없습니다. %s' %e)

# --------------------------
# 사용자 정의 에러
# 에러만들기1 : raise 문 이용
# 일부러 에러 발생
# if 조건식:
#   raise Exception(오류 메세지)

# 변수값이 음수이면 에러발생.
# try:
#     x = int(input('숫자를 입력하세요'))
# except:
#     print('입력값의 타입을 변환할 수 없습니다.')
# else :
#     if x<=0:
#         raise Exception('0보다 큰 양수를 입력하세요.')
#     else :
#         print(x)

# --------------------------
# 에러만들기2 : raise 문 이용
# 특정 기능을 구현하게 만드는 사용자에러
# raise NotImplementedError
# => 메소드 오버라이딩
# 부모클래스에서 정의했던 메서드를 재정의한다.


# raise NotImplementedError
# 사용자정의 에러를 만들지 않은 경우
# 부모 클래스 정의
class Bird1:
    def fly(self):
        print('새가 나는 중')

# 자식 클래스정의
class Dove1(Bird1):
    pass

dove = Dove1()
dove.fly()


# 부모 클래스 정의
class Bird2:
    def fly(self):
        print('새가 나는 중')
        #자식클래스에서는 메소드 오버라이딩을 정의해야 한다 .
        raise NotImplementedError

# 자식 클래스1 정의
class Dove2(Bird2):
    pass

# 자식 클래스2 정의
class Eagle2(Bird2):
    # 메소드 오버라이딩
    def fly(self):
        print('독수리가 나는 중 ')

# 인스턴스화
# NotImplementedError 발생.
# dove2 = Dove2()
# dove2.fly()


eagle2 = Eagle2()
eagle2.fly()


# --------------------------
# 에러만들기3 : Exception 내장 클래스 이용
# 특정 상황에서 예외 발생


# 1단계 : 사용자 에러 등록.
# Exception 내장 클래스를 상속받아 임의의 에러명으로 클래스 생성
# class 에러명클래스(Exception):
#       명령문

class MyError(Exception):
    pass
# 2단계 : 함수 정의
# '바보' 문자열이 변수에 값으로 지정되면
# 정의된 myError() 발생.

def say(nickName):
    if nickName == '바보':
        raise MyError()
    else : 
        print('별명 ==> ', nickName)

# 3단계 : 함수 호출 
say('천사') # 별명 ==> 천사

# say('바보') # 에러발생.
'''
    raise MyError()
__main__.MyError
'''

# --------------------
# try... except문을 이용하여 MyError 예외처리
try :
    say('귀염둥이')
    say('바보')
except MyError:
    print('금지된 단어입니다. 에러 발생.')

# 에러 발생.
# 금지된 단어입니다. 에러 발생.




#------------------------------------
# 에러 메세지 등록과정.
# 사용자오류 등록 : 에러 메세지 등록하여 사용하기
# def __str__(self):
#     return 메세지

class MyErrorMessage(Exception):
    def __str__(self):
        return '금지된 단어로 사용 정지입니다.'


def sayYourNickName(nickName):
    if nickName =='바보':
        raise MyErrorMessage()
    else :
        print('별명 ==>', nickName)


try :
    sayYourNickName('똘똘이 스머프')
    sayYourNickName('바보')
except MyError as e :
    print(e)