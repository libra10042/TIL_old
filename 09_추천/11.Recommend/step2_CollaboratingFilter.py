# step2_CollaboratingFilter.py
import math

# 피타고라스 공식을 이용해 거리를 계산한다.
def sim(i, j) :
    return math.sqrt(pow(i, 2) + pow(j, 2))

# 사용자에 대한 유사도 계산
def use_sim(user_name, ratings) :
    # 정규화를 통해 유사도 범위를 0과 1사이에 두고,
    # 1에 가까울 수록 유사도가 높게 평가하기
    print('%s --------------------' % user_name)
    for name in ratings:
        if name != user_name:
            a1 = ratings[user_name]['범죄도시']
            a2 = ratings[name]['범죄도시']
            num1 = a1 - a2

            a3 = ratings[user_name]['샤인']
            a4 = ratings[name]['샤인']
            num2 = a3 - a4

            print(name, ":", 1 / (1 + sim(num1, num2)))

def step2_CollaboratingFilter() :
    ratings = {
        'Dave': {'달콤한인생': 5, '범죄도시': 3, '샤인': 3},
        'David': {'달콤한인생': 5, '범죄도시': 1, '샤인': 4},
        'Alex': {'범죄도시': 4, '샤인': 5},
        'Andy': {'달콤한인생': 2, '범죄도시': 1, '샤인': 5}
    }

    a1 = ratings['Alex']['범죄도시']
    a2 = ratings['Andy']['범죄도시']
    # print(a1)
    # print(a2)
    result1 = a1 - a2
    print(result1)

    a3 = ratings['Alex']['샤인']
    a4 = ratings['Andy']['샤인']
    result2 = a3 - a4
    print(result2)

    # 유사도 계산
    result3 = sim(result1, result2)
    # print('Alex와 Andy 의 유사도 :', result3)

    use_sim('Dave', ratings)
    use_sim('David', ratings)
    use_sim('Alex', ratings)
    use_sim('Andy', ratings)


