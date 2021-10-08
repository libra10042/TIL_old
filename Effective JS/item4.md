### 객체 래퍼보다 원시 데이터형을 우선시하라.

---

##### JS의 다섯 가지의 원시 데이터형 값 

- 불리언
- 숫자
- 문자열
- null
- undefined

( typeof 연산자는 null의 데이터형을 "object"로 반환하지만 ECMAScript 표준은 null을 별도의 데이터형으로 기술한다. )

```javascript
var s = new String("hello");

s + " world"; // "hello world"

s[4]; // "o"

typeof "hello"; // "string"
typeof s; // "object"


var s1 = new String("hello");
var s2 = new String("hello");
s1 === s2; // false

s1 == s2; //false
```

<br>

String 프로토타입 객체는 문자열을 대문자로 변환해주는 toUpperCase 메서드를 가진다.

```javascript
"hello".toUpperCase(); // "HELLO"

"hello".someProperty = 17;
"hello".someProperty; // undefined;
```


<br><br>

- 원시 데이터형을 위한 객체 래퍼는 그 자신의 원시 데이터 값과는 동작이 다르다. 동일한지 비교했을 때도 서로 다르다.
- 원시 데이터형에 프로퍼티를 설정하거나 가져오면 암묵적으로 객체 래퍼를 생성한다. 
