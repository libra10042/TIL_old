function solution(nums){
    // let nums = [3,1,2,3];
    let result = 0; 
    let num = nums.length/2;
    console.log(nums.length/2);
    let arr = []; 
    
    nums.sort((a, b)=> a-b);

    for(let i=0;i<nums.length-1; i++){
        if(nums[i]!==nums[i+1]){
            arr.push(nums[i]);
        }
    }

    let max = arr.length; 
    console.log(max);

    if(max <= num){
        result = max; 
    }else{
        result = num; 
    }

    return result; 
}
