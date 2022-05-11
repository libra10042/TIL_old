# 함수
# 사용자정의함수
# 내장함수 : 별도의 import 명령이 필요없다
#           함수(옵션)
# 외장함수 : 별도의 import 명령이 필요
#           모듈.함수(옵션)

# 시간과 관련된 모듈 임포트
import datetime

# 현재 시간을 기준으로 년,월,일,시,분,초 변수 생성
now = datetime.datetime.now()
print(now)


print(' 년도 : ', now.year)
print(' 월 : ', now.month)
print(' 날짜 : ', now.day)
print(' 시간 : ', now.hour)
print('-'*30, '\n'*2)

'''
2019-12-30 16:39:41.929593
 년도 :  2019
 월 :  12
 날짜 :  30
 시간 :  16
'''

# 아래와 같이 출력하여 보세요
# 오늘은 2019년 12월 30일 입니다.
# 현재시간은 ()시 ()분입니다.

print(' 오늘은 {}년 {}월 {}일 입니다.'
      .format(now.year,now.month,now.day))
print(' 현재시간은 {}시 {}분입니다.'
      .format(now.hour,now.minute))
print(' 현재시간은 {}시 {}분입니다.'
      .format(now.hour-12,now.minute))

print(type(now.hour)) # <class 'int'>
print(' 오늘은 %s년 %s월 %s일 입니다.'
      %(now.year,now.month,now.day))
print(' 오늘은 %d년 %d월 %d일 입니다.'
      %(now.year,now.month,now.day))
'''
 오늘은 2019년 12월 30일 입니다.
 오늘은 2019년 12월 30일 입니다.
'''


# 퀴즈1 : if문과 datetime 모듈 이용
# 현재 시간을 아래와 같이 출력한다.
# 현재 시간은 오후 3시 () 분입니다.

# 오전 구분
if now.hour < 12:
    print("현재 시간은 오전 {}시로 오전입니다!".
          format(now.hour))
# 오후 구분
else:
    print("현재 시간은 오후 {}시 {}분 입니다!".
          format(now.hour-12, now.minute))


# 퀴즈2 : if문과 datetime 모듈 이용
# 달을 추출 now.month
# 달에 따라 봄, 여름, 가을 ,겨울 메세지 출력
# 12, 1,2 : 겨울
# 3~5 : 봄
# 6~8 : 여름
# 9~11 : 가을
# 출력은 아래와 같이.
# 12월은 겨울입니다.

print(now.month) # 12
# 봄 구분
if 3 <= now.month <= 5:
    print("{}월은 봄입니다!".format(now.month))
# 여름 구분
elif 6 <= now.month <= 8:
    print("{}월은 여름입니다!".format(now.month))
# 가을 구분
elif 9 <= now.month <= 11:
    print("{}월은 가을입니다!".format(now.month))
# 겨울 구분
else:
    print("{}월은 겨울입니다!".format(now.month))

# 요일 찍기
# 요일은 (월요일)0 ~ 6(일요일)
today = datetime.datetime.today().weekday()
print(today, type(today)) # 0 <class 'int'>
if today == 0:
    print('월요일 입니다.')


# 퀴즈 :
# 아래와 같이 출력해보세요
# 2018년 8월 1일 수요일
# 방법 1
# 0~6
today2 = datetime.datetime.today().weekday()
if today2 == 0:
    print('월요일 입니다.')
elif today2 == 1:
    print('화요일 입니다.')
elif today2 == 2:
    print('수요일 입니다.')
elif today2 == 3:
    print('목요일 입니다.')
elif today2 == 4:
    print('금요일 입니다.')
elif today == 5:
    print('토요일 입니다.')
else:
    print('일요일 입니다.')

# 방법 2
# 요일 리스트를 정의한 후
# 요일 인덱스를 리스트 인덱스로 활용
t = ['월요일', '화요일', '수요일', '목요일', '금요일',
'토요일', '일요일']
today = datetime.datetime.today().weekday()
print(t[today])
print('{} 년 {} 월 {}일 {}'.
format(now.year, now.month, now.day, t[today] ))
# 2019 년 12 월 30일 월요일