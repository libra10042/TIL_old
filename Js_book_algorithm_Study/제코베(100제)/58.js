//  콤마 찍기
// 숫자를 입력 받고 천단위로 콤마(,)를 찍어주세요.


const number = 123456789;

console.log(number.toLocaleString());

// 반복문은 전부 재귀함수로, 재귀함수는 전부 반복문으로 나타낼 수 있다.
function comma(s){
    if(s.length <= 3){
        return s; 
    }else{
        return comma(s.slice(0, s.length-3)) + ',' + s.slice(s.length-3);
    }
}


// console.log('12345678'.slice(3,7));
console.log(comma("123456789"));