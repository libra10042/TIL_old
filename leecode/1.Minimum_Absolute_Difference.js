function minimumAbsDifference(){
    const arr = [4,2,1,3]
    
    
    arr.sort();
    let result = [];
    
    
    for(let i=0; i< arr.length-1; i++){
        if(i < arr.length -1){
            console.log(result.push(Math.abs(arr[i] -arr[i+1])));
        }
        
        
        
    }
    

    return result; 
    
    
};

console.log(minimumAbsDifference());