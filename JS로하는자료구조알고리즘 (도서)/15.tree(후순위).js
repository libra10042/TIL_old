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