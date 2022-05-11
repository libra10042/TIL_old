# 반복문
# while문
# for ...in
# for ... range()


# 반복문 : while
# while 조건 :
#       실행명령
# 조건이 True 이면 명령을 실행해라.


# 무한 루프
# while True:
#       명령문

# while True:
#     print('Python')


# while 조건 :
#       실행명령
#       False조건


# 초기값
# While False가 될 조건제시:
#       증감
#       실행명령

# 1~10 까지 출력하라
cnt = 1
while cnt<=10:
    # 한줄로 출력
    print(cnt)
    cnt += 1
print('\n프로그램 종료')


cnt = 1
while cnt<=10:
    print(cnt)
    cnt+=1


# 10~1까지 출력하여라
cnt2 = 10
while cnt2>0:
    # 한줄로 출력
    print(cnt2, end=' ')
    cnt2 -=1
print('\n프로그램 종료')



# 별찍기1
'''
*
**
***
****
*****
'''

cnt3 = 1
while cnt3<=5:
    print('*'*cnt3)
    cnt3+=1


print('-'*30)
# 1~50까지 짝수만 출력하기.
cnt4=1
while cnt4<=50:
    if cnt4%2 ==0:
        print(cnt4, end=' ')
    cnt4+=1

print('\n\n')

# 퀴즈1 - 3단 출력하기
'''
3 x 1 = 3
'''
dan3 =3
i=1;
while i<=9:
    print(dan3, 'x', i, '=', dan3*i)
    i+=1



# 퀴즈2 - 1~100까지의 합 출력하기
hap1 = 1
count = 0;
while hap1<=100:
    hap1 +=1
    count +=hap1
print(f'1~100까지의 합 : {count}')



# 무한루프
# while True:
#       print('Python')