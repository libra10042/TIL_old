// 다익스트라 알고리즘 : 목적지에 도달하기 위해 각 단계에서 최단 경로를 취하는 방식으로 동작한다.

function _isEmpty(obj){
    return Object.keys(obj).length === 0;
}

function _extractMin(Q, dist){
    var minimumDistance = Infinity, 
        nodeWithMinimumDistance = null; 
        
        
    for(var node in Q){
        if(dist[node] <= minimumDistance){
            minimumDistance = dist[node];
            nodeWithMinimumDistance = node; 
        }
    }
    return nodeWithMinimumDistance;
}


DirectedGraph.prototype.Dijkstra = function(source){
    // 정접 집합 Q를 생성한다.
    var Q = {}, dist = {};
    
    for(var vertex in this.edges){
        // 모르는 거리는 무한으로 설정한다.
        dist[vertex] = Infinity;
        // v를 Q에 추가한다.
        Q[vertex] = this.edges[vertex];
    }


    // 출발점에서 출발점까지의 거리를 0으로 설정한다.
    dist[source]  = 0; 

    while(!_isEmpty(Q)){
        var u = _extractMin(Q, dist); // 최소 거리를 얻는다.

        // Q로부터 u를 제거한다.
        delete Q[u];

        // v가 여전히 Q에 있는 한
        // u의 각 이웃 V에 대해 다음을 수행한다.
        for(var neighbor in this.edges[u]){
            // 현재 거리
            var alt = dist[u] + this.edges[u][neighbor];
            // 더 짧은 경로가 발견됐다.
            if(alt < dist[neighbor]){
                dist[neighbor] = alt; 
            }
        }
    }
    return dist; 
}

var diagraph1 = new DirectedGraph();
diagraph1.addVertex("A");
diagraph1.addVertex("B");
diagraph1.addVertex("C");
diagraph1.addVertex("D");
diagraph1.addEdge("A", "B", 1);
diagraph1.addEdge("B", "C", 1);
diagraph1.addEdge("C", "A", 1);
diagraph1.addEdge("A", "D", 1);

console.log(diagraph1);

// DirectedGraph {
// V : 4,
// E : 4, 
// edges : {A : {b : 1, D: 1}, B: { c: 1}, C : {a : 1}, D : {} }}
diagraph1.Dijkstra("A"); // {A : 0, B: 1, C : 2, D : 1}