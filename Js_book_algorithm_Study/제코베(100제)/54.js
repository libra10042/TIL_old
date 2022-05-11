// 연속되는 수 
/*
입력 1
1 2 3 4 5

출력1 
YES


입력 2
1 4 2 6 3

출력2
NO
*/



function solution(arr){
    arr.sort((a,b) => {return a-b});

    for(let i=0; i<arr.length-1; i++){
        if(arr[i] + 1 !== arr[i+1] ){
            return 'No';
        }
    }
    return 'YES';
}

const n = '1 3 4 2 5 6'.split(' ')
console.log(n);
console.log(solution(n));