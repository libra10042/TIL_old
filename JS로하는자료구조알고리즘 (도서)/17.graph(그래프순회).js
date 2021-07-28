//  그래프 순회에는 2가지 바법이 있다. 가장 일반적인 방법으로 너비 우선 검색과 기피 우선 검색이 있다.


// 1) 너비 우선 검색. ( 너비 우선 검색은 큐를 필요로 한다.)

DirectGraph.prototype.traverseBFS = function(vertex, fn){
    var queue = [], visited = {}; 


    queue.push(vertex);

    while(queue.length) {
        vertex = queue.shift();

        if(!visited[vertex]){
            visited[vertex] = true;

            fn(vertex);

            for(var adjacentVertex in this.edges[vertex]){
                queue.push(adjacentVertex);
            }
        }
        
    }
}

digraph1.traverseBFS("B", (vertex) => {console.log(vertext)});



// 2) 깊이 우선 검색  ( 그래프에서 다른 연결을 방문하기 전에 하나의 연결을 깊게 파고들며 순회하는 검색 알고리즘을 말한다. )

DirectGraph.prototype.traverseDFS = function(vertex, fn){
    var visited = {};

    this._traverseDFS(vertex, visited, fn);
}

DirectGraph.prototype._traverseDFS  = function(vertex, visited, fn){
    visited[vertex] = true; 
    
    fn(vertex);

    for(var adjacentVertex in this.edges[vertex]){
        if(!visited[adjacentVertex]){
            this._traverseDFS(adjacentVertex, visited, fn);
        }
    }


}