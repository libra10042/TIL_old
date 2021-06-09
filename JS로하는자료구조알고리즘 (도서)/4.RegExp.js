// 정규 표현식. 
var str = "javaScript DataStructures";
var n = str.search(/DataStructures/);
console.log(n); // '11'을 출력한다.


// 개발자들이 자주 사용하는 정규표현식. 
// 숫자를 포함하는 문자 /\d+/
var reg = /\d+/;
reg.test("123"); // true
reg.test("33asd"); // true
reg.test("5asdasd"); // true
reg.test("asdasd"); // false


// 숫자만 포함하는 문자. 
// /^\d+$/
var reg = /^\d+$/;
reg.test("123"); // true
reg.test("123a"); // false
reg.test("a"); // false


// 부동소수점 문자
// /^[0-9]*[0-9]*[1-9]+$/;
var reg = /^[0-9]*.[0-9]*[1-9]+$/;
reg.test("12"); // true
reg.test("12.2"); // true


// 숫자와 알파벳만을 포함하는 문자.
// /[a-zA-Z0-9]/ 
var reg = /[a-zA-Z0-9]/;
reg.test("somethingElse"); // true
reg.test("hello"); // true
reg.test("112a"); // true
reg.test("112"); // true
reg.test("^"); // false; 


// 질의 문자열 
// /([^?=&]+)(=([^&]*))/
// SELECT LCD, TV FROM database WHERE Category = 4 AND Product_id=2140;
var uri = 'http://your.domain/product.aspx?category=4&product_id=2140&query=lcd+tv';
var queryString = {};
uri.replace(
    new RegExp("([^?=&]+)(=)[^&]*))?", "g"),
    function ($0, $1, $2, $3) { queryString[$1] = $3; }
);

console.log('ID : ' + queryString['product_id' ]); // ID : 2140
console.log('Name : ' + queryString['product_name' ]); // Name : undefined;
console.log('Category : ' + queryString['category' ]); // Category : 4


