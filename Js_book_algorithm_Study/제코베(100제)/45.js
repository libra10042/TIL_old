// getTime() 함수 사용하기

/*
Date 객체의 메소드 중 하나인 getTime()은 1970년 1월 1일 0시 0분 0초 이후로부터 지금까지 흐른 시간을 천분의 1초 단위(ms)로 반환합니다.

이를 이용하여 현재 연도(2019)를 출력해보세요.

*/

function solution(){

    let date = new Date();

    let nowDate = date.getTime(); //ms 
    
    console.log(nowDate);

    console.log(60*60*24*365); // 1년

    console.log(60*60*24*365*1000); // 1년의 ms

    console.log(nowDate / (60*60*24*365*1000)); //1970년부터 51년이 흘렸다.

    console.log(Math.floor(nowDate / (60*60*24*365*1000) + 1970)); //올해 날짜 

}

solution();