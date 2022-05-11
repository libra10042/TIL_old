// 순열과 조합
// 조합은 순서를 신경쓰지 않고, 순열은 순서를 신경 쓴다. 


function solution(chars){
    let combi = []; 

    const f = (pre, charsArray) =>{
        for(let i=0; i<charsArray.length; i++){
            console.log(pre + charsArray[i]);
            combi.push(pre + charsArray[i]);
            f(pre + charsArray[i], charsArray.slice(i + 1));
        }
    }

    // pre charsArray
    // [A, B, C, D]


    f('', charsArray);


    const result = cmobi.filter(x => x.length ===n)
    return result; 

}

const arr = 'A,B,C'.split(',');
console.log(arr);
const user_input_n = 3;

console.log(solution(arr, user_input_n));
