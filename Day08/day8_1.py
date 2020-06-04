# csv 임포트
import csv

# csv 파일쓰기 (데이타 기준)
# - 리스트 안에 리스트 => csv
# - 리스트안에 딕셔너리 => csv
# - 1행은 컬럼 제목용도로 사용 => Header

# -----------------------------------
# 리스트 데이타를 csv 파일 쓰기 1
# 리스트는 2차원이어야 한다. : 리스트 안에 리스트
# [[1행...], [2행...] ]

# 파일변수 = open(csv파일경로, 'w', newline='공백/\r',
#               encoding='uft-8/cp949')
# csv변수 = csv.writer(파일변수)
# for row in 리스트데이타변수:
#   csv변수.writerow(row)
# 파일변수.close()

# csv 파일에 저장될 2차원 리스트
# 1행은 제목용도
myList = [['이름','주소','전화번호'],
          ['김영희','부산시','010-6374-90874'],
          ['홍길동','춘천시','010-5463-9403'],
          ['성은희','서울시','010-4646-9403']]

# 행과 행사이에 공백 생성 : 디폴드값 : newline='\r'
# f = open('data/addr1.csv','w', encoding='cp949')
# 공백행없이 쓰기 : newline=''
f = open('C:/pyclass/data/addr1.csv','w', newline='', encoding='cp949')
csvline = csv.writer(f)
for row in myList:
    csvline.writerow(row)
print('파일쓰기가 완료되었습니다.')
f.close()

# --------------------------------
# 리스트 데이타를 기존 csv 파일에 추가하기
# 추가 데이타 리스트는 2차원이어야 한다. : 리스트 안에 리스트
# [[1행...], [2행...] ]

# 파일변수 = open(csv파일경로, 'a', newline='',
#               encoding='uft-8/cp949')
# csv변수 = csv.writer(파일변수)
# for row in 리스트데이타변수:
#   csv변수.writerow(row)
# 파일변수.close()

myList2 = [['이름','주소','전화번호'],
          ['이영희','부산시','010-6374-90874'],
          ['양수정','춘천시','010-5463-9403']]

f = open('C:/pyclass/data/addr1.csv', 'a', newline='')
csvline = csv.writer(f)
# 1행의 제목 헤더행은 제외하고 2행부터 추가
for row in myList2[1:]:
    csvline.writerow(row)
f.close()

# with 문 이용하여 파일 추가
with open('c:/pyclass/data/addr1.csv', 'a', newline='') as f:
    csvline = csv.writer(f)
    # 1행의 제목 헤더행은 제외하고 2행부터 추가
    for row in myList2[1:]:
        csvline.writerow(row)

# -------------------------
# 'data/population.csv' 파일에서 모든 데이타행을 추출해서
# 'data/population_11.csv' 파일로 11행만 쓰기

# 파일을 읽고 리스트안에 리스트 구조로 만들기
with open('c:/pyclass/data/population.csv', 'r') as f:
    csv_data = csv.reader(f)
    # for row in csv_data:
    #     print(row)

    # 리스트안에 리스트 구조로 저장하기
    list_pop = []
    for row in csv_data:
        list_pop.append(row)
    print(list_pop)

# 11개를 새로운 파일에 쓰기
f = open('c:/pyclass/data/population_11.csv','w', newline='')
csvline = csv.writer(f)
cnt = 1
for row in list_pop[:11]:
    csvline.writerow(row)
    print(f'{cnt} 행 쓰기')
    cnt+=1
print('population_11.csv 파일쓰기가 완료되었습니다.')
f.close()

# 'data/population.csv' 파일에서 모든 데이타행을 추출한 후
# 주(State)가 'S'로 시작하는 행만
# 'data/population_11.csv' 파일에 추가하기
with open('c:/pyclass/data/population_11.csv','a', newline='') as f:
    csvline = csv.writer(f)
    cnt = 1
    for row in list_pop:
        # row[0][0] : 주(State)의 첫글자
        if (row[0][0] == 'S'):
            csvline.writerow(row)
            print(f'{cnt} 행 쓰기 : {row[0]}')
            cnt+=1
    print('데이타 추가가 완료되었습니다.')

# 'data/population.csv' 파일에서
# 주(State)가 'W'이거나 'M'으로 시작하는
# 데이타 추가하기
with open('c:/pyclass/data/population_11.csv','a', newline='') as f:
    csvline = csv.writer(f)
    cnt = 1
    for row in list_pop:
        # row[0][0] : 주(State)의 첫글자
        if (row[0][0] == 'W') or (row[0][0] == 'M'):
            csvline.writerow(row)
            print(f'{cnt} 행 쓰기 : {row[0]}')
            cnt+=1
    print('데이타 추가가 완료되었습니다.')






# # -------------------------
# # csv.DictWriter 방식으로 파일쓰기
#
# f = open('data/names.csv', 'w')
#
# with f:
#     fnames = ['first_name', 'last_name']
#     writer = csv.DictWriter(f, fieldnames=fnames)
#
#     writer.writeheader()
#     writer.writerow({'first_name': 'John', 'last_name': 'Smith'})
#     writer.writerow({'first_name': 'Robert', 'last_name': 'Brown'})
#     writer.writerow({'first_name': 'Julia', 'last_name': 'Griffin'})
#
#
#
#
#
#
