# range(start, end, step)
# start~ (end-1)까지 step만큼 차례대로 숫자 생성.
# range 객체로 생성되므로
# 실제 출력을 확인하면서 리스트, 튜플 집합 형태로 자료형 변경.

# list( range(start, end, step))
# : 순차적으로 숫자로 구성된 리스트
# tuple ( range(start, end, step) )
# : 순차적으로 숫자로 구성된 튜플
# set( range(start, end, step) )
# : 순차적으로 숫자로 구성된 집합.

print(range(1, 11), type(range))
print(list(range(1, 11)))
print(tuple(range(1, 31, 2)))
print(set(range(0, 31, 2)))

# 1~20 사이의 짝수 또는 홀수로 구성된 리스트 생성하기
listEven = list(range(2,21,2))
listOdd = list(range(1,21,2))
print(listEven)
print(listOdd)


# for 문과 range
# for 인덱스 in range(start, end, step):
#   명령문

# 1~10까지 출력하기
for i in range(1, 11):
    print(i, end =' ')

print('\n')
# 홀수만 출력하기
for j in range(1, 11, 2):
    # 한줄로 출력 원할 때
    print(j, end = ' ')

print('\n')

# 1~100사이의 합 구하기
count = 0
for k in range(1,101):
    count += k
print(count)


# 1~10 다곱한 값 구하기
# 1x2x... x10 = ?
count1 = 1
for k in range(1, 11):
    count1 *= k
print(f'1~10 다곱한 값 {count1}')



# for 문에서 조건문 실행
# 한줄에 1~25 까지 5개씩 출력하기
'''
1 2 3 4 5
6 7 8 9 10
..
21 22 23 24 25
'''
for i in range(1,26):
    print(i, end=' ')
    if i%5==0:
        print()
print('-'*30, 'n'*2)

# 1 ~ 27 에서 5의 배수만 빼고 출력하기.
for i in range(1, 28):
    if i%5 == 0:
        continue
    print(i, end=' ')


print('\n', '-'*30, '\n'*2)

for i in range(1, 28):
    if i%5 ==0:
        break
    print(i, end=' ')


# 다중 for문
for i in range(0, 3):
    print('-'*30)
    for j in range(0, 3):
        print('Hello world')



# 다중 for 문을 이용하여 구구단 출력.
for i in range(1,10):
    for j in range(1, 10):
        print(f'{i} * {j} = {i*j}')



# 리스트 for = 리스트 내포
# 리스트 안에 for 문이 내포된 형태
# 결과값으로 구성된 리스트가 생성된다.
# 리스트변수 = [ 결과값 for 명령문 ]


# 1~10 까지 숫자로 이루어진 리스트를 만들어라.
numList1 = []
for i in range(1,11):
    numList1.append(i)
print(numList1)

numList2 = [i for i in range(1,11)]
print(numList2)



# 3단의 결과 값 만들어라.
numList3 = [(i*3) for i in range(1,10)]
print('numList3 = ', numList3)

# 3단의 결과값으로 -1 한 값으로 리스트를 만들어라.
numList3 = [(i*3)-1 for i in range(1,10)]
print('numList3 = ', numList3)


# 아래와 같은 형태로 리스트를 만들어라.
# ['*', '**', '***' ..., '**********']
numList5 = ['*'*i for i in range(1,11)]
print('numList5 = ', numList5)
for i in range(0, len(numList5)):
    print(numList5[i])
print('-'*30)
for i in range(0, len(numList5)):
    print(numList5[len(numList5)-1-i])


# 리스트 다중 for
# 리스트안에 이중 for 문이 있는 형태
# 구구단의 결과값을 리스트로 추가.
numList6 = []
for i in range(2,11):
    for j in range(1,10):
        numList6.append(i*j)
print('numList1 = ', numList6)
6

numList7 = [ i*j for i in range(2,11) for j in range(1,10)]
print('numList7 = ', numList7)




# p146 ~ 148 연습문제 풀기.

