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
    let queue = [start];

    while(queue.length !=0){
        let n = queue.shift();
        
        if(!visited.includes(n)){
            visited.push(n);
            let sub = graph[n].filter(x => !visited.includes(x));

            for(let i of sub){
                queue.push(i);
            }

        }
    }
    return visited;

}


console.log(dfs(graph, 'E'));
