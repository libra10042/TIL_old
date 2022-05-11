// 민규의 악수

/*
광장에서 모인 사람들과 악수를 하는 행사가 열렸습니다.
참가자인 민규는 몇명의 사람들과 악수를 한 후 중간에 일이 생겨 집으로 갔습니다.

이 행사에서 진행된 악수는 총 n 번이라고 했을 때, 
민규는 몇 번의 악수를 하고 집으로 돌아갔을까요?
그리고 민규를 포함한 행사 참가자는 몇 명일까요?

- 악수는 모두 1대 1로 진행이 됩니다.
- 민규를 제외한 모든 참가자는 자신을 제외한 참가자와 모두 한번씩 악수를 합니다.
- 같은 상대와 중복된 악수는 카운트 하지 않습니다.
- 민규를 제외한 참가자는 행사를 모두 마쳤습니다.


예를들어 행사에서 59회의 악수가 진행되었다면 민규는 4번의 악수를 하였고 민규를 포함한 참가자는 12명이다.

행사에서 진행된 악수 횟수(n)를 입력받으면 민규의 악수 횟수에 행사 참가자 추가 출력됩니다.
*/

//참가자 == n
//악수의 수 = n-1 + n-2 n-3 .... 1
//n = n(n-1)/2

function solution(n){
    //사람수
    let people =0;
    // 총악수 
    let result = 0;
    //임시
    let tmp = 0;  
    while(true){
        result = parseInt((people * (people-1))/2, 10);
         
        if(n < result){
            break; 
        }
        tmp = result;
        people +=1 ;
        
    }
    return [parseInt(n-tmp, 10), people]; 
}

const totalCount = 59; 
console.log(solution(totalCount));