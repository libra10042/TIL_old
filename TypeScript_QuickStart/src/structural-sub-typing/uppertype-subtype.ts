type upper = {a: string, b: string};
type sub = {a: string, b: string, c: string};
let objectUpper : upper = { a:"a", b : "b"};

let objectSub : sub = {a:"a", b: "b", c:"c"}; // <--- 하위 타입
objectUpper = objectSub;    // <-- 상위 타입 = 하위 타입
console.log(objectUpper);   // <-- {a : 'a', b:'b', c:'c'}

