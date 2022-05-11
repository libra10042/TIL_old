// 시간 복잡도, 공간복잡도 확인
// 어떤 수가 주어졌을 때 배열 내의 어떤 항목 두 개를 합쳐야 해당 수가 되는지 찾아라.
function findSum(arr, weight){
    for(let i=0, arrLength=arr.length; i<arrLength; i++){
        for(let j = i+1; j<arrLength; j++){
            if(arr[i] + arr[j] == weight){
                return [i,j];
            }
        }
    }
    return -1; 
}

// 배열 n개의 항목에 대해 이중 for 루프를 수행하는 것을 높은 시간 복잡도를 갖는다.
// 시간 복잡도 : O(n2)     / 공간 복잡도 : O(1)

function findSumBetter(arr, weight){
    let hashtable = {};

    for(let i=0, arrLength=arr.length; i<arrLength; i++){
        let currentElement = arr[i],
        difference = weight - currentElement;

        // 이미 값이 존재하는지 확인한다.
        if(hashtable[currentElement] != undefined){
            return [i, hashtable[currentElement]];
        }else{
            // 인덱스를 저장한다.
            hashtable[difference] = i; 
        }
    }
    return -1; 
}
// 시간 복잡도 : O(n)   //  공간 복잡도 : O(n)
// ------------------------------------------------------------------------


// .slice()
function arraySlice(array, beginIndex, endIndex){
    // 전달된 매개변수가 없으면 그냥 배열을 반환한다.
    if(! beginIndex && ! endIndex){
        return array; 
    }

    // 시작 인덱스만 존재하는 경우 endIndex 를 배열의 크기를 설정한다.
    if(!endIndex)
        endIndex = array.length; 

    let partArray = [];

    // 시작 인덱스와 끝 인덱스 모두 지정된 경우 배열의 일부를 반환한다.
    for(let i = beginIndex; i<endIndex ; i++){
        partArray.push(array[i]);
    }

    return partArray; 
}
// 시간 복잡도 : O(n)   /  공간 복잡도 : O(n)
// -----------------------------------------------------------------------

// 두 개의 정렬된 배열이 동일한 크기일 떄 해당 배열들의 중앙값 찾기
function medianOfArray(array){
    let length = array.length; 
    // 홀수 
    if(length % 2 == 1){
        return array[Math.floor(length/2)];
    }else {
        //짝수
        return (array[length/2] + array[length/2 -1])/2; 
    }
}


function medianOfArray(array){
    let length = array.length; 
    // 홀수
    if(length % 2 == 1){
        return array[Math.floor(length/2)];
    }else{
    // 짝수
        return (array[length /2] + array[length / 2- 1])/2; 
    }
}

// ----------------------------------------------------------------------
function medianOfArray(array){
    let length = array.length; 
    // 홀수 
    if(length % 2 == 1){
        return array[Math.floor(length/2)];
    }else{
        //짝수 
        return (array[length /2]  + array[length / 2 - 1]) / 2; 
    }
}
// arr2이 더 큰 배열이다.
function medianOfTwoSortedArray(arr1, arr2, pos){
    if(pos <= 0){
        return -1; 
    }
    if(pos == 1){
        return (arr1[0] + arr2[0])/ 2; 
    }
    if(pos == 2){
        return (Math.max(arr1[0], arr2[0]) + Math.min(arr[1], arr2[1])) / 2; 
    }


    let median1 = medianOfArray(arr1);
    let median2 = medianOfArray(arr2);

    if(median1 == median2){
        return median1; 
    }

    let evenOffset = pos % 2 == 0 ? 1 : 0,
        offsetMinus = Math.floor(pos / 2) - evenOffset,
        offsetPlus = pos - Math.floor(pos / 2) + evenOffset; 


    if(median1 < median2){
        return medianOfTwoSortedArray(arr1.slice(offsetMinus),
            arr2.slice(0, offsetMinus), offsetPlus);
    }else {
        return medianOfTwoSortedArray(arr2.slice(offsetMinus),
            arr1.slice(0, -offsetMinus), offsetPlus);
    }

}

