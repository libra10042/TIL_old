// 컴퓨터 과학 분야에서 재귀함수는 자기 자신을 호출하는 함수이다.
// 재귀 함수는 재개 우아하며 "분할 정복" 방식을 통해 복잡한 문제를 해결한다.
// 기저 조건 : 재귀에는 기저 조건(종료 조건이라고 부름)이 존재한다.

// n부터 0까지 세면서 숫자 출력하는 함수.
function countDownToZero(n){
    // 기저 조건. 0에서 중단한다.
    if(n < 0){
        return; // 함수를 중단한다.
    } else { 
        console.log(n);
        countDownToZero(n-1); // 1만큼 감소시킨다.
    }
}
countDownToZero(12);




// 분할 정복 방식. 
// 컴퓨터 과학 분야에서 분할 정복 방식은 어떤 문제를 작은 단위로 나눠서 해당 작은
// 단위의 문제들을 모두 해결함으로써 문제를 해결하는 것을 말한다.


// 방법1) 반복 루프를 활용한 해결책 : 피보나치 수열. 
function getNthFibo(n){
    if( n<=1 ) return n;
    let sum = 0, last = 1, lastlast = 0; 

    for(let i = 1; i<n; i++){
        sum = lastlast + last; 
        lastlast = last; 
        last = sum;
    }
    return sum; 
}


// 방법2) 피보나치 재귀 
function getNthFibo(n){
    if(n<=1){
        return n; 
    }else { 
        return getNthFibo(n - 1) + getNthFibo(n - 2);
    }
}

// 방법3) 피보나치 수열 : 꼬리 재귀 
function getNthFibo(n){
    if(n <= 1) return n; 
    let sum = 0, last = 1, lastlast = 0; 


    for(let i= 1; i<n; i++){
        sum = lastlast + last;
        lastlast = last;
        last = sum;
    }
    return sum;
}

function getNthFiboBetter(n, lastlast, last){
    if(n == 0){
        return lastlast; 
    }
    if(n == 1){
        return last; 
    }
    return getNthFiboBetter(n-1, last, lastlast + last);
}


//------------------------------------------
// 파스칼의 삼각형
function pascalTriangle(row, col){
    if(col == 0){
        return 1;
    }else if(row == 0){
        return 0;
    }else {
        return pascalTriangle(row -1, col) + pascalTriangle(row -1, col-1);
    }
}

pascalTriangle(5, 2); // 10 

// ------------------------------------------
// 재귀의 빅오 분석. 
function getNthFibo(n){
    if( n <= 1){
        return n; 
    }else { 
        return getNthFibo(n-1) + getNthFibo(n-2);
    }
}
getNthFibo(3);
//  시간 복잡도는 O(1) 이다. 