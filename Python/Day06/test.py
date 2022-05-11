# test.py
# day6_4.py에서 모듈 임포트해서 호출한다.


def testPrint():
    print("모듈 테스트")

# print(' 모듈 테스트2 ')

# 두 개의 숫자를 더하는 함수 생성.
def sum(a,b):
    print(f'test.py의 sum 함수 실행')
    print(f' {a} + {b} = {a+b}')



# 메인으로 설정.
if __name__ == '__main__':
    print('메인으로 실행중.')