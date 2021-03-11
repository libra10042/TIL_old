function solution(arr, divisor) {
    var answer = [];
    
    for(let i=0; i<arr.length; i++){
        if(arr[i] % divisor ===0){
            answer.push(arr[i]);
        }
    }
    
    if(divisor >= 1){
        answer.sort((a,b) => a - b)
    }
    
    if(answer.length=== 0){
        // return answer.push(-1);
        return [-1];
    }
   
    
    return answer;
}