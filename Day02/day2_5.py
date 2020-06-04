# 딕셔너리
# CRUD : Create Read Update Delete
# 딕셔너리 생성 - 초기값 지정
# 딕셔너리변수 = {키1:값1, 키2:값2}
# 키값은 문자형, 숫자형 둘 다 가능.

dict1 = {100:'백', 200:'이백', 300:'삼백'}
dict2 = {'a' : 'africa', 'c':'cat', 'd':'drama'}
print(f'dict1 = {dict1}.{type(dict1)}')
print(f'dict2 = {dict2}.{type(dict2)}')
'''
dict2 = {'a': 'africa', 'c': 'cat', 'd': 'drama'}.<class 'dict'>
dict2 = {'a': 'africa', 'c': 'cat', 'd': 'drama'}.<class 'dict'>
'''

#딕셔너리 생성 - 빈 딕셔너리 생성 후 값 추가
dict3 = {}
print(f'dict3 = {dict3},{type(dict3)}')

# 딕셔너리 요소 추가   //add
# 딕셔너리변수[키값] = 값
dict3['st1'] = '홍길동'
print(f'dict3 = {dict3}, {type(dict3)}')
dict3[1] ='이영애'
print(f'dict3 = {dict3}, {type(dict3)}')
'''
dict3 = {},<class 'dict'>
dict3 = {'st1': '홍길동'}, <class 'dict'>
dict3 = {'st1': '홍길동', 1: '이영애'}, <class 'dict'>
'''

# 딕셔너리 요소 조회 : 인덱싱
# 딕셔너리변수[키값] => 해당요소의 값 표시
# print(f'dict3[\'tstr1\') = {dict3["st1"]}, {type(dict3["st1"])}')
# print(f'dict3[100] = {dict3[100]}, {type(dict3[100])}')
'''
dict3['tstr1') = 홍길동, <class 'str'>
dict3[1] = 이영애, <class 'str'>
'''
# 리스트, 튜플처럼 숫자 인덱싱이 가능할까?
# keyError : 딕셔너리는 키 값으로만 호출가능
# print(f'dict3[0] = { dicts[0]}')
#
# # 리스트, 튜플처럼 슬라이싱이 가능할까?
# # TypeError 발생. 딕셔너리는 슬라이싱이 불가능.
# print(f'dict3[0:2] = {dicts[0:2]}')

#딕셔너리 중복키는 가능할까요?
#값은 같아도 되지만 키값이 중복되면 마지막 키값만 유효하다.
dict4 = {'a' : 'africa', 'ab' : 'africa' ,'c':'cat', 'c':'coffee', 'd':'dry'}
print(f'dict4 = {dict4}')

print('-'*40)
# 딕셔너리 값 교체  //update
# 딕셔너리[키값] = 값
dict4['d'] = 'drama'
print(f'dict4 = {dict4}')
'''
dict4 = {'a': 'africa', 'ab': 'africa', 'c': 'coffee', 'd': 'drama'}
'''

print('-'*30)
print(f'dict4 = {dict4}')
dict4.pop('a')
print(f'dict4 = {dict4}')
del dict4['ab']
print(f'dict4 = {dict4}')
dict4.clear()
print(f'dict4 = {dict4}')
# del dict4
# NameError 발생.
# print(f'dict4 = {dict4}')
'''
dict4 = {'a': 'africa', 'ab': 'africa', 'c': 'coffee', 'd': 'drama'}
dict4 = {'ab': 'africa', 'c': 'coffee', 'd': 'drama'}
dict4 = {'c': 'coffee', 'd': 'drama'}
dict4 = {}
'''
# 딕셔너리 요소 삭제 //삭제
# 딕셔너리변수.clear()
# 딕셔너리변수.pop()
# del 딕셔너리변수
# del 딕셔너리변수[키값]


# 딕셔너리 함수
# 딕셔너리변수.values() : 값만 표시
# 딕셔너리변수.keys() : 키값만 표시
# 딕셔너리변수.items() : 튜플스타일로 표시(키, 값)....
dict5 = {'a' : 'africa', 'e' : 'africa', 'c' : 'coffee', 'd' : 'drama', 'y' : 'yes'}
print(f'dict5 = {dict5},{type(dict5)}')
print(f'dict5.values() = {dict5.values()},{type(dict5)}')
print(f'dict5.keys() = {dict5.keys()},{type(dict5)}')
print(f'dict5.items() = {dict5.items()}, {type(dict5)}')
'''
dict5 = {'a': 'africa', 'e': 'africa', 'c': 'coffee', 'd': 'drama', 'y': 'yes'},<class 'dict'>
dict5.values() = dict_values(['africa', 'africa', 'coffee', 'drama', 'yes']),<class 'dict'>
dict5.keys() = dict_keys(['a', 'e', 'c', 'd', 'y']),<class 'dict'>
dict5.items() = dict_items([('a', 'africa'), ('e', 'africa'), ('c', 'coffee'), ('d', 'drama'), ('y', 'yes')]), <class 'dict'>
'''




# 딕셔너리에서 키값만 리스트로 만들어서 마지막 키값 조회
keysList = dict5.keys()
print(f'keysList = {keysList}')
# TypeError발생
# print(f'keysList[-1] = {keysList[-1]}')
keysList = list(dict5.keys())     #바로 조회를 하지 못하고 딕셔너리는 list로 변경한 후에 조회해야 한다.
print(f'keysList[-1] ={keysList[-1]}')



# 캐스팅
# 딕셔너리 -> 리스트
# 리스트 -> 딕셔너리
dict6 = {'a' : 'africa', 's' : 'say', 'c' :'coffee', 'd' : 'drama', 'y' :'yes'}
# 값만 모아서 리스트로 생성.

dict6valuesList = list(dict6.values())  #객체로 만들어진 것을 list로 풀어 준다.
print(f'dict6ValuesList={dict6valuesList}')
print(f'dict6ValuesList 데이타형은? {type(dict6valuesList)}')
'''
dict6ValuesList=['africa', 'say', 'coffee', 'drama', 'yes']
dict6ValuesList 데이타형은? <class 'list'>
'''

# list(딕셔너리변수) => 키값만으로 생성된 리스트
dict6valuesList2 = list(dict6)
print(f'dictValuesList2 = {dict6valuesList2}')
# 결과 : dictValuesList2 = ['a', 's', 'c', 'd', 'y']







# 리스트 -> 딕셔너리(인덱싱숫자가 키값이 된다)  //리스트에서 딕셔너리로 바로 들어가지 못하고 enumerate를 해줘야 한다.
# 리스트 -> enumerate(리스트, 문자열, 튜플) -> dict(enumerate(리스트, 문자열, 튜플))
# dict()
# enumerate(리스트, 문자열, 튜플)
# : 리스트, 문자열, 튜플 같은 자료형을 enumerate 객체로 변환.
# enumerate 객체의 요소는 딕셔너리 스타일. 키값은 숫자로 표시
myList = ['Red', 'Blue', 'Green']
print(f'myList = {myList}')
# ValueError
# myDict = dict(myList)
temp = enumerate(myList)
print(f'temp = {temp}')
# temp = <enumerate object at 0x0308C0E8> 메모리에 올라가 있다.
# temp 요소 출력
# for i in temp:
#     print(i)
# '''
# (0, 'Red')
# (1, 'Blue')
# (2, 'Green')
# '''


for key, value in temp:
    print(f'key　{key}, value {value}')
'''
key　0, value Red
key　1, value Blue
key　2, value Green
'''

print(f'myDict = {myList}')
'''
myList = ['Red', 'Blue', 'Green']
'''



myList2 = ['Red', 'Blue', 'Green']
myDict2 = dict(enumerate(myList2))      #list에서 딕셔너리는 enumerate를 해주어야 한다.
print(f'myDict2 = {myDict2}')
print(f'myDict2 type = {type(myDict2)}')
'''
myDict2 = {0: 'Red', 1: 'Blue', 2: 'Green'}
myDict2 type = <class 'dict'>
'''


# 딕셔너리 -> 문자열
# str(딕셔너리변수) => {...}
# 구분자.join(딕셔너리변수) -> 키값으로 생성된 문자열
dict7 = {'a' : 'africa', 's' :'say', 'c':'coffee', 'd' :'drama', 'y' :'yes'}
print(f'dict7 = {dict7}')
print(f'문자열 변경은? {str(dict7)}')
print(f'문자열 변경은? {",".join(dict7)}')
'''
dict7 = {'a': 'africa', 's': 'say', 'c': 'coffee', 'd': 'drama', 'y': 'yes'}
문자열 변경은? {'a': 'africa', 's': 'say', 'c': 'coffee', 'd': 'drama', 'y': 'yes'}
문자열 변경은? a,s,c,d,y
'''

# 딕셔너리 -> 튜플
# tuple(딕셔너리) -> 키값으로 구성된 튜플 생성.
print(f'튜플 변경은? {tuple(dict7)}')
# 튜플 변경은? ('a', 's', 'c', 'd', 'y')
# 딕셔너리 값으로만 이루어진 튜플 생성.
print(f'dict7.values()? {tuple(dict7.values())}')
print(f'튜플 구조로 변경 => {tuple(dict7.values())}')
'''
튜플 변경은? ('a', 's', 'c', 'd', 'y')
dict7.values()? ('africa', 'say', 'coffee', 'drama', 'yes')
튜플 구조로 변경 => ('africa', 'say', 'coffee', 'drama', 'yes')
'''
print('-'*50)
# db에서 끌어와서 파이썬 자료로 변경하는 기술.
# 딕셔너리 리스트
# : 리스트안에 딕셔너리가 있는 구조
dictList = [{'a':'apple','v':'victory'},
            {100:'백'},{200:'이백'},
            {'user1' : '김철수', 'user2':'고소영'}]
print(f'dictList = {dictList}')
print(f'dictList[0] = {dictList[0]}')
# keyError 발생. 딕셔너리리스트명[인덱스위치][키값] 만 가능.
# print(f'dictList[0][0] = {dictList[0][0]}')
print(f'dictList[2][\'user1\'] = {dictList[2]["user1"]}')