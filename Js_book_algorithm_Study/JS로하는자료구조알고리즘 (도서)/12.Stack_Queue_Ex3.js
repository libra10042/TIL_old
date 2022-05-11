// 스택을 사용해 괄호 검증기 설계하기
// : 스택을 사용하는 경우 왼쪽 괄호를 저장한 다음 오른쪽 괄호르르 발견했을 때 push와 pop을 사용해 괄호의 유효성을 검증할 수 있다. 
function isParenthesisValid(validationString){
    var stack = new Stack();
    for(var pos =0; pos<validationString.length; pos++){
        var currentChar = validationString.charAt(pos);
        if(currentChar =="("){
            stack.push(currentChar);
        }else if(currentChar == ")"){
            if(stack.isEmpty())
                return false; 
            
            stack.pop();
            
        }
    }
    return stack.isEmpty();
}
isParenthesisValid("((()"); // false
isParenthesisValid("(((("); // false
isParenthesisValid("()()"); // true; 
// 시간 복잡도 O(n)

// ------------------------------------------------------------------
// 정렬 가능한 스택 설계하기 
function sortableStack(size){
    this.size = size; 

    this.mainStack = new Stack(); 
    this.sortedStack = new Stack();

    // 무작위 정수로 스택을 초기화한다.
    for(var i=0; i<this.size; i++){
        this.mainStack.push(Math.floor(Math.random()* 11));
    }
}
sortableStack.prototype.sortStackDescending = function(){
    while(!this.mainStack.isEmpty()){
        var temp = this.mainStack.pop();
        while(!this.sortedStack.isEmpty() && this.sortedStack.peek() < temp){
            this.mainStack.push(this.sortedStack.pop());
        }
        this.sortedStack.push(temp);
    }
}


var ss = new sortableStack(10);
console.log(ss); // [ 8, 3, 4, 4, 1, 2, 0, 9, 7, 8]
ss.sortStackDescending();
console.log(ss.sortedStack); // [ 9, 8, 8, 7, 4, 4, 3, 2, 1, 0]
// 시간 복잡도 : O(n²)
