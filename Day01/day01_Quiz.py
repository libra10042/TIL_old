# # 퀴즈 1:
# # 아래와 같이 3줄로 글자를 출력하는 4가지 방법은?
# '''
# 파이썬
# 파이썬
# 파이썬
# '''
# #1.
# print('파이썬')
# print('파이썬')
# print('파이썬')
# #2.
# print('파이썬 \n'*3)
# #3.
#
# #4.
#
#
#
# # 퀴즈 2
# # 홍길동 씨의 과목별 점수는 다음과 같다.
# # 홍길동 씨의 평균 점수를 소숫점 둘째자리까지 출력하여라
# '''
# 국어 : 86
# 영어 : 77
# 수학 : 55
# 평균 :
# '''
# kor = 86
# eng = 77
# mat = 55
# avg = (float)((kor+eng+mat)/3);
# print('홍길동 씨의 평균은 %.2f 입니다' % avg)
#
# # 퀴즈 3
# # 변수 a,b를 입력문을 이용하여 데이터를 저장한다.
# # == 을 이용하여 a,b 가 같은지 True, False 로 출력하여라
# '''
# a ? 10
# b ? 10
# True
# '''
#
#
#
#
# # 퀴즈 4
# # 2개의 숫자를 입력받아
# # 사칙연산의 결과물을 출력하여라
# # 출력시 % 포맷 형식 이용
#
# '''
# 첫번째 숫자를 입력하세요? 34
# 두번째 숫자를 입력하세요? 56
#
# 결과 :
# 34 + 56 =
# 34 - 56 =
# 34 * 56 =
# 34 / 56 =
#
# '''
#
# inputNum1 = (int)(input('첫번째 숫자를 입력하세요?'))
# inputNum2 = (float)(input('두번째 숫자를 입력하세요?'))
# print(inputNum1 , '+' , inputNum2, '=', inputNum1+inputNum2)
# print(inputNum1 , '-' , inputNum2, '=', inputNum1-inputNum2)
# print(inputNum1 , '*' , inputNum2, '=', inputNum1*inputNum2)
# print(inputNum1 , '/' , inputNum2, '=', inputNum1/inputNum2)
#


# # 퀴즈 5
# # 홍길동씨의 주민등록번호는 881120-1068234
# # 연월일과 숫자 부분을 나누어서 출력하여라.
# '''
# 연월일 : 881120
# 숫자 : 1068234
# '''
# idenfiNum = input('홍길동씨의 주민번호는 : ')
# year = idenfiNum[0:6]
# num = idenfiNum[7:14]
# print('연월일 :', year , "숫자 :", num)
#
#

# 퀴즈 6
# 2개의 변수를 정의하고 아래와 같이 출력한다.
# format 이용
#
# '''
# movie1 = '알라딘'
# movie2 = '스파이더맨'
#
# --------------
# 스파이더맨      :        알라딘
# +++   알라딘    +++
#
# '''
# movie1 = input('movie1 =')
# movie2 = input('moive2 =')
#
# print('{}    :    moive2'.format())
# print()


# 퀴즈 7
# 다음과 같이 교체한다.
# replace() 이용

'''
좋아하는 꽃 - 장미 

좋아하는 꽃 - 백합 

좋아하는 flower - 백합 
'''
txt1 = '''
좋아하는 꽃 - 장미
좋아하는 꽃 - 백합
'''
print(txt1.replace('좋아하는 꽃 - 장미', '좋아하는 flower -백합'))



# 퀴즈 8
# 다음과 같이 문자열 변수를 정의하고 결과값이 출력되도록 한다.
'''
Let thy speech be short, comprehending much in few words.

첫번째 t의 위치 : 3
첫번째 m의 위치 : 28
s 의 갯수 : 3

= 으로 연결 : 
 L=e=t= =t=h=y= =s=p=e=e=c=h= =b=e= =s=h=o=r=t=,= =c=o=m=p=r=e=h=e=n=d=i=n=g= =m=u=c=h= =i=n= =f=e=w= =w=o=r=d=s=.

대문자로 변경 : 
LET THY SPEECH BE SHORT, COMPREHENDING MUCH IN FEW WORDS.
'''




# 퀴즈 9
# 아래와 같이 변수를 지정하고
# humidity = 82
# temperature = -1.8
# % 포맷, format(), f' 포맷 3가지 방식을 이용하여 다음과 같이 출력하여라

'''
오늘의 날씨 : 맑음, 습도 82%, 현재기온 -1.8
'''

