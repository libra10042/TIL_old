// 오타 수정하기

// 문장이 입력되면 q를 e로 바꾸는 프로그램을 작성하시오. 

/*
입력 : querty
출력 : euerty

입력 : hqllo my namq is hyqwon
출력 : hello my name is hyewon
*/

// 풀이1) 오답.
function solution(){
    const text = "querty";

    let checkChar;
    let result = [];

    for(const a of text){
        checkChar = a.charAt(text);
        if(checkChar === "q"){
            result += checkChar;
            checkChar.replace("q", "e");
        }
    }
    return result; 
}
console.log(solution());


// 정답
function solution1(){
    const word = "hqllo my namq is hyqwon";
    console.log(word.split("q").join("e"));

}
solution1();