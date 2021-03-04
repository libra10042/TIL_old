// 버블정렬 구현하기

/*
버블정렬은 두 인접한 원소를 검사하여 정렬하는 방법을 말한다. 
시간 복잡도는 느리지만 코드가 단순하기 때문에 자주 사용된다.
*/
function bubble(arr){
    // 슬라이스에 매개변수가 없으면 그냥 복사한다.
    let result = arr.slice();

    for(let i=0; i<result.length-1; i++){
        
        for(let j=0; j<result.length-i; j++){
            if(result[j] > result[j + 1]){
                let temp = result[j];
                result[j] =result[j+1];
                result[j+1] = temp; 
            }
        }
    }
    return result; 

}


const items = "9 5 1 2 6 7".split(' ').map((n) =>{
    return parseInt(n, 10);
});

console.log(bubble(items));