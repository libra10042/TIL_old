// 이상한 369
// 369 게임을 하는데 조금 이상한 규칙이 있습니다. 3이나 6, 9일때만 박수를 쳐야 합니다. 
// 예를 들어 13, 16과 같이 3과 6,9 만으로 된 숫자가 아닐 경우엔 박수를 치지 않습니다. 
// 수현이는 박수를 몇 번 쳤는지 확인하고 싶습니다. 36일 때 박수를 쳤다면 박수를 친 횟수는 5번 입니다.
// n을 입력하면 박수를 몇 번 쳤는지 그 숫자를 출력해주세요.

// >> 입력 '93'
// >> 출력 10

function solution(n){
    let answer  = 0; 
    let count = 1; 

    const obj = {3:1, 6:2, 9:3};

    while(n.length !== 0){
        answer += obj[parseInt(n.pop(), 10)]*count;
        count *= 3; 
    }


    return answer; 
}

const user_input = '63'.split('');
console.log(user_input);
solution(solution(user_input));