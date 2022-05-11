// 단일 연결 리스트 뒤집기
function reverseSingleLinkedList(sll){
    var node = sll.head; 
    var prev = null; 
    while(node){
        var temp = node.next; 
        node.next = prev; 
        prev = node; 
        if(!temp)
            break; 
        node = temp; 
        
    }
    return node; 
}
// 시간 복잡도 : O(n)   / 공간 복잡도 O(1)

// -----------------------------------------------------
// 연결 리스트에서 중복된 항목 제거하기 
// 정렬 되지 않은 연결 리스트에서 중복 항목을 삭제한다. 
function deleteDuplicateInUnsortedSll(sll1){
    var track = {};

    var temp = sll1.head; 
    var prev = null; 
    while(temp){
        if(track.indexOf(temp.data) >= 0){
            prev.next = temp.next;
            sll1.size--;
        }else { 
            track.push(temp.data);
            prev = temp; 
        }
        temp = temp.next; 
    }
    console.log(temp);
}
// 시간 복잡도 l O(n²) / 공간 복잡도 : O(n)
// 위 알고리즘은 .indexOf() 메소드를 사용해 배열을 순회한다. 이는 O(n)의 사간이 걸릴 뿐만 아니라 n번 순회한다.
// 이로 인해 공간 복잡도가 O(n)이 된다. 이제 시간 복잡도를 O(n)으로 낮춰보자. 

// 정렬되지 않은 연결 리스트에서 중복 항목을 삭제한다.
function deleteDuplicateUnsortedSllBeset(sll1){
    var track = {}; 
    
    var temp = sll1.head; 
    var prev = null; 
    while(temp){
        if(track[temp.data]){
            prev.next = temp.next; 
            sll1.size--; 
        }else {
            track[temp.data] = true; 
            prev = temp; 
        }
        temp = temp.next; 
    }
    console.log(temp);
}
// 시간 복잡도 : O(n)   / 공간 복잡도 : O(n)
// 방문한 항목을 저장하고 확인하기 위해 자바스크립트 Object 해시 테이블로 사용하면 시간 복잡도를 O(n)으로 낮출 수 있다 .하지만 해시 테이블을 위한 추가적인 메모리가 필요하기 때문에 공간 복잡도는 O(n)이다.


