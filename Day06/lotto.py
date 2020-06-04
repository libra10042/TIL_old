import random



def lottoNum(n) :
    lottoList = []
    while True :
        # 탈출 조건 : 번호 6개인지 확인
        if len(lottoList) >= n:
            break
        else:
            # 로또번호 생성.
            data = random.randint(1, 46)
            # 로또번호가 리스트에 있는지 없는지 확인
            if data not in lottoList:
                lottoList.append(data)
    print('금주의 로또번호 : ', lottoList)
