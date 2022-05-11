// 반장선거
// 새 학기를 맞아 호준이네 반은 반장 선거를 하기로 헀습니다. 학생들이 뽑은 후보들을 입력받으면 뽑힌 학생의 이름과 받은 표 수를 출력하는 프로그램을 작성하시오. 

// 입력 : 원범 원범 혜원 혜원 혜원 유진 유진
// 출력 : 혜원(이)가 총 4표로 반장이 되었습니다.


// 풀이1) 
// set을 통해 후보자 리스트 생성 후 -> map으로 변환 후 투표 결과를 value 에 추가한다.
// HashMap 사용 ( key값은 중복 value값을 찾기 위한 데이터인데 중복을 허용하지 않는다. 하지만 value 값은 중복을 허용한다.

function election(){
    // 투표 결과
    const array = ["원범", "원범", "혜원", "혜원", "혜원", "유진", "유진"];

    // 투표를 가장 많이 받은 학생 수.
    let winner = " ";

    // 2. 반장 후보 set으로 중복 제거.
    let candidate = new Set();
    candidate.push(array);

    // 3. set -> map으로 변환 한 후 투표 count
    let candidate_result = new Map(candidate);

    for(let i=0; i<array.length; i++){
        // 4. 투표 수 count
        let count; 

        for(let j=0; j<candidate_result.length; j++){
            if(candidate_result[j].containsKey(array[i])){
                candidate_result[j][count++]; 
            }
        }
    }    
}
console.log(election);

// 정답
function election1(){
    const array = ["원범", "원범", "혜원", "혜원", "혜원", "유진", "유진"];
    // 객체 생성.
    let result = {};
    let winner = "";

    for(let index in array){
        let val = array[index];
        result[val] = result[val] === undefined ? 1: result[val] = result[val] + 1;
    }

    console.log(result);

    winner = Object.keys(result).reduce(function(a, b){
        return result[a] >  result[b] ?  a : b;
    });
    

    console.log(`${winner}(이)가 총 ${result[winner]} 표로 반장이 되었습니다.`);; 

    return winner; 
}

console.log(election1());



