# 문자열 인덱싱.
# 인덱싱이란? 문자열의 글자 위치를 숫자로 표시.
# 인덱싱의 첫 위치는 0
# 인덱싱의 마지막 위치는 -1,
# 문자열변수[인덱스값]
myString = "abcdefg"
print('myString[0] = ',myString[0])
print('myString[-1] = ',myString[-1])
print('myString[3] = ',myString[3])
print('myString[-2] = ',myString[-2])
# 결과 값은 양수이면 왼쪽 음수이면 오른쪽부터 찾는다.

#문자열 전체 길이는?
# len(문자열이나 문자열 변수)
print('myString =', myString)
print('myString 전체 길이는?', len(myString), type(len(myString)))


# 문자열 슬라이싱이란?
# 문자열의 일부를 잘라서 표시
# 문자열변수 [start : end :step]
# start 부터 end-1 까지 step 수만큼 건너뛰기
print('\n\nmyString =', myString)
print('myString[0:3] =', myString[0:3])
print('myString[:3] =', myString[:3])
print('myString[5:] =', myString[5:])
print('myString[::] =', myString[::])
print('myString[::2] =', myString[::2])
print('myString[-1:] =', myString[-1:])
print('myString[-5:-1] =', myString[-5:-1])


# 출력포맷 방식.
# % 를 이용한 포맷팅
# format()를 이용한 포맷팅
# f 를 이용한 포맷팅. 파이썬 3.6이상 에서 사용 가능.
today ='화요일'
yesterday ='수요일'
#오늘은 수요일 입니다.
print('오늘은 ', today, '입니다.')

# %자료형, d/s/전체자리수.f소수점자리이하 숫자f/%o/%x
# print(' 문자열 %자료형 ' %변수)
# print(' 문자열 %자료형1 %자료형 ' %(변수1, 변수2))

print('오늘은 %s 입니다.' % today )
print('오늘은 %s 입니다. 내일은 %s' % (today, yesterday))

myNum = 16
print('10진수 : %d' %myNum)
print('16진수 : %x' %myNum)
print('8진수 : %o' %myNum)
print('실수로 표시 :%f' % myNum)


# %전체자릿수. 소수점이하자릿수f
# %. 소수점이하자릿수f
pi = 3.14156748
print('pi : %f' %pi)
print('pi : %.3f' %pi)
print('pi : %10.2f' %pi)
print('pi : %15.1f' %pi)


# 퀴즈 : 2개의 숫자를 입력받아
# 다음과 같이 출력하여라.
'''
숫자를 입력하세요 ...12
숫자2를 입력하세요 ...12: .345

입력받은 숫자1은 12입니다.
입력받은 숫자1은 8진수로 14입니다.
입력받은 숫자1은 16진수로 c입니다.
입력받은 숫자2는 12.3 입니다.
'''
#
#  inputNum = (int)(input('숫자를 입력하세요...\n'))
#  inputNum2 = (float)(input('숫자를 입력하세요...\n'))
#
# print('입력받은 숫자1은 %d 입니다.' %inputNum)
# print('입력받은 숫자1은 8진수로 %o 입니다.' %inputNum)
# print('입력받은 숫자1은 %x 입니다.' %inputNum)
# print('입력받은 숫자2은 %.1f 입니다.' %inputNum2)

# % 퍼센트 기호 표시 : %%
# 오늘의 미세농도는 0.0005 % 입니다.
todayM = 0.005
# 아래는 에러 발생.
# print('오늘의 미세농도는 %f % 입니다.' %todayM)
print ('오늘의 미세농도는 %f %% 입니다.' % todayM)

# %로 공백 지정.
# %양수숫자Style(s/f/d/x/o) : 왼쪽에 공백 생성.
# %음수숫자Style(s/f/d/x/o) : 오른쪽에 공백 생성.
userName = '홍길동'
userNumber = 123.45
print('user Name : %10s **' % userName)
print('user Name : %-10s **' % userName)
print('user Name : %10d **' % userNumber)
print('user Name : %10f **' % userNumber)
'''
user Name :        홍길동 **
user Name : 홍길동        **
user Name :        123 **
user Name : 123.450000 **
'''



# format 을 이용한 출력방식.
# ' 문자열1 {} {} 문자열2'.format(변수1, 변수2)
# ' 문자열1 {숫자나 변수} {숫자나 변수} 문자열2'
#   .format(변수1, 변수2)

color = 'blue'
myNumber = 7

print(' color {} \n number{}'.format(color, myNumber))


# 인덱스 지정.
print(' 순서교체 : number {1} color {0}' .format(color, myNumber))

#초기값 다시 지정.
print(' 이름지정 : number {myNumber} color {color}' .format(myNumber=100, color ='red'))


# 공백이나 공백대신 대체문자 반복 출력하기
# : >숫자 (앞에 공백생성)
# : <숫자 (뒤에 공백생성)
# : ^숫자(좌우에 여백 생성) : {}안에 입력
# : 대체문자>숫자 (앞에 대체문자 생성)
# : 대체문자<숫자 (뒤에 대체문자 생성)
# : 대체문자^숫자(좌우에 대체문자)

print('...{}...' .format('hellow world'))
print('...{:>30}...' .format('hellow world'))
print('...{:<30}...' .format('hellow world'))
print('...{:^30}...' .format('hellow world'))
print('...{:*>30}...' .format('hellow world'))
print('...{:*<30}...' .format('hellow world'))
print('...{:*^30}...' .format('hellow world'))




# format() 으로 소수점처리하기
# 방법1.
# format(값이나 변수, '전체자릿수.소수점이하자릿수f')
# 방법2.
# "문자열 {위치 인덱스 : 전체자릿수.소수점이하자릿수f}"
#    .format(값이나 변수)
pi2 = 3.14156748
print('pi :', format(pi2))
print('pi :', format(pi2, '11.3f'))
print('pi : {0:2.1f}'.format(pi2))



# format 함수안에서 {} 표시하기
# '{{ }}.format()
fruit = "사과, 바나나, 홍시"
# indexError 발생
# print("{} [...}".format(fruit))
print("{} {{...}}".format(fruit))

# 사과, 바나나, 홍시{...}

# f 문자열 포맷팅 : 3.6 이상 지원
# f' 문자열 {변수명이나 변수를 이용한 수식} '
stName1 = '나은'
stName2 = '건후'
age = 10
print(f'학생1 {stName1} , 학생2 {stName2}')
print(f'나이 {age} , 나이2 {age+5}')



# f 포맷팅 소수점 처리
# f' 문자열 {변수명:전체자릿수.소숫점이하자릿수f} '
height = 155.67890
print(f' 키는? {height}')
print(f' 키는? {height:.2f}')
print(f' 키는? {height:10.1f}')


# f' 문자열 공백, 대체문자여백 지정
# f' 문자열 {변수명:>숫자} : 왼쪽여백 생성
# f' 문자열 {변수명:<숫자} : 오른쪽여백 생성.
# f' 문자열 {변수명:^숫자} : 좌우여백 생성
# f' 문자열 {변수명:대체문자<숫자} : 오른쪽에 대체문자반복
# f' 문자열 {변수명:대체문자>숫자} : 왼쪽에 대체문자반복
# f' 문자열 {변수명:대체문자^숫자} : 좌우 대체문자 반복.
message = 'Hello world'
print(f' ***{message} ***')
print(f' ***{message:>30}***')
print(f' ***{message:<30}***')
print(f' ***{message:^30}***')
print(f' ***{message:#^30}***')
print(f' ***{message:!>30}***')
print(f' ***{message:!<30}***')


