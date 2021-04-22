// 안전한 땅
/*
5 3
1 0 0 1 0 
0 1 0 0 1
0 0 0 1 0 
0 0 0 0 0 
0 0 1 0 0 
*/

let 사각형 = 5; 
let 탐색가능지역 = 4; 
let value = 0; 
let valueArray = [];
let 지뢰밭 = [[1, 0, 0, 1, 0], 
            [0, 1, 0, 0, 1], 
            [0, 0, 0, 1, 0],
            [0, 0, 0, 0, 0],
            [0, 0, 1, 0, 0]]

console.log(지뢰밭);
let iadd =0; // 가로
let jadd =0; // 세로
for(let iadd; iadd<= 사각형 - 탐색가능지역; iadd++){
    for(let iadd; iadd<= 사각형 - 탐색가능지역; jadd++){
        for(let i=iadd; iadd<= 탐색가능지역-1 + iadd; i++){
            for(let j=jadd; j<=탐색가능지역-1 +jadd; j++){
                // console.log(i, j);                     
                value += 지뢰밭[i][j]
            }
        }
        valueArray.push(value);
        value = 0; 
        console.log('-----');
        
    }
    console.log(valueArray);
}



console.log(valueArray);
console.log(Math.max.apply(null, valueArray));


let maxValue = 0; 
for(let i of valueArray){
    if(i > maxValue){
        maxValue = i;
    }
}

console.log(maxValue);



