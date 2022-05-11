# 클래스 : 특별한 자료구조
# 관련 키워드 => OOP, 인스턴스=객체
# 기본자료형(숫자, 문자열, 불른)
# 콜렉션형 (리스트, 집합, 튜플, 딕셔너리)
# 클래스 ( 속성, 함수 ...) => 틀
# 인스턴스=객체=Object
#   => 클래스에 의해서 만들어진 산출물

# 클래스 생성 문법
# 클래스이름은 첫글자는 대문자로 지정
# class 클래스이름:
#   명령문

#빈클래스 생성
class Test:
    pass
print(Test, type(Test))
#<class '__main__.Test'> <class 'type'>d


# 인스턴스 생성하기
# 인스턴스명은 첫글자는 소문자로 지정
# 인스턴스변수 = 클래스이름()
# isinstance(인스턴스변수, 클래스이름)
# 특정클래스에 의해서 생성된 인스턴스가 맞는지 출력
# True / False 로 출력

t1 =Test()
print(t1, type(t1))
#<__main__.Test object at 0x00F0E058> <class '__main__.Test'>


# 관계확인 (클래스에 의해서 생성된 인스턴스가 맞는지 여부 확인)
# isinstance(인스턴스명, 클래스명)
list = []
print(isinstance(t1, Test))
print(isinstance(list, Test))

print('-'*30)

# 생성자 함수 (Constructor)
# => 속성값 정의
# 사각형에 관련된 클래스 속성 => 가로, 세로, 색상
# 사람에 대한 클래스 속성 => 이름, 성별, 키, 몸무게
# 붕어빵에 대한 클래스 속성 => 재료, 생산시간

# 생성자함수 문법
# class 클래스명:
#   def __init__(self, 인자):
#       self.인자 = 인자값
# 인스턴스 생성
# 인스턴스명 = 클래스이름(인자값,..)
# 실제 속성값 출력
# 인스턴스명.속성

# 사각형에 대한 클래스 생성.
# 가로, 세로
class Square:
    #생성자 함수- 속성
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.color = "red"
        self.style = ("줄무늬", "모서리둥금", "도트 무늬")

# 사각형 인스턴스 생성
s = Square(50,100)
print(isinstance(s, Square))
# 사각형 인스턴스의 가로와 세로 속성 출력
print(f'가로길이 {s.width}, 세로길이 {s.height}, 색상 : {s.color}, 스타일 : {s.style} ')

print('-'*30)

# 클래스 메소드란?
# def 메소드이름(self,인자):
#   명령어
#   return 값
# 메소드 호출
# 인스턴스명.메소드이름(인자)

# Bread 클래스 생성하기
class Bread:
    # 생성자 함수 - 속성.
    def __init__(self, name, price, kcal):
        self.name = name
        self.price = price
        self.kcal = kcal
        self.brand = "파리크리상"

    # 빵의 정보를 출력하는 메소드 등록.
    def info(self):
        print(f'빵의 이름 : {self.name}, 가격 : {self.price}, 칼로리 : {self.kcal}, 브랜드 : {self.brand}')


# 인스턴스 생성.
b = Bread('소보로빵', 30000, '500kcal')
print('선택하신 빵 정보')

#인스턴스 메소드 출력.
b.info()

b2 = Bread('단팥빵', 20000, '368kcal')
b2.info()

print('-'*30)


'''
퀴즈 :
    1. 타원 클래스 생성
    2. 속성 : ?
    3. 속성을 출력하는 메소드 정의
    4. 타원의 면적을 출력하는 메소드 정의 : 3.14*반지름**2
    5. 인스턴화
    6. 속성과 면적 메소드 호출
'''
class Circle:
    def __init__(self, name, color, radius):
        self.name = name
        self.color = color
        self.radius = radius

    def info(self):
        print(f'반지름 : {self.radius}')
        print(f'색상 : {self.color}')
        print(f'이름 : {self.name}')

    def area(self, radius):
        print(f'원의 면적은? {3.14*self.radius**2}')


c1 = Circle('한국', '빨강', 5)
c1.info()
c1.area(5)
print('-'*50)


# 퀴즈 1
# 삼각형을 클래스를 생성한 후 2개의 삼각형을 인스턴스화한 후
# 숙성(이름, 밑변, 높이)과 면적을 출력하여라.
# 삼각형의 면적 구하는 공식 (밑변의 길이* 높이)/2
'''
t1 은 Triangle의 인스턴스인가요? True



'''
class Triangle:
    def __init__(self, name, width, height):
        self.name = name
        self.width = width
        self.height = height

    def info(self):
        print(f'삼각형의 이름 : {self.name}')
        print(f'삼각형의 밑변 : {self.width}')
        print(f'삼각형의 높이 : {self.height}')

    def cal2(self):
        print('삼각형의 면적 : ', (self.width * self.height)/2)


t2 = Triangle('t2', 50, 100)
print('t2는 Triangle의 인스턴스인가요?', isinstance(t2, Triangle))

t2.info()
t2.cal2()
print('-'*50)

# 퀴즈 : 계산기 만들기
# 2개의 숫자를 속성으로 가진 계산기 클래스 만들기
# 인스턴스화 시킨 후 다음과 같이 출력한다
#
# [ 출력형태 : ]
# 첫번째 숫자 : ?
# 두번째 숫자 : ?
# 더하기 : ?
# 빼기 : ?
# 곱하기 : ?
# 나누기 : ?

# 클래스 선언 -  Calculator
# 생성자함수를 이용하여 속성 정의
# 더하기 메소드 정의
# 빼기 메소드 정의
# 곱하기 메소드 정의
# 나누기 메소드 정의
# 클래스를 이용하여 인스턴스 생성
# 출력형태로 메소드 호출하여 출력
class Calculator:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def info(self):
        print(f'첫번째 숫자 : {self.x}')
        print(f'두번째 숫자 : {self.y}')

    def add(self):
        print('더하기 :', self.x + self.y)

    def minus(self):
        print('빼기 :', self.x - self.y)

    def mul(self):
        print('곱하기 :', self.x * self.y)

    def div(self):
        print('나누기 :', self.x / self.y)

cal1 = Calculator(40,16)
cal1.info()
cal1.add()
cal1.minus()
cal1.mul()
cal1.div()
print('-'*40)


#----------------
# 클래스 변수
# 클래스 정의시 지정된 공용 변수
# 생성자 함수 위에 정의
# 동일한 주소값을 가지고 있다.
# id(객체이름) : 주소 표시
# 인스턴스 생성후 접근
# - 인스턴스명.클래스변수명
# - 클래스명.클래스변수명

class Test2:
    # 클래스 변수
    message = "오늘도 좋은 하루"
    def __init__(self, testName):
        self.testName = testName

    def messagePrint(self):
        print(self.message)


testInstance1 = Test2('testInstance1')
testInstance1.messagePrint()
print(f'message = {Test2.message}')
print(f'message = {testInstance1.message}')               #.... test명과 instance명은 동일하다.

# 클래스변수의 주소값 확인
print(id(testInstance1.message))
print(id(Test2.message))
print('-'*30)

# ---------------
# 상속이란?
# 부모클래스의 속성이랑 메소드를 그대로 가진다.
# class 클래스이름(부모클래스1,부모클래스2...)

# 부모클래스1 - 아파트, 차
# 부모클래스2 - 오피스텔, 전동스쿠터
# 자식클래스 - 아파트, 차 , 오피스텔, 전동스쿠터


# 부모클래스를 상속해서 자식 클래스 만들기
# class 자식클래스명(부모클래스명1, 부모클래스명2..)
#   명령문

# 2개의 부모 클래스 생성후 자식 클래스 상속
class Papa:
    def __init__(self, firstName):
        self.firstName = firstName
    def info1(self):
        print('아파트, 차')

class Mama:
    def __init__(self, lastName):
        self.lastName = lastName
    def info2(self):
        print('오피스텔, 전동스쿠터터')

class Child(Papa, Mama):
    def __init__(self, firstName, lastName, card):   #부모 클래스의 매개변수를 써줘야 한다.
        Papa.__init__(self, firstName)
        Mama.__init__(self, lastName)
        # 새로운 속성 정의
        self.card = card

# 상속받은 자식 클래스 인스턴스화
child1 = Child('노트북', '핸드폰', '롯데카드')
print('상속받은 메소드를 호출합니다.')
child1.info1()
child1.info2()
print(child1.firstName)
print(child1.lastName)
print(child1.card)

# 부모 클래스와 자식 클래스의 관계 확인
# issubclass(자식클래스,부모클래스)
# : 자식클래스와 부모 클래스와의 관계 표시 (True / False)
# 부모 클래스 정보 표시
# 클래스명.__bases__ =>  튜플 형태
print(issubclass(Child, Mama))  # True
print(issubclass(Child, Papa))  # True
print(issubclass(Child, Test2)) # False
print(f' 상속받은 클래스 명은 ? {Child.__bases__}')

# 부모 클래스 정보 표시
# 클래스명.__bases__ => 튜플 형태
print('-'*30)

# 인스턴스가 접근할 수 있는 속성과 메소드
# dir(인스턴스명)
# 상속받은 메소드랑 속성 확인.
print(dir(child1))


# 메서드 오버라이딩(method overriding)
# 상속 관계에서 부모클래스(Super Class)의 메서드에 대하여 자식클래스(Sub Class)에서 재정의하는 기능




# 오버라이딩된 메서드 외에 부모의 메서드를 호출하려면
# super() 키워드 이용
# super().메서드()
class Person:
    def __init__(self):
        self.nation = "Korea"
    def greeting(self):
        print('사람입니다.')

class Student(Person):
    def __init__(self):
        pass
    # 부모 클래스의 메서드와 이름이 동일하다.
    # 메소드 오버라이딩(method overriding)
    def greeting(self):
        #상속받은 부모 메서드 호출
        super().greeting()
        print('학생입니다.')

stu1 = Student()
print(issubclass(Student, Person))  # False
print(f' 상속받은 클래스명은 ?... {Student.__bases__}')   # 상속받은 클래스명은 ?... (<class 'object'>,)

# 메서드 확인하기 : 자기자신의 메서드가 호출된다.
stu1.greeting() # 학생입니다.

print('!'*50)





# # 오버라이딩된 메서드 외에 부모의 메서드를 호출하려면
# # super() 키워드 이용
# # super().메서드()
# class Person:
#     def __init__(self):
#
#         Person.__init__(self)
#     def greeting(self):
#         print('사람입니다.')
#
# class Student(Person):
#     # 속성이 부모와 같은 경우
#     # 마지막에 정의한 속성이 우선순위가 높다.
#     def __init__(self):
#         self.nation = 'USA'
#         # 부모속성 상속 = nation
#         Person.__init__(self)
#         # self.nation = 'USA'
#     # 부모 클래스의 메서드와 이름이 동일하다.
#     # 메소드 오버라이딩(method overriding)
#     def greeting(self):
#         #상속받은 부모 메서드 호출
#         super().greeting()
#         print('학생입니다.')
#
# stu1 = Student()
# print(issubclass(Student, Person))  # False
# print(f' 상속받은 클래스명은 ?... {Student.__bases__}')   # 상속받은 클래스명은 ?... (<class 'object'>,)
#
# # 메서드 확인하기 : 자기자신의 메서드가 호출된다.
# stu1.greeting() # 학생입니다.
#
# print(stu1.nation)



# 다중 상속일 때 우선 순위 확인하기
# Lion, Tiger => Liger
# 다중 상속인 경우 부모 클래스 이름이 같은 경우는 먼저 선언한 부모 클래스의 메서드가 우선순위가 높다.
class Lion:
    def __init__(self):
        bloodType = 'A형'
    def cry(self):
        print('사자 : 으리렁')
class Tiger:
    def __init__(self):
        bloodType = 'B형'
    def cry(self):
        print('호랑이 : 어흥')

# class Liger(Lion, Tiger)
class Liger(Tiger, Lion):
    def __init__(self):
        Lion.__init__(self)
        Tiger.__init__(self)
        self.bloodType = 'AB형'
        Lion.__init__(self)
ligerBoy = Liger()
print(ligerBoy.bloodType)
print(ligerBoy.cry())


