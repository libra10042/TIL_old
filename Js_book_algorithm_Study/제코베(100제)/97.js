// 택배 배달. 

/*
n 명의 택배 배달원은 쌓인 택배를 배달해야 한다.
각 택배는 접수된 순서로 배달이 되며 택배마다 거리가 주어진다.
거리1당 1의 시간이 걸린다고 가정하였을 떄 모든 택배가 배달 완료될 시간을 구하세요.

1. 모든 택배의 배달 시간 1 이상이며 배달지에 도착하고 돌아오는 왕복 시간 입니다.
2. 택배는 물류창고에서 출발합니다.
3. 배달을 완료하면 다시 물류창고로 돌아가 택배를 받습니다. 
4. 물류창고로 돌아가 택배를 받으면 배달을 시작합니다. 
5. 택배를 상차할 때 시간은 걸리지 않습니다. 

*/


function solution(n, l){
    // n : 택배원 수, l : 택배의 배달 거리 
    let answer = 0; 
    let man = new Array(n).fill(0);
    console.log(man);

    while(l.length !== 0){
        for(var j=0; j<man.length; j++){
            if(man[j] == 0 && l){
                man[j] += l.shift();
            }
        }

        man = man.map(x => x = x -1);
        console.log(man);

        answer += 1; 
    }
    return answer + Math.max.apply(null, man);


}

const 배달원 = 3; 
const 배달시간 = [1,2,1,3,3,3];

console.log(solution(배달원, 배달시간));

