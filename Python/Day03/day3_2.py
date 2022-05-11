# in / not in 연산자
# 아이템 in 그룹(튜플, 리스트, 문자열, 집합) => True/ False
# 아이템 not in 그룹(튜플, 리스트, 문자열, 집합) => True/ False



# 문자가 문자열에 있는가?
print('a' in 'banana') #True
print('a' in 'Python') #False


# 값이 리스트에 있는가?
myList = [100,200,300] #True
print(100 in myList) #False
print(1 in myList) #True


# if문에 in/not in 연산자 사용하기
# if item in group(리스트, 튜플, 문자열, 집합) :
#   명령문

# if item in group(리스트, 튜플, 문자열, 집합) :
#   명령문1
# else:
#   명령문2


singer1 = '지민'
singer2 = '카이'
bts = ['지민','RM', '슈가','진','정국', '뷔', '제이홉']
if singer1 in bts:
    print('{} : bts 멤버이다.'.format(singer1))

if singer2 not in bts:
    print('{} : bts 멤버가 아니다.'.format(singer2))



myClas = {'python','c', 'java', 'c++'}
print(myClas, type(myClas))

if '어셈블러' not in myClas:
    print('어셈블리 미수강')
if 'python' not in myClas:
    print('python 미수강')
else : 
    print('python 수강')



# if... elif..else.. 문에 in/not in 연산자 사용하기
# if item in group(리스트, 튜플, 문자열, 집합) :
#   명령문1
# elif item in group(리스트, 튜플, 문자열, 집합) :
#   명령문2
# else:
#   명령문3
t1 = ('바나나', '포도', '수박', '자두')
if '체리' in t1:
    print('체리가 우리집 냉장고에 있다.')
elif '포도' in t1:
    print('포도가 많이 우리집 냉장고에 있다.')
else :
    print('냉장고에 과일이 있다.')




# pass 키워드 이용하기
# 명령문의 일종으로 비실행
# 함수, 클래스 생성시 등록만 시킬때 사용.
pocket = ['paper', 'money', 'cellphone']
if 'money' in pocket:
    pass
else:
    print("카드를 꺼내라")



# 입력받은 데이터에 따라 양수, 음수, 숫자가 아니라 출력
# 입력받은 데이터가 0인 경우에는 메세지를 출력하지 않는다.
# 문자열변수.strip() : 좌우공백 삭제
myNumber = (input('데이터를 입력해주세요.').strip())

# 입력받은 데이터가 2글자 이상인 경우
# 첫번째 글자와 나머지 글자 찍기
if len(myNumber)>=2:
    print(myNumber[0], '\n\t', myNumber[1:])
print('-'*30)


if myNumber[0] =='-' and myNumber[1:].isdigit():
    print('음수')
elif myNumber =='0':
    pass
elif myNumber.isdigit():
    print('양수')
else :
    print('숫자가 아니다.')


