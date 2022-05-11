// 도장 찍기
let N = 4; 

let stmp = 
[[1,1,1,2],
[2,0,0,0],
[1,1,1,1],
[0,0,0,0]];

let k = 1; 

function solution(stmp, k){
    let N = stmp.length; 
    let p = [];

    for(let i=0; i<N; i++){
        p.push(Array(N).fill(0));
    }
    // console.log(p);

    // 회전시키기 전 최초 1번 찍어주기
    p = sum_matrix(p, stmp);

    for(let i=0; i<k; i++){
        stmp = rotate(stmp);
        p = sum_matrix(p, stmp);
    }


    return p; 
}


function rotate(stmp){
    let N = stmp.length; 
    let rot = [];

    for(let i=0; i<N ; i++){
        rot.push(Array(N).fill(0));
    }

    for(let i=0; i<N ; i++){
        for(let j=0; j<N; j++){
            rot[j][N-1-i] = stmp[i][j];
        }
    }

    return rot;
}

function sum_matrix(p, stmp){
    for(let i=0; i<N; i++){
        for(let j=0; j<N; j++){
            p[i][j] += stmp[i][j];
        }
    }


    return p; 
}



console.log(solution(stmp, k));