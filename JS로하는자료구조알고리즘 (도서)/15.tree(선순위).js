// 첫 번쨰이자 가장 상위 노드를 루트라고 부른다. 
// 노드용 코드는 다음과 같다.
function TreeNode(value){
    this.value = value; 
    this.children = [];
}



// 이진 트리 
function BinaryTreeNode(value){
    this.value = value; 
    this.left = null; 
    this.right = null; 
}


// 트리 순회
/*
    트리의 경우 트리의 모든 항목을 방문하기 위해 왼쪽 포인터와 오른쪽 포인터가 존재한다.
    가장 널리 사용되는 순회 기법으로 선순위 순회, 후순위 순회, 순위 순회, 단계순위 순회가 있다.
*/
// 선순위 순회 : 현재-> 왼쪽 오른쪽순으로 노드를 방문한다.
// 1) 재귀 이용
BinaryTree.prototype.ttaversePreOrder = function(){
    traversePreOrderHelper(this._root);

    function traversePreOrderHelper(node){
        if(!node)
            return;
        console.log(node.value);
        traversePreOrderHelper(node.left);
        traversePreOrderHelper(node.right);
    }
}

// 2) 반복문 이용
BinaryTree.prototype.traversePreOrderHelper = function(){
    // 빈 스택을 생성한 루트를 스택에 추가한다.
    var nodeStack = [];
    nodeStack.push(this._root);

    // 모든 항목을 하나씩 꺼낸다. 꺼낸 모든 항목에 대해 다음 사항을 추가한다.
    // a) 항목을 출력한다.
    // b) 오른쪽 자식을 스택에 추가한다.
    // c) 왼쪽 자식을 스택에 추가한다.
    // 오른쪽 자식을 왼쪽 자식보다 먼저 스택에 추가해
    // 왼쪽 자식이 먼저 처리되도록 했다는 점에 주의하자.
    while(nodeStack.lenght){
        // 스택으로부터 최상위 항목을 꺼낸 다음 출력한다.
        var node = nodeStack.pop();
        console.log(node.value);


        // 꺼낸 노드의 오른쪽 자식과 왼쪽 자식을 스택에 추가한다.
        if(node.right){
            nodeStack.push(node.right);
        }
        if(node.left){
            nodeStack.push(node.left);
        }
    }
}
// 결과는 [42, 41, 10, 40, 50, 45, 75]