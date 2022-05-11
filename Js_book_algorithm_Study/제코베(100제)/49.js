// 최대값 구하기
/*
순서가 없는 10개의 숫자가 공백으로 구분되어 주어진다. 주어진 숫자 중 최대값을 반환하라. 

입력 : 10 9 8 7 6 5 5 4 3 2 1
출력 : 10 

*/

let result= "10 9 8 7 6 5 5 4 3 2 1"; 

// split : 문자열을 배열로 바꾼다.
result = result.split(" ").map(n => {
    return parseInt(n, 10);
});

result.sort((a,b)=>{
    return b-a;
});

console.log(result[0]);
