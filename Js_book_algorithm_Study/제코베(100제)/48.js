// 대소문자 바꿔서 출력하기
/*문자열이 주어지면 대문자아 소문자를 바꿔서 출력하는 프로그램을 작성하세요. 


입력 : AAABBBcccddd
출력 : aaabbbCCCDDD
*/
const str = 'AAABBBcccddd';
let arr = [];

for(let i=0; i<str.length; i++){
    if(str[i] === str[i].toUpperCase()){
        arr.push(str[i].toLowerCase());
    }else{
        arr.push(str[i].toUpperCase());
    }

}
// join : 배열을 문자열로 반환
console.log(arr.join(""));