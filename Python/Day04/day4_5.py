# 수학관련 내장 함수
# 절대값 출력 : abs(숫자)
# 최대값 리턴 : max(리스트/튜플/집합...)
# 최소값 리턴 : min(리스트/튜플/집합...)


num = -10
print(f'{num}의 절대값은 {abs(num)}')
numList = [100, 45, 20, 40, 500]
print(f'{numList}의 최대값은 {max(numList)}')
print(f'{numList}의 최대값은 {min(numList)}')
'''
-10의 절대값은 10
[100, 45, 20, 40, 500]의 최대값은 500
[100, 45, 20, 40, 500]의 최대값은 20
'''


numList2 = (100, 45, 20, 40, 500)
print(f'{numList2}의 최대값은 {max(numList2)}')
print(f'{numList2}의 최솟값은 {min(numList2)}')


# 나누기 연산자 /, //
# 나머지 연산자 %
# divmod(n1, n2) => 몫과 나머지 값을 구한다. => 튜플
print(f'divmod(55,2) = {divmod(55,2)}, 데이터형 = {type(divmod(55,2))}')
# print(f'divmod(55,2) = {divmod(55,2)},
#           데이터형 = { type(divmod(55,2))}')
'''
divmod(55,2) = (27, 1), 데이터형 = <class 'tuple'>
'''

print(f'몫 = {divmod(55,2)[0]}')
print(f'나머지 = {divmod(55,2)[1]}')
'''
몫 = 27
나머지 = 1
'''




# enumerate(리스트/튜플/문자열, 인덱스 숫자)
# 인덱스숫자로 구성된 리스트/튜플/문자열
# => emumerate 객체 생성.
# => for... in 하나씩아이템 출력 가능
# => 각각 튜플아이템으로 생성(인덱스 값)
listA = ['a', 'b', 'c']
enumResult = enumerate(listA, 1)
print(enumResult, type(enumResult))
#<enumerate object at 0x01642FA8> <class 'enumerate'>

for i in enumResult:
    print(i)
'''
(1, 'a')
(2, 'b')
(3, 'c')
'''



# enumResult => 딕셔너리 구조로 변경.
# dict(enumerate(리스트/문자열/튜플, 인덱싱번호))
enumResult2 = enumerate(listA, 5)
print(dict(enumResult2), type(dict(enumResult2)))
# {5: 'a', 6: 'b', 7: 'c'} <class 'dict'>


enumResult3 = enumerate(listA, 0)

for i, j in enumResult3:
    print(f'{i} => {j}')
    '''
0 => a
1 => b
2 => c
    '''

# eval (문자열계산식)
# 입력받은 수식을 계산하여라.
# result = input('수식을 입력하세요? ...')
# print(result, ' = ', eval(result))
# print(result, ' = ', result)
# '''
# 1+3+50  =  54
# 1+3+50  =  1+3+50
# '''



# 5개의 값을 입력문을 이용하여 리스트로 저장한 후
# 최대값과 최소값을 출력한다.
# 빈 리스트 생성.
inList =[]
for i in range(0, 5):
    temp = int(input('숫자를 입력하세요'))
    inList.append(temp)

print(f'{inList}의 최대값은 {max(inList)}')
print(f'{inList}의 최소값은 {min(inList)}')