### 혼합된 데이터형을 ==로 비교하지 마라.

---

아래 코드는 "1.0e0"는 숫자 1로 파싱되고, 오른쪽 객체 역시 valueOf 메서드가 호출된 결과인 true가 다시 숫자로 변환되어 1로 처리된다.

```javascript
"1.0e0" == { valueOf : function() { return true; } };
```

```javascript
var today = new Date();

if(form.month.value == {today.getMonth() + 1) &&  form.day.value == today.getDate()){
  // 생일 축하합니다.!
  // ...
}
```

<br>

하지만 사실, 값을 숫자로 명시적으로 변환하는기는 매우 쉽다. Number 함수나 단일 + 연산자를 사용하면 된다. 

```javascript
var today = new Date();

if(+form.month.value == (today.getMonth() + 1) && + form.day.value == today.getDate()){
  // 생일 축하합니다.!
  // ...
} 
```



<br><br>


```javascript
var today = new Date();

if (+form.month.value === (today.getMonth() + 1) && // 엄격한 비교
    +form.day.value === today.getDate()) { // 엄격한 비교
    // 생일 축하합니다.!
    // ...
}
```


---


- == 연산자는 인자들이 서로 다른 데이터형일 때, 일련의 혼동스러운 암묵적인 강제 형변환을 적용시킨다.
- 비교가 어떠한 암묵적인 강제 형변환과도 연관이 없다는 사실을 코드를 읽는 사람에게 명확하게 전달하기 위해서 ===를 사용하라.
- 비교할 값이 서로 다른 데이터형이라면 프로그램의 동작을 더 명백히 하기 위해 직접 명시적인 강제 형변환을 사용하라. 
