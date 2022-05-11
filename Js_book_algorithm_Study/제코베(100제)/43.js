// 10진수를 2진수로

// 사용자에게 숫자를 입력받고 이를 2진수를 바꾸고 그 값을 출력하시오. 
const number = 10;
function solution(number){
    const numberTrans = parseInt(number, 2);

    console.log(numberTrans); 
}
solution(number);


//정답1
function solution1(){ 

    let dec ="32";
    let arrBinary = [];

    while(dec){
        arrBinary.push(dec%2);
        dec = Math.floor(dec/2);
    }
    console.log(arrBinary);
    arrBinary.reverse().join(" ");
    return arrBinary;
}   

console.log(solution1());

//정답2
let dec2 = 160;
console.log(dec2.toString(2));