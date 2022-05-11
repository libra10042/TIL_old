// Number.EPSILON은 두개의 표현 가능한 숫자 사이의 가장 작은 간격을 반환
function numberEquals(x, y){
    return Math.abs(x-y) < Number.EPSILON;
}

const x = 0.2, y = 0.3, z = 0.1;
let equal = (Math.abs(x - y + z) < Number.EPSILON);
console.log(equal);


//Number.EPSILON : 두 수의 차이가 Number.EPSILON보다 작은지 검사해 더 작은 경우 true를 반환한다.
console.log(Number.EPSILON);

console.log(numberEquals(0.1 + 0.2, 0.3)); //true



// 최대치
// Number.MAX_SAFE_INTEGER는 가장 큰 정수를 반환한다.
console.log(Number.MAX_SAFE_INTEGER);
console.log(Number.MAX_SAFE_INTEGER + 1 === Number.MAX_SAFE_INTEGER + 2); // true

//Number.MAX_VELUE는 가능한 가장 큰 부동 소수점을 반환한다.
console.log(Number.MAX_VALUE);
console.log(Number.MAX_VALUE + 1 === Number.MAX_VALUE +2); 
console.log(Number.MAX_VALUE +1.111 === Number.MAX_VALUE + 2.022);
console.log("-------------------------");


//최소치
//Number.MIN_VALUE 는 가능한 가장 작은 부동소수점 수를 반환한다.
console.log(Number.MIN_SAFE_INTEGER -1 === Number.MIN_SAFE_INTEGER -2); //true
console.log(Number.MIN_SAFE_INTEGER - 1.111 === Number.MIN_SAFE_INTEGER -2.022); //false
console.log(Number.MIN_VALUE -1 == -1); //true
console.log("------------------------");


//무한
// Number.MAX_VALUE보다 큰 유일한 것은 Infinity이고 Number.MAX_SAFE_INITEGER보다 작은 유일한 것은 -Infionity이다.
console.log(Infinity > Number.MAX_SAFE_INTEGER); //true
console.log(-Infinity < -Number.MAX_SAFE_INTEGER); //true
console.log(-Infinity -3232322 === -Infinity -1); //true

