# step4_kNNRecomendation.py
from step3_Similarity import *

ratings_expand = {
    '마동석': {
        '택시운전사': 3.5,
        '남한산성': 1.5,
        '킹스맨:골든서클': 3.0,
        '범죄도시': 3.5,
        '아이 캔 스피크': 2.5,
        '꾼': 3.0,
    },
    '이정재': {
        '택시운전사': 5.0,
        '남한산성': 4.5,
        '킹스맨:골든서클': 0.5,
        '범죄도시': 1.5,
        '아이 캔 스피크': 4.5,
        '꾼': 5.0,
    },
    '윤계상': {
        '택시운전사': 3.0,
        '남한산성': 2.5,
        '킹스맨:골든서클': 1.5,
        '범죄도시': 3.0,
        '꾼': 3.0,
        '아이 캔 스피크': 3.5,
    },
    '설경구': {
        '택시운전사': 2.5,
        '남한산성': 3.0,
        '범죄도시': 4.5,
        '꾼': 4.0,
    },
    '최홍만': {
        '남한산성': 4.5,
        '킹스맨:골든서클': 3.0,
        '꾼': 4.5,
        '범죄도시': 3.0,
        '아이 캔 스피크': 2.5,
    },
    '홍수환': {
        '택시운전사': 3.0,
        '남한산성': 4.0,
        '킹스맨:골든서클': 1.0,
        '범죄도시': 3.0,
        '꾼': 3.5,
        '아이 캔 스피크': 2.0,
    },
    '나원탁': {
        '택시운전사': 3.0,
        '남한산성': 4.0,
        '꾼': 3.0,
        '범죄도시': 5.0,
        '아이 캔 스피크': 3.5,
    },
    '소이현': {
        '남한산성': 4.5,
        '아이 캔 스피크': 1.0,
        '범죄도시': 4.0
    }
}

# 상품 추천 함수
def getRecommendation(data, person, k=3, sim_function=sim_pearson) :
    # 현재 사용자와 다른 사용자들 간의 유사도 값을
    # 가져온다.
    result = top_match(data, person, k, sim_function)

    score = 0       # 평점 합을 담을 변수
    li = list()     # 리턴값. 추천 상품
    score_dict = dict()     # 유사도 총합을 위한 dic
    sim_dic = dict()        # 평점 총합을 위한 dic

    # 받아온 사용자간의 유사도 만큼 반복한다.
    for sim, name in result :
        # 유사도가 0보다 작으면 그냥 통과
        if sim < 0 :
            continue
        # 현재 비교 대상이 되는 사람이 본 영화만큼
        # 반복한다.
        for movie in data[name] :
            # 이 영화를 기준이 된 사람이 본 영화가
            # 아니라면 유사도의 누적합을 구한다.
            score += sim * data[name][movie]
            score_dict.setdefault(movie, 0)
            score_dict[movie] += score
            # 계산에 사용된 유사도 값을 누적한다.
            sim_dic.setdefault(movie, 0)
            sim_dic[movie] += sim

        score = 0

    # 추천 목록을 만든다.
    for key in score_dict :
        # 유사도와 계산된 평점 총합 / 유사도 총합
        score_dict[key] = score_dict[key] / sim_dic[key]
        li.append((score_dict[key], key))

    li.sort()
    li.reverse()
    return li



def step4_kNNRecomendation() :
    # 소이현에 대한 영화 추천 목록
    a1 = getRecommendation(ratings_expand, '소이현', k=3, sim_function=sim_msd)
    a2 = getRecommendation(ratings_expand, '소이현', k=3, sim_function=sim_cosine)
    a3 = getRecommendation(ratings_expand, '소이현', k=3, sim_function=sim_pearson)

    print(a1)
    print(a2)
    print(a3)