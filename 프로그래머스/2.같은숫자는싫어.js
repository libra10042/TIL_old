
function solution()
{
    let answer = [];
    const number = [1,1,3,3,0,1,1];


    for(let i=0; i<number.length; i++){
        let check =0; 

        if(number[i] !== number[i+1]){
            answer.push(number[i]);
        }
    }
    
    return answer;
}

console.log(solution());

 
