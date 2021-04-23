// 수학 괄호 판별

let user_input = '))111)((111({{{';

function solution(s){
    const m = {
        ')' : '(',
        '}' : '{'
    }

    let stack = [];

    for(let i in s){
        if(s[i] === '(' || s[i] === '{'){
            stack.push(s[i]);
        } else if(m[s[i]]){
            if(stack.length === 0){
                return false; 
            }else {
                let t = m[s[i]];
                if( t != stack.pop()){
                    return false;
                }
            }
        }
    }
    console.log(stack);
    return stack.length === 0; 

    console.log(stack);
}