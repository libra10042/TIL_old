// 행렬 곱하기
/*
행렬 2개가 주어졌을 때 곱할 수 있는 행렬인지 확인하고 곱할 수 있다면 그 결과를 출력하고,
곱할 수 없다면 -1을 출력하는 프로그램을 만들어주세요. 

let value = 3;  // 스칼라
let value2 = [1, 2, 3]; //백터
let value3 = [[1,2,3], [1,2,3]]; // 행렬 matrix
let value4 = [3]; // qorxj
let value5 = [[3]]; //행렬
*/

// a = [[1,2], [2,4]]

// b = [[1,0], [0,3]]

// a = [[a[0][0], a[0][1], a[1][0], a[1][1]]]

// b = [[b[0][0], b[0][1], b[1][0], b[1][1]]]

function solution(a,b){
    let c = [];
    const len = a.length;

    if(len === b[0].length){
        for(let i=0; i<len; i++){
            let row = []; 
            for(let j=0; j<len; j++){
                let x=0; 
                for(let k=0; k<length; k++){
                    x += a[i][k]*b[k][j];

                }
                row.push(x);
            }
            c.push(row);
        }
        return c;
    }else{
        return -1;
    }

    return len; 
}


console.log(solution(a,b));


