let array1 = [12, 3, 4, 2, 1, 34, 23];
array1.sort(); // array1 : [1, 12, 2, 23, 3, 34, 4]

let array1 = [12, 3, 4, 2, 1, 34, 23];

function comparatorNumber(a, b){
    return a-b; 
}

array1.sort(comparatorNumber);
// array1 : [1, 2, 3, 4, 12, 23, 34]


let array1 = [12, 3, 4, 2, 1, 34, 23];
function comparatorNumber(a, b){
    return b-a;
}
array1.sort(comparatorNumber); // array1 : [34, 23, 12, 4, 3, 2, 1]


// 가장 효율적인 정렬 알고리즘은 빠른 정렬, 병합 정렬, 계수 정렬이다. 
// 계수 정렬이 가장 빠르기는 하지만 배열의 값 범위를 아는 경우에만 사용 가능하다.