# 함수 정의 10
# 딕셔너리 가변인자 **kwargs
# 가변인자는 키 = 값
# 결과 데이터형이 딕셔너리

'''
def 함수명(**kwargs):
    kwargs를 명령문...
    return 값/변수/수식/명령문
'''

# 호출
# 함수명(키1 = 값1)
# 함수명(키1 = 값1, 키2, 값3 ...)

def printDict(**kwargs):
    return print(kwargs)

printDict(key1 ='키1')
printDict(key1 = '키1', key2 = '키2')
'''
{'key1': '키1'}
{'key1': '키1', 'key2': '키2'}
'''
print('-'*30)

def printDict2(**kwargs):
    print('kwargs[key1] = {key1}'.format(**kwargs))
    print('kwargs[key2] = {key2}'.format(**kwargs))
    print(f'kwargs[key1] = {kwargs["key1"]}')
# printDict2(key1 ='키1')
printDict2(key1 ='키1', key2 = '키2')

print('-' * 30)

def printDict3(**kwargs):
    for key in kwargs:
        print(f'{key} : {kwargs[key]}')
printDict3(key1 ='키1')
# key1 : 키1
printDict3(key1 ='키1', key2 ='키2')
# key1 : 키1

# 함수 정의 11
# 초기 값이있는 딕셔너리 가변인자 **kwargs
# 가변인자는 키 = 값
# 결과 데이터형 딕셔너리
'''/=
def 함수명(**kwargs):
    # 초기값 지정.
    kwargs[키값] = 값
    kwargs를 명령문...
    return 값/변수/수식/명령문
'''




# 호출
# 함수명(키1=값1)
# 함수명(키1=값1 , 키2=값3....)
'''
st1 = {'nationality' :'USA', 'age' : 33, 'name' 'Jackson'}
st2 = {'nationality' :'USA', 'age' : 2, 'name' 'maria'}
'''


# nationality 값이 고정.
def makePerson(**kwargs):
    kwargs['nationality'] = 'USA'
    # return print(kwargs)
    # cnt
    print('-' * 20)
    for key in kwargs:
        print(f'{key} = {kwargs[key]}')


makePerson(age =33, name = 'Jackson')
makePerson(age = 33, name = 'maria')

makePerson(age = 13, name = 'Sopia', nationality = 'Spain')
'''
age = 13
name = Sopia
nationality = USA        //고정
'''


# 아이템이 in 그룹 / 아이템 not in 그룹
print('a' in 'banana') # True
print('a' not in 'banana') # False


# nationality 값이 함수 호출시 전달되는 값으로 변경.
def makePerson2(**kwargs):
    if 'nationality' not in kwargs:
        kwargs['nationality'] = 'USA'
    # return print(kwargs)
    # cnt
    print('-' * 20)
    for key in kwargs:
        print(f'{key} = {kwargs[key]}')

makePerson2(age =33, name ='Jackson')
makePerson2(age = 13, name = 'Sopia', nationality = 'Spain')
'''
age = 13
name = Sopia
nationality = Spain
'''




# 함수정의 12
# 람다 함수
# def 로 정의하지 않는다.
# 한줄로 정의한다. 
'''
# 람다함수 정의
함수변수 = lambda 인자:명령

# 람다함수 호출
함수변수(인자)
'''

# 문자열을 특정 단어와 결합해서 출력한다.
def printWord(m):
    return 'Message => ' + m
print(printWord('오늘도 좋은 하루'))
#Message => 오늘도 좋은 하루

f1 = lambda message:('Message lambda=>' + message)
print(f1('좋은 하루되세요'))
# Message lambda => 좋은 하루되세요


# 두수의 합을 출력한다.
f2 = lambda x,y:print(f'{x} + {y} = {x+y}')
f2(30, 100)
# 30 + 100 = 130

print('-'*30)



# 함수의 변수 영역
# 스코프(Scope)
# 전역변수(문서 전체의 공통변수)?
# 지역변수(함수 내부에만 유효한 변수)?

# 함수내에서 지역변수를 전역변수로 정의
# global 변수명 = 값
v = 10  # 전역변수
w = 200
def scopeTest():
    v = 100 # 지역변수
    global w  # 전역변수 정의
    print(f'함수안의 v = {v}')
    print(f'함수안의 w = {w}')
    w = 400

print(f'함수밖의 v = {v}') # 함수밖의 v =10
print(f'함수밖의 w = {w}') # 함수밖의 w = 200
scopeTest()
# 함수안의 v =100
# 함수안의 v =200
print(f'함수밖의 v = {v}') # 함수밖의 v =10
print(f'함수밖의 w = {w}') # 함수밖의 w =400