### 암묵적인 형변환을 주의하라. 

--- 

js에서는 다음과 같은 코드를 4

```javascript
3 + true; // 4
```


<br>

javascript는 오류를 발생시키는 대신, 뒤이어 발생하는 다양한 자동 형변환 프로토콜에 따라 예상된 데이터형으로 값을 형변환한다.

예를 들어 산술 연산자 -, *, /, % 는 계산 전에 인자들을 숫자형으로 변환한다. 

+ 연산자는 조금 특이한데, 숫자의 뎃셈이나 문자의 병합을 인자들의 데이터형에 따라 오버로딩한다.

```javascript
2 + 3; // 5
"hello" + "world"; // "hello world"
```

그렇다면, 숫자와 문자열을 합친다면 어떻게 될까? 

#### JS는 다음과 같이 문자열을 우선하여 숫자를 문자열로 바꾼다. 

```javascript
"2" + 3; // "23"
2 + "3"; // "23"
```

연산의 순서

```javascript
1 + 2  + "3"; // "33"
```


좌측결합성

```javascript
(1 + 2) + "3"; // "33"
```

대조적으로, 다음 표현식은 문자열 "123"으로 평가된다. 

```javascript
(1 + "2") + 3; // "123"
```

사용자의 입력이나 텍스트 파일 또는 네트워크 스트림에서 들어온 문자열을 다음과 같이 자동으로 변환해준다.

```javascript
"17" * 3; // 51
"8" | "1"; // 9
```

하지만 형변환은 오류를 숨길 수도 있다. null로 판단된 변수가 산술 연산에서 오류를 발생하지 않은 채 조용히 0으로 변환되고, 정의되지 않은 변수가 특별한 부동 소수점 값인 NaN 으로 변환된다.
(이런 형변환은 즉시 예외를 발생시키지 않고, 계산을 계속해서 이뤄지게 하며 혼란스럽고 예측하기 어려운 값들을 자주만들어 낸다. ) 

첫째로 JS는 IEEE 부동 소수점 표준에 정의된 이상한 요구사항을 따라 NaN 자신을 동등하지 않다고 처리하기 때문이다. 

```javascript
var x = NaN;
x === NaN; // false
```

게다가, 표준 isNaN 라이브러리 함수는 스스로 암묵적인 형변환, 즉 값을 테스트하기 전에 숫자를 바꾸기 때문에 신뢰할 만하지 않다. 

하지만 NaN으로 강제 형변환할 수 있는 다른 값들은, 실제로 NaN이 아니라면 isNaN으로 구별할 수 없다.

```javascript
isNaN("foo"); // true
isNaN(undefined); // true
isNaN({}); // true
isNaN({valueOf : "foo" }); // true
```

----

직관적이지는 않지만, NaN을 테스트하기 위한 간결하고 신뢰할 만한 코딩 관례가 있다. 
(NaN은 JS에서 자기 자신과 동일하지 않은 유일한 값이다. 따라서 값이 NaN인지 아닌지는 자기 자신과의 동일함을 확인하여 테스트 할 수 있다.

```javascript
var a = NaN;
a !== a; // true
var b = "foo";
b !== b; // false
var c = undefined; 
c !== c; // false
var d = {};
d !== d; // false
var e = { valueOf : "foo" };
e !== e; // false
```

<br><br>

> 조용히 이뤄지는 강제 형변환은 오류를 숨기고 분석하기 어렵게 하고, 오류가 있는 프로그램을 디버깅하기 곤란하게 만든다. 


<br>

객체 또는 원시 데이터형(primitive) 으로 강제 형변환될 수도 있다.



valueOf는 Number 객체처럼, 객체가 실제로 숫자로 된 값을 가질 때 사용되는 것이 맞다. 이런 객체에서 toString과 valueOf 메서드는 문자열 표현 또는 동일한 값의 숫자 표현을 일관되게 반환된다. 
따라서 객체가 문자열 병합에 쓰이든 덧셈에 쓰이든, 오버로딩된 + 연산자가 항상 일관되게 동작하게 한다. 보통, 숫자로 강제 형변환하는 것보다 문자열로 강제 형변환하는 것이 훨씬 더 일반적이고 유용하다.

객체가 진짜로 숫자형 추상이 아니고 obj.toString()이 obj, valueOf()의 문자열 표현을 나타내지 않는다면 valueOf의 사용을 피하는게 최선의 방법이다.


<br><br>

강제 형변환의 마지막 종류는 종종 트루시니스라고 알려져 있다.

if, ||, &&와 같은 연산자는 논리적으로 불리언 값과 함께 동작하는데, 실제로는 어떤 값도 수용한다. 
JS 값들은 간단한 암묵적인 강제 형변환에 의해 불리언 갑승로 해석될 수 있기 때문이다.

대부분의 자바스크립트 값들은 TRUE로 처리되는데, 다시 말해 암묵적으로 TRUE로 강제형변환 된다.


### JS에서 7개를 제외한 모든 값들은 TRUE로 처리된다.
- false
- 0
- -0
- ""
- NaN
- null
- undefined

---
---
##### 기억할점

- 데이터혀 에러는 암묵적인 강제 형변환에 의해 은밀하게 감춰질 수 있다.
- +연산자는 인자의 데이터형에 따라 덧셈이나 문자열 병합으로 오버로딩된다.
- 객체는 valueOf를 통해 숫자형으로, toString을 통해 문자열로 강제 형변환된다.
- valueOf 메서드를 가지는 객체는 반드시 valueOf 에 의해 생성되는 숫자 값의 문자열 표현을 생성하는 toString 메서드를 구현해야 한다.
- undefined 값을 테스트할 때 트루시니스를 사용하기보다는 typeof 를 사용하거나 undefined 와 비교하는 것이 좋다. 
