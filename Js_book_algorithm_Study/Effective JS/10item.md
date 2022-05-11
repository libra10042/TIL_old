### with를 사용하지 마라. 

--- 

with은 진정 암경이 높다. with은 편리함을 제공하기는 하지만 그로 인해 얻는 이득보다 더 많이 신뢰도를 떨어뜨리고 비효율적이다. 

with의 필요성은 이해할 법도 하다. 프로그램은 종종 하나의 객체에서 여러 메서드를 호출해야 하는데, 해당 객체에 대한 참조를 반복할 필요가 없는 경우에는 with를 사용하는 편이 편리하기 때문이다.

```javascript
function status(info){
    var widget = new Widget();
    with (widget){
        setBackground("blue");
        setForeground("white");
        setText("Status : " + info); 
        show();
    }

}
```

모듈로 제공되는 객체의 변수를 불러들이기 위해 with를 사용하기도 한다.

```javascript
function f(x, y){
    with (Math){
        return min(round(x), sqrt(y)); 
    }
}
```

with에 제공된 객체에 어떤 프로퍼티가 있는지 혹은 없는지 얼마나 확신할 수 있을까? with 블록 내에서 외부 변수로의 모든 참조는 암묵적으로 with 객체 내에, 혹은 prototype 객체 내에 같은 이름의 
프로퍼티가 없다는 것을 가정한다. 하지만 프로그램의 다른 부분에서 with 객체와 이 객체의 prototype을 생성하거나 수정할 수 있으며, 이 prototype이 그런 가정을 공유하지 않을 수도 있다.



JS에는 with의 대안으로 사용할 만한 직접적인 대체 기능은 없다. 어떤 경우에는 객체를 단순히 짧은 이름의 변수로 바인딩하는게 최선의 대안이다.

```javascript
function status(info){
    var w = new Widget();
    w.setBackground("blue");
    w.setForeground("white");
    w.addText("Status : " + info);
    w.show();
}
```

어떠한 변수 참조도 객체 w의 내용에 신경쓰지 않는다. 따라서 어떤 코드가 Widget의 prototype을 수정하더라도, status 함수는 계속해서 기대한 대로 동작할 것이다.

```javascript
status("connecting"); // Status : connecting
Widget.prototype.info = "[[widget info]]";
status("connected"); // Status : connected

```


다른 경우에는, 지역 변수를 명시적으로 연관된 프로퍼티와 바인딩하는 것이 최선의 방법이다.

```javascript
function f(x, y){
    var min = Math.min, round = Math.round, sqrt = Math.sqrt; 
    return min(round(x), sqrt(y)); 
}
```

```javascript
Math.x = 0; 
Math.y = 0; 
```

##### 기억할 점. 
- wtih 선언문을 사용하지 마라. 
- 객체로의 반복되는 접근을 위해 짧은 변수 이름을 사용하라. 
- with 선언문으로 암묵적으로 바인딩하는 대신에 명시적으로 지역 변수를 객체 프로퍼티에 바인딩하라. 
