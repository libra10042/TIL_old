let 텃밭 = `0 0 0 0 0
0 1 0 0 0
0 1 0 0 0
0 0 1 0 0
0 0 0 1 0`.replace(/1/g, "!").replace(/0/g, "1").replace(/!/g, "0");

console.log(텃밭);
// console.log(텃밭.split("\n"));

let 역전텃밭 = []; 
for(let row of 텃밭.split("\n")){
    역전텃밭.push(row.split(" "));
}

console.log(역전텃밭);

function solution(역전텃밭){

    const 높이 = 역전텃밭.length; 
    const 넓이 = 역전텃밭[0].length; 
    let max = 0; 
    let posX = 0; 
    let posY = 0; 

    for(let i=0; i<높이; i++){
        for(let j=0; j<넓이; j++){
            역전텃밭[i][j] = parseInt(역전텃밭[i][j], 10);
        }
    }


    for(let i=1; i<높이; i++){
        for(let j=1; j <넓이; j++){
            if(역전텃밭[i][j] == 1){
                let min; 

                // 좌측 원소의 값이 가장 작은 경우
                if (역전텃밭[i - 1][j] >= 역전텃밭[i][j - 1]){
                    min = 역전텃밭[i][j-1];

                // 윗측 원소의 값이 가장 작을 경우
                }else if(역전텃밭[i-1][j] <= 역전텃밭[i][j-1]){
                    min =  역전텃밭[i-1][j];
                }

                // 대각선 원소의 값이 가장 작은 경우
                if(min >= 역전텃밭[i-1][j-1]){
                    min = 역전텃밭[i-1][j-1];
                } 

                // 현재 기준점이 그릴 수 있는 가장 큰 정사각형의 한변의 길이 
                역전텃밭[i][j] = min + 1; 

                // 텃밭배열에서 가장 큰 숫자 찾기 
                if(max <역전텃밭[i][j]){
                    max = 역전텃밭[i][j]
                    posX = j; 
                    posY = i; 
                }
            }
        }
    }

    // 밭을 #으로 표시 
    for(let i= posY - (max - 1); i < posY + 1; i++){
        for(let j = posX - (max -1); j < posX + 1; j++){
            역전텃밭[i][j] = "#";
        }
    }

    // 숫자를 다시 0 과 1로 표기 
    for(let i=0; i< 높이; i++){
        for(let j=0; j<넓이; j++){
            if(역전텃밭[i][j] >= 1){
                역전텃밭[i][j] = 0; 
            }else if(역전텃밭[i][j] == 0){
                역전텃밭[i][j] = 1; 
            }
        }
    }


   for(let i of 역전텃밭){
       console.log(i);
   }

   // 크기 출력
   console.log(max + " X " + max);


}

solution(역전텃밭);