// 회전 초밥

const point = [1,1,3,2,5];
const dish = 3; 

function solution(point, dish){
    let answer = 0; 

    dish -= 1; 

    let s = point.slice();
    // console.log(s);

    s.sort((a,b) => {
        return a-b; 
    })

    // console.log(s);

    while(true){
        let p = point.shift();
        
        if(s[0] === p){
            // 내가 원하는 접시? 그렇지 않은 접시 
            if(dish === 0){
                break;
            }

            dish -= 1; 
            s.shift(); 

        }else{
            point.push(p);
            if(dish === 0){
                dish = point.length - 1; 
            }else{
                dish -= 1; 
            }
        }

        break;
    }

    return answer; 

}

console.log(solution(point, dish));

