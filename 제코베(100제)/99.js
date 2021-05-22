// 토끼들의 행진

const 돌의내구도= [1, 2, 1, 4, 5, 2];
const 토끼의점프력 = [2, 1, 3, 1];


function solution(내구도, 점프력){
    let answer = []; 

    for(let i in 점프력){
        answer.push('pass');
    }

    for(let i in 점프력){
        let 토끼의현재위치 = 0; 

        while(토끼의현재위치 < 내구도.length-1){
            토끼의현재위치 += 점프력[i];

            내구도[토끼의현재위치 -1] -= 1; 

            if(내구도[토끼의현재위치 -1 ]< 0){
                answer[i] = 'fail';
            }


        }
        let 내구도감소 = JSON.parse(JSON.stringify(내구도));
        console.log(내구도감소);
    }
    return answer;
}


console.log(solution(돌의내구도, 토끼의점프력));