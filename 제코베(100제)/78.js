// 원형 테이블
const user_input = '6 3'.split(' ');
console.log(user_input);

const n = parseInt(user_input[0], 10);
const k = parseInt(user_input[1], 10);
console.log(n, k);
function solution(n, k){
    let index = 0; 
    let q = [];
    for(let i=0; i<n; i++){
        q.push(i+1);
    }
    while(q.length > 2){
        if(index > q.length-1){
            index -= q.length;
        }
        q.splice(index, 1);
        index += k; 
        index -= 1; 
    }
    return q;
}


console.log(solution(n,k))