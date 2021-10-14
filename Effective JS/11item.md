### 클로저에 익숙해져라. 

--- 

#### 클로저를 이헤하기 위해서는 세 가지 기본적인 사실만 배우면 된다. 

##### 첫번째로 JS는 현재 함수 외부에서 선언된 변수만 참조할 수 있다.

```JAVASCRIPT
function makeSanWich(){
    var magicIngredient = "peanut butter";
    function make(filling){
        return magicIngredient + " and " + filling;
    }
    return make("jelly");
}
makeSandWich(); // "peanut butter and jelly"
```

내부의 make 함수가 이 함수 바깥에서 선언된, 다시 말하면 magicIngredient 함수에서 선언된 makeSandwich 변수를 참조한다는 사실에 주목하라. 


##### 두번째로 함수는 외부 함수가 무언가를 리턴한 이후에도 이 외부 함수에 선언된 변수를 참조할 수 있다. 

( 자바스크립트 함수가 일급 객체라는 사실을 기억하면 좋다. 이는 내부 함수를 리턴할 수 있고, 이 함수가 나중에 다시 호출될 수 있다는 뜻이다. 

```javascript
function sandwichMaker(){
    var magicIngredient = "peanut butter";
    function make(filling){
        return magicIngredient + " and "  + filling; 
    }
    
    return make;
}

var f = sandwichMaker();
f("jelly"); // "peanut butter and jelly"
f("bananas"); // peanut butter and bananas"
f("marshmallows"); // "peanut butter and marshmallows"
```



##### 세 번쨰이자 마지막으로 기억해야할 사실은 클로저가 외부 변수의 값을 변경할 수 있다는 점이다. 
( 클로저는 외부 변수의 값을 복사하지 않고 참조를 저장한다.따라서 그들에게 접근하는 어떤 클로저도 변경사항을 볼 수 있다. ) 


```javascript
function box(){
    var val = undefined;
    return {
        set : function(newVal_ { val = newVal; },
        get : function() { return val; },
        type : function() { return typeof val; } 
    };
}

var b = box();
b.type(); // "undefined"
b.set(98.6); 
b.get(); // 98.6
b.type(); // "number"

```

이 예제는 세 개의 클로저 set, get, type 프로퍼티들을 포함하는 객체를 생성한다. 각 클로저는 val 변수를 공유하여 접근한다. set 클로저로 val의 값을 변경하고, 그 이후에 get과 type 을 호출해
변경에 대한 결과를 확인한다.


#### 기억할점. 
- 함수는 외부 스코프에 선언된 변수를 참조할 수 있다. 
- 클로저는 자신을 생성한 함수보다 더 오래 지속된다.
- 클로저는 내부적으로 외부 변수에 대한 참조를 저장하고, 저장된 변수를 읽고 갱신할 수 있다. 
