# 자료형의 종류
# 기본 자료형 - 문자열, 정수, 실수, 블린형
# 집합형 자료형 : 여러개의 구성요소로 조직화 p.72
#         : 리스트[], 튜프(), 딕셔너리{ }, 집합{ }

# CRUD : Create Read Update Delete

# 리스트
# 다른 데이터형 가능.
# 순차적으로 생성.
# 빈 리스트, 초기값 설정 방식.


# 초기값 설정 방식을 이용한 리스트 정의
# 리스트 변수 = [값1, 값2 ...]
fruits = ['사과','바나나', '포도']
print(fruits)
# 빈 리스트를 이용한 리스트 정의
# 리스트변수 =[]
movieList =[]
print()
myList = [True, 100, '홍길동']
print(f'myList= {myList}')


#리스트 인덱싱v
#리스트이름[숫자] : 0부터 시작, 숫자값이 -1 마지막 요소 표시
print(fruits[0], fruits[1]) #사과, 바나나
print(fruits[-1]) #포도


# 리스트 슬라이싱
# 리스트이름[start:end:step]
# 리스트이름[start:end]
# 리스트이름[start :]
# 리스트이름[:end]
# 리스트이름[::step]
# 리스트이름[::] = 전체리스트

numList =[0,1,2,3,4,5,6,7]
print(f'numList = {numList}')
print(f'numList = {numList[0:3]}')
print(f'numList = {numList[3:]}')
print(f'numList = {numList[::2]}')
print(f'numList = {numList[:4]}')
print(f'짝수번째만 출력하기 ={numList[1::2]}')


# 리스트 값 변경하기
# 리스트변수[인덱스] = 값
print(f'numList = {numList}')
numList[0] =100;
print(f'numList ={numList}')
'''
numList = [0, 1, 2, 3, 4, 5, 6, 7]
numList =[100, 1, 2, 3, 4, 5, 6, 7]
'''


# 리스트 연산
# 리스트1 + 리스트2 : 같이 표시
# 리스트이름 * 숫자 : 반복
movie =['알라딘', '엔드게임', '토이스토리']
drama =['남자친구', '으랴차차 와이키키2']
print('movie =%s' % movie)
print('drama =%s' % drama)
movieDrama = drama + movie
print('drama +movie = %s' %movieDrama)
print(drama * 3)
'''
movie =['알라딘', '엔드게임', '토이스토리']
drama =['남자친구', '으랴차차 와이키키2']
drama +movie = ['남자친구', '으랴차차 와이키키2', '알라딘', '엔드게임', '토이스토리']
['남자친구', '으랴차차 와이키키2', '남자친구', '으랴차차 와이키키2', '남자친구', '으랴차차 와이키키2']
'''


# 리스트 함수
# 리스트 변수.함수명(옵션)
# 정의된 리스트에 새로운 값 추가
# 리스트변수.append(값)   :  마지막에 값이 추가
# 리스트변수.insert(삽입위치, 값)   : 삽입위치에 아이템이 추가.
foods= ['라면']
print(f'foods ={foods}')
foods.append('김밥')
print(f'foods ={foods}')
foods.append('짬뽕')
print(f'foods ={foods}')

foods.insert(0, '냉면')
print(f'foods = {foods}')

# 리스트 삭제와 관련된 함수와 명령어
# 리스트변수.remove()  //값으로 삭제하기
# 리스트변수.pop()   // 마지막 요소가 삭제되면서 값이 반환된다.
# 리스트변수.pop(위치값) : 위치에 해당하는 요소가 삭제되면서 값이 반환된다.

# clear()   //삭제 : 리스트안의 값이 모두 삭제. 빈리스트로 된다.

# del 리스트변수 : 리스트 자체가 삭제된다.

numList2 = [1,2,3,4,5,6,7]
print(f'numList2 = {numList2}')
numList2.remove(3)
print(f'numList2 = {numList2}')
numList2.pop()                # 공란이면 마지막 값이 삭제된다.
print(f'numList2 = {numList2}')

print(f'numList2 삭제하는 값은?', numList2.pop(0))
print(f'numList2 = {numList2}')
numList2.clear()
print(f'numList2 ={numList2}')

print('-'*30)
#메모리에 리스트 없애기
#del numList2
# del 리스트변수[위치] = 리스트변수.pop(위치)

print(f'numList2 = {numList2}')

# 리스트 전체 길이 출력
# len(리스트변수)
# 리스트 데이터형 출력
# type(리스트 변수)
numList3 = [1,2,3,4,5,6,7]
print(f'numList3 = {numList3}')
print(f'numList3 전체길이는? = {len(numList3)}')
print(f'numList3 데이터형은? = {type(numList3)}')
print(f'numList3[0] 데이터형은? = {type(numList3[0])}')


# 입력받은 값으로 리스트를 생성하라.
# jobList = []
# print(f'jobList = {jobList}')
# jobList.append(input('데이터1 =>'))
# jobList.append(input('데이터2 =>'))
# jobList.append(input('데이터3 =>'))
#
# print(f'jobList = {jobList}')


# 리스트 값 정렬하기
# 리스트변수.reverse()
# 리스트변수.sort()
# 주의사항은 리스트를 이루는 구성요소의 데이터형은 같아야 한다.
# TypeError 발생.
sampleList1 = ['나','가','abc', '100']
sampleList2 = ['나',True, 'abc', 100]


print(f'sampleList1 = {sampleList1}')
sampleList1.sort()
print(f'sampleList1 = {sampleList1}')
sampleList1.reverse()
print(f'sampleList1 = {sampleList1}')
'''
sampleList1 = ['나', '가', 'abc', '100']
sampleList1 = ['100', 'abc', '가', '나']
sampleList1 = ['나', '가', 'abc', '100']
'''

# typeError 발생
# sampleList2.sort()
# sampleList1.revers()


# 리스트변수.count(값)
# 중복값은 몇개인가?
sampleList3 = [100, '나', 100, True, 'abc',100]
print(f'sampleList3 = {sampleList3}')
print(f'100은 몇번 중복되어 있는가? = {sampleList3.count(100)}')


# 리스트변수.index(값)
# 값에 해당하는 요소가 몇번째에 위치하고 있는가?
jobList2 = ['파이썬', 'DB', '플라스크']
print(f'jobList2 = {jobList2}')
print(f'DB의 인덱싱 값 = {jobList2.index("DB")}')


# 여러개의 요소를 한꺼번에 리스트에 추가하고 싶다면?
# 리스트변수.extend([값1, 값2])
jobList3 = ['공무원']
print(f'jobList3 = {jobList3}')
jobList3.extend(['회계사', '간호사'])
print(f'jobList3 = {jobList3}')
'''
jobList3 = ['공무원']
jobList3 = ['공무원', '회계사', '간호사']
'''