//  반평균 등수
// 한 반에 30명인 학생, 총 7개의 반 점수가 국어, 영어, 수학, 사회, 과학 순어로 있는 다중 리스트를 랜덤한 값으로 만들어주시고 아래 값을 모두 출력하시오.


/*
1. 반 점수 모두가 담긴 전교 점수 다중 리스트를 만들어주세요.
2. 반 평균 점수를 구하세요
3. 반 1등 점수를 구하세요.
4. 전교 평균을 구하세요.
*/


let score = [];
let class_score = [];
let total_score = []; 


for(let k=0; k<7; k++){
    class_score = []; 
    for(let j=0; j<30; j++){
        score = [];

        for(let i=0; i<5; i++){
            score.push(Math.floor(Math.random() * 100)+1);
        }

        class_score.push(score);
    }

    total_score.push(class_score);
}


console.log(total_score);

let total_average = []; 
let c_average = [];
let s_average = 0; 
let s_sum = 0; 
let c_sum = 0; 
let 일등 = 0; 

for(let c of total_score){
    console.log(c);
    for(let s of c){
        s_sum = s.reduce((a, b)=> a + b);
        s_average = s_sum / 5; 
        c_average.push(s_average);

        if(일등 < s_average){
            일등 = s_average;
        }

    }
    console.log(일등);
    일등 = 0; 

    total_average.push(c_average.reduce((a, b) => a + b)/30);
    c_average = []; 
}
console.log(total_average);

console.log(total_average.reduce((a, b)=> a + b) /7);