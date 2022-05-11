// set 자료형의 응용
/* 바울랩에서는 3월 29일 제주대학교에서 '제주 빅데이터 사회혁신 해커톤' 행사를 주최하게 되었습니다.
이에 구글 설문지를 배포하였으나 제주대학생들이 중복해서 n개씩 설문지를 제출하였습니다.
중복된 데이터들을 삭제하여 실제 접수 명단이 몇 명인지 알고 싶습니다.

*/

const people = {
    이호준 : '01050442903',
    이호상 : '01051442904',
    이준호 : '01050342904',
    이호준 : '01050442903',
    이준 : '01050412904',
    이호 : '01050443904',
    이호준 : '01050442903'

};


//풀이1)
function solution(){
    let key1 = Object.keys(people);

    let count = 0; 
    for(let i=0; i<key1.length; i++){ count++; }


    return count; 
}
console.log(solution());



//정답)
let result = new Set();
for(let key in people){
    result.add(people[key]);
}

console.log(result.size);

