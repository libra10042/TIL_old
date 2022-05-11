// var string ='안녕하세요';
// var string = '반갑습니다.';

// var greeting = string1 + ' ' + string2;

// var product = { name : '도서', price : '4200원'};

// var message = '제품' + product.name + '의 가격은' + product.price + '입니다.';

// var multiLine = '문자열1\n문자열2';

// var value1 = 1;
// var value2 = 2;
// var boolValue = false;

// var operator1 = '곱셈값은 ' + (value1 * value2) + '입니다.';
// var operator2 = '불리언값은' + (boolValue ? '참' : '거짓') + '입니다.';

//ES6 적용
var string1 = '안녕하세요';
var string2 = '반갑습니다.';

var greeting = `${string1} ${string2}`;
var product = { name: '도서' , price : '4200원' };
var message = `제품 ${product.name}의 가격은 ${product.price}입니다.`;
var multiLine = `문자열1
문자열2`;

var value1 = 1;
var value2 = 2;

var boolValue = false;
var operator1 = `곱셈값은 ${value1 * value2}입니다.`;
var operator2 = `${boolValue ? '참' : '거짓'}입니다.`;

//----------템플릿 문자열을 적용하여 바꿔보자..!!------------
var cart = { name : '도서', price : 1500 };
var getTotal = function(cart){
    return cart.price + '원';
};

var myCart = '장바구니에' + cart.name + '가 있습니다. 총 금액은 ' + getTotal(cart) + '입니다.';
//-----------↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-----------------
var cart = { name:'도서', price :1500 };
var getTotal = function(cart){
    return `{cart.price}원`;
}
var myCart = `장바구니에 ${cart.name} 가 있습니다. 총 금액은 ${getTotal(cart)} 입니다.`;




