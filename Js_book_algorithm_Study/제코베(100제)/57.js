// 1의 개수

/*
0부터 1000까지 1의 개수를 세는 프로그램을 만드려고 한다.

0부터 20까지 1의 개수를 세어본다면 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 에 
각각 1이 들어가므로 12개의 1이 있게 된다.
11은 1이 2번 들어간 셈이다.
*/


let s = ''

for(let i=0; i<15; i++){
    s+= i;
}

console.log(s);

let count = 0; 
for(let a of s){
    // console.log(a);
    if(a==1){
        count++; 
    }
}

console.log(count);



const obj = {};

for(let i=0; i<1000; i++){
    let tmp = i; 
    while(tmp > 0){
        let num = tmp%10;
        if(obj[num]){
            obj[num]++;
        }else{
            obj[num] = 1;
        }
        tmp = parseInt(tmp/10, 10);
    }
}

console.log(obj[1]);