// function solution(n , lost, reserve) {    
//     let answer = 0;
//     let arr = [];    

//     for(let i=0; i<n; i++){
//         arr.push(i+1); 
//     }   

//     console.log(JSON.stringify(arr));
//     console.log(JSON.stringify(arr) === JSON.stringify(reserve));
//     console.log(JSON.stringify(lost));
//     console.log(JSON.stringify(reserve));
    
//     console.log(arr.includes(JSON.stringify(answer)));

//     arr.forEach( answer => {
//         if(arr.indexOf(JSON.stringify(reserve))){
//             answer++
//         }else if(lost.indexOf(answer+1)){
//             answer++
//         }
//     })
      
//     return answer;
// }

// console.log(solution(5, [2,4], [1,3,5]));


// var arr = ['a', 'b', 'c'];
// var arr1 = 'a';



// console.log(arr.includes(arr1));


function solution(n, lost, reverse){
    let answer=[];
    let cnt = 0; 

    for(let i=0; i<n; i++){
        answer.push(1);
    }
    console.log(answer);

    for(let i=0; i<lost.length; i++){
        answer[lost[i]-1] = 0; 
    }
    for(let i=0; i<reverse.length; i++){
        answer[reverse[i]-1]++;
    }

    return answer; 
}

solution(5);