

# char(), ord() => 아스키 코드
# 유효성 검사 => True/False
# isdigit(), isalpha(), isalnum(), isnumeric(),
# islower(), isupper(), isdecimal()

# 정렬
# sort(), reverse(), sorted()             ..애네들을 적절히 활용하면 반복문이나 소스가 간랸화 된다.
# 별도의 Object로 생성 => 다른 함수, lambda 함수에 적용
# zip(), fillter(), map()
# 객체에 대한 속성과 메소드 표시
# dir()

# 내장함수 : 아스키코드와 관련된 함수
# char(), ord()
# char(숫자) => 아스키코드값에 해당하는 문자나 숫자
# 문자의 아스키 코드 값을 돌려주는 함수.
# 0에서 127 사이의 숫자를 각각 하나의 문자 또는 기호에 대응시켜 놓은 코드표
print(chr(65))  #'A'
print(chr(97))  # 'a'
print(chr(48))  # 0
print(ord('A'))  # 65
print(ord('a'))  # 97
print(ord('0'))  # 48


print('-'*30)

# 리스트 /튜플 등의 원소값이 False 값인지 True 값인지
# Boolean 형(True/ False)로 표시
# all(리스트/ 튜플/ 집합) : 값이 모두 True 조건이면 True
# any(리스트/ 튜플/ 집합) : 값중 하나라도 True 조건이면 True
# False 조건값 : None, 0, 0.0, '', False
listA = [0, False, '', ' ']
setB = {0, False, '', None, 0.0}
tupleC = (1, 2, 3, True, 'Yes')
print(any(listA)) #True
print(any(setB))  #False
print(any(tupleC)) #True
print(all(listA))  #False
print(all(setB))   #False
print(all(tupleC))  #True

print('-'*30)


# 유효성 검사?
# 데이터(숫자, 문자...)가 조건에 맞는지 검사하는 기능
# 문자열변수.isalpha()
# : 모두 문자(알파벳, 한글..)인가? 숫자문자제외, True/False
# 문자열변수.isdigit(), 문자열변수.isnumeric()
# : 모두 숫자문자인가? , True/ False
# 문자열변수.isalnum() : 문자열과 숫자로만 구성되어 있는가?
# islower(), isupper() : 대소문자/소문자 검사
# isdecimal() : 모두 10진수 인가?
str1 = 'fkfkfk'
str2 = '12345'
str3 = '1asdfsa1234'
str4 = 'BANANA'
str5 = '#$%^=+'
print(str1.isalpha())
print(str2.isalpha())
print(str3.isdigit())
print(str1.isdigit())
print(str2.isdecimal())
print(str5.isalpha()) # False... 특수문자는 alpha에 들어가지 않는다.



# 퀴즈 : 숫자로 구성된 리스트 생성. (길이는 5)
# 빈 리스트를 생성한다.
# 입력문이 실행된다.
# 입려값이 숫자이면 리스트에 추가한다.
# 입력값이 숫자가 아니면 다시 입력문이 실행된다.
# 리스트의 전체길이가 5이면 입력을 종료한다.
# 리스트를 출력한다.


# resultList = []
# while True :
#     data = input('데이터를 입력해주세요')
#
#     if data.isdigit() :
#         resultList.append(data)
#         print('리스트가 추가되었습니다.')
#     else:
#         print('숫자가 아닙니다. 다시 입력해주세요.')
#
#     if len(resultList) == 5 :
#         break
# print(resultList)


# 퀴즈 : 문자열에서 숫자와 숫자가 아닌 문자의 갯수를 출력하여라.
# testWord :
'''
숫자 갯수 ?
문자 갯수 ?
'''
# 문자열 변수 정의
# 숫자갯수를 저장할 변수 정의 : cnt
# 반복문 생성 : 문자열에서 숫자라면 : cnt += 1 값을 증가 시킨다.
# 숫자갯수 출력
# 문자갯수는? len(문자열변수)-cnt
testWord = 'Python1234Java4774'
cnt = 0 # 숫자갯수를 저장할 변수
for i in testWord:
    if i.isdigit():
        cnt += 1

print( '숫자 갯수 : ', cnt)
print( '문자 갯수 : ', len(testWord)-cnt)


# 사용자 정의 함수로 변경
def checkStringCount(word):
    cnt = 0
    for i in word:
        if i.isdigit():
            cnt += 1
    print('\nword : ' ,word)
    print('숫자갯수 : ', cnt)
    print('문자갯수 : ', len(word)-cnt)

checkStringCount('ajskfj123askdfj')


print('-'*30)

# 정렬과 관련된 내장함수.
# sorted(리스트/ 튜플/ 집합..)
# : 바로 인쇄 가능.  튜플과 집합은 정렬된 형태의 리스트로 변경.
# : 데이터 정렬
# : 결과값을 리턴한다. => print()로 바로 출력
# 리스트이름.sort() : 리스트 정렬
# 리스트이름.reverse() : 리스트 역정렬

myList =['b', 'a', 'c', 'x']
myTuple = ('b', 'a', 'c', 'x')
mySet = {'b', 'a', 'c', 'x'}
print(myList.sort()) #none 출력.
# 오류 발생 : AttributeError
# myTuple.sort()
print(myList) #['b', 'a', 'c', 'x']
myList.reverse()
print(myList) #['x', 'c', 'a', 'b']
#바로 출력 가능.
print(sorted(['b', 'a', 'c', 'x']))

print(sorted(['b', 'a', 'c', 'x']))
print(sorted(['b', 'a', 'c', 'x']))




print('*'*30)


myList = ['b', 'a', 'c', 'x']
print(myList.sort()) #None
myList.sort()
myList.reverse()
print(myList)
# # 바로 출력 가능.
print(sorted(['b', 'a', 'c', 'x']))  #['a', 'b', 'c', 'x']


print('-'*30)
# dir(자료형) => Reference 기능
# 사용가능한 속성과 함수를 리스트 구조로 표시
print(dir('String'))
print(dir(True))
print(dir(100))
print(dir([1, 2, 3, 4, 5]))
print(dir((1, 2, 3, 4, 5)))
print(dir({1:'하나' , 2:'둘'}))
print(dir({1, 2, 3, 4, 5}))
print('-'*10, '\n'*2)



#-------------------------#
# zip(리스트1, 리스트2..)
# zip 객체로 리턴 => for... in zip 문 이용해서 아이템 확인
# : 리스트의 각 아이템 요소를 튜플화 구조로 묶어준다.
# : [(아이템1, 아이템2)...]
# zip(*zip객체)
# : zip으로 묶어준 객체를 원래대로 풀어준다.

p1 = ['길동', '동미', '미영', '영철']
p1Gender = ['남', '여', '여', '남']

# zip 객체로 출력
print(zip(p1, p1Gender))
# <zip object at 0x00C50088>
# 하나씩 출력
for i in zip(p1, p1Gender):
    print(i)
# 각각 구분자로 분리해서 출력
for i, j in zip(p1, p1Gender):
    print(i, '-', j)
# 리스트화
print(list(zip(p1, p1Gender)))
#[('길동', '남'), ('동미', '여'), ('미영', '여'), ('영철', '남')]



# zip으로 리스트안의 튜플구조 해제하기 -unzip
# 변수1, 변수2 = zip(*리스트튜플이름)
# 결과물은 같은 인덱스의 값만 튜플로 다시 생성.
# 리스트 튜플 정의
myList2 = [('a', 'apple'), ('b', 'banana'), ('c', 'cat')]
print(myList2, type(myList2))
x,y = zip(*myList2)
print(x)
print(y)



# 딕셔너리 구조를 튜플 형태로 변경.
# 딕셔너리 = 키 리스트, 값 리스트 => zip => unzip 튜플
myDict = {'a':'africa', 'd' : 'drama', 'm' : 'movie'}
print(f'myDict = {myDict}, {type(myDict)}')
# 키 조합으로 리스트 생성.
print(list(myDict))#['a', 'd', 'm']

# 값만 조합으로 리스트 생성.
print(list(myDict.values())) #['africa', 'drama', 'movie']

# zip 객체로 변경한 후 하나씩 출력
print(zip(list(myDict), list(myDict.values())))
for i in zip(list(myDict), list(myDict.values())):
    print(i)
'''
<zip object at 0x03A51308>
('a', 'africa')
('d', 'drama')
('m', 'movie')
'''
# zip 객체의 리스트화 => 리스트 튜플
print(list(zip(list(myDict), list(myDict.values()))))   #[('a', 'africa'), ('d', 'drama'), ('m', 'movie')]

# unzip => 튜플
x,y = zip(*zip(list(myDict), list(myDict.values())))
print(x) #('a', 'd', 'm')
print(y) #('africa', 'drama', 'movie')


#----------------#
# filter(함수명/lambda 함수, 리스트/튜플),
# map(함수명/lambda 함수, 리스트/튜플),
# reduct(함수명/lambda 함수, 리스트 /튜플)
# 정의된 사용자정의함수, 람다함수를
# 리스트 데이타 각각 적용한다.

# filter()
# filter(함수명/ lambda 함수, 리스트/튜플)
# 사용할 함수는 결과값이 True/ False
# 함수를 적용하여 리스트/ 튜플의 data에서 True 인것만 Return
# => 참인 조건의 리스트만 출력

print('퀴즈:리스트 중 짝수만 출력하기')
# 퀴즈
# 리스트 중 짝수만 출력하기 = filter() 함수 이용
# 짝수인지 판독하는 함수 정의
# 리스트 정의
# filter() 함수 적용 => filter 객체
# filter 객체를 리스트화



# filter()를 사용하지 않은 경우 일반 함수 적용
def oddPrint(listName):
    resultList = []
    for i in listName:
        if i % 2 == 0:
            resultList.append(i)
    return resultList

print(f'짝수만 출력(일반함수) : {oddPrint([10, 30, 5, 8,19])}') #짝수만 출력(일반함수) : [10, 30, 8]
print('-'*30)

print('짝수만 출력(filter() 함수)')
# filter 함수에 사용할 함수 정의
# 리스트 각각의 요소에 정의할 함수
# 결과값은 True / False
def oddPrint2(n):
    if n%2 == 0:
        return True
print(oddPrint2((10)))  #True
print(filter(oddPrint2, [10, 30, 5, 9, 18])) #<filter object at 0x010DE0E8>
for i in filter(oddPrint2, [10, 30, 5, 9, 18]):
    print(i)
'''
10
30
18
'''
print(list(filter(oddPrint2, [10, 30, 5, 9, 18]))) #[10, 30, 18]
print('-'*30)

print('짝수만 출력(filter()와 lambda함수)')
# 함수변수 = lambda 인자:명령
# 함수변수(인자)
f_odd = lambda x : x%2 ==0
print('람다 호출 = ',f_odd(40)) #True
# filter(lambda 인자:명령, 적용할데이터리스트) => filter객체
print(filter(lambda x:x%2==0, [10, 30, 5, 9, 18])) #<filter object at 0x02BB8580>
print(list(filter(lambda x:x%2==0, [10, 30, 5, 9, 18]))) #[10, 30, 18]

for i in filter(lambda x:x%2==0, [10, 30, 5, 9, 18]):
    print(i)
'''
10
30
18
'''






print('\n퀴즈 : 숫자 리스트에서 양수만 출력하기')
# 양수인지 판독하는 함수 정의
numList = [10, -30, 20, 5, -100]
def positive_num(list):
    result =[]
    for i in list:
        if i>0 :
            result.append(i)
    return result
print(positive_num(numList)) #[10, 20, 5]


print('양수만 출력(filter() 함수)')
def positive(x):
    return x>0
print(positive(-10)) #False
print(positive(10)) #True


# filter() 함수 적용
print(filter(positive, numList)) #<filter object at 0x02B18598>
# 리스트화 : 양수만 출력
print(list(filter(positive, numList))) #[10, 20, 5]
# for...in 으로 출력
for i in filter(positive, numList):
    print(i)
'''   
10
20
5
'''
print('-'*30)

print('양수만 출력(filter(), lambda 함수')
f_positive = lambda x:x>0
print(f_positive(-7)) #False
print(f_positive(7)) #True

print(list(filter(lambda x:x>0, numList))) #[10, 20, 5]
for i in filter(lambda x:x>0, numList):
    print(i)
'''
10
20
5  
'''

print('\n 퀴즈 : 문자열에서 숫자만 리스트로 만들기')
message = 'asfas123가349나1다'
print('숫자만 출력(일반 함수)')
def numList(txt):
    result = []
    for i in range(0, len(txt)):
        if txt[i].isdigit():
            result.append(txt[i])
    return result
print(numList(message)) #['1', '2', '3', '3', '4', '9', '1']

print(filter(numList, message)) #<filter object at 0x035385C8>
print(list(filter(numList, message))) #['1', '2', '3', '3', '4', '9', '1']
for i in filter(numList, message):
    print(i, end =' ') #1 2 3 3 4 9 1

# 위의 일반 함수를 filter(함수명, 리스트)와
# filter(lambda 함수정의, 리스트) 형태로 변경하여 보세요
# 문자열을 리스트로 변경하기
# 문자 사이에 공백을 삽입하기  : ' '.join(문자열변수)
print(' '.join(message))
# 문자열에서 공백을 기준으로 리스트 생성.
# 문자열.split()
print(' '.join(message).split())
'''
1 2 3 3 4 9 1 a s f a s 1 2 3 가 3 4 9 나 1 다
['a', 's', 'f', 'a', 's', '1', '2', '3', '가', '3', '4', '9', '나', '1', '다']
'''


messageList = ' '.join(message).split()
print('숫자만 출력(filter() 함수)')
def digitPrint(c):
    return c.isdigit()
print(list(filter(digitPrint, messageList)))

print('숫자만 출력(filter(), lambda 함수)')
print(list(filter(lambda x:x.isdigit(), messageList )))



# map() 함수
# map(정의된 함수나 lambda함수, 데이타(리스트, 튜플))
# -> map오브젝트 생성.
# list(map(정의된함수, 데이타(리스트,튜플)))
# 데이타 요소를 정의된 함수의 결과값으로 리턴한다.
# 결과값을 리스트 요소로 추가.

print('\n퀴즈 : 리스트의 제곱을 구해서 새로운 리스트로 만들기')
numList2 = [1, 2, 3, 4]
# [1, 4, 9, 16]

print('제곱값으로 구성된 리스트 출력(일반 함수)')
# 제곱을 구하는 함수 정의
def power_fn1(list):
    result = []
    for i in list :
        result.append(i**2)
    return result
print(power_fn1(numList2))
# [1, 4, 9, 16]


print('제곱값으로 구성된 리스트 출력(map() 함수)')
# map() 사용할 제곱을 출력하는 함수 정의
def power_f2(value):
    return value**2
print(power_f2(3))  #9
print(map(power_f2, numList2)) #<map object at 0x013886D0>  ....map 오브젝트로 출력
# 리스트화 해서 출력
print(list(map(power_f2, numList2))) #[1, 4, 9, 16]

# print('제곱값으로 구성된 리스트 출력 (map(), lambda함수)')
f_multy = lambda x:x**2
print(f_multy(2)) #4
print(list(map(lambda x:x**2, numList2))) #[1, 4, 9, 16]

print('@'*30)
print('\n퀴즈 : 두 리스트에서 인덱스가 ''같은 값을 서로 곱한 후 리스트로 만들기')
list1 = [2,3,7]
list2 = [4,5,9]
# => [8, 15, 63]

def multyply_n(list1, list2):
    resultList = []
    for i in range(0, len(x)):
        resultList.append(list1[i]*list2[i])
    return resultList
print('인덱스가 같은 두 수 곱하기 (일반 함수)')
print(list1, list2, '\n => ', multyply_n(list1, list2))

print('인덱스가 같은 두 수 곱하기 (map함수)')
def multyply(x,y):
    return x*y
print(list1, list2, '\n => ', list(map(multyply, list1, list2)))  #[8, 15, 63]

print('인덱스가 같은 두 수 곱하기 (map(), lambda 함수)')
f_multy2 = lambda x,y:x*y
print(f_multy2(2,4))  #8
print(list1, list2, '\n=>', list(map(lambda x,y:x+y, list1, list2)))



print('!'*100)
# 문자열의 리스트화  (3.8 버전)
txt = "6473adf"
sampleList = txt.split()
print(sampleList, len(sampleList))




print('-'*30)

# reduce()
# 리스트의 요소에 함수를 적용해 1개의 결과를 리턴한다.
# reduce(람다나 정의한함수, 리스트나 튜플)
# 외장함수로 import functools 모듈 임포트 명령 필요
# 묘듈내의 함수 사용? = 별칭 지정.
# import functools as f
# f.reduce(옵션)

print('\n퀴즈 : 리스트의 모든 합 구하기')
# 1~10으로 구성된 리스트 생성 : range()
numlist3 = list(range(1,11))
print(numlist3) #[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print('\n일반함수 이용 ')
def sumList(list):
    sum = 0
    for i in list:
        sum += i
    return sum
print(sumList(numlist3)) #55
print('\nreduce() 이용')
import functools as f #모튤 임포트
def add(x,y):
    return x+y
print(f.reduce(add, numlist3))  #55

# print('\nreduce(), lambda 이용')
f_add = lambda x,y:x+y
print(f_add(1,2)) #3
print(f.reduce(lambda x,v:x+v, numlist3)) #55

