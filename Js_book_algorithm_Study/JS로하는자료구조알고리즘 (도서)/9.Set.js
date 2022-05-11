// Set
// 집합(Set)은 가장 근간이 되는 자료 구조 중 하나이다. 
// Set 객체에는 속성이 하나만 존재하는데 size라는 속성이다.
// Set 객체는 삽입, 삭제, 포함 여부확인을 지원하는데 모두 O(1)이라는 시간복잡도를 지닌다.

// 삽입 : O(1)
var exampleSet = set; 
exampleSet.add(1);
exampleSet.add(1);
exampleSet.add(2);


// 삭제 : O(1)
var exampleSet = new Set(); 
exampleSet.add(1); // exampleSet : Set {1}
exampleSet.adelete(1); // true;
// 항목이 삭제되면 true 그렇지 않으면 false 반환. 


// 포함 : O(1)
var exampleSet = new Set();
exampleSet.add(1);
exampleSet.has(1); // true
exampleSet.has(2); // false


// 교집합 
function intersaction(setA, setB){
    let intersection = new Set(); 
    for(let elem of setB){
        if(setA.has(elem)){
            intersection.add(elem);
        }
    }
    return intersection;
}
var setA = new Set([1,2,3,4]), setB = new Set([2,3]);
intersactSets(setA, setB); // Set {2, 3}

// 상위 집합 여부 확인. 
function isSuperSet(setA, setB){
    for(let elem of subset){
        if(!setA.has(elem)){
            return false; 
        }
    }
    return true; 
}

var setA = new Set([1,2,3,4]), setB = new Set([2,3]), setC = new Set([5]);
isSuperSet(setA, setB); // true 
isSuperSet(setA, setC); // false


// 합집합 
function unionSet(setA, setB){
    let union = new Set(setA);
    for(let elem of setB){
        union.add(elem);
    }
    return union;
}
let setA = new Set([1,2,3,4]), setB = new Set([2,3]), setC = new Set([5]);
unionSet(setA, setB); // Set {1, 2, 3, 4}
unionSet(setA, setC); // Set {1, 2, 3, 4, 5}

// 차집합
function differenceSet(setA, setB){
    let difference = new Set(setA);
    for(let elem of setB){
        difference.delete(elem);
    }
    return difference;
}
let setA = new Set([1,2,3,4]), setB = new Set([2,3]);
differenceSet(setA, setB); // Set {1, 4}