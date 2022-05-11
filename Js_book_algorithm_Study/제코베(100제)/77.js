// 가장 긴 공통 부분 문자열

function solution(string){
    let result = [];
    for(let i=1; i<string.length + 1; i++){
        for(let j=0; j<i; j++){
            result.push(string.slice(j, j + string.length + 1 -i));
        }
    }
    return result;
}

console.log(solution("ABCDEF"));

let inputOne = "ABCDF";
let inputTwo = "BCE";
let ArrayOne = solution(inputOne);
let ArrayTwo = solution(inputTwo);


let inter = ArrayOne.filter(x => ArrayTwo.includes(x));
console.log(inter);

inter.sort((a, b) =>{
    return b.length - a.length; 
})


console.log(inter[0].length);

let s  = ['ABC', 'DEF', 'ABCDE', 'ABCDEF'];
let ss = s.filter(word => word.length >=4);
console.log(ss);


let i = [1, 2, 100000, 22, 300, 33];
i.sort((a,b) => {
    return a-b; 
})
console.log(i);