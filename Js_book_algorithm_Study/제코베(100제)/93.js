// 페이지 교체 - 선입선출 알고리즘

// BCBAEBCE

// 페이지 = [B]  1번째 
// 페이지 = [B, C] 2번째 
// 페이지 = [B, C] 3번째
// 페이지 = [B, C, A] 4번째
// 페이지 = [B, C, A] 5번째
// 페이지 = [A, E, B] 6번째 
// 페이지 = [A, E, B] 7번째

const f = 3; 
const page = 'BCBABCE'.split('');


function solution(frame, page){
    let runTime = 0; 
    let temp = [];


    if(frame ===0){
        runtime = page.length * 6;
        return runTime; 
    }

    for(let i of  page){
        if(temp.includes(i)){
            runTime += 1; 
        }else{
            if(temp.length < frame){
                temp.push(i);
            }else{
                temp.shift();
                temp.push(i);
            }
            runTime += 6; 
        }
    }


    return runTime; 
}

console.log(solution(f, page));

