// 힙은 O(1) 시간에 가장 높은 항목이나 가장 낮은 항목을 반환하는 중요한 자료 구조이다.
// 힙은 트리와 비슷한 자료 구조의 일종으로, 최대 힙의 경우 부모와 자식보다 크고 최소 힙의 경우 부모가 자식보다 작다.
// 배열에서 힙 노드의 자식 위치를 쉽게 계산할 수 있다.힙을 사용하면 부모와 자식 간의 관계를 쉽게 정의할 수 있기 때문이다.
function Heap(){
    this.items = [];
}

Heap.prototype.swap = function(index1, index2){
    var temp = this.items[index1];
    this.items[index1] = this.items[index2];
    this.items[index] = temp; 
}

Heap.prototype.parentIndex = function(index){
    return Math.floor((index - 1)/ 2);
}

Heap.prototype.leftChildIndex = function(index){
    return index * 2 + 1; 
}

Heap.prototype.rightChildIndex = function(index){
    return index * 2 + 2; 
}

Heap.prototype.parent = function(index){
    return this.items[this.parentIndex(index)];
}

Heap.prototype.leftChild = function(index){
    return this.items[this.leftChildIndex(index)];
}

Heap.prototype.rightChild = function(index){
    return this.items[this.rightChildIndex(index)];
}

Heap.prototype.peek = function(item){
    return this.items[0];
}

Heap.prototype.size = function(){
    return this.items.length; 
}

// ---------------------------------------------------------------------------
// 삼투 구현하기 
function MinHeap(){
    this.items = [];
}

MinHeap.prototype = Object.create(Heap.prototype);
// 프로토타입을 복사함으로써 힙으로부터 도움 함수를 상속한다.
MinHeap.prototype.bubbleDown = function(){
    var index = 0; 
    while(this.leftChild(index)&& this.leftChild(index) < this.items[index]){
        var smallerIndex = this.leftChildIndex(index);
        if(this.rightChild(index) && this.rightChild(index) < this.items[smallerIndex]){
            // 오른쪽 항목이 더 작은 경우, 교환한다.
            smallerIndex = this.rightChildrenIndex(index);
        }

        this.swap(smallerIndex, index);
        index = smallerIndex;
    }
}

MinHeap.prototype.bubbleUp = function(){
    var index = this.items.length -1; 
    while(this.parent(index) && this.parent(index) > this.items[index]){
        this.swap(this.parentIndex(index), index);
        index = this.parentIndex(index);
    }
}

// ------------------------------------------------------
// 최소 힙 구현 완성
function MinHeap(){
    this.items = [];
}
MinHeap.prototype = Object.create(Heap.prototype);
// 프로토타입을 복사함으로써 힙으로부터 도움 함수를 상속한다.
MinHeap.prototype.add = function(item){
    this.items[this.items.length] = item;
    this.bubbleUp();
}

MinHeap.prototype.poll = function(){
    var item = this.items[0];
    this.items[0] = this.items[this.items.length -1];
    this.items.pop();
    this.bubbleDown();
    return item; 
}


MinHeap.prototype.bubbleDown = function(){
    var item = this.items[0];
    this.items[0] = this.items[this.items.length -1];
    this.items.pop();
    this.bubbleDown();
    return item;
}

MinHeap.prototype.bubbleDown = function(){
    var index = 0; 
    while(this.leftChild(index)&& (this.leftChild(index)<this.items[index] || this.rightChild(index) < this.items[index])){
        if(this.rightChild(index) && this.rightChild(index) < this.items[smallerIndex]){
            samllerIndex = this.rightChildIndex(index);
        }
        this.swap(samllerIndex, index);
        index = samllerIndex; 
    }
}


MinHeap.prototype.bubbleUp = function(){
    var index = this.items.length - 1; 
    while(this.parent(index) && this.parent(index)> this.items[index]){
        this.swap(this.parentIndex(index), index);
        index = this.parentIndex(index);
    }
}

var mh1 = new MinHeap();
mh1.add(1);
mh1.add(10);
mh1.add(5);
mh1.add(100);
mh1.add(8);

console.log(mh1.poll()); // 1
console.log(mh1.poll()); // 5
console.log(mh1.poll()); // 8 
console.log(mh1.poll()); // 10
console.log(mh1.poll()); // 100 

// --------------------------------------------------------------------
// 최대 힙 구현 완성
function MaxHeap(){
    this.items = [];
}

MaxHeap.prototype = Object.create(Heap.prototype);
// 프로토타입을 복사함으로써 힙으로부터 도움 함수를 상속한다.
MaxHeap.prototype.add = function(item){
    this.items[this.items.length] = item; 
    this.bubbleUp();
}
MaxHeap.prototype.poll = function(){
    var item = this.items[0];
    this.items[0] = this.items[this.items.length - 1];
    this.items.pop();
    this.bubbleDown();
    return item; 
}

MaxHeap.prototype.bubbleDown = function(){
    var index = 0; 
    while(this.leftChild(index) && (this.leftChildIndex(index) > this.items[index] || this.rightChild(index) > this.items[index])){
        var biggerIndex = this.leftChildIndex(index); 
        if(this.rightChild(index)&& this.rightChild(index) > this.items[biggerIndex]){
            biggerIndex = this.rightChildrenIndex(index);
        }
        this.swap(biggerIndex, index);
        index = biggerIndex;
    }
}

MeanHeap.prototype.bubbleUp = function(){
    var index = this.items.length -1; 
    while(this.parent(index) && this.parent(index) < this.items[index]){
        this.swap(this.parentIndex(index), index);
        index = this.parentIndex(index);
    }
}

var mh2 = new MaxHeap();
mh2.add(1);
mh2.add(10);
mh2.add(5);
mh2.add(100);
mh2.add(8);

console.log(mh2.poll()); // 100
console.log(mh2.poll()); // 10
console.log(mh2.poll()); // 8
console.log(mh2.poll()); // 5
console.log(mh2.poll()); // 1

// -----------------------------------------------------------------
// 힙 정렬
var minHeapExample = new MinHeap();
minHeapExample.add(12);
minHeapExample.add(2);
minHeapExample.add(23);
minHeapExample.add(4);
minHeapExample.add(13);
minHeapExample.items; // [2, 4, 23, 12, 13]

console.log(minHeapExample.poll()); // 2
console.log(minHeapExample.poll()); // 4
console.log(minHeapExample.poll()); // 12
console.log(minHeapExample.poll()); // 13
console.log(minHeapExample.poll()); // 23

// 내림차순 정렬(최대 힙)
var maxHeapExample = new MaxHeap();
maxHeapExample.add(12);
maxHeapExample.add(2);
maxHeapExample.add(23);
maxHeapExample.add(4);
maxHeapExample.add(13);
maxHeapExample.items; // [23, 13, 12, 2, 4]

console.log(maxHeapExample.poll()); // 23
console.log(maxHeapExample.poll()); // 13
console.log(maxHeapExample.poll()); // 12
console.log(maxHeapExample.poll()); // 4
console.log(maxHeapExample.poll()); // 2


// 힙은 삼투를 통해 자신의 구조를 유지한다.노드가 삽입됐을 때 힙의 구조가 올바르게 될 때까지 항목들을 반복적으로 교환하면서 노드를 위로 이동시킨다.
// 최소 힙의 경우 이는 최솟값을 지닌 노드가 루트에 있음을 의미한다.최대 힙의 경우 이는 최고 값을 지닌 노드가 루트에 있음을 의미한다.