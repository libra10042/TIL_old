// 깊이 우선 탐색 (DFS) - Stack
/*
데이터
graph = {'E' : ['D', 'A'], 
        'F' : ['D'],
        'A' : ['E', 'C', 'B'],
        'B' : ['A'],
        'C' : ['A'],
        'D' : ['E', 'F]}

출력
E D F A C B 

*/

const graph = {
    'E' : ['D', 'A'], 
    'F' : ['D'],
    'A' : ['E', 'C', 'B'],
    'B' : ['A'],
    'C' : ['A'],
    'D' : ['E', 'F']
};


function dfs(graph, start){
    let visited = [];
    let stack = [start];

    while(stack.length !=0){
        let n = stack.pop();
        
        if(!visited.includes(n)){
            visited.push(n);
            let sub = graph[n].filter(x => !visited.includes(x));

            for(let i of sub){
                stack.push(i);
            }

        }
    }
    return visited;

 
}

// const values = [10, 20, 30, 40, 50, 60];
// console.log(values.filter(x => x > 30))  //  값이 반환 
// console.log(values.includes(30)) // true, flase로 반환

console.log(dfs(graph, 'E'));
