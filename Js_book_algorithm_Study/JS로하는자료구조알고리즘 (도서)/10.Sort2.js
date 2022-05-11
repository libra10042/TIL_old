// 빠른 정렬
// : 빠른 정렬은 기준점을 획든한 다음 해당 기준점을 기준으로 배열을 나눈다.
function quickSort(items){
    return quickSortHelper(items, 0, items.length - 1);
}

function quickSortHelper(items, left, right){
    let index; 
    if(items.length > 1){
        index = partition(items, left, right);

        if(left < index -1){
            quickSortHelper(items, left, index -1);
        }

        if(index < right){
            quickSortHelper(items, index, right);
        }
    }
    return items; 
}

function partition(array, left, right){
    let pivot = array[Math.floor(right + left) / 2];
    while(left <= right){
        while(pivot > array[left]){
            left++;
        }
        while(pivot <array[right]){
            right--; 
        }
        if(left <= right){
            let temp = array[left];
            array[left] = array[right];
            array[right] = temp; 
            left++;
            right--;
        }

    }
    return left; 
}
quickSort([6,1,23,4,2,3]); // [1,2,3,4,6,23]
// 시간 복잡도 : 평균 O(nlog2(n)), 최악의 경우 O(n2)




// 빠른 선택. 
// : 빠른 선택은 정렬되지 않은 목록에서 k번째로 작은 항목을 찾는 선택 알고리즘이다.
let array = [1,3,3,-2,3,14,7,8,1,2,2];
// 정렬된 형태 : [-2, 1, 1, 2, 2, 3, 3, 3, 7, 8, 14]
function quickSelectInPlace(A, l, h, k){
    let p = partition(A, l, h);
    if(p == (k-1)){
        return A[p];
    }else if(p >(k-1)){
        return quickSelectInPlace(A, l, p -1, k);
    }else { 
        return quickSelectInPlace(A, p + 1, h, k);
    }
}

function medianQuickselect(array){
    return quickSelectInPlace(array, 0, array.length, Math.floor(array.length/2));
}
quickSelectInPlace(array, 0, array.length-1, 5); //2 
// 2 - 5 번째로 가장 작은 항목이기 때문이다.
quickSelectInPlace(array, 0, array.length, 10); // 7
// 7 - 10 번째로 가장 작은 항목이기 때문이다. 
// 시간 복잡도 : O(n)



// 병합 정렬
function merge(leftA, rightA){
    let results = [], leftIndex = 0, rightIndex = 0; 

    while(leftIndex < leftA.length && rightIndex < rightA.length){
        if(leftA[leftIndex] < rightA[rightIndex]){
            results.push(leftA[leftIndex++]);
        }else { 
            results.push(right[rightIndex++]);
        }
    }
    let leftRemains = leftA.slice(leftIndex),
        rightRemains = rightA.slice(rightIndex);

    // 남은 항목들을 결과 배열에 추가한다.
    return results.concat(leftRemains).concat(rightRemains);
}
function mergeSort(array){
    if(array.length < 2){
        return array; // 기저 조건 : 항목이 하나뿐이라서 해당 배열은 이미 정렬된 것이다.
    }

    let midpoint = Math.floor((array.length)/2),
        leftArray = array.slice(0, midpoint),
        rightArray = array.slice(midpoint);

    return merge(mergeSort(leftArray), mergeSort(rightArray));
}
mergeSort([6,1,23,4,2,3]); // [1,2,3,4,6,23]
// 시간 복잡도 : O(nlog2(n))    /   공간 복잡도 : O(n)




// 계수 정렬
// : 계수 정렬은 값들을 비교하지 않기 때문에 O(k+n) 시간 안에 수행된다.
function countSort(array){
    let hash = {}, countArr = [];
    for(let i=0; i<array.length; i++){
        if(!hash[array[i]]){
            hash[array[i]] = 1; 
        }else {
            hash[array[i]]++;
        }
    }
    for(let key in hash){
        // 항목이 몇 개가 되든 해당 항목을 배열에 추가한다. 
        for(let i=0; i<hash[key]; i++){
            countArr.push(parseInt(key));
        }
    }   
    return countArr;
}
countSort([6,1,23,2,3,2,1,2,2,3,3,1,123,123,4,2,3]); 
// 시간 복잡도 O(k+n)   /  공간 복잡도 : O(k)







