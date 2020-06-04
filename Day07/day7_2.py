# CSV
# data 폴더에서 csv 파일 확인
# population.csv / data.csv /
# 한국교통안전공단_대중교통 이용자유형별 이용인원(2017년).csv
# => koreaTraffic.csv

# 공공데이타포탈
# https://www.data.go.kr/

# CSV란?
# Comma Seperate Value
# 콤마(,)로 데이타가 분리된 파일

# 내장 모듈 임포트
import csv

# CSV 파일 읽기
# 파일변수
#  = open('csv파일경로', 'r', encoding='utf-8/cp949')
# csv객체변수 = csv.reader(파일변수)
f = open('c:/pyclass/data/data.csv', 'r', encoding='utf-8')
csv_data = csv.reader(f)
print(csv_data, type(csv_data));
# <_csv.reader object at 0x010ED4F8>
# <class '_csv.reader'>
# csv 객체 출력 : csv파일에서 각행이 리스트로 생성
# for i in csv_data:
#     print(i, type(i))
# # 리스트안에 리스트구조로 변경
# # 주의 사항 : csv.reader(f) 는 한번만 읽어서 메모리에 로딩된다.
data_list = []
for i in csv_data:
    data_list.append(i)
print(data_list)
print(f' 전체 행의 갯수 크기 : {len(data_list)}') # 13

#
# for i in data_list:
#     print(i, '컬럼갯수', len(i))

# 첫번째 행은 ? => 컬럼 제목
# print(data_list[0])
# 1행1열 출력
# print(data_list[0][0])
# 마지막행의 마지막열 출력
print(data_list[-1][-1])

# kor, eng, mat, bio 과목의 데이터형 확인하기
print(type(data_list[-1][-1]))
# <class 'str'>

# 'kor' 데이타만 정수형 리스트로 생성하여라
#  1행은 제외 : 1행은 컬럼제목
korList = []
for i in range(1, len(data_list)):
    korList.append(int(data_list[i][2]))


# korList = []
# for i in range(1, len(data_list)):
#     korList.append(int(data_list[i][2]))
# kor 데이타 리스트 확인
print(korList)

# kor 과목의 총합과 평균을 구해라
print(f'kor 과목의 총점: {sum(korList)}')
print(f'kor 과목의 평균: {sum(korList)/len(korList)}')
print(f'kor 과목의 최고점: {max(korList)}')
print(f'kor 과목의 최하점: {min(korList)}')

# 퀴즈 :
# 4과목('kor', 'eng', 'mat', 'bio')의 총점 구하기
# 전체 평균 구하기

totalList = []
for i in range(1, len(data_list)):
    totalList.append(int(data_list[i][2])+int(data_list[i][3])+int(data_list[i][4])+int(data_list[i][5]))
print(totalList)
print(f'4과목의 총점은? {sum(totalList)}')
# round(값, 소숫점이하자릿수)
print('전체 평균은?',
      round((sum(totalList)/(4*len(totalList))),2))
# 4과목의 총점은? 3748
# 전체 평균은? 78.08

# 국어 점수의 최고점을 받은 학생의 이름은?
# 알고리즘
# 국어점수의 최고점을 구한다. max()
# 최고점의 인덱스를 구한다. 리스트이름.index()
# 인덱스를 학생이름인덱스에 삽입한다.
#  - 전체리스트[?]
#  - data_list[?][1]

print(f'kor 과목의 최고점: {max(korList)}')
print(f'kor 과목의 최고점의 인덱스는? {korList.index(max(korList))}')
num = korList.index(max(korList))
print(f'kor 과목의 최고점의 학생이름은? {data_list[num+1][1]}')
# kor 과목의 최고점: 100
# kor 과목의 최고점의 인덱스는? 8
# kor 과목의 최고점의 학생이름은? oscar

# 전체 총점이 가장 높은 학생의 이름은?
print(f'총점의 최고점: {max(totalList)}')
print(f'총점의 최고점의 인덱스는? {totalList.index(max(totalList))}')
num2 = totalList.index(max(totalList))
print(f'전체 총점이 가장 높은 학생이름은? {data_list[num2+1][1]}')
# 총점의 최고점: 362
# # 총점의 최고점의 인덱스는? 9
# # 전체 총점이 가장 높은 학생이름은? martin


# 파일닫기
f.close()

