# 파이썬 제어문
# 제어문의 종류
# - 조건문 : if / if ~ else / if~elif~else
# - 반복문 : for / while

# 파이썬 제어문 특징
# {}를 사용하지 않고 탭1개 나 공백 4칸으로 블록 지정
# 들여쓰기가 없는 경우 IndentationError: 에러 발생
# switch 문이 없다.
# else if 대신 elseif 문이 있따.

# 조건문 if

# 조건문 1
# if 조건 :
#   명령문

# 조건문 2
# if 조건 :  - 2가지 조건이 있는 if문
#   명령문 1
# else :
#   명령문2


# 조건문 3   - 다중 if 문
# if 조건문:
#   명령문1
# elif 조건:
#   명령문2


# if 문
# if True 조건식:
#    실행할 문장

# a = 1
# b = 10
# if a>b : #False
#     print('a는 b보다 크다.')
#
# if a<b : #True
#     print('a는 b보다 작다.')


# # 짝수인지 홀수인지 판단?
myNum = 45
if myNum%2 ==0:
    print('짝수')
if myNum%2 !=0:
    print('홀수')

# 파이썬 3.7 이하에서만 사용 가능.  3.8은 지원이 안됨.
# if myNum%2 is 0:
#     print('짝수')
# if myNum%2 is not 0:
#     print('홀수')


# 퀴즈 1 :
# 숫자를 입력받아서
# 숫자값이 3의 배수이면 3의 배수이다.
# 그렇지 않으면 3의 배수가 아니다.
'''
숫자를 입력해주세요?
3의 배수이다.
3의 배수가 아니다.
'''
# data = (int)(input('숫자를 입력해주세요'))
# if (data%3)==0:
#     print('3의 배수이다.')
# if (data%3)!=0:
#     print('3의 배수가 아니다.')
#


# 퀴즈:
# 나이를 입력받아서
# 나이에 따라서 서로다른 메시지 출력
'''
당신의 나이를 입력하세요? ...
14~16 : 중학생
17~19 : 고등학생
20 ~ : 성인
'''
# userAge = int(input('당신의 나이를 입력해주세요? ...'))
# if (userAge>=14) and (userAge<=16):
#     print('중학생')
# if (userAge>=17) and (userAge<=19):
#     print('고등학생')
# if (userAge>=20):
#     print('성인')
#

userAge = int(input('당신의 나이를 입력해주세요?'))
if (14<= userAge <=16):
    print('중학생')
elif 17<= userAge <=19:
    print('고등학생')
else:
    print('성인')

# 조건식에서 True가 되는 조건 = 
# True, 0 빼고 나머지숫자, 문자열
# 조건식에서 False가 되는 조건
# = False, 0, '', None

# if True:
# if 123:
# if '문자열' :
#     print('무조건 실행')
#
# if None :
# if False:
# if 0:
# if '':
#     print('실행안됨')
#

# if ~ else ~
# a2 = 1
# b2 = 10
# if a2>b2 : # False
#     print('a2는 b2보다 크다')
# else :
#     print('a2는 b2보다 작다')
#
# print('-'*30,'\n')


# if ~ elif ~ else 다중 조건문
# 입력받은 데이터가 0 =>0
# 0 => 0
# 양수
# 음수
# 숫자가 아니다.
# inData = int(input('숫자를 입력하세요...'))
# if inData == 0:
#     print('0이다')
# elif inData>0:
#     print('양수이다.')
# elif inData<0:
#     print('음수이다.')
# else:
#     print('숫자가 아니다.')


# 띠 테스트
# 띠 = 테이난년도 % 12
# 원숭이, 닭, 개, 돼지, 쥐, 소, 범, 토끼, 용, 뱀, 말,양

yourZodiac = (int)(input('당신의 태어난 년도를 입력해세요 : '))
ZodiacList = ['원숭이', '닭', '개', '돼지', '쥐', '소', '범', '토끼', '용', '뱀', '말', '양']
animal = yourZodiac %12
print(f'당신이 태어는 년도는 {yourZodiac}이고, {ZodiacList[animal]} 띠 입니다.')

# yourZodiac = (int)(input('당신이 태어난 년도를 입력하세요 : '))
# if (yourZodiac%12) ==0:
#     print('원숭이입니다.')
# elif (yourZodiac%12) ==1:
#     print('닭입니다.')
# elif (yourZodiac %12) ==2:
#     print('개입니다.')
# elif (yourZodiac %12) ==3:
#     print('돼지입니다.')
# elif (yourZodiac %12) ==4:
#     print('쥐입니다.')
# elif (yourZodiac %12) ==5:
#     print('소입니다.')
# elif (yourZodiac % 12) == 6:
#     print('범입니다.')
# elif (yourZodiac % 12) == 7:
#     print('토끼입니다.')
# elif yourZodiac % 12 == 8:
#     print('용입니다.')
# elif (yourZodiac %12) ==9:
#     print('뱀입니다.')
# elif (yourZodiac %12) ==10:
#     print('말입니다.')
# elif (yourZodiac %12) ==11:
#     print('왕입니다.')
#
#
# yourZodiac2 = (int)(input('당신이 태어난 년도를 입력하세요 : '))
# animal =  yourZodiac2%12
# animalList2 =['원숭이','닭','개','돼지','쥐','소','범','용','뱀','말','왕']
# print('당신은', animalList2[animal],'입니다.')
#




# 조건문안에 조건문
# 숫자를 입력받아서
# 0, 양수, 음수, 숫자가 아니다.
# 입력받은 데이터가 숫자이면 데이터형 변경.
# 그렇지 않으면 메시지 출력
# 문자열.isdigit() : 문자열이 숫자이면 True

inData2 = input('숫자를 입력하세요...')
if inData2.isdigit():         # isdigit 숫자인지 판별하는 함수.
    # print('숫자이다.')
    inData2 = int(inData2)
    if inData2 ==0:
        print('0이다.')
    elif inData2>0:
        print('양수이다.')
    else:
        print('음수이다.')
else:
    print('숫자가 아니다.')



