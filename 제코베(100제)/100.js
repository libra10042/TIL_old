// 퍼즐 게임
 
let 퍼즐판 = [[0, 0, 0, 0], 
            [0, 1, 0, 3], 
            [2, 5, 0, 1], 
            [2, 4, 4, 1], 
            [5, 1, 1, 1]];

let 조작 = [1,1,1,1,3,3,3];

function solution(plate, moves){
    let stack = [0]; 
    let point = 0; 

    while(moves.length !== 0){
        let m = moves.shift(); 
        for(let i=0; i<plate.length; i++){
            if(plate[i][m-1] !== 0){
                if(stack[stack.length -1] == plate[i][m-1]){
                    point += plate[i][m-1] * 2; 
                    plate[i][m-1]=0; 
                    stack.pop();
                }else {
                    stack.push(plate[i][m-1]);
                }
                    
                plate[i][m-1] = 0;
                break;
            }else if(i == plate.length -1) { 
                point -= 1; 
            }
        }

        let k = JSON.parse(JSON.stringify(moves));
        let s = JSON.parse(JSON.stringify(stack));
        let p = JSON.parse(JSON.stringify(point));

        console.log('move', k);
        console.log('stack', s);
        console.log('point', p);


    }


    return point; 
}

console.log(solution(퍼즐판, 조작));