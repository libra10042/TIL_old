# step3_Similarity.py
import math
# name1인 사용자와 name2인 사용자 간의 유사도를 계산
# 평균 제곱 차이 유사도
# 유사성이 높을 수록 0에 가깝고
# 유사성이 낮을 수록 1에 가깝다.
def sim_msd(data, name1, name2) :
    sum = 0
    count = 0
    # 사용자1에 대한 상품의 수만큼 반복한다.
    for movies in data[name1] :
        # 다른 사용자가 같은 영화를 봤다면
        if movies in data[name2] :
            sum += pow(data[name1][movies] - data[name2][movies], 2)
            count += 1

    return 1 / (1 + (sum / count))

# 코사인 유사도
# 유사도가 1에 가까울 수록 유사성이 높고
# 0에 가까울 수록 유사성이 낮다
def sim_cosine(data, name1, name2) :
    sum_name1 = 0
    sum_name2 = 0
    sum_name1_name2 = 0
    count = 0

    for movies in data[name1] :
        if movies in data[name2] :
            sum_name1 += pow(data[name1][movies], 2)
            sum_name2 += pow(data[name2][movies], 2)
            sum_name1_name2 += data[name1][movies] * data[name2][movies]

    return sum_name1_name2 / (math.sqrt(sum_name1) * math.sqrt(sum_name2))
# 피어슨 유사도
# 1에 가까울 수록 유사성이 높고
# -1에 가까울 수록 유성이 낮다
def sim_pearson(data, name1, name2) :

    avg_name1 = 0
    avg_name2 = 0
    count = 0
    for movies in data[name1] :
        if movies in data[name2] :
            avg_name1 += data[name1][movies]
            avg_name2 += data[name2][movies]
            count += 1

    avg_name1 = avg_name1 / count
    avg_name2 = avg_name2 / count


    sum_name1 = 0
    sum_name2 = 0
    sum_name1_name2 = 0
    count = 0

    for movies in data[name1]:
        if movies in data[name2]:
                sum_name1 += pow(data[name1][movies] - avg_name1, 2)
    sum_name2 += pow(data[name2][movies] - avg_name2, 2)
    sum_name1_name2 += (data[name1][movies] - avg_name1) * (data[name2][movies] - avg_name2)

    if (math.sqrt(sum_name1) * math.sqrt(sum_name2)) != 0 :
        return sum_name1_name2 / (math.sqrt(sum_name1) * math.sqrt(sum_name2))
    else :
        return 1



# data : 전체 데이터
# name : 기준이 되는 사람
# index : 유사성이 높은 사용자 중 가져올 상위 인원 수
# sim_function : 유사도 계산 함수
def top_match(data, name, index=3, sim_function=sim_pearson) :
    # 유사도 정보를 담을 리스트
    li = []

    for i in data :     # 모든 사용자만큼 반복
        if name != i :  # 자기 자신이 아닐 때만...
            a1 = sim_function(data, name, i)
            li.append((a1, i))

    li.sort()
    if sim_function != sim_msd :
        li.reverse()

    return li[:index]

def step3_Similarity() :
    ratings = {
        'Dave': {'달콤한인생': 5, '범죄도시': 3, '샤인': 3},
        'David': {'달콤한인생': 5, '범죄도시': 1, '샤인': 4},
        'Alex': {'범죄도시': 4, '샤인': 5},
        'Andy': {'달콤한인생': 2, '범죄도시': 1, '샤인': 5}
    }
    # Dave와 Andy의 유사도
    # 값이 낮을 수록 유사도가 높다.
    a1 = sim_msd(ratings, 'Dave', 'Andy')
    print("평균 제곱 차이 유사도 :", (1.0 - a1))
    # 값이 높을 수록 유사도가 높다.
    a2 = sim_cosine(ratings, 'Dave', 'Andy')
    print("코사인 유사도 :", a2)

    a3 = sim_pearson(ratings, 'Dave', 'Andy')
    print("피어슨 유사도 :", a3)

    a10 = top_match(ratings, 'Dave', 3, sim_msd)
    a11 = top_match(ratings, 'Dave', 3, sim_cosine)
    a12 = top_match(ratings, 'Dave', 3, sim_pearson)
    print(a10)
    print(a11)
    print(a12)