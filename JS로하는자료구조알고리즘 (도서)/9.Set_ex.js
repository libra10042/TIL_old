// 집합을 사용해 배열의 중복 확인하기
// 시간 복잡도 : O(n) /   공간 복잡도 : O(n)
function checkDuplicaters(arr){
    let mySet = new Set(arr);
    return mySet.size < arr.length; 
}

checkDuplicaters([1,2,3,4,5]); // false
checkDuplicaters([1,1,2,3,4,5]); // true 

// 개별적인 배열들로부터 유일한 값만을 반환하기
function uniqueList(arr1, arr2){
    let mySet = new Set(arr1.concat(arr2));
    return Array.from(mySet);
}

uniqueList([1,1,2,2], [2,3,4,5]); // [1,2,3,4,5]
uniqueList([1,2], [3,4,5]); // [1,2,3,4,5]
uniqueList([], [2,2,3,4,5]); // [2,3,4,5]