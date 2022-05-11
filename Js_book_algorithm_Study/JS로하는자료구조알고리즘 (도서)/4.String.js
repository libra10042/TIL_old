// 문자열 접근 ( charAt, substring )
console.log('dog'.charAt(1)); // "o"

console.log('YouTube'.substring(1,2)); // 'o' 를 반환한다.
console.log('YouTube'.substring(3,7)); // 'tube' 를 반환한다. 
console.log('Youtube'.substring(1)); // 'outube' 를 반환한다.

// 문자열 검색 ( indexOf ) -> -1을 반환하면 문자열이 없음을 나타낸다. 
console.log('Red Dragon'.indexOf('Red')); // 0 을 반환한다. 
console.log('Red Dragon'.indexOf('RedScale')); // -1을 반환한다.
console.log('Red Dragon'.indexOf('Dragon', 0)); // 4를 반환한다.
console.log('Red Dragon'.indexOf('Dragon', 4)); // 4를 반환한다.
console.log('Red Dragon'.indexOf("", 9)); // 9를 반환한다. 


function existsInString(stringValue, search){
    return stringValue.indexOf(search) !== -1; 
}
// existsInString 
console.log(existsInString('red', 'r')); // 'true'를 출력한다. 
console.log(existsInString('red', 'b')); // 'false'를 출력한다.


// a의 등장 횟수를 세는 로직. 
var str = "He's my king from this day until his last day"; 
var count = 0; 
var pos = str.indexOf('a');
while(pos!== -1){
    count++; 
    pos = str.indexOf('a', pos + 1);
}
console.log(count); // '3' 을 출력한다. 


// startsWith, endsWith ( 특정 문자열이 특정 입력으로 시작하면 true 를 반환하고 endsWith는 문자열이 특정 입력으로 끝나면 true를 반환한다.)
'Red Dragon'.startsWith('Red'); // true 를 반환한다.
'Red Dragon'.endsWith('Dragon'); // true를 반환한다.
'Red Dragon'.startsWith('Dragon'); // false를 반환한다. 
'Red Dragon'.endsWith('Red'); // false를 반환한다.

// .split(separator) : (문자열 분해)
var test1 = 'chiken,noodle,soup,broth';
test1.split(","); // ["chiken", "noodle", "soup", "broth"]

var test1 = "chiken"; 
test1.split(""); // ["c", "h", "i", "c", "k", "e", "n"]


// 문자열 바꾸기 
"Wizard of Oz".replace("Wizard", "Width"); // Width of Oz"




