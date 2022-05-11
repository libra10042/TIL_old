// 소수 판별

/*
숫자가 주어지면 소수인지 아닌지 판별하는 프로그램을 작성하시오.
소수이면 yes, 소수가 아니면 no 로 출력
(소수 : 1과 자기 자신만으로 나누어 떨어지는 1보다 큰 양의 정수)
*/
// 풀이1)
const number = 12; 
function solution(number){
    for(let i=2; i<number-1; i++){
        if(number % i === 0){
            console.log("no");
            return false; 
        }
    }
    console.log("yes");
}
solution(14);


// 정답 
const prime = 14; 
function primeFunction(n){
    for(let i = 2; i < n; i++){
        if( n % i === 0 ){
            console.log("no");
            return false;
        }
    }
    if(n === 1){
        console.log("no");
        return false; 
    }


    console.log("yes")
}

primeFunction(prime);