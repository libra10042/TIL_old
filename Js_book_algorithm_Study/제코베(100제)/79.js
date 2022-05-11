// 순회하는 리스트
const l = [10, 20, 25, 27, 34, 35, 39];
const turn = 3; 


function rotate(a, t){
    let b = a.slice();
    let c = [];

    for(let i=0; i<t; i++){
        b.unshift(b.pop());
    }

    console.log(b);
    for(let i in b){
        c.push(Math.abs(a[i] - b[i]))
    }
    console.log(a);
    console.log(b);
    console.log(c);

    const m = Math.min.apply(null, c);
    let index = c.indexOf(m);

    console.log(index);
    console.log(a[index], b[index]);
}

console.log(rotate(l, turn));

console.log("-----------");
let test = [10, 20, 25, 27, 34, 35, 39];

console.log(test.unshift(test.pop()));
console.log(test.pop());

test.unshift(test.pop());
test.unshift(test.pop());
console.log(test);

