// 선언만 되고 값이 할당되지 않은 변수에 undefined가 할당된다.

// === vs ==
console.log("5" ==5);
console.log("5" ===5);


// 객체
var o1 = {};
var o2 = {};

console.log(o1 === 02); // false 반환
console.log(01 === 02); // false




// 객체 속성 비교
function isEquivalent(a, b){
    // 속성 이름 배열
    var aProps = Object.getOwnPropertyNames(a);
    var bProps = Object.getOwnPropertyNames(b);

    // 속성 길이가 다른 경우 두 객체는 다른 객체다.
    if (aProps.length != bProps.length){
        return false; 
    }

    for(let i=0; i<aProps.length; i++){
        let propName = aProps[i];


        // 속성 값이 다른 경우 두 개게는 같지 않다.
        if (a[propName] !== b[propName]){
            return false;
        }
    }

    // 모든 것이 일치하면 두 객체는 일치한다.
    return true; 

}

isEquivalent({'hi' : 12}, {'hi' :12}); //true를 반환한다.


// 등가 연산자는 false를 반환한다. 기본 등가 확인 연산자인 ==와 ===는 문자열과 숫자에만 사용할 수 있다. 
// 객체에 대한 등가 확인을 구현하려면 객체의 각 속성을 확인해야 한다.
