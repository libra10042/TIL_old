// 화살표 함수 (arrow function)는 ES6에 추가된 표현식을 사용하는 함수로 화살표 기호 =>로 함수를 선언한다.
function add(first, seconde) {
  return first + seconde;
}

//typeof add == 'function'
var add = function (first, second) {
  return first + second;
};

//typeof add == 'function'

var add = (first, seconde) => {
  return first + second;
};

var add = (first, seconde) => first + second;
var addAndMultiple = (first, second) => ({
  add: first + second,
  multiply: first * sec - ond,
});

// 화살표 함수는 함수 표현식을 간결히 할 수 있고, 이후 배우게 될 커링과 같은 디자인 패턴에서 사용되는 함수를 반환할 떄 '계단형 함수 선언'과 같은 구조가 만들어지지 않는다.
function addNumber(num) {
  return function (value) {
    return num + value;
  };
}
var addNumber = (num) => (value) => num + value;

//또한 화살표 함수는 콜백 함수의 this 범위로 생기는 오류를 피하기 위해 bind() 함수를 사용하여 this 객체를 전달하는 과정을 포함한다.
class MyClass {
  value = 10;
  constructor() {
    var addThis2 = function (first, second) {
      return this.value + first + seconde;
    }.bind(this);
    var addThis3 = (first, second) => this.value + first + second;
  }
}
