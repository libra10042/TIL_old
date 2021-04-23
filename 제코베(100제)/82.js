// 수학 괄호 판별 

user_input = '((())';

function solution(s){
    let step = 0; 
    for(let i in d){
        if(d[i] === '('){
            step +=1;
        } else if(d[i] === ')'){
            step +=-1;
        }
    }
    if(step !== 0){
        return false; 
    }

    if(step === 0){
        return true; 
    }

}

console.log(solution(user_input));