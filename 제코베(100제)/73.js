// 최단 경로 찾기
/*
다음과 같이 노드의 연결 관계가 그래프 형태로 주어집니다. 그 다음 경로를 구할 두 정점이 공백으로 주어질 것입니다.

두 정점 사이의 이동할 수 있는 최단거리를 출력하는 프로그램을 작성해 주세요.

이 때 최단 거리란, 정점의 중복 없이 한 정점에서 다른 정점까지 갈 수 있는 가장 적은 간선의 수를 의미합니다.

const graph = {
    'E' : ['D', 'A'], 
    'F' : ['D'],
    'A' : ['E', 'C', 'B'],
    'B' : ['A'],
    'C' : ['A'],
    'D' : ['E', 'F']
};


입출력

입력 :  A F
출력 : 2
*/

console.log(graph)

// const user_input = prompt('입력해주세요').split('')


const graph = {
    'E' : ['D', 'A'], 
    'F' : ['D'],
    'A' : ['E', 'C', 'B'],
    'B' : ['A'],
    'C' : ['A'],
    'D' : ['E', 'F']
};


let user_input = ["A", "F"];
console.log(user_input);
const start = user_input[0];
const end = user_input[1];


let queue = [];
let visited = [];

function solution(){
    let count = -1; 

    while(queue.length !== 0){
        count += 1; 
        let size = queue.length 
        for(let i=0; i<size; i++){
            let node = queue.splice(0, 1);

            if(node == end){
                return count; 
            }



        }
    }    




}













