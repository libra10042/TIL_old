# step1_Popularity.py
import operator

def step1_Popularity() :
    # 데이터
    ratings = {
        'Dave' : {'달콤한인생':5,'범죄도시':3,'샤인':3, '뽀롱뽀롱뽀로로':2, '머털도사':1},
        'David' : {'달콤한인생':5,'범죄도시':1,'샤인':4, '뽀롱뽀롱뽀로로':1, '머털도사':4},
        'Alex' : {'달콤한인생':0,'범죄도시':4,'샤인':5, '뽀롱뽀롱뽀로로':5, '머털도사':2},
        'Andy' : {'달콤한인생':2,'범죄도시':1,'샤인':5, '뽀롱뽀롱뽀로로':3, '머털도사':5}
    }

    # 영화 정보를 담을 딕셔너리를 만든다.
    movie_dic = dict()

    # 사용자의 수 만큼 반복한다.
    for key1 in ratings :
        # 각 사용자별 영화 목록만큼 반복한다.
        for key2 in ratings[key1] :
            # 영화 평점 데이터를 누적한다.
            if key2 not in movie_dic :
                movie_dic[key2] = ratings[key1][key2]
            else :
                movie_dic[key2] += ratings[key1][key2]

    print(movie_dic)
    # 누적된 평점 총합의 평균을 구한다.
    keys = movie_dic.keys()
    # print(keys)
    for key in keys :
        movie_dic[key] = movie_dic[key] / 4
    # print(movie_dic)
    # 정렬한다.
    sorted_x = sorted(movie_dic.items(), key=operator.itemgetter(1), reverse=True)
    # print(sorted_x)
    # 상위 3개를 출력한다.
    print(sorted_x[:3])







