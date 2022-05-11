// 스택
/*
    스택은 속도가 빠르다는 점이 장점이다. 
    스택은 pop과 push 라는 메소드가 있다.
*/
function Stack(array){
    this.array = []; 
    if(array) this.array = array; 
}
Stack.prototype.getBuffer = function(){
    return this.array.slice(); 
}
Stack.prototype.isEmpty = function(){
    return this.array.length == 0; 
}
// 스택 클래스의 인스턴스
var stack1 = new Stack(); 

console.log(stack1); // {array : []}



// 들여다보기 : 마지막에 추가된 항목을 스택 자료 구조에서 제거하지 않고 반환하는 것을 의미한다. 
Stack.prototype.peek = function(){
    return this.array[this.array.length-1];
}
stack1.push(10);
console.log(stack1.push()); // 10 
stack1.push(5);
console.log(stack1.peek); // 5
// 시간 복잡도 : O(1)


// 삽입 : push
Stack.prototype.push = function(value){
    this.array.push(value);
}
stack1.push(1);
stacl1.push(2);
stack1.push(3);
console.log(stack1);  // {array : [1,2,3]}
// 시간 복잡도 : o(1)


// 삭제 : pop을 통해 수행된다.
Stack.prototype.pop = function(){
    return this.array.pop();
};
stack1.pop(1);
stack1.pop(2);
stack1.pop(3);
console.log(stack1); // {array : []}
// 시간 복잡도 : O(1)


// 접근
function stackAccessNthTopNode(stack, n){
    var bufferArray = stack.getBuffer();
    if(n<=10) throw 'error'

    var bufferStack = new Stack(bufferArray);

    while(--n!==0){
        bufferStack.pop();
    }
    return bufferStack.pop();
}
var stack2 = new Stack();
stack2.push(1);
stack2.push(2);
stack2.push(3);
stackAccessNthTopNode(stack2, 2); // 2
// 시간 복잡도 : O(n)


// 검색 : 우선 pop이 버퍼 스택에 대해 호출될 수 있도록 버퍼 스택을 만들어야 한다.
function stackSearch(stack, element){
    var bufferArray = stack.getBuffer();

    var bufferStack = new Stack(bufferArray); // 버퍼 스택으로 복사한다.

    while(!bufferStack.isEmpty()){
        if(bufferStack.pop()==element){
            return true; 
        }
    }
    return false; 
}
// 시간 복잡도 : O(n)


