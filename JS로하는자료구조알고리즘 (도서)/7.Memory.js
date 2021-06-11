// 메모리 누수 
// ( 메모리 누수는 자바스크립트 엔진의 가비지 컬렉터가 메모리를 올바른 방식으로 해제하지 않은 경우 발생할 수 있다.)
var foo = {
    bar1 : memory(), // 5kb
    bar2 : memory() // 5kb
}

function clickEvent(){
    alert(foo.bar1[0]);
}
// foo 객체가 bar1 만을 참조하기 떄문이다. 하지만 실제 clickEvent() 함수는 10KB 메모리를 사용한다.

<div id="one">One</div>
<div id="two">Two</div>

let one = document.getElementById("one");
let two = document.getElementById("two");
one.addEventListener('click', function(){
    two.remove();
    console.log(two);
})
// two 항목이 더 이상 사용 중이 아닌 경우 이를 메모리 누수 라고 부르며 미리 누수를 피해야 한다.
//----------------------------------------
// 위의 메모리 누수 해결 방법1. 
let one = ducement.getElementById("one");

one.addEventListener('click', function(){
    let two = document.getElementById("two");
    two.remove(); 
});
// 해결 방법2
let one = document.getElementById("one");
one.addEventListener('click', function(){
    let two = document.getElementById("two");
    two.remove();
}); 

one.removeEventListener("click");


