// 객체 함수의 응용
// 다음의 객체가 주어졌을 때 한국의 면적과 가장 비슷한 국가와 그 차이를 출력하시오. 

const nationWidth = {
    'korea' : 220877,
    'Rusia' : 17098242,
    'China' : 9596961,
    'France' : 543965,
    'Japen' : 377915,
    'England' : 242900,
}
            // 카멜 표기법
const w = nationWidth['korea'];

delete nationWidth['korea'];
console.log(nationWidth);


const entry = Object.entries(nationWidth);
console.log(entry);

const values = Object.values(nationWidth);
values.sort((a,b)=>{
    return a-b; 
});
console.log(values);

let gap = Math.max.apply(null, values);
console.log(gap);


let item = []; 
for(let i in entry){
    if(gap > Math.abs(entry[i][1] - w)){
        gap = Math.abs(entry[i][1] -w);
        item  = entry[i];
    }
}

console.log(item[0], item[1] -w);
