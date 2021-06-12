// window 전역 객체
// window는 브라우저에서 전역 객체이며 alert()와 setTimeout()과 같은 다양한 내장 메소드를 지닌다.
let a = "apples"; // var 키워드를 통해 전역변수로 선언
b = "oranges";  // var 키워드 없이 전역변수로 선언

console.log(window.a); // "apples"를 출력한다.
console.log(window.b); // "oranges"를 출력한다.

// 가능하면 전역변수는 사용하지 않는 것이 좋다. 전역변수를 사용하지 않음으로써 메모리를 절약할 수 있다.
var test = { 
    prop1 : 'test'
}

// 다음과 같이 코드를 구현해서는 안된다.
function printProp1(test){
    console.log(test.prop1);
}

printProp1(test); // 'test'

// 다음과 같이 속성을 전달해야 한다.
var test = { 
    prop1 : 'test'
}
function printProp1(prop1){
    console.log(prop1);
}

printProp1(test.prop1); //'test'

// delete 연산자
let test = { 
    prop1 : 'test'
}

console.log(test.prop1); //'test'
delete test.prop1; 
console.log(test.prop1); // undefined_
