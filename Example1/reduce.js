// 배열의 모든 값 ( 1부터 10까지 ) 더하기
const numbers = [1,2,3,4,5,6,7,8,9,10];
const sum1 = numbers.reduce((accmulator, currentNumber) => accmulator + currentNumber);
console.log('sum1 = ', sum1);

function sumReducer(accumulator, currentNumber){
    return accumulator + currentNumber;
}
const sum2 = numbers.reduce(sumReducer);
console.log('sum2 = ', sum2);


const friends = [
    {
        name : 'line',
        age : 32,
        job : 'dev',
    }, 
    {   name : 'kakao',
        age : 35,
        job : 'docter'

    },
    {
        name : 'naver',
        age : 40, 
        job : 'teacher'
    }
];

// 3명의 나이의 합. 
const ageSum = friends.reduce((accumulator, currentObject) => {
    return accumulator + currentObject.age;
}, 0);
console.log(ageSum);




// -----------------------------------------
const number = [1,2,3,4,5];
function reducer(accumulator, currentValue, currentIndex){
    const result = accumulator + currentValue; 
    console.log('accumulator = ', accumulator, ', currentValue = ', currentValue, ', currentIndex = ', currentIndex, ', result = ', result);
    return result; 
}


// initValue가 없는 경우
number.reduce(reducer);
console.log('--------------------');
// initialValue가 있을 경우
number.reduce(reducer, 0); 