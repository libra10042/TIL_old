// 검색. 
// 앞에서 언급했듯이 검색은 자료 구조 내에 특정 항목을 찾는 일을 말한다.


// 선형 검색. ( 시간 복잡도 : O(n)) 
function linearSearch(array, n){
    for(let i=0; i<array.length; i++){
        if(array[i] == n){
            return true; 
        }
    }
    return false; 
}
console.log(linearSearch([1,2,3,4,5,6,7,8,9], 6)); // true
console.log(linearSearch([1,2,3,4,5,6,7,8,9], 10)); // false


// 이진 검색
// : 중간 값을 확인해 원하는 값보다 해당 중간 값이 큰지 작은지 확인한다.
function binarySearch(array, n){
    let lowIndex = 0, highIndex = array1.length-1; 

    while(lowIndex <= highIndex){
        let midIndex = Math.floor((highIndex + lowIndex) / 2);
        if(array[midIndex] == n){
            return midIndex;
        }else if(n > array[Index]){
            lowIndex = midIndex + 1; 
        }else { 
            highIndex = midIndex -1; 
        }
    }

    return -1; 
}

console.log(binarySearch([1,2,3,4], 4)); // 3
console.log(binarySearch([1,2,3,4], 5)); // -1
