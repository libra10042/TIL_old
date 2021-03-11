function solution(a, b) {
    let answer = 0;
    
   
    if(a < b){
        for(let i=a; i<=b; i++){
            answer +=i; 
            console.log(i);
        }
    }else{
        for(let i=b; i<=a; i++){
            answer +=i; 
            console.log(b);
        }
    }

    
    
    return answer;
}


console.log(solution(7,5));