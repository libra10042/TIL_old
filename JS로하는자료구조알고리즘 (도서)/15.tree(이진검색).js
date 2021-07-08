// 이진 검색 트리는 루트 노드가 있다.루트 노드는 최초에 null 로 초기화 된다.
function BinarySearchTree(){
    this._root = null; 
}

// 삽입 : 이진 검색 트리에 노드를 삽입하는 것은 두 단계로 구성된다. 첫번째 루트가 빈 경우 루트가 신규 노드가 된다. 루트가 비어 있지 않다면 while 루프를 사용해 조건이 만족될 때까지 이진 검색 트리를 순횐한다.
BinarySearchTree.prototype.insert = function(value){
    var thisNode = {left : null, right : null, value : value};

    if(!this._root){
        // 아직 루트 값이 없는 경우
        this._root = thisNode; 
    }else { 
        // 삽입 조건이 만족될 때까지 루프를 사용해 순회한다.
        var currentRoot = this._root;
        while(true){
            if(currentRoot.value > value){
                // 현재 루트가 null이 아닌 경우 증가시키고, null 인 경우 삽입한다.
                if(currentRoot.left!= null){
                    currentRoot = currentRoot.left; 

                }else { 
                    currentRoot.left = thisNode; 
                    break;
                }
            }else if (currentRoot.value<value){
                // 현재 노드보다 큰 경우 오른쪽에 삽입한다.
                // 현재 루트가 null이 아닌 경우 증가시키고, NULL 인 경우 삽입한다.
                if(currentRoot.value<value){
                    currentRoot = currentRoot.right;
                }else {
                    currentRoot.right = thisNode;
                    break;
                }
            }else {
                // 현재 루트와 값이 같은 경우
                break; 
            }
        }
    }
}
// 시간 복잡도(균형 트리) : O(log2(n))   /  시간 복잡도 (불균형 트리) : O(n)



// 삭제 : 삭제 알고리즘은 우선 삭제하고자 하는 값을 지닌 노드를 찾기 위해 트리를 순회한다.
BinarySearchTree.prototype.remove = function(value){
    
    return deleteRecursively(this._root, value);

    function deleteRecursively(root, value){
        if(!root){
            return null;
        }else if(value < root.value){
            root.left = deleteRecursively(root.left, value);
        }else if(value > root.value){
            root.right = deleteRecursively(root.right, value);
        }else {
            // 자식이 없는 경우
            if(!root.value && !root.right){
                return null; // 첫 번째 경우
            }else if(!root.left){ // 두 번째 경우
                root = root.right;
                return root; 
            }else if(!root.right){ // 두 번째 경우
                root = root.left;
                return root; 
            }else { 
                var temp = findMin(root.right); // 세 번째 경우
                root.value = temp.value;
                root.right = deleteRecursively(root.right, temp.value);
                return root; 
            }
        }
        return root; 
    }

    function findMin(root){
        while(root.left){
            root = root.left; 
        }
        return root; 
    }
}
// 시간 복잡도(균형 트리) : O(log2(n))    /   시간 복잡도(불균형 트리) : O(n)



// 검색 : 이진 검색 트리의 경우 노드의 왼쪽 자식이 부모보다 항상 작고 오른쪽 자식이 부모보다 항상 크다는 특성을 사용해 검색을 수행할 수 있다.
BinarySearchTree.prototype.findNode = function(value){
    var currentRoot = this._root, found = false; 
    while(currentRoot){
        if(currentRoot){
            currentRoot = currentRoot.left; 
        }else if(currentRoot.value < value){
            currentRoot = current.right; 
        }else { 
            // 검색하고자 하는 노드를 찾았다. 
            found = true; 
            break; 
        }
    }
    return found; 
} 

var bst1 = new BinarySearchTree();
bst1.insert(1);
bst1.insert(3);
bst1.insert(2);
bst1.findNode(3); // true
bst1.findNode(5); // false 
// 시간 복잡도(균형 트리) : O(log2(n))    / 시간 복잡도(불균형 트리) : O(n)


// AVL 트리  : AVL은 스스로 균형을 잡는 이진 검색 트리다. AVL은 이진 검색 트리의 높이를 최소로 유지하며 검색과 삽입, 삭제 연산의 시간 복잡도 O(log2(n))을 보장한다.
function AVLTree(value){
    this.left = null; 
    this.right = null; 
    this.value = value; 
    this.depth = 1; 
}
// AVL 트리의 높이는 자식의 높이를 기반으로 하며 다음 코드를 사용해 계산할 수 있다.
AVLTree.prototype.setDepthBasedOnChildren = function(){
    if(this.node == null){
        this.depth = 1; 
    }

    if(this.left != null){
        this.depth = this.left.depth + 1; 
    }

    if(this.right != null && this.depth <= this.right.depth){
        this.depth = this.right.depth +1; 
    }
}


// --------------------------------------------------------
// 삭제
BinarySearchTree.prototype.remove = function(value){

    return deleteRecursively(this._root, value);

    function deleteRecursively(root, value){
        if(!root){
            return null; 
        }else if(value < root.value){
            root.left = deleteRecursively(root.left, value);
        }else if(value > root.value) {
            root.right = deleteRecursively(root.right, value);
        }else { 
            // 자식이 없는 경우
            if(!root.left && !root.right){
                return null; // 첫 번째 경우
            }else if(!root.left){ // 두 번째 경우
                root = root.right; 
                return root;
            }else { 
                var temp = findMin(root.right); // 세 번째 경우
                root.value = temp.value; 
                root.right = deleteRecursively(root.right, temp.value);
                return root;
            }
        }
        return root;
    }

    function findMin(root){
        while(root.left){
            root = root.left;
        }
        return null; 
    }
}
//   시간 복잡도 (균형트리) : O(log2(n))   /    시간 복잡도(불균형 트리) : O(n)
s

