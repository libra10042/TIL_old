// LRU 캐싱 
/* 
LRU 캐싱은 가장 오래된 항목(가장 최근이 아닌 항목)을 먼저 제거하는 캐싱 알고리즘이다.
따라서 교체될 항목을 가장 오래전에 접근한 항목이다.
캐시의 항목에 접근하면 해당 항목은 리스트의 뒤로 이동한다.

캐시에 없는 페이지에 접근하면 가장 앞에 있는 항목이 제거되고 신규 항목이 리스트의 가장 뒤에 삽입된다. 

LRU 알고리즘을 구현하기 위해서는 어떤 노드가 언제 사용됐는지를 관리해야 한다. 
이를 구현하기 위해 LRU 캐시는 이중 연결 리스트와 해시 테이블을 사용해 구현된다.
*/  
function DLLNode(key, data){
    this.key = key; 
    this.data = data; 
    this.next = null; 
    this.prev = null;
}
//capacity는 캐시에 허용되는 노드의 개수를 정의한다.
function LRUCache(capacity){
    this.keys = {};
    this.capacity = capacity;
    this.head = new DLLNode('', null);
    this.tail = new DLLNode('', null);
    this.head.next = this.tail;
    this.tail.prev = this.head; 
}
LRUCache.prototype.removeNode = function(node){
    var prev = node.prev, next = node.next; 
    prev.next = next; 
    next.prev = prev; 
}

LRUCache.prototype.addNode = function(node){
    var realTail = this.tail.prev; 
    realTail.next = node; 

    this.tail.prev = node; 
    node.prev = realTail;
    node.next = this.tail;
}
// get과 set 함수를 정의해야 한다. get이 호출될 때마다 LRU 캐싱 방식은 해당 노드를 이중 연결 리스트의 헤드로 이동시킨다. 해당 노드가 가장 최근에 사용된 노드이기 때문이다. 노드의 삭제와 추가 시에도 동일한 방식을 사용한다.
// set을 사용해 노드를 설정하는 경우 LRU 캐시의 keys 속성을 사용해 해당 노드를 저장한다.이는 get 을 사용 시에 노드를 O(1) 시간에 접근하기 위함이다. 하지만 캐시의 용량이 가득 찬 경우 테일로부터 가장 먼 노드를 제거한다.
LRUCache.prototype.get = function(key){
    var node = this.keys[key];
    if(node == undefined){
        return null; 
    }else { 
        this.removeNode(node);
        this.addNode(node);
        return node.data; 
    }
}

LRUCache.prototype.set = function(key, value){
    var node = this.keys[key];
    if(node){
        this.removeNode(node);
    }

    var newNode = new DLLNode(key, value);

    this.addNode(newNode);
    this.keys[key] = newNode; 

    //노드를 제거한다.
    if(Object.keys(this.keys).length > this.capacity){
        var realHead = this.head.next; 
        this.removeNode(realHead);
        delete this.keys[realHead.key];
    }
}

var myLRU = new LRUCache(5);

myLRU.set(1, 1);  // 1
myLRU.set(2, 2); // 1 <-> 2
myLRU.set(3, 3); // 1 <-> 2 <-> 3
myLRU.set(4, 4); // 1 <-> 2 <-> 3 <-> 4
myLRU.set(5, 5); // 1 <-> 2 <-> 3 <-> 4 <-> 5

myLRU.get(1); // 2 <-> 3 <-> 4 <-> 5 <-> 1
myLRU.get(2); // 3 <-> 4 <-> 5 <-> 1 <-> 2

myLRU.set(6, 6); // 4 <-> 5 <-> 1 <-> 2 <-> 6
myLRU.set(7, 7); // 5 <-> 1 <-> 2 <-> 6 <-> 7
myLRU.set(8, 8); // 1 <-> 2 <-> 6 <-> 7 <-> 8


// 정리 : LFU 캐싱은 빈도를 사용해 어떤 노드를 제거해야 할지 결정하기 때문에 좋아 보인다.하지만 대부분의 경우 LFU는 LRU보다 성능이 떨어진다. LFU는 특정 시점에 한해 자주 사용된 경우를 배제하지 못하기 떄문이다.
        // 마지막으로 실제 우리가 사용하는 시스템의 동작 방식과 작업량을 고려할 때 LRU 가 가장 효과적인 알고리즘이라는 점을 알아둬야 한다.

