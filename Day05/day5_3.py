# 교재 p171
# 현재 작업 폴더 위치 확인하기
# python.exe 위치, 현재 파이썬 파일 정보 출력
import os
print('-'*30)
print(os.getcwd())
# 파일입출력
# 파일변수 = open(파일경로, 'r'/'w'/'a',
#                       encoding='utf-8/cp949'
# 파일변수.파일입출력함수(옵션)

# 파일 읽기
# 파일변수 생성
# 파일변수 = open(파일경로, 'r')
# 파일변수.read() : 파일전체 문자열 구조 => 문자열 
# 파일변수.readline() : 파일에서 첫줄만 읽기 => 문자열
# 파일변수.readlines() : 각행이 리스트 구조로 변경 => 리스트

# ---------------------
# 문서 읽기1 - 파일변수.read()
f = open('C:\pyclass/Day05/Yesterday.txt', 'r')
print(f)
print('$'*30)
# io 객체 출력 - 파일의 인코딩과 경로 확인
# 파일경로가 올바르지 않으면 FileNotFoundError
# 문서전체가 출력
data = f.read()
print(data, '\n\n', type(data))
# <class 'str'>
# 첫글자만 추출
print(f' 첫 글자 => {data[0]}') # 첫 글자 => Y
# 10글자만 추출
print(f' 10글자만 추출 = >{data[0:10]}')


# 문서는 몇개의 어구로 구성되어 있을까?
# 단어별로 구성해서 리스트 구조로 변경
# 문자열변수.split() => 공백기준으로 리스트로 변경
dataList = data.split()
# 3개만 출력
print(type(dataList))
print(dataList[:3])
print('단어 수? =>', len(dataList))
'''
<class 'list'>
['Yesterday,', 'all', 'my']
단어 수? => 133
'''

# 파일 닫기
# 파일변수.close()
f.close()
print('-'*30)
#------------
# 문서 읽기2 - 파일변수.readline()
# 파일변수 = open('파일경로', 'r')
# 첫번째 줄만 출력하기 -> 문자열
# 변수 = 파일변수.readline()

f = open('c:/pyclass/Day05/sample.txt', 'r')
data2 = f.readline()
print('\n\n 첫줄만 출력 : \n\n', data2, type(data2))
f.close


print('-'*100)
#------------- 가장 많이 사용한다.
# 파일 읽기 3 - readlines()
# 파일변수 = open('파일경로', 'r', 'encoding ='utf-8/cp949')
# 한줄씩 읽어서 리스트 요소로 저장
# 리스트이름 = 파일변수.readlines()
f = open('c:/pyclass/day05/sample.txt', 'r')
data3 = f.readlines()
print('\n 출력 : \n\n', data3, '\n', type(data3))
# 3개의 요소만 출력
print(data[0:3], '\n\n', type(data3))
# 리스트 요소 단위로 5줄만 출력하기
for i in data3[0:5]:
    print(i)
# 파일닫기
f.close()

print('-'*100)

# -----------------------
# 퀴즈
# 파일의 단어전체수와 3개의 단어가
# 표시되는 함수를 정의하여라.
# >> 함수호출
# printWord('c:/pyclass/Day05/sample.txt')
# >> 결과값
# 파일명 : c:/pyclass/Day05/sample.txt
# 단어 갯수 :134
# 단어 3개 출력
# ['Yesterday', 'All', 'my']

print('퀴즈 : 파일의 단어전체수와 3개의 단어만 출력하기')
def printWord(fileUrl, op):
    f = open(fileUrl, 'r', encoding=op)
    data = f.read()
    myList = data.split()
    print('-'*30)
    print('파일명 : ', fileUrl)
    print('단어 갯수 : ', len(myList))
    print('단어 3개 출력')
    print(myList[0:3])
    f.close()

printWord('c:/pyclass/Day05/data/sample.txt', 'cp949')




# 퀴즈
# data_eng.txt, data_kor.txt
# 파일안의 데이타의 합과 평균을 구하는
# 함수를 정의하고 아래와 같이 출력하여라.
# 함수 정의 => 파일 읽기 => 리스트화
# => 리스트의 값 더하기(숫자형 데이터로 변환) : 합
# => 합/ 리스트갯수 : 평균
#'''
# 함수 호출
# sumAvr('data/data_eng.txt', 'cp949')
# sumAvr('data/data_kor.txt', 'cp949')

#>> 결과
#
# 파일명 = data/data_eng.txt
# 데이터 수 = 12
# 합 = 892
# 평균 = 74.33
#
#'''
def sumAvr(fileUrl, op):
    f = open(fileUrl, 'r', encoding=op)
    dataList = f.readlines() # 리스트화
    total = 0
    # 합계 구하기
    for i in dataList:
        score = int(i) #데이터형 변경
        total += score

    # 평균 구하기
    avr = total/len(dataList)
    print('\n\n', '-'*10)
    print('파일명 = ', fileUrl)
    print('데이터 수 = ', len(dataList))
    print('합 =', total)
    print('평균 = %.2f'%(avr))
    f.close()

sumAvr('C:/pyclass/Day05/data/data_eng.txt', 'cp949')

sumAvr('C:/pyclass/Day05/data/data_kor.txt', 'cp949')
