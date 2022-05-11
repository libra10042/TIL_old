/*  
캐싱 설계는 다음 두가지 요소를 고려한다.
1) 시간적 지역성 : 최근에 접근한 메모리 위치를 다시 접근할 가능성이 높다.
2) 공간적 지역성 : 최근에 접근한 메모리 위치 주변의 위치를 다시 접근할 가능성이 높다.


LFU(최소빈도 사용) 캐싱 : 운영체제가 메모리를 관리하기 위해 사용하는 캐싱 알고리즘이다.

설계상 캐시가 자신의 한계를 초과하는 경우 운영체제는 가장 참조 빈도가 낮은 항목을 삭제한다.


LFU 캐시잉 직관적인 접근법처럼 보이지만 메모리의 항목이 단시간에 반복적으로 참조된 다음 이후에 접근을 하지 않는 경우 이상적인 접근법이 아니다. 

반복된 참조에 인해 해당 블록의 빈도는 높다. 따라서 해당 블록이 집중저긍로 참조된 짧은 시간을 제외한 나머지 시간 동안 더 자주 사용되는 다른 블록이 삭제될 수 있다.게다가 

신규 항목이 접근 빈도가 낮다는 이유로 캐시에 포함된지 얼마 안돼 삭제될 가능성이 있다. 이러한 문제로 인해 LFU는 잘 사용하지 않는다.

LFU 캐시는 이중 연결 리스트를 사용해 O(1) 시간에 항목을 제거한다. LFU에서 이중 연결 노드에는 freqCount 속성이 있다.
freqCount 속성은 해당 노드가 삽이보딘 다음에 해당 노드에 얼마나 자주 접근하거나 해당 노드를 얼마나 자주 설정했는지 나타낸다.
*/
function LFUNode(key, value) {
    this.prev = null; 
    this.next = null; 
    this.key = key; 
    this.data = value; 
    this.freqCount = 1; 
}



//LFU 캐시에는 keys와 freq라는 두 개의 해시 테이블이 있다. freq의 키는 빈도를 나타내고 각 항목은 이중 연결 리스트 클래스의 인스턴스이다. keys는 O(1) 시간에 노드를 접근할 수 있도록
// 각 이중 연결 리스트 노드를 저장한다.
function LFUDoublyLinkedList(){
    this.head = new LFUNode('buffer head', null); 
    this.tali = new LFUNode('buffer tail', null);
    this.head.next = this.tali; 
    this.tail.prev = this.head; 
    this.size = 0; 
}

function LFUCache(capacity){
    this.keys = {}; // LFUNode를 저장한다.
    this.freq = {}; // LFUDoulbyLinkedList를 저장한다.
    this.capacity = capacity; 
    this.minFreq = 0; 
    this.size = 0; 
}


// LFUDoublyLinkedList 클래스는 삽입과 제거를 위해 이중 연결 리스트 구현을 필요로 한다. 하지만 삽입은 헤드에서만 일어나고 제거는 테일에서만 일어난다.이러한 구현은 이중 연결 리스트 클래스의 구현과 동일하다.
LFUDoublyLinkedList.prototype.insertAtHead = function(node){
    node.next = this.head.next; 
    this.head.next.prev = node; 
    this.head.next = node; 
    node.prev = this.head; 
    this.size++; 
}

LFUDoublyLinkedList.prototype.removeAtTail = function(){
    var oldTail = this.tail.prev; 
    var prev = this.tail.prev; 
    prev.prev.next = this.tail; 
    this.tail.prev = prev.prev; 
    this.size--; 
    return oldTail; 
}


LFUDoublyLinkedList.prototype.removeNode = function(node){
    node.prev.next = node.next; 
    node.next.prev = node.prev;
    this.size--; 
}


// LFU의 set 구현하기
LFUCache.prototype.set = function(key, value){
    var node = this.keys[key];


    if(node == undefined){
        node = new LFUNode(key, value);

        this.keys[key] = node; 

        if(this.size != this.capacity){
            //삭제 없이 삽입하기 
            if(this.freq[1] == undefined){
                this.freq[1] = new LFUDoublyLinkedList();

            }

            this.freq[1].insertAtHead(node);
            this.size++; 
        }else { 
            // 삭제 후 삽입하기
            var oldTail = this.freq[this.minFreq].removeAtTail(); 
            delete this.keys[oldTail.key];

            if(this.freq[1] === undefined){
                this.freq[1] = new LFUDoublyLinkedList();
            }

            this.freq[1].insertAtHead(node);
        }
        this.minFreq = 1;
    }else{
        var oldFreqCount = node.freqCount; 
        node.data = value; 
        node.freqCount++; 


        this.freq[oldFreqCount].removeNode(node);

        if(this.freq[node.freqCount] === undefined){
            this.freq[node.freqCount] = new LFUDoublyLinkedList();
        }

        this.freq[node.freqCount] = new LFUDoublyLinkedList();

        if(oldFreqCount == this.minFreq && Object.keys(this.freq[oldFreqCount]).size == 0 ){
            this.minFreq++; 
        }
    }
}


// LFU get 구현하기 
LFUCache.prototype.get = function(key){
    var node = this.keys[key];

    if(node == undefined){
        return null;
    }else { 
        var oldFreqCount = node.freqCount; 
        node.freqCount++; 

        this.freq[oldFreqCount].removeNode(node);

        if(this.freq[node.freqCount] === undefined){
            this.freq[node.freqCount] = new LFUDoublyLinkedList(); 
        }

        this.freq[node.freqCount].insertAtHead(node);

        if(oldFreqCount == this.minFreq && Object.keys(this.freq[oldFreqCount]).length == 0){
            this.minFreq++; 
        }
        return node.data; 
    }
}