// 주어진 이진 트리에서 두 개의 노드의 가장 가까운 조상 찾기. 
function findLowestCommonAncestor(root, value1, value2){
    function findLowestCommonAncestorHelper(root, value1, value2){
        if(!root)
            return;
        if(Math.max(value1, value2) < root.value)
            return findLowestCommonAncestorHelper(root.left, value1, value2);
        if(Math.min(value1, value2) > root.value)
            return findLowestCommonAncestorHelper(root.right, value1, value2);
        return root.value
        
    }
    return findLowestCommonAncestorHelper(root, value1, value2);
}
var node1 = {
    value : 1, 
    left : {
        value : 0
    }, 
    right : {
        value : 2
    }
}

var node2 = {
    value : 1, 
    left : {
        value : 0, 
        left : {
            value : -1
        }, 
        right : {
            value : 0.5
        }
    }, 
    right : {
        value : 2
    }
}

console.log(findLowestCommonAncestor(node1, 0, 2)); // 1
console.log(findLowestCommonAncestor(node2, 0, 2)); // 1
console.log(findLowestCommonAncestor(node2, 0.5, -1)); // 0