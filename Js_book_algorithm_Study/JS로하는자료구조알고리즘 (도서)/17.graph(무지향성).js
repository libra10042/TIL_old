// graph를 사용하면 객체간의 연결을 다양하게 나타낼 수 있다.

// 무지향적 그래프 
// : 간선 간에 방향성이 없는 그래프다. 간선은 두 노드 간에 방향 없이 상호 연결을 암시한다. 무지향성 그래프 관계의 실생활 예로 우정이 있다.

// 간선과 정점 추가하기
function UndirectedGraph(){
    this.edges = {};
}

UndirectedGraph.prototype.addVertex = function(vertex){
    this.edges[vertex] = {};
}


UndirectedGraph.prototype.addEdge = function(vertex1, vertex2, weight){
    if(weight == undefined){
        wegiht = 0; 
    }

    this.edges[vertex1][vertex2] = weight; 
    this.edges[vertex2][vertex1] = wegiht; 
}

var graph1 = new UndirectedGraph();
graph1.addVertex(1);
graph1.addVertex(2);
graph1.addEdge(1,2, 1);
graph1.edges; // 1 :{ 2 : 1}, 2: {1 : 1}
graph1.addVertex(3);
graph1.addVertex(4);
graph1.addVertex(5);
graph1.addEdge(2, 3, 8);
graph1.addEdge(3, 4, 10);
graph1.addEdge(4, 5, 100);
graph1.addEdge(1, 5, 88);


// ─────────────────────────────────────────────────────────────────────
// 간선과 정점 삭제하기
UndirectedGraph.prototype.removeEdge = function(vertex1, vertex2){
    if(this.edges[vertex1] && this.edges[vertex1][vertex2] != undefined){
        delete this.edges[vertex1][vertex2];
    } 

    if(this.edges[vertex2] && this.edges[vertex2][vertex1] != undefined){
        delete this.edges[vertex2][vertex1];
    }

}


UndirectedGraph.prototype.removeVertex = function(vertex){
    for(var adjacentVertex in this.edges[vertex]){
        this.removeEdge(adjacentVertex, vertex);
    }
    delete this.edges[vertex];
}


var graph2 = new UndirectedGraph();
graph2.addVertex(1);
graph2.addVertex(2);
graph2.addEdge(1, 2, 1);
graph2.edges; // 1: {2 : 1}, 2: {1: 1}
graph2.addVertex(3);
graph2.addVertex(4);
graph2.addVertex(5);
graph2.addEdge(2, 3, 8);
graph2.addEdge(3, 4, 10);
graph2.addEdge(3, 4, 100);
graph2.addEdge(1, 5, 88);
graph2.removeVertex(5);
graph2.removeVertex(1);
graph2.removeEdge(2, 3);