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


