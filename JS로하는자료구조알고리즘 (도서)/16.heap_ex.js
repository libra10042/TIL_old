// 일련의 숫자에서 중간 값 찾기. 
function MedianHeap(){
    this.minHeap = new MinHeap();
    this.maxHeap = new MaxHeap();
}

MedianHeap.prototype.add = function(value){
    if(value > this.median()){
        this.minHeap.add(value);
    }else { 
        this.maxHeap.add(value);
    }

    // 재구성
    if(this.minHeap.size() - this.maxHeap.size() > 1){
        this.maxHeap.add(this.minHeap.poll());
    }

    if(this.maxHeap.size() - this.minHeap.size() > 1){
        this.minHeap.add(this.maxHeap.poll());
    }
}

MedianHeap.prototype.median = function(){
    if(this.minHeap.size() == 0 && this.maxHeap.size() == 0){
        return Number.NEGATIVE_INFINITY;
    }else if(this.minHeap.size() == this.maxHeap.size()){
        return (this.minHeap.peek() + this.maxHeap.peek()) / 2; 
    }else if(this.minHeap.size() > this.maxHeap.size()){
        return this.minHeap.peek();
    }else { 
        return this.maxHeap.peek();
    }
}

var medianH = new MedianHeap(); 

medianH.add(12);
console.log(medianH.median()); // 12
medianH.add(2);
console.log(medianH.median()); // 7 (12 + 2 = 14; 14 / 2 = 7)
medianH.add(23);
console.log(medianH.median()); // 12
medianH.add(13);
console.log(medianH.median()); // 12.5


// 배열에서 k번째로 가장 작은 값 찾기 
var array1 = [12, 3, 13, 4, 2, 40, 23];

function getKthSamllestElement(array, k){
    var minH = new MinHeap();
    for(var i=0, arrayLength = array.Length; i < arrayLength; i++){
        minH.add(array[i]);
    }
    for(var i=1; i<k ; i++){
        minH.poll();
    }
    return minH.poll();
}

getKthSmallestElement(array1, 1); // 3
getKthSamllestElement(array1, 1); // 2
getKthSamllestElement(array1, 7); // 40 



// 배열에서 k번째로 가장 큰 값 찾기 
var array1 = [12, 3, 13, 4, 2, 40, 23];

function getKthBiggestElement(array, k){
    var maxH = new MaxHeap();
    for(let i=0, arrayLength = array.length; i<arrayLength; i++){
        maxH.add(array[i]);
    }

    for(let i=1; i<k; i++){
        maxH.poll(); 
    }
    return maxH.poll();
}

getKthBiggestElement(array1, 2); // 23
getKthBiggestElement(array, 1); // 40 
getKthBiggestElement(array1, 7); // 2