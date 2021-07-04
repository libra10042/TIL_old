// 후순위 순회 : 왼쪽 -> 오른쪽 -> 현재 순으로 노드를 방문한다.
BinaryTree.prototype.traversePostOrder = function(){
    traversePostOrderHelper(this._root);

    function traversePostOrderHelper(node){
        if(node.left)
            traversePostOrderHelper(node.left);
        if(node.right)
            traversePostOrderHelper(node.right);
        console.log(node.value);
    }
}

BinaryTree.prototype.traversePostOrderIterative = function(){
    // 두 개의 스택을 만든다.
    var s1 = [], 
        s2 = [];

    // 루트를 첫 번째 스택에 추가한다.
    s1.push(this._root);

    // 첫 번째 스택이 비어 있는 동안 계속 실행한다.
    while(s1.length){
        // s1으로부터 항목을 꺼내 s2에 추가한다.
        var node = s1.pop(); 

        s2.push(node);

        // 제거된 항목의 왼쪽 지식과 오른쪽 지식을 s1에 추가한다.
        if(node.left)
            s1.push(node.left);
        if(node.right)
            s1.push(node.right);


    }
    //  두번째 스택의 모든 항목을 출력한다.
    while(s2.length){
        var node= s2.pop();
        console.log(node.value);
    }

}



// 단계 순위 순회 : BFS (breadth first search) 라고 부른다.
BinaryTree.prototype.traverseLevelOrder = function(){
    // 너버 우선 검색
    var root = this._root, 
        queue = [];

    if(!root)
        return; 
    queue.push(root);

    while(queue.length){
        var temp = queue.shift();
        console.log(temp.value);
        if(temp.left)
            queue.push(temp.left);
        if(temp.right)
            queue.push(temp.right);
    }
}

/*  
    앞 노드를 방문하기 전에 루트를 조사할 필요가 있는 경우 선순위 순회를 선택하라. 선순위 순회를 선택하면 잎 노드를 방문하기 전에 모든 루트를 방문하기 떄문이다. 

    부모 노드를 방문하기 전에 잎 노드를 먼저 조사해야 하는 경우 후순위 순회를 선택하라. 후순위 순회를 선택하면 잎 노드를 검색할 때 루트를 조사하느라 시간을 낭비하지 않기 때문이다.

    트리의 노드 자체에 순서가 있어서 트리를 원래 순서대로 방문하고 싶은 경우 중순위 순회를 선택하라. 트리를 생성할 때와 동일한 순서로 방문할 수 있다. 
    선순위 순회 혹은 후순위 순회는 트리가 생성된 순서와 다른 순서로 트리를 방문한다.

    시간 복잡도 O(n) : 위의 순회는 모든 순회를 방문해야 하기 때문에 시간 복잡도가 복잡하다.





*/