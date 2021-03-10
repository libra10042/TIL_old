// 이상한 엘리베이터

/*
정량 N에 정확히 맞춰야만 움직이는 화물용 엘리베이터가 있다. 
화물은 7KG, 3KG 두 가지이며 팔이 아픈 은후는 가장 적게 화물을 옳기고 싶습니다

예를 들어 정량이 24KG이라면 3KG 8개를 올기는 것 보다는 
7KG 3개, 3KG 1개 즉 4개로 더 적게 옮길 수 있습니다.


입력 : 정량이 N이 입력됩니다.


출력
가장 적게 옮길 수 있는 횟수를 출력합니다.
만약 어떻게 해도 정량이 N이 되지 않는다면 -1을 출력합니다.
*/
let checkNumber = 25; 

let result = 0; 

while(true){
    if (checkNumber % 7 === 0){
        result = parseInt(checkNumber/7, 10);
        break;
    } 
    checkNumber -= 3;
    result +=1; 
    if( checkNumber < 0 ){

        console.log(-1);
        break; 
    } 
}
console.log(result);