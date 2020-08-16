# step5_surprise.py
# pip install surprise

import surprise
import pandas as pd

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

def data_to_dic ():
    # 사용자 목록을 담을 리스트
    name_list = []
    # 영화 목록을 담을 set
    movie_list = set()
    # 사용자의 수 만큼 반복한다.
    for user_key in ratings_expand :
        # 사용자의 이름을 담는다.
        name_list.append(user_key)
        # 현재 사용자가 본 영화 이름을 담는다.
        for movie_key in ratings_expand[user_key] :
            movie_list.add(movie_key)

    movie_list2 = list(movie_list)
    # print(name_list)
    # print(movie_list2)
    # 학습을 위해 사용할 데이터를 담을 딕셔너리
    rating_dic = {
        'user_id' : [],
        'item_id' : [],
        'rating' : []
    }

    for name_key in ratings_expand :
        for movie_key in ratings_expand[name_key] :
            a1 = name_list.index(name_key)
            a2 = movie_list2.index(movie_key)
            a3 = ratings_expand[name_key][movie_key]

            rating_dic['user_id'].append(a1)
            rating_dic['item_id'].append(a2)
            rating_dic['rating'].append(a3)

    return name_list, movie_list2, rating_dic

def step5_surprise() :
    # 데이터를 가져온다.
    name_list, movie_list, rating_dic = data_to_dic()
    # print(rating_dic)
    # 데이터 셋을 만든다.
    df = pd.DataFrame(rating_dic)
    # rating_scale : 데이터에 담긴 평점의 범위
    reader = surprise.Reader(rating_scale=(0.0, 5.0))
    # 딕셔너리에 담겨져 있는 리스트의 이름
    col_list = ['user_id', 'item_id', 'rating']
    data = surprise.Dataset.load_from_df(df[col_list], reader)
    # 학습 한다.
    trainset = data.build_full_trainset()
    option1 = {'name' : 'pearson'}
    algo = surprise.KNNBasic(sim_options=option1)
    algo.fit(trainset)

    # 소이현에 대해 영화를 추천받는다.
    index = name_list.index('소이현')
    result = algo.get_neighbors(index, k=3)

    for r1 in result :
        print(movie_list[r1 - 1])


def step5_surprise2() :
    # 사용할 영화 데이터 셋
    data = surprise.Dataset.load_builtin('ml-100k')
    # print(data)
    # print(data.raw_ratings)
    # df = pd.DataFrame(data.raw_ratings, columns=['user', 'item', 'rate', 'id'])
    # del df['id']
    # print(df)

    # 유사도 계산 방식을 설정
    # option1 = {'name' : 'msd'}
    # option1 = {'name' : 'cosine'}
    option1 = {'name' : 'pearson'}
    # 추천 목록을 만들기 위한 객체 생성
    algo = surprise.KNNBasic(sim_options=option1)
    # 학습한다.
    trainset = data.build_full_trainset()
    algo.fit(trainset)
    # 추천 목록을 가져온다.
    # k 추천받을 상품의 수
    result = algo.get_neighbors(196, k=5)

    for r1 in result :
        print(r1)
