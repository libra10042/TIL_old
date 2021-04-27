// 페이지 교체 - LRU 알고리즘
// 패이지 부재가 발생했을 경우 가장 오랫동안 사용되지 않은 페이지를 제거하는 알고리즘.


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
            temp.splice(temp.indexOf(i), 1);
            temp.push(i);
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
