// 중순위 순회 :  왼쪽 -> 현재 -> 오른쪽순으로 노드를 방문한다.
BinaryTree.prototype.traverseInOrder = function(){
    traverseInOrderHelper(this._root);

    function traverseInOrderHelper(node){
        if(!node)
            return;
        traverseInOrderHelper(node.left);
        console.log(node.value);
        traverseInOrderHelper(node.right);
    }
}
BinaryTree.prototype.traverseInOrderIterative = function(){
    var current = this._root, 
        s = [],
        done = false; 


    while(!done){
        // 현재 노드의 가장 왼쪽에 있는 노드로 이동한다.
        if(current != null){
            // 현재 노드의 왼쪽 하위 트리를 순회하기 전에 
            // 포인터가 스택의 트리 노드를 가리키도록 한다.
            s.push(current);
            current = current.left; 

        }else {
            if(s.length){
                current = s.pop();
                console.log(current.value);
                current = current.right; 
            }else { 
                done = true; 
            }
        }
    }
}