//문제) 수학 라이브러리를 사용하지 않고 정수의 제곱근 함수 구현하기
// 방법1) 선형 검색 시간 복잡도 O(n)
function sqrtInNative(number){
    if(number == 0 ||  number == 1){
        return number; 
    }

    let index = 1, square = 1; 

    while(square < number){
        if(square == number){
            return square;
        }

        index++;
        square = index * index; 
    }
    return index; 
}
console.log(sqrtInNative(9)); 


// 방법2) 시간 복잡도 O(log2(n))
function sqrtInt(number){
    if(number == 0 || number == 1) return number; 
    let start =1, end = number, ans; 

    while(start <= end){
        let mid = parseInt((start + end) / 2);

        if(mid * mid == number){
            return mid; 
        }

        if(mid * mid <number){
            start = mid + 1; // 큰쪽을 사용한다.
            ans = mid; 
        }else {
            end = mid - 1; // 작은 쪽을 사용한다.
        }
    }
    return ans;
}
console.log(sqrInt(9));


// 문제) 배열의 두 항목을 더해서 주어진 수가 될 수 있는지 확인하기
// 시간 복잡도 O(n2)  / 공간 복잡도 : O(1)
function findTwoSum(array, sum){
    for(let i=0, arrayLength = array.length; i < arrayLength; i++){
        for(let j=i+1; j<arrayLength; j++){
            if(array[j] + array[i] == sum){
                return true;
            }
        }
    }
    return false; 
}

// 시간 복잡도 O(n)  / 공간 복잡도 O(n)
function findTwoSum(array, sum){
    let store = {};

    for(let i=0, arrayLength = array.length; i < arrayLength; i++){
        if(store[array[i]]){
            return true; 
        }else { 
            store[sum-array[i]] = array[i];
        }
    }
    return false;
}


// 문제) 배열에서 단 한번만 등장하는 항목 찾기 
// 시간 복잡도 : O(log2n)    / 공간 복잡도 : O(1)
function findOnlyOnce(arr, low, high){
    if(low > high){
        return null; 
    }

    if(low == high){
        return arr[low];
    }

    let mid = Math.floor((high + low) / 2); 

    if(mid % 2 == 0){
        if(arr[mid] == arr[mid+1]){
            return findOnlyOnce(arr, mid +2, high);
        }else { 
            return findOnlyOnce(arr, low, mid);
        }
    }else { 
        if(arr[mid] == arr[mid-1]){
            return findOnlyOnce(arr, mid+1, high);
        }else{ 
            return findOnlyOnce(arr, low, mid-1);
        }
    }
}
function findOnlyOnceHelper(arr){
    return findOnlyOnce(arr, 0, arr.length);
}
findOnlyOnceHelper([1, 1, 2, 4, 4, 5, 5, 6, 6]);




// 문제) 문자열을 길이순으로 정렬하는 자바스크립트 정렬 비교 함수 생성하기
let mythical = ['dragon', 'slayer', 'magic', 'wizard of oz', 'ned stark']; 

function sortComparator(a, b){
    return a.length - b.length; 
}

mythical.sort(sortComparator);
// ["magic", "dragon", "slayer", "wizard of oz", "ned stark"]


// 문제) 문자열 내 a의 위치에 따라 문자열 항목들을 정렬한다.
let mythical = ['dragon', 'slayer', 'magic', 'wizard of oz', 'ned tark'];

function sortComparator(a, b){
    return a.indexOf("a") - b.indexOf("a");
}

mythical.sort(sortComparator);
// ["magic", "dragon", "slayer", "wizard of oz", "ned stark"]



// 문제) 단어 세기 목록 구현하기 
function wordConut(sentence){
    // 마침표가 단어로 인식되지 않도록 마침표를 제거한다.
    let wordsArray = sentence.replace(/[.]/g,"").split(" "),
        occurenceList = {}, answerList = {};

    for(let i=0, wordsLength=wordsArray.length; i<wordsLength; i++){
        let currentWord = wordsArray[i];

        // 존재하지 않는다. 따라서 첫 번째 등장으로 설정한다.
        if(!occurenceList[currentWord]){
            occurenceList[currentWord] = 1; 
        }else { 
            occurenceList[currentWord]++; // 등장 횟수를 증가한다.
        }
    }

    let arrayTemp = []; 
    // 값과 키를 고정 배열로 저장한다.
    for(let prop in occurenceList){
        arrayTemp.push([occurenceList[prop], prop]);
    }

    function sortcomp(a, b){
        return b[0] - a[0]; // 배열의 첫 번째 항목을 비교한다.
    }
    arrayTemp.sort(sortcomp); // 정렬

    for(let i=0, arrlength = arrayTemp.length; i < arrlength; i++){
        let current = arrayTemp[i];
        answerList[current[1]] = current[0]; // 키-값 쌍
    }
    return answerList;    
}
wordConut("practice makes perfect. get perfect by practice. just parctice"); 