function multiply(a, b) {
  return a * b;
}

function multiplyTwo(a) {
  return multiply(a, 2);
}

function multiplyX(x) {
  return function (a) {
    return multiply(a, x);
  };
}

//화살표 함수 표현식
const multiplyX = (x) => (a) => multiply(a, x);

const multiplyThree = multiplyX(3);
const multiplyFour = multiplyX(4);

const result1 = multiplyThree(3);
const result2 = multiplyFour(4);

const result1 = multiplyX(3)(3); //9
const result2 = multiplyX(4)(3); //12

// => ((x * a) * b) + c
// a = 2, b = 3, c = 4
const equation = (a, b, c) => (x) => x * a * b + c;
const formula = equation(2, 3, 4);
const x = 10;
const result = formula(x); //64반환

//💡이와 같이 인자를 나중에 받아 실행할 함수를 생성해주는 quation()과 같은 함수를 '커링 함수' 라고 부른다.

const multiply = (a, b) => a * b;
const add = (a, b) => a + b;

const multiplyX = (x) => (a) => multiply(a, 2);
const addX = (x) => (a) => add(x, a);

const addFour = addX(4);
const multiplyTwo = multiplyX(2);
const multiplyThree = multiplyX(3);
const formula = (x) => addFour(multiplyThree(multiplyTwo(x)));


