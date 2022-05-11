// 함수형 배열 메소드 
// map, filter, reduce
// map
[1,2,3,4,5,6,7].map(function(value){
    return value * 10; 
});
// [10, 20, 30, 40, 50, 60, 70]

//filter
[100,  2003, 10 , 203, 333, 12],filter(function(value){
    return value > 100;
});
// [2003, 203, 333]

// reduce
let sum = [0,1,2,3,4].reduce(function (prevVal, currentVal, index, array){
    return preVal + currentVal;
});
console.log(sum); // 10을 출력한다.