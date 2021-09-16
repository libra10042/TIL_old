const [a, b] = [10, 20];
console.log(a);
console.log(b);


const {c, d} = {c : 10, d: 20};
console.log(c); //10
console.log(d); //20


// 배열 오브젝트의 나머지 값 할당. 
const arr = [10, 20, 30, 40, 50];
const [i, j, ...rest] = arr;
console.log(i); // 10 
console.log(j); // 20
console.log(rest); // [30, 40, 50] 

// 배열의 일부 값 무시하여 할당. 
const arr1 = [10, 20, 30, 40, 50];
const [start, , , , end] = arr1; 
console.log(start);
console.log(end);

// 오브젝트 새로운 변수이름으로 할당. 
const obj = {a : 3, b : 5};
const {a : aa = 10, b : bb = 5} = obj; 
 
console.log(aa); // 3
console.log(bb); // 5