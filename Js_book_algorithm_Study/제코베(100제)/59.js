// 빈칸 채우기
// 총 문자열의 길이는 50으로 제한. 
const s = "hi";


const n = 25 + parseInt((s.length/2), 10)

// 왼쪽 채우기 
const left = s.padStart(n, '=');
// 오른쪽 채우기
const right = left.padEnd(50, '=');





console.log(right);
