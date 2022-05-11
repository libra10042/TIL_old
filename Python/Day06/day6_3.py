# 클래스구조로 커피 자판기 프로그램
# 속성 : 선택 메뉴, 가격, 이름
# 메서드
# : 메뉴를 표시
# : 금액 투입
# : 메뉴 선택과 선택한 메뉴 배달완료
# 남은 금액 표시


# 커피 자판기 메뉴
# 메뉴1 - 아메리카노 : 500원
# 메뉴2 - 라떼 : 500원
# 메뉴3 - 카라멜 마끼아또 : 700원
# 주문하실 메뉴의 금액을 삽입구에 넣어주세요.

class Vending_machine():
    def __init__(self, v_name):
        self.v_name = v_name
        self.product = ('아메리카노', '라떼', '마끼야또')
        self.price = (5000, 7000, 10000)

    def show_menu(self, v_name):
        print(f'\t\t {self.v_name}')

        for i in range(0, len(self.product)):
            print(f'메뉴{i+1} = {self.product[i]} : {self.price[i]}')

    # 금액 투입
    def input_money(self):
        while True :
            self.in_money = input('금액을 삽입구에 넣어주세요....')
            # 숫자만 입력되는 확인
            if self.in_money.isdigit():
                # 자료형 변경
                self.in_money = int(self.in_money)
                print(f'투입 금액 : {self.in_money}원')
                break
            else:
                print('투입한 금액이 올바르지 않습니다.')

    # : 메뉴 선택과 선택한 메뉴 배달 완료
    def get_drink(self):
        # 메뉴 선택 변수
        sel = input('메뉴를 선택하세요 1. 아메리카노   2. 라떼    3.마끼야또.....')

        if sel == '1':
            print(f'주문하신 {self.product[0]}가 나왔습니다.')
            changes = self.in_money - self.price[0]
            print('잔돈은 : ', changes)


        elif sel == '2':
            print(f'주문하신 {self.product[1]}가 나왔습니다.')
            changes = self.in_money - self.price[1]
            print('잔돈은 : ', changes)

        elif sel == '3':
            print(f'주문하신 {self.product[2]}가 나왔습니다.')
            changes = self.in_money -self.price[2]
            print('잔돈은 : ', changes)

        else:
            print('잘못된 선택입니다.')


    def add_exe(self):
        while True:
            ans = input('메뉴추가 주문을 하시겠습니까....(y/n)')
            if ans == 'y':
                    if self.get_drink(self) >= self.price[1] or self.get_drink(self) >= self.price[0] or self.get_drink(self)>=self.price[2]:
                        sel = (int)(input('메뉴를 선택하세요 1.아메리카노    2.라떼    3.마끼야또......'))
                        if sel == 1:
                            print('거스름돈 : ', self.get_drink() - self.price[0])
                        elif sel == 2:
                            print('거스름돈 : ', self.get_drink() - self.price[1])
                        elif sel == 3:
                            print('거스름돈 : ', self.get_drink() - self.price[2])
                        else :
                            print('잘못입력하셨습니다.')
                    else :
                        print('잔액이 부족합니다.')
            elif ans == 'n':
                print('프로그램을 종료합니다.')
                break
            else :
                print('잘못입력하셨습니다.')




# 메인
vm = Vending_machine('강남점')
while True :
    # 메뉴 표시
    vm.show_menu('강남점')
    # 금액 삽입 메세지
    vm.input_money()
    # 투입 금액이 가장 낮은 메뉴의 가격보다 큰지 확인
    if vm.in_money >= int(min(vm.price)):
        print('주문이 가능합니다.')
        vm.get_drink()

        vm.add_exe()

        break
    else:
        print('투입 금액이 부족하여 메뉴 주문이 불가능합니다.')




# 과제 제출일은? 월요일 1/6 오후
# 관련 파일을 압축한 후 강사메일로 제출(coderecipe@naver.com)

# 과제1
'''
1) 커피 자판기 기능 추가
 - 투입금액에 맞는 메뉴만 주문
 - 잔돈 표시
 - 잔돈이 주문메뉴의 최소금액보다 높은 경우 다시 메뉴 선택 가능.

메뉴를 주문하시겠습니까? (y/n)
남은 잔돈은 000입니다.



'''

# 과제2
'''
quiz5_2 마지막 문제 완성. (파일 입출력) 8번 완성 : 파일입출력
- 단어 추가 여부
'''