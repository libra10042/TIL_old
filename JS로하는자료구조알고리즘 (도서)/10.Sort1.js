// 거품 정렬
// swap 은 정렬에 사용되는 일반적인 함수이다.
function swap(array, index1, index2){
    let temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp; 
}

function bubbleSort(array){
    for(let i=0, arrayLength = array.length; i <arrayLenght; i++){
        for(let j=0; j<=i; j++){
            if(array[j] > array[j+1]){
                swap(array, i, j);
            }
        }
    }
    return array; 
}
bubbleSort([6,1,2,3,4,5]); // [1,2,3,4,5,6]
// 시간 복잡도 : O(n2)  / 공간 복잡도 O(1)



// 선택 정렬
function selectionSort(items){
    let len = items.length, min; 

    for(let i=0; i<len; i++){
        // 최소 항목을 현재 위치로 설정한다.
        min = i; 
        // 더 작은 항목이 있는지 배열의 나머지를 확인한다.
        for(j = i+1; j<len; j++){
            if(items[j] < items[min]){
                min = j; 
            }
            // 현재 위치가 최소 항목 위치가 아니라면 항목들을 교환한다.
            if(i != null){
                swap(items, i, min);
            }
        }
    }
    return items; 
}
selectionSort([6,1,23,4,2,3]); //[1,2,3,4,6,23]
// 시간 복잡도 : O(n2)  / 공간 복잡도 O(1)


// 삽입 정렬
function insertionSort(items){
    let len = items.length, // 배열의 항목 수
    value, // 현재 비교 중인 값. 
    i,  // 정렬되지 않은 부분의 인덱스
    j; // 정렬된 부분의 인덱스


    for(i=0; i<len; i++){
        //현재 값이 이후에 이동될 수도 있기 때문에 저장한다.
        vale = items[i];

        // 정렬된 부분의 값이 정렬되지 않은 부분의 값보다 큰 경우
        // 정렬된 부분의 모든 항목을 하나씩 이동시킨다. 
        // 이는 값을 삽입할 공간을 만든다.

        for(j = i-1; j > -1 && items[j] > value; j--){
            items[j+1] = items[j];
        }
        items[j+1] = value;
    }
    return items; 
}
insertionSort([6,1,23,4,2,3]); // [1,2,3,4,6,23]
// 시간 복잡도 O(n2)  / 공간복잡도 O(1)








