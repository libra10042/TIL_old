// 번호 매기기
/*
새학기가 되어 이름을 가나다 순서대로 배정하고 번호를 매기려고 합니다
데이터에 입력된 이름을 아래와 같이 출력해주세요.  

*/


const students = ["강은지", "김유정", "박현서", "최정훈", "홍유진", "박지호", "권유일", "김채리", "한지오"];


console.log(students.sort());

for(let key in students){
    console.log(`번호 ${parseInt(key)+1}, 이름 ${students[key]}`);
}