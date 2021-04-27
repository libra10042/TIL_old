// 숫자 놀이 
// let result ='';

// for(let i=0; i<10001; i++){
//     result += i;
// }

// console.log(result);  
// let re = new RegExp(8, 'g');
// console.log(result.re);


// 1. 1 -> (1)
// 2. 11 -> (1이 1개)
// 3. 12 -> (1이 2개)
// 4. 1121 -> (1이 1개 2가 1개)
// 5. 1321 -> (1이 3개 2가 1개)
// 6. 122131 -> (1이 2개 2가 1개 3이 1개)
// 7. 132231 -> (1이 3개 2가 2개 3이 1개)

function solution(n){
    let answer = '1';

    if(n == 1){
        return 1; 
    }

    for(let i=1; i<n; i++){
        answer = rule(answer);
    }

    return answer; 
}

function rule(answer){
    let answerMax = 9;
    let result = '';

    for(let i=1; i<answerMax; i++){
        let re = new RegExp(i, 'g');
        let count = (answer.match(re) || []).length;

        if(count >= 1){
            result = result + String(i) + String(count);
        }
    }
    return result; 
}

const user_input = 7; 
console.log(solution(user_input));
