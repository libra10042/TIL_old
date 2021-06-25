// 이중 연결 리스트 
// : 이중 연결 리스트를 양방향 단일 연결 리스트라고 생각해도 좋다. 이중 연결 리스트의 각 노드에는 next 포인터와 prev 포인터가 있다.
function DoublyLinkedList(data){
    this.data = data; 
    this.next = null; 
    this.prev = null; 
}

function DoublyLinkedList(){
    this.head = null; 
    this.tail = null; 
    this.size = 0; 
}
DoublyLinkedList.prototype.isEmpty = function(){
    return this.size == 0; 
}


// 헤드에 항목 삽입하기  : O(1) 
// : 이중 연결 리스트의 헤드에 항목을 삽입하는 것은 prev 포인터를 갱신해야 한다는 점을 제외하고는 단일 연결 리스트의 헤드에 항목을 삽입하는 것과 동일하다. 
DoublyLinkedList.prototype.insertAtHead = function(value){
    if(this.head === null) { // 첫 번째 노드의 null 여부 확인. 
        this.head = new DoublyLinkedListNode(value);
        this.tail = this.head; 
    } else { 
        var temp = new DoublyLinkedListNode(value);
        temp.next = this.head; 
        this.head.prev = temp; 
        this.head = temp; 
    } 
    this.size++; 
}
var dll1 = new DoublyLinkedList();
dll1.insertAtHead(10); // ddl1 구조 : 테일 : 10 헤드 : 10 
dll1.insertAtHead(12); // ddl1 구조 : 테일 : 10 헤드 : 12
dll1.insertAtHead(20); // ddl1 구조 : 테일 : 10 헤드 : 20 



// 테일에 항목 삽입하기 : 시간 복잡도 O(1)
DoublyLinkedList.prototype.insertAtTail = function(value){
    if(this.tail == null) { // 첫 번째 노드의 null 여부 확인
        this.tail = new DoublyLinkedListNode(value);
        this.head = this.tail; 
    } else { 
        var temp = new DoublyLinkedListNode(value);
        temp.prev = this.tail; 
        this.tail.next = temp; 
        this.tail = temp; 
    }
    this.size++; 
}
var dll1 = new DoublyLinkedList();
dll1.insertAtHead(10); // dd1l 구조 : 테일 : 10 헤드 : 10 
dll1.insertAtHead(12); // dd1l 구조 : 테일 : 10 헤드 : 12
dll1.insertAtHead(20); // dd1l 구조 : 테일 : 10 헤드 : 20
dll1.insertAtHead(30); // dd1l 구조 : 테일 : 30 헤드 : 20 



// 헤드의 항목 삭제하기 : 시간 복잡도 O(1) 
// : 이중 연결 리스트의 헤드에 위치한 항목은 O(1) 시간에 제거할 수 있다.
DoublyLinkedList.prototype.deleteAtHead = function(){
    var toReturn = null; 
    if(this.head !== null){
        toReturn = this.head.data; 
        
        if(this.tail === this.head){
            this.head = null; 
            this.tail = null; 
        }else { 
            this.head = this.head.next;
            this.head.prev = null; 
        }
    }
    this.size--; 
    return toReturn; 
}


// 테일의 항목 삭제하기 : 시간 복잡도 O(1) 
DoublyLinkedList.prototype.deleteAtTail = function(){
    var toReturn = null; 

    if(this.tail !== null){
        toReturn = this.tail.data; 

        if(this.tail === this.head){
            this.head = null; 
            this.tail = null; 
        }else { 
            this.tail = this.tail.prev; 
            this.tail.next = null; 
        }
    }
    this.size--; 
    return toReturn; 
}
var dll1 = new DoublyLinkedList();
dll1.insertAtHead(10); // ddl1 구조 : 테일 : 10 헤드 : 10 
dll1.insertAtHead(12); // ddl1 구조 : 테일 : 10 헤드 : 12
dll1.insertAtHead(20); // ddl1 구조 : 테일 : 10 헤드 : 20
dll1.insertAtHead(30); // ddl1 구조 : 테일 : 30 헤드 : 20
ddl1.insertAtHead(); // ddl1 구조 : 테일 : 10 헤드 : 20 



// 검색 : 시간 복잡도 O(n) 
DoublyLinkedList.prototype.findStartingHead = function(value){
    var currentHead = this.head; 
    while(currentHead.next){
        if(currentHead.data == value){
            return true; 
        }
        currentHead = currentHead.next; 
    }
    return false; 
}
var dll1 = new DoublyLinkedList(); 
dll1.insertAtHead(10); // dll1 구조: 테일: 10 헤드 : 10
dll1.insertAtHead(12); // dll1 구조: 테일: 10 헤드 : 12
dll1.insertAtHead(20); // ddl1 구조: 테일: 10 헤드 : 20
dll1.insertAtHead(30); // ddl1 구조: 테일: 30 헤드 : 20
dll1.findStartingHead(10); // true
dll1.findStartingHead(100); // false



// 시간 복잡도 : O(n)
DoublyLinkedList.prototype.findStartingTail = function(value){
    var currentTail = this.tail; 
    while(currentTail.prev){
        if(currentTail.data == value){
            return true; 
        }
        currentTail = currentTail.prev; 
    }
    return false; 
}
var dll1 = new DoublyLinkedList();
dll1.insertAtHead(10); // dll1 구조: 테일: 10 헤드 : 10 
dll1.insertAtHead(12); // dll1 구조: 테일: 10 헤드 : 12
dll1.insertAtHead(20); // dll1 구조: 테일: 10 헤드 : 20
dll1.insertAtHead(30); // dll1 구조: 테일: 30 헤드 : 20
dll1.findStartingTail(10); // true
dll1.findStartingTail(100); // false 