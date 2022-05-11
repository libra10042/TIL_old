// 패션 대회

let input = "1번 : 4,2,3 2번 : 3 3번 : 2, 3, 4, 1 4번 : 2,3";

function solution(i){
    answer = [];

    let idx = i.split(/[0-4]번 : /g);

    idx.shift();
    console.log(idx);    

    for(let i=0; i<idx.length; i++){
        idx[i] = idx[i].replace(/ /g, '').split(','); 
    }



    console.log(idx);

    for(let i of idx){
        for(let j of i){
            if(!answer.includes(j)){
                answer.push(j);
            }
        }
    }
    answer.map(x => parseInt(x, 10));

    return answer; 
}

console.log(solution(input));
