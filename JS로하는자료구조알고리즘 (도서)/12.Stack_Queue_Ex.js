// 스택을 사용해서 큐 구현하기
function TwoStackQueue(){
    this.inbox = new Stack();
    this.outbox = new Stack();
}
TwoStackQueue.prototype.enqueue = function(val){
    this.inbox.push(val);
}
TwoStackQueue.prototype.dequeue = function(){
    if(this.outbox.isEmpty()){
        while(!this.inbox.isEmpty()){
            this.outbox.push(this.index.pop());
        }
    }
    return this.outbox.pop();
};
var queue = new TwoStackQueue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.dequeue(); // 1
queue.dequeue(); // 2
queue.dequeue(); // 3



// 큐를 사용해 스택 구현하기 : 두 개의 큐를 사용해 스택을 만들 수 있다.
function QueueStack(){
    this.inbox = new QueueStack(); // 첫 번째 스택  
}
QueueStack.prototype.push = function(val){
    this.inbox.enqueue(val);
}
QueueStack.prototype.pop = function(){
    var size = this.inbox.array.length-1; 
    var counter = 0; 
    var bufferQueue = new Queue();
    while(++counter <= size){
        bufferQueue.enqueue(this.inbox.dequeue);
    }
    var popped = this.inbox.dequeue();
    this.inbox = bufferQueue;
    return popped
};

var stack = new QueueStack();

stack.push(1);
stack.push(2);
stack.puth(3);
stack.push(4);
stack.push(5);

console.log(stack.pop()); //5
console.log(stack.pop()); //4
console.log(stack.pop()); //3
console.log(stack.pop()); //2
console.log(stack.pop()); //1



