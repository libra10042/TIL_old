//  친해지고 싶어

/*
한국대학교의 감한국교수님은 학생들과 친해지기 위해서 딸에게 줄임말을 배우기로 했다.
"복잡한 세상 편하게 살자"라는 문장을 "복세편살"로 줄여 말한다.
*/

const c = "복잡한 세상 편하게 살자";

let array = c.split(" ");

console.log(array);

let result = '';

for(let k of array){
    result += k[0].split(0, 1);
}

console.log(result);