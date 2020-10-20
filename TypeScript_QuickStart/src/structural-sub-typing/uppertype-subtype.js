var objectUpper = { a: "a", b: "b" };
var objectSub = { a: "a", b: "b", c: "c" }; // <--- 하위 타입
objectUpper = objectSub; // <-- 상위 타입 = 하위 타입
console.log(objectUpper); // <-- {a : 'a', b:'b', c:'c'}
