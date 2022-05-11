// ES6 에서는 값을 수정할 수 있는 가변 변수를 위한 let 키워드와, 값을 수정할 수 없는 불변 변수를 위한 const 키워드를 사용한다.
// const로 사용한 변수는 읽기만 가능하다.
let num = 1;
num = num * 3;
let str = "문자";
str = "다른 문자";
let arr = [];
arr = [1, 2, 3];
let obj = {};
obj = { name: "새 객체" };

const num = 1;
num = 3;
const str = "문자";
str = "새 문자";
const arr = [];
arr = [1, 2, 3];
const obj = {};
obj = { name: "내 이름" };

//-----------------------
const arr2 = [];
arr2.push(1);
arr2.splice(0, 0, 0); //arr2 = [0, 1]
arr2.pop(); //arr2 = [1]
const obj2 = {};
obj2[name] = "내이름"; //obj2 = { name : '내이름'}
Object.assign(obj2, { name: "새이름" }); //obj2 = {name : '새이름'}
delete obj2.name; //obj2 = {}

//------------------------
// 새로운 값을 추가할 때는 push() 함수 대신 concat() 함수를, 삭제할 때는 pop(), shift() 함수 대신 slice(), concat() 함수에 전개 연산자를 조합하여
// 사용한 점을 유심히 살펴 보자.
const num1 = 1;
const num2 = num1 * 3;
const str1 = "문자";
const str2 = str1 + "추가";
const arr3 = [];
const arr4 = arr3.concat();
const arr5 = [...arr4, 2, 3];
const arr6 = arr5.slice(0, 1);
const [first, ...arr7] = arr5;
const obj3 = { name: "내이름", age: 20 };
const objValue = { name: "새이름", age: obj3.age };
const obj4 = { ...obj3, name: "새이름" }; //obj4 = { name : '새이름', age : 20 }
const { name, ...obj5 } = obj4; //obj5={age : 20}


