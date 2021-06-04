
// var 사용예)
function scope1(){
    var top = "top";

    bottom = "bottom";

    console.log(bottom);

    var bottom;

}

console.log(scope1()); // "bottom" 을 출력하며 오류가 발생하지 않는다.

function scope1(){
    var top = "top";
    var bottom;

    bottom = "bottom"
    console.log(bottom);
}
console.log(scope1());



// 사용예2)
function scope3(print){
    if(print){
        let insideIf = '12';
    }
    console.log(insideIf);
}
console.log(scope3(true));
 
