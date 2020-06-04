# 클래스

# 퀴즈 1
# 삼각형을 클래스를 생성한 후 2개의 삼각형을 인스턴스화한 후
# 속성(이름, 밑변, 높이)과 면적을 출력하여라
# 삼각형의 면적 구하는 공식 (밑변의길이 * 높이)/2

'''
 퀴즈1 결과 >>

 t1은 Triangle의 인스턴스인가요? True

 --------------------
삼각형 이름 :  triangle1
삼각형의 밑변 :  10
삼각형의 높이 :  5
삼각형의 면적 :  25.0

 t2는 Triangle의 인스턴스인가요? True

 --------------------
삼각형 이름 :  triangle2
삼각형의 밑변 :  20
삼각형의 높이 :  8
삼각형의 면적 :  80.0

'''

class Triangle:
    def __init__(self, name, width, height):
        self.name = name
        self.width = width
        self.height = height

    def info(self):
        print(f' 삼각형의 이름 : {self.name}')
        print(f' 삼각형의 밑변 : {self.width}')
        print(f' 삼각형의 높이 : {self.height}')
    def cal(self):
        print(' 삼각형의 면적 : ', (self.width * self.height)/2)


t1 = Triangle('tr1', 100, 300)
print('t2는 Triangle의 인스턴스 인가요?', isinstance(t1, Triangle))
t1.info()
t1.cal()

# 퀴즈 2
# 클래스 Animal과  Animal 클래스를 상속받는 Dog 클래스를
# 정의하여라. 아래는 참고 코딩이다.

# class Animal:
#     def __init__(self, objName, leg):
#         명령 입력
#
#     def info(self, objName, leg):
#         명령 입력
#
#     def run(self):
#         명령 입력
#
# class Dog(?):
#     def shout(self):
#         명령 입력
#
# print('='*30)
# print('\n\n 퀴즈2 결과 >> ')
# animal1 = Animal('animal1', 4)
# animal1.info('animal1', 4)
# animal1.run()
# print('인스턴스 animal1의 클래스 이름은 - ' , type(animal1).__name__)
#
# dog1 = Dog('dog1', 4)
# dog1.info('dog1', 4)
# dog1.run()
# dog1.shout()
# print('인스턴스 dog1의 클래스 이름은 - ' , type(dog1).__name__)
# print(f'{type(dog1).__name__}의 부모 클래스는 {type(animal1).__name__} 입니까? {issubclass(Dog, Animal)}')

'''
퀴즈2 결과 

이름 :  animal1
다리의 수 :  4
달리는 중입니다.
인스턴스 animal1의 클래스 이름은 -  Animal

이름 :  dog1
다리의 수 :  4
달리는 중입니다.
멍멍 짖습니다.
인스턴스 dog1의 클래스 이름은 -  Dog
'''

