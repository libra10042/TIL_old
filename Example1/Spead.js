const language = ["java", "js", "pyhone"];

console.log(...language);

// Speacd 연산자를 이용해 데이터 생성. 
const toObject = (a, b, c) => {
    return { 
        a : a, 
        b : b, 
        c : c
    }
};
console.log(toObject(...language));

const toObject2 = (a, b, c) => ({a, b, c});
console.log(toObject2(...language));


// 매개변수에 spread 연산자 적용
const language2 = ['java', 'js', 'python', 'c++', 'c'];
const toObject3 = (a, b, ...c) => {
    return {a : a, b : b, c : c}
};

console.log(toObject3(...language2));

// 2개의 object를 합치는 방법. 
const language3 = {front : 'js', backend : 'java'};
const framework = { frontframework : 'react', backendframework : 'spring'};
const union = {...language3, ...framework};
console.log(union);


// key 업데이트
const union2 = {...language3, ...framework, frontframework : 'viewjs'};
console.log(union2);


// Object.assign()
const language4 = {front : 'js', backend : 'java'};
const framework2 = { frontframework : 'react', backendframework : 'spring'};
const union3 = Object.assign(language4, framework2);
console.log(union3);


// push 대신 사용하는 스프레드 연산자 
const language5 = ["js", "java"];
language5.push("python");
console.log(language5);

let language6 = ["js", "java"]
language6 = [...language6, "python"];
console.log(language6);

