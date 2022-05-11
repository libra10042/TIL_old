import csv

# with문을 이용하여 CSV 파일 읽기
# with open('csv파일경로', 'r', encoding='utf-8/cp949') as 파일변수:
#   csv객체변수 = csv.reader(파일변수)


with open('c:/pyclass/data/population.csv', 'r') as f:
    csv_data = csv.reader(f)
    print(csv_data, type(csv_data));


    print('-'*30);
    # 행단위로 출력하기
    # for row in csv_data:
    #     print(row)

    # 리스트 구조로 변경하기
    result_list = [];
    for i in csv_data:
        result_list.append(i)

    print(result_list)
    print(len(result_list)) # 행수 - 52
    print(len(result_list[0])) # 열수 - 2

    # 1행은 컬럼 제목이므로 삭제한 후 다른 리스트에 복사
    result_list2 = result_list[1:]
    print(len(result_list2)) # 행수 - 51

    # 1컬럼은 미국 주 데이타 => state_list
    # state_list를 정렬시켜라
    state_list = []
    for i in result_list2:
        state_list.append(i[0])

    print(state_list)
    # ['Alabama', 'Alaska', 'Arizona',
    # 'Arkansas', 'California', 'Colorado',
    # 'Connecticut', 'Delaware', 'District of Columbia',
    # 'Florida', 'Georgia', 'Hawaii', 'Idaho',
    # 'Illinois', 'Indiana', 'Iowa', 'Kansas',
    # 'Kentucky', 'Louisiana', 'Maine', 'Maryland',
    # 'Massachusetts', 'Michigan', 'Minnesota',
    # 'Mississippi', 'Missouri', 'Montana', 'Nebraska',
    # 'Nevada', 'New Hampshire', 'New Jersey',
    # 'New Mexico', 'New York', 'North Carolina',
    # 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon',
    # 'Pennsylvania', 'Rhode Island', 'South Carolina',
    # 'South Dakota', 'Tennessee', 'Texas', 'Utah',
    # 'Vermont', 'Virginia', 'Washington',
    # 'West Virginia', 'Wisconsin', 'Wyoming']

    # 역순 정렬
    state_list.reverse()
    print(state_list)

    # 퀴즈0. 인구컬럼만 정수리스트로 새로 만들어라
    # '4,780,131' => 4780131
    # 콤마(,) 삭제한다. replace(',','')
    # int()

    population_list = []
    for i in result_list2:
        # population_list.append(i[1])
        # population_list.append(i[1].replace(',',''))
        population_list.append(int(i[1].replace(',','')))

    # print(population_list)
    # for i in range(0, len(population_list)):
    #     temp = population_list[i].replace(',','')
    #     population_list[i] = temp
    print(population_list)

    print(type(population_list[0])) # <class 'int'>

    # 퀴즈1 . 가장 많은 인구수는? max()
    print(max(population_list)) # 37254522
    # 퀴즈2 . 가장 작은 인구수는? min()
    print(min(population_list)) # 563767
    # 퀴즈3. 가장 인구가 많은 주(State)는?

    # 가장많은인구수의 인덱스 구하기
    max_pop = population_list.index(max(population_list))
    # state_list.sort()
    # print(state_list[population_list.index(max(population_list))])
    print(result_list2[max_pop][0])
    # California
    # 퀴즈4. 가장 인구가 적은 주(State)는?
    # 가장많은인구수의 인덱스 구하기
    min_pop = population_list.index(min(population_list))
    # print(state_list[population_list.index(min(population_list))])
    print(result_list2[min_pop][0])
    # Wyoming

# ordered dict 형태로 데이터 불러오기

# 파일변수 = open('csv파일경로', 'r', encoding='utf-8/cp949')
# csv객체변수 = csv.DictReader(파일변수)

# with open('csv파일경로', 'r', encoding='utf-8/cp949') as 파일변수:
#   csv객체변수 = csv.DictReader(파일변수)

with open('c:/pyclass/data/koreaTraffic.csv', 'r') as f:
    # csv_data = csv.reader(f)
    csv_data = csv.DictReader(f)
    print(csv_data, type(csv_data));
    # <csv.DictReader object at 0x02D90190>
    # <class 'csv.DictReader'>

    # 행별 구조는 딕셔너리
    # for row in csv_data:
    #     print(row, type(row))

    # {'구분': '서울', '일반인': '3711168', '어린이': '36098', '청소년': '259128', '기타': '417539'}
    # <class 'dict'>

    # 컬럼명 = 키값 으로 접근하기
    # for row in csv_data:
    #     print(row['구분'],' / ', row['일반인'], ' / ',
    #           type(row['일반인']))
    print('-'*30);
    # 일반인 사용자의 가장 작은 값은?
    list1 = []
    list2 = []
    for row in csv_data:
        list1.append(int(row['일반인']))
        list2.append(row['구분'])
    print(list1)
    print(type(list1[0]))
    print(min(list1))

    # 일반인 사용자가 가장작은 값의 인덱스는?
    print(list1.index(min(list1)))
    # 7

    # 일반인 사용자가 가장 적은 도시는?
    print(list2)
    print(list2[list1.index(min(list1))])
    # 세종

# 일반인+청소년+어린이 합해서 지역별 사용자 구하기
with open('c:/pyclass/data/koreaTraffic.csv', 'r') as f:
    csv_data = csv.DictReader(f)
    list_city = []
    list_user = []
    for row in csv_data:
        list_city.append(row['구분'])
        list_user.append(int(row['일반인'])+
                         int(row['어린이'])+
                         int(row['청소년']))

    print(list_city, type(list_city))
    print(list_user, type(list_user))

    # 제주 사용자의 총 데이타값 출력 ?
    print('제주 인덱스 =>', list_city.index('제주'))
    print('제주의 사용자수 =>',
          list_user[list_city.index('제주')])

    # 딕셔너리 구조로 변경하기
    # {도시명:인구사용자총수, ...}
    # 빈 딕셔너리 만들기
    korea_traffic_dict = {}
    for i in range(0, len(list_city)):
        # 딕셔너리변수[키] = 값
        korea_traffic_dict[list_city[i]] = list_user[i]
    print(korea_traffic_dict)
    # {'서울': 4006394, '부산': 952394,
    # '대구': 547517, '인천': 716825,
    # '광주': 242717, '대전': 262872,
    # '울산': 152289, '세종': 22677,
    # '경기': 2816335, '강원': 84879,
    # '충북': 117371, '충남': 148303,
    # '전북': 118447, '전남': 120123, '경북': 165815,
    # '경남': 253772, '제주': 63008}

    # 강원 사용자의 총 데이타값 출력?
    print(korea_traffic_dict['강원'])

    # 퀴즈 1) 시도대학별기업규모에따른취업자수.csv (aaa.csv)
    #         파일 읽기
    #         day7 번 클라우드 참조

with open('c:/pyclass/data/aaa.csv', 'r') as a:
    a_data = csv.reader(a)
    print(a_data)
# {'서울': 4006394, '부산': 952394, '대구': 547517, '인천': 716825, '광주': 242717, '대전': 262872, '울산': 152289, '세종': 22677, '경기': 2816335, '강원': 84879, '충북': 117371, '충남': 148303, '전북': 118447, '전남': 120123, '경북': 165815, '경남': 253772, '제주': 63008}
    a_list = []
    for i in a_data:
        a_list.append(i)
    print(a_list)

    # 퀴즈 2) 1000명 이상인 회사에 들어간 취업자수가
    #        가장 많은 도시는?
    print(max(a_list[1]))

    # 퀴즈 3)
    #        딕셔너리로 만들기
    #        {'지역명':'분석대상자수'...}





