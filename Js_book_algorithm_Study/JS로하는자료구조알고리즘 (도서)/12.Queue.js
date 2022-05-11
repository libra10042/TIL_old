// 큐
/*
    큐는 스택과 달리 첫 번쨰로 추가된 항목만을 제거할 수 있는 자료 구조다. 
    연산이 산수 시간이라는 점이 큐의 장점이다. 
    알고리즘이 첫 번째로 추가된 항목만을 접근해야 하는 선입선출 방시긍로 자료를 처리해야 하는 경우에만 배열에 대해 사용한다.
    큐에 항목을 추가하는 것을 인큐라하고, 큐에서 항목을 제거하는 것을 디큐라고 한다.
*/
function Queue(array){
    this.array = []; 
    if(array) this.array = array; 
}
Queue.prototype.getBuffer = function(){
    return this.array.slice();
}
Queue.prototype.isEmpty = function(){
    return this.array.length == 0; 
}
// 큐 클래스의 인스턴스
var queue1 = new Queue();

console.log(queue1); // { array : {} }


// 들여다보기 : peek 함수는 큐에서 첫 번째 항목을 제거하지 않고도 첫 번째 항목을 반환한다.
Queue.prototype.peek = function(){
    return this.array[0];
}

// 삽입 : 삽입을 인규라고 부른다.
Queue.prototype.enqueue = function(value){
    return this.array.push(value);
}
// 시간 복잡도 : O(1)


// 삭제 : 삭제를 디큐라고 부른다. 
Queue.prototype.dequeue = function(){
    return this.array.shift();
};
var queue1 = new Queue(); 

queue1.enqueue(1);
queue1.enqueue(2);
queue1.enqueue(3);
console.log(queue1); // {array : [1,2,3]}

queue1.dequeue();
console.log(queue1); // {array : [2,3]}

queue1.dequeue();
console.log(queue1); // {array : [3]}
// 시간 복잡도 O(n)



//접근 : 배열과 달리 인덱스를 통해 큐의 항목들에 접근할 수 없다.
function queueAccessNthTopNode(queue, n){
    var bufferArray = queue.getBuffer();
    if(n<=0) throw 'error'


    var bufferQueue = new Queue(bufferArray);

    while(--n!==0){
        bufferQueue.dequeue();
    }
    return bufferQueue.dequeue(); 
} 
// 시간 복잡도 : O(n)


// 검색
function queueSearch(queue, element){
    var bufferArray = queue.getBuffer();

    var bufferQueue = new Queue(bufferArray);

    while(!bufferQueue.isEmpty()){
        if(bufferQueue.dequeue() == element){
            return true; 
        }
    }
    return false; 
}
// 시간 복잡도 : O(n)



// 스택과 큐 모두 들여다 보기, 삽입, 삭제를 O(1) 시간에 지원한다. 
// 둘의 차이점은 스택은 후입선출이고 큐는 선입선출이라는 것이다. 
