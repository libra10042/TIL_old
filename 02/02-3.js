// ES6의 전개 연산자는 독특하면서도 매우 유용한 문법이다.
// 전개 연산자는 나열형 자료를 추출하거나 연결할 떄 사용한다.
// 사용 방법은 배열이나,객체, 변수명 앞에 마침표 세 개(...)를 입력한다.
// 다만, 배열, 객체, 함수 인자를 표현식 ([], {}, ()) 안에서만 사용해야 한다.

var array1 = ["one", "two"];
var array2 = ["three", "four"];
//var combined = [array1[0], array1[1], array2[0], array2[1]];
const combined = [...array1, ...array2];

var combined = array1.concat(array2);
var combined = [].concat(array1, array2);
var first = array1[0];
var second = array1[1];
var three = array1[2] || "empty";

const [first, seconde, three = "empty", ...others] = array1;

function func() {
  var args = Array.prototype.slice.call(this, arguments);
  var first = args[0];
  var others = args.slice(1, args.length);
}
var first = args[0];
var others = args.slice(1, args.length);

//func(...args) { var [first, ...others] = args; }
