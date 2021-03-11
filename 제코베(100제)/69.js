// 골드바흐의 추축
/*
골드바흐의 추측은 오래전부터 알려진 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두개의 소수(Prime Number)의 합으로
표시할 수 있다는 것이다.이 때 하나의 소수를 두 번 사용하는 것은 허용한다.

위 설명에서 2보다 큰 모든 짝수를 두 소수의 합으로 나타낸 것을 골드바흐 파티션이라고 합니다.

에) 
100 == 47+ 53
56 == 19 + 37

2보다 큰 짝수 n이 주어졌을 때, 골드바흐 파티션을 출력하는 코드를 작성하시오. 

* 해당 문제의 출력 형식은 자유롭습니다 가능하시다면 골드바흐 파티션 모두를 출력하거나, 
그 차가 작은 것을 출력하거나 그 차가 큰 것 모두 출력해보세요. 
*/

let 소수 = [];
let 소수판별 = true;

for(let i=2; i<100; i++){
    for(let j=2; j<i; j++){
        if(i%j == 0){
            소수판별 = false;
        }
    }

    if(소수판별){
        소수.push(i);
    }

    소수판별 = true; 
}

console.log(소수);

const 숫자 = 100; 
let 순회 = 0; 
let 골드바흐파티션 = []; 
for(let n of 소수){
    // console.log(n);
    if(소수.includes(숫자-n)){
        console.log(n, 숫자-n);
    }
    if(순회 >  parseInt(소수.length / 2, 10)){
        break; 
    }

    순회++; 
}

console.log(골드바흐파티션);

let 차 = 골드바흐파티션.map(e => e[0]-e[1])

console.log(차.indexOf(Math.min.apply(null, 차)));

let 차의인덱스 = 차.indexOf(Math.min.apply(null, 차));
console.log(골드바흐파티션);