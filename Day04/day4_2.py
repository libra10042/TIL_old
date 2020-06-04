# 함수 정의 8
# 가변인자의 경우 : 인자의 갯수가 정해지지 않는 경우
'''
def 함수명(*args):
    인자에 관련된 명령문...
    return 값/변수/수식/명령문
'''


# 호출
# 함수명(값1)
# 함수명(값1, 값2)
# 함수명(값1, 값2, 값3....)

# 학생의 이름을 출력한다.
def studentName(*args):
    print(f'수강학생 목록 : {args}, 데이터형은? {type(args)}')  # 가변일 때는 tuple로 만들어진다.
    print(f'첫번째 수강생 목록 : {args[0]}')


# studentName()
studentName('홍길동')
studentName('김동천', '한승우')
studentName('김동천', '한승우', '윤희욱')
'''
수강학생 목록 : (), 데이터형은? <class 'tuple'>
수강학생 목록 : ('홍길동',), 데이터형은? <class 'tuple'>
수강학생 목록 : ('김동천', '한승우'), 데이터형은? <class 'tuple'>
수강학생 목록 : ('김동천', '한승우', '윤희욱'), 데이터형은? <class 'tuple'>
'''
print('-' * 30)

# 가변인자 언어
# 퀴즈1. 위의 예제를 다음 형태로 변경하여라.
'''
1번 학생 : ?
2번 학생 : ?
...

studentName2('홍길동')
1번 학생 : 홍길동

studentName2('홍길동', '이순신')
1번 학생 : 홍길동
2번 학생 : 이순신

studentName2('홍길동', '이순신', '이몽룡')
1번 학생 : 홍길동
2번 학생 : 이순신
3번 학생 : 이몽룡
'''


def studentName2(*args):
    if len(args) == 0:
        return print('학생이 없습니다.')
    print('\n')
    # for i in range(0, len(args)):
    # print(f'{i+1}번째 학생 : {args[i]}')
    cnt = 0
    for i in args:
        cnt += 1
        print(f'{cnt}번째 학생 : {i}')


studentName2()
studentName2('홍길동')
studentName2('홍길동', '이순신')
studentName2('홍길동', '이순신', '이몽룡')

# 퀴즈2. n개의 숫자의 합을 구하는 가변함수를 정의하여라.
'''
sumNumber(1,2) => 1+2 =?
sumNumber(4,5,6) = >4,5,6 =?
'''


def sumNumber(*args):
    if len(args) == 0:
        return print('인자 값이 없다.')
    sum = 0
    for i in range(0, len(args)):
        sum += args[i]
    return print(f'누적합은? {sum}')


sumNumber()
sumNumber(1, 2)
sumNumber(4, 5, 6)


def sumNumber(*args):
    if len(args) ==0:
        return print('인자값이 없다.')
    sum = 0
    tempList = []
    for i in range(0, len(args)):
        sum +=args[i]
        tempList.append(str(args[i]))
    print(f'')

# '구분자'.join(리스트/튜플)
# => 문자열로 데이터형 변환. 구분자가 아이템 사이에 삽입
testList = ('1', '2', '3', '4')
print(' + '.join(testList))

# tuple로 반환되는 경우
# 1. parameter가 가변일 때
# 2. return 값이 여러개 일때.







# 함수 정의 9
# 인자랑 가변인자가 함께 있는 경우.
'''
def 함수명(인자, *args):
    명령문...
    return 값/변수/수식/명령문
'''
# 호출
# 함수명(인자값, 가변값1)
# 함수명(인자값, 가변값1, 가변값2...)



def printSymbolNumber(symbol, *args):
    return print(f'{symbol} // {args}')
printSymbolNumber('##', 10)
printSymbolNumber('$$$$', 10, 20, 30)
'''
## // (10,)
$$$$ // (10, 20, 30)
'''



# choice 값에 따라서 뒤의 가변인자값을 계산하여라.

# def calChoice(계산기호인자, *args):
#   if 계산기호인자 == *:
#       명령문1
#   elif 계산기호인자 == +:
#       명령문2
#   else:
#       명령문3

# calChoice('*', 20,30)
# 계산결과 : 곱 : 600
# calChoice('+', 20,30,50)
# 계산결과 : 합 : 100


def calChoice(a, *args):
    if a == '*':
        result = 1
        for i in range(0, len(args)):
            result *= args[i]
        return print(f'계산결과 : 곱 : {result}')
    elif a =='+':
        result = 0
        for i in range(0, len(args)):
            result += args[i]
        return print(f'계산결과 : 합 : {result}')
    else :
        print('오류입니다.')










# def calChoice(a, *args):
#     if a == '*':
#         result = 1
#         for i in range(0, len(args)):
#             result *= args[i]
#         return print(f'계산결과 = 곱 : {result} ')
#     elif a == '+':
#
#         result = 0
#         for i in range(0, len(args)):
#             result += args[i]
#         return print(f'계산결과 = 합 : {result}')
#     else:
#         print('오류입니다.')
#
# calChoice('*', 20, 30)
# calChoice('+', 20, 30, 50)




