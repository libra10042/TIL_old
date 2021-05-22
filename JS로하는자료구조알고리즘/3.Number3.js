// 숫자 알고리즘

// 소수 테스트 
// : 숫자가 소수인지 알아보는 방법은 숫자 n을 2부터 n-1까지의 수로 나눠 나머지가 0인지 확인하면 된다.
// 방법1) O(n)
let startTime = new Date().getTime();
function isPrime(n){
    
    if(n <= 1){
        return false; 
    }

    // 2부터 n-1까지의 수로 나눈다.
    for(let i=2; i<n; i++){
        if(n%i==0){
            return false; 
        }

    }
    return true; 
}
console.log(isPrime(17));
let endTime = new Date().getTime();
console.log((endTime - startTime)/ 1000);




//방법2) O(sqrt(n))
let startTime2 = new Date().getTime();
function isPrime2(n){
    if(n <= 1) return false; 
    if(n <= 3) return true; 

    //입력된 수가 2또는 3인 경우 아래 반복문에서 
    //다섯 개의 숫자를 건너뛸 수 있다.
    if(n%2 === 0 || n%3 ===0) return false; 

    for(let i=5; i*i<=n; i=i+6){
        if(n%i === 0 || n%(i+2) === 0){
            return false;
        }
    }
    return true; 

}
console.log(isPrime(17));
let endTime2 = new Date().getTime();
console.log((endTime2 - startTime2)/ 1000);
console.log("===============================");
// ------------------------------------------------------------------

// 소인수 분해  O(sqrt(n))
function primeFactors(n){
    // n이 2로 나눠진다면 나눠질 수 있는 수만큼 2가 출력된다.
    while(n%2 ==0){
        console.log(2);
        n = n/2;
    }

    //이 지점에서 n은 홀수임이 확실하다. 따라서 수를 두 개씩 증가시킬 수 있다. (주목 : i = i + 2).
    for(let i=0; i*i<=n; i=i+2){
        //i가 나눌 수 있는 한 계속해서 i가 출력되고 n을 i로 나눈다.
        while(n % i === 0){
            console.log(i);
            n = n / i;
        }
    }
    // 다음 조건문이 n이 2보다 큰 소수인 경우를 처리하기 위한 것이다.
    if(n > 2){
        console.log(n);
    }
}

console.log(primeFactors(10));
console.log("===============================");
// ------------------------------------------------------------------
// 무작위 수 생성
/*
    연습 문제
    1. x와 y, p라는 세 개의 숫자에 대해(x^y) % p를 계산하라 
        여기서 x는 기저이고 y는 지수이고 p는 모듈러다.
        모듈러 제곱거듭은 모듈러에 대해 수행하는 종류의 제곱거듭이다. 
        이는 컴퓨터 과학에서 유용하며 공개 키 암호화 알고리즘 분야에서 사용된다.
*/
// 방법1)
function modularExponentiation( base, exponent, modules){
    return Math.pow(base, exponent) % modules;
}

// 방법2)
function modularExponentiation( base, exponent, modules){
    if ( modules === 1) return 0; 

    let value = 1; 

    for(let i=0; i<exponent; i++){
        value = (value * base) % modules;
    }
    return value;
}


