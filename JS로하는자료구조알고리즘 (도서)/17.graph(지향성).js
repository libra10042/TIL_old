// 지향성 그래프 : 정점간에 방향이 있는 그래프다. 

function DirectedGraph(){
    this.edges = {};
}

DirectedGraph.prototype.addVertex = function (vertex){
    this.edges[vertex] = {}; 
}

DirectedGraph.prototype.addEdge = function(orgVertex, destVertex, weight){
    if(weight === undefined){
        weight =0; 
    }

    this.edges[origVertex][destVertext] = weight; 
}

var digraph1 = new DirectedGraph();
digraph1.addVertex("A");
digraph1.addVertex("B");
digraph1.addVertex("C");
diagraph1.addEdge("A", "B", 1);
diagraph1.addEdge("B", "C", 2);
diagraph1.addEdge("C", "A", 3);


DirectedGraph.prototype.removeEdge = functoin(origVertex, destVertex){
    if(this.edges[origVertex] && this.edges[origVertex][destVertex] != undefined){
        delete this.edges[origVertex][destVertex];
    }
}

DirectedGraph.prototype.removeVertex = function(vertex){
    for(var adjacentVertex in this.edges[vertex]){
        this.removeEdge(adjacentVertex, vertext);
    }
    delete this.edges[vertex];
}
