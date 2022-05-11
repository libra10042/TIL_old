# csv 임포트
import csv

# 리스트안에 딕셔너리 => csv
# -----------------------------------
# 딕셔너리 리스트 데이타를 csv 파일 쓰기
# 파일 쓰기 용도의 데이타 구조는
# 딕셔너리 리스트 : 리스트안에 딕셔너리가 있는 구조
# [ {키1:값1, 키2:값2....},
#   {키1:값1, 키2:값2....} ... ]

# 파일변수 = open(csv파일경로, 'w', newline='공백/\r',
#               encoding='uft-8/cp949')
# 제목용도의 별도의 리스트 생성
# 키리스트변수 = [키1, 키2...]
# csv변수 = csv.DictWriter(파일변수, fieldnames=키리스트변수)
# 제목행쓰기
# csv변수.writeheader()
# for row in 리스트데이타변수:
#   csv변수.writerow(row)
# 파일변수.close()

# 딕셔너리 리스트
dict_list1 = [ {'first-name':'Jhon', 'last-name':'Smith'},
{'first-name':'Julia', 'last-name':'Brown'},
{'first-name':'Mike', 'last-name':'Kim'} ]
# 키 리스트 => 제목행의 필드명
field_list = ['first-name','last-name']

with open('c:/pyclass/data/names1.csv', 'w', newline='') as f:
    csvLine = csv.DictWriter(f, fieldnames=field_list)
    # 제목행 쓰기 : csv변수.writeheader()
    csvLine.writeheader()
    for row in dict_list1:
        csvLine.writerow(row)
    print('파일쓰기가 완료되었습니다.')

# ------------------------------
# 딕셔너리 리스트 데이타를 기존 csv 파일에 추가하기
# 파일변수 = open(csv파일경로, 'a', newline='',
#               encoding='uft-8/cp949')
# 제목용도의 별도의 리스트 생성
# 키리스트변수 = [키1, 키2...]
# csv변수 = csv.DictWriter(파일변수, fieldnames=키리스트변수)
# for row in 리스트데이타변수:
#   csv변수.writerow(row)
# 파일변수.close()

with open('c:/pyclass/data/names1.csv', 'a', newline='') as f:
    csvLine = csv.DictWriter(f, fieldnames=field_list)
    # 한행씩 추가하기
    # csv변수.writerow(딕셔너리)
    csvLine.writerow({'first-name':'Miranda', 'last-name':'Lee'})
    csvLine.writerow({'first-name':'Jeremy', 'last-name':'Kim'})
    print('파일에 데이타 추가가 완료되었습니다.')

    # -------------------------------------------
    # 'data/population.csv' 파일에서
    # 'data/population_22.csv' 파일로 11행만 쓰기
    # population.csv = > 리스트안에 딕셔너리 구조
    # 리스트안에 딕셔너리 구조 => population_22.csv
print('-'*30)
with open('c:/pyclass/data/population.csv', 'r') as f:
    csvData = csv.DictReader(f)
    # for row in csvData:
    #     print(row, type(row))
    # 파이썬 3.7
    # print(dict(row), type(dict(row)))
    # 딕셔너리 리스트로 생성
    dict_list2 = []
    for row in csvData:
        dict_list2.append(row)

    print(dict_list2)

    print(type(dict_list2), type(dict_list2[-1]))
    # <class 'list'> <class 'dict'>

# 리스트안에 딕셔너리 구조(dict_list2) => population_22.csv
# 키 리스트 => 제목행의 필드명
field_list2 = ['State','Population']

# 주(State)의 데이타값이 N으로 시작하는 행만 쓰기
with open('c:/pyclass/data/population_22.csv', 'w', newline='') as f:
    csvLine = csv.DictWriter(f, fieldnames=field_list2)
    csvLine.writeheader()
    cnt = 1
    for row in dict_list2:
        if row['State'][0] == 'N':
            csvLine.writerow(row)
            print(f'{cnt}행 추가 {row["State"]}')
            cnt+=1
    print('파일쓰기가 완료되었습니다.')

# -------------------------------------------
# 퀴즈1. data.csv 파일에서 class 필드명의 값이 1인
#        데이타만 별도 파일 data_class1.csv
#        저장하기
#       (저장할때 class 필드는 제외하고 저장)
#       (name, kor, eng, mat, bio)

# 퀴즈2. data.csv 파일의 데이타에
#       총점과 평균 필드를 추가하여 별도 파일에 저장
#       data_class2.csv
# (class name, kor, eng, mat, bio)
# (class name, kor, eng, mat, bio, total, avr)

with open('c:/pyclass/data/data.csv', 'r') as f:
    csvData = csv.DictReader(f)
    # 딕셔너리 리스트로 생성
    class1_list = []
    for row in csvData:
        if row['class'] == '1':
            class1_list.append(row)

    for row in class1_list:
        print(row)

    for row in class1_list:
        del row['class']

    for row in class1_list:
        print(row)


with open('c:/pyclass/data/data_class1.csv', 'w', newline='') as f:
    datafieldlist = ['name', 'kor', 'eng', 'mat', 'bio']
    csvLine = csv.DictWriter(f, fieldnames=datafieldlist)
    # 제목행 쓰기 : csv변수.writeheader()
    csvLine.writeheader()
    for row in class1_list:
        csvLine.writerow(row)
    print('data_class1.csv 파일쓰기가 완료되었습니다.')

print('-'*20)

with open('c:/pyclass/data/data.csv', 'r') as f:
    csvData = csv.DictReader(f)
    # for row in csvData:
    #     print(row, type(row))
    # 파이썬 3.7
    # print(dict(row), type(dict(row)))
    # 딕셔너리 리스트로 생성
    data_list = []
    for row in csvData:
        data_list.append(row)

    for row in data_list:
        row['total'] = (int(row['kor'])+int(row['eng'])+int(row['mat'])+int(row['bio']))
        row['avr'] = ((int(row['kor'])+int(row['eng'])+int(row['mat'])+int(row['bio'])))/4

    for row in data_list:
        print(row)


with open('c:/pyclass/data/data_class2.csv', 'w', newline='') as f:
    datafieldlist = ['class','name', 'kor', 'eng', 'mat', 'bio', 'total', 'avr']
    csvLine = csv.DictWriter(f, fieldnames=datafieldlist)
    # 제목행 쓰기 : csv변수.writeheader()
    csvLine.writeheader()
    for row in data_list:
        csvLine.writerow(row)
    print('파일쓰기가 완료되었습니다.')