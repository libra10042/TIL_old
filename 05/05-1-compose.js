[multiplyTwo, multiplyThree, addFour].reduce(
  function (prevFunc, nextFunc) {
    return function (value) {
      return nextFunc(prevFunc(value));
    };
  },
  function (k) {
    return k;
  }
);


//💡단계 별로 분해 해보자
//1단계 : 초기값과 multiplyTwo() 함수의 조합
function(value){
    return multiplyTwo((k =>k)(value));
}

//2단계 : 1단계 결과값과 multiplyThree() 함수의 조합
function(value){
    return multiplyThree(
        function(value){
            return multiplyTwo(
                (k =>k)(value)
            );
        }(value)
    );
}

//3단계 : 2단계 결과 값과 addFour함수의 조합. 
function(value){
    return addFour(
        function(value){
            return multiplyThree(
                function(value){
                    return multiplyTwo(
                        (k => k )(value)
                    );
                }(value)
            );
        }(value)
        
    )
}




function compose(funcArr){
    return funcArry.reduce(
        function (prevFunc, nextFunc){
            return function(value){
                return nextFunc(prevFunc(value));
            }
        },
        function(k){ return k; }
    );
}

const formulaWithCompose = compose([multiplyTwo, multiplyThree, addFour]);

//1. arguments를 사용하여 배열 인자 대신 나열형 인자로 함수 구조를 유연하게 만들기
function compoose(){
    const functArr = Array.prototype.slice.call(arguments);
    return funcArr.reduce(
        function (prevFunc, nextFunc){
            return function(value){
                return nextFunc(prevFunc(value));
            }
        },
        function(k) {return k;}

    )
}
const formulaWithCompose = compose(multiplyTwo, multiplyThree, addFour);

//2. arguments를 활용하여 하나의 실행인자 value를 다중 인자로 사용 가능하게 확장하기
function compose(){
    const funcArr = Array.prototype.slice.call(arguments);
    return funcArr.reduce(
        function(prevFunc, nextFunc){
            return function(){
                const args = Array.prototype.slice.call(arguments);
                return nextFunc(prevFunc.apply(null, args));
            }
        },
        function(k) {return k;}
    )
}


function compose(...funcArr){
    return funcArr.reduce(
        function(prevFunc ,nextFunc){
            return function(...args){
                return nextFunc(prevFunc(...args));
            }
        },
        function(k) { return k;}
    )
}


//3. 함수 조합 실행하기
const formulaWithCompose = compose(multiplyTwo, multiplyThree, addFour);

const formulaWithCompose = compose(
multiplyTwo,
multiplyThree,
addFour

);
const x = 10; 
formulaWithCompose(10);





//4. 연산함수를 이와 같은 조합 방식으로 다양하게 구현할 수 있다.
// => ((x * 2) * 3 )+ 4
const formulaWithCompose = compose(

    multiply(2),
    multiplyX(3),
    addX(4)
);

//조합 함수 없이 표현한 경우
const formulaWithCompose = add(4)(multiplyX(3)(multiplyX(2)));

// (((x*2) +5 )* 3)  + 4 연산이 추가된 공식.
const formulaWithCompose2 = compose(
    multiplyX(2),
    addX(5),
    multiplyY(3),
    addX(4)
);

const formulaWithoutCompose2 = addX(4)(multiplyX(3)(addX(5)(multiplyX)));








