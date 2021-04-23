//  숫자 뽑기
function solution(chars){
    let result = [];

    const f = (pre, chars) =>{
        for(let i=0; i<chars.length; i++){
            result.push(pre + chars[i]);


            f(pre + chars[i], chars.slice(i + 1));
        }
    }

    f('', chars);
    console.log(result);

    result = result.filter(x => x.length === length)
    console.log(result);
    
    result.sort((a, b) => {return a-b})
    
    return result[0];

    
}

const num = '1723'
const len = 2; 



console.log(solution(num, len));