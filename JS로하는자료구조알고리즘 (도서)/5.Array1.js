// 삽입 -> 시간 복잡도 : O(1)
var array1 = [1,2,3,4];
array1.push(5); // array1 = [1,2,3,4,5]
array1.push(7); // array1 = [1,2,3,4,5,6,7]
array1.push(2); // array1 = [1,2,3,4,5,7,2]


// 삭제 -> 시간 복잡도 : O(1)
var array1 = [1,2,3,4];
array1.pop(); // 4를 반환한다. array1 = [1,2,3]
array1.pop(); // 3를 반환한다. array1 = [1,2]

array1 = [1,2,3,4];
array1.shift(); // 1를 반환한다. array1 = [2,3,4]
array1.shift(); // 2를 반환한다. array1 = [3,4]


// 접근 -> 시간 복잡도 : O(1)
var array1 = [1,2,3,4];
array1[0]; // 1을 반환한다.
array1[1]; // 2를 반환한다.


// 반복 -> 시간 복잡도 : O(n)
for(let i=0, len=array1.length; i<len; i++){
    console.log(array1[i]);
}


// for (in) 
let array2 = ['all', 'cows', 'are', 'big'];
for(let index in array1){
    console.log(index);
    // 0, 1, 2, 3
}

for(let index in array2){
    console.log(array2[index]);     
}

for(var element of array2){
    console.log(element);
}


// farEach()
let array3 = ['all', 'cows', 'are', 'big'];
array1.forEach(function(element, index){
    console.log(element);
});
array1.forEach(function(element, index){
    console.log(array1[index]);
})


// 도움 함수 -> .slice(begin, end)
let array4= [1,2,3,4];
array4.slice(1,2); // [2]를 반환한다..array1 = [1,2,3,4]
array4.slice(2,4); //[3,4]를 반환한다. array1 = [1,2,3,4]

array1.slice(1); // [2,3,4] 를 반환한다. arrray1 = [1,2,3,4]
array1.slice(1,4); // [2,3,4] 를 반환한다. array1 = [1,2,3,4]
// 매개변수로 아무것도 전달하지 않는 경우 .slice() 는 배열의 복사본을 반환한다.
// array1.slice() === array1 가 false로 평가된다는 점에 유념하자. 

let array1 = [1,2,3,4], array2 = array1; 

array1 // [1,2,3,4]
array2 // [1,2,3,4]

array2[0] = 5; 

array1 // [5,2,3,4]
array2 // [5,2,3,4]


// from 를 이용해 새로운 배열 생성. 
let array5 = [1,2,3,4];
let array6 = Array.from(array5);

array5 // [1,2,3,4]
array6 // [1,2,3,4]

array2[0] = 5; 
array5 // [1,2,3,4]
array6 // [5,2,3,4]

// .from()의 시간 복잡도는 O(n)이다. 여기서 n은 배열의 크기를 나타낸다.



// .splice(begin, size, element1, element2...)
// .splice() 도움 함수는 기존 항목을 제거하거나 신규 항목을 추가함으로써 배열의 내용을 반환한다.
let array7 = [1,2,3,4];
array7.splice();  // []를 반환한다, array7 = [1,2,3,4]
array7.splice(1, 2); // [2,3] 을 반환한다. array7 = [1,4]

let array8 = [1,2,3,4];
array8.splice(); // []를 반환한다, array1 = [1,2,3,4]
array8.splice(1,2,5,6,7); // [2,3]을 반환한다, array8 = [1,5,6,7,4]

// .splice()는 시간 복잡도가 O(n)이다.
let array9 = [1,2,3,4];
array9.splice(1,2,[5,6,7]); // [2,3]을 반환한다, array9 = [1,[5,6,7],4]
array9 = [1,2,3,4];
array9.splice(1,2,{'ss':1}); // [2,3]을 반환한다, array9 = [1, {'ss' : 1},4]



// .concat() 
let array10 = [1,2,3,4];
array10.concat(); // [1,2,3,4]를 반환한다, array10 = [1,2,3,4]
array10.concat([2,3,4]); //[1,2,3,4,2,3,4] 를 반환한다, array10 = [1,2,3,4]


// .length() 
let array11 = [1,2,3,4];
console.log(array11.length); // 4를 출력한다.
array11.length = 3; // array11 = [1,2,3]
