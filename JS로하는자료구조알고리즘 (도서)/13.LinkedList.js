// 연결 리스트 : 각 노드가 다른 노드를 가리키는 자료 구조이다.
function SinglyLinkedisNode(data){
    this.data = data; 
    this.next = null; 
}

function SinglyLinkedList(){
    this.head = null; 
    this.size = 0; 
}
SinglyLinkedList.prototype.isEmpty = function(){
    return this.size == 0; 
}


// 삽입 : 시간복잡도 O(1)
SinglyLinkedList.prototype.insert = function(value){
    if(this.head == null){ // 첫 번째 노드의 null 여부 확인
        this.head = new SinglyLinkedListNode(value);
        
    }else{
        var temp  = this.head; 
        this.head = new SinglyLinkedListNode(value);
        this.head.next = temp; 
    }
    this.size++;
}
var sll1 = new SinglyLinkedList();
sll1.insert(1); // 현재 연결 리스트 : 1 -> null
sll1.insert(12); // 현재 연결 리스트 : 12 -> 1 -> null
sll1.insert(20); // 현재 연결 리스트 : 20 -> 12 -> 1 -> null


// 값에 의한 삭제 : 시간 복잡도 O(n) 
SinglyLinkedLis.prototype.remove = function(value){
    var currentHead = this.head; 
    if(currentHead.data == value){
        // 현재 헤드가 삭제하고자 하는 값을 갖고 있기 때문에 바로 삭제한다.헤드는 이제 새로운 값을 갖는다.
        this.head = currentHead.next; 
        this.size--; 
    }else { 
        var prev = currentHead; 
        while(currentHead.next){
            if(currentHead.data == value){
                // 해당 노드를 건너뛰어 삭제한다.
                prev.next = currentHead.next; 
                prev = currentHead; 
                currentHead = currentHead.next; 
                brea; // break out of the loop
            }
            prev = currentHead; 
            currentHead = currentHead.next;
        }
        // 삭제하고자 하는 노드가 중간에도 없고 헤드에도 없다면 테일이 있을 것이다.
        if(currentHead.data == value){
            prev.next = null; 
        }
        this.size--; 
    }
}

var sll1 =  new SinglyLinkedList();
sll1.insert(1); // 현재 연결 리스트 : 1 -> null
sll1.insert(12); // 현재 연결 리스트 : 12 -> 1 -> null
sll1.insert(20); // 현재 연결 리스트 : 20 -> 12-> 1 -> null
sll1.remove(12); // 현재 연결 리스트 : 20 -> 1 -> null
sll1.remove(20); // 현재 연결 리스트 : 1 -> null



// 헤드 항목 삭제 : 연결 리스트의 헤드에 있는 항목을 삭제하는 것은 O(1)의 시간에 가능하다. 
SinglyLinkedList.prototype.deleteAtHead = function(){
    var toReturn = null; 

    if(this.head != null){
        toReturn = this.head.size; 
        this.head = this.head.next; 
        this.size--; 
    }
    return toReturn; 
}
var sll1 = new SinglyLinkedList(); 
sll1.insert(1); // 현재 연결 리스트 : 1 -> null
sll1.insert(12); // 현재 연결 리스트 : 12 -> 1 -> null 
sll1.insert(20); // 현재 연결 리스트 : 20 -> 12 -> 1 -> null
sll1.deleteAtHead(); // 현재 연결 리스트 : 12 -> 1 -> null



// 검색 : 시간 복잡도 : O(n) 단일 연결 리스트 내에 존재하는지 확인하기 위해서는 모든 next 포인터를 반복 순회하면 된다.
SinglyLinkedList.prototype.find = function(value){
    var currentHead = this.head; 
    while(currentHead.next){
        if(currentHead.data == value){
            return true; 
        }
        currentHead = currentHead.next; 
    }
    return false; 
}






