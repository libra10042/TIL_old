function work1(onDone) {
  setTimeout(() => onDone("작업1 완료!"), 100);
}

function work2(onDone) {
  setTimeout(() => onDone("작업2 완료!"), 200);
}

function work3(onDone) {
  setTimeout(() => onDone("작업2 완료!"), 300);
}

function urgentwork() {
  console.log("긴급 작업");
}

work(function (msg1) {
  console.log("done after 100ms : " + msg1);
  work2(function (msg2) {
    console.log("done after 300ms : " + msg2);
    work3(function (msg3) {
      console.log("done after 600ms : " + msg3);
    });
  });
});
urgentwork();

//비동기 함수는 비동기 처리를 위해 사용한다.
//비동기 처리란 작업 시간이 많이 필요한 작업 A를 처리하느라 다른 작업들(B, C, D...) 이 대기 하고 있는 상태라면 일단 다른 작업들을 먼저 진행하고
// 작업 A와 작업 A와 연관된 작업을 이후에 처리하는 방식을 말한다.
// 비동기 처리의 대표적인 예는 서버에 데이터를 요청하고 결과를 기다리는 과정이다.
// 서버에 데이터를 요청하는 동안 다른 작업을 진행하다가 데이터 요청이 완료되면 본격적으로 작업을 진행한다.
// 여러 작업을 효율적으로 처리하려면 비동기 처리를 꼭 할 줄 알아야 한다.

// 기존 자바스크립트는 비동기 작업을 위해 setTimeout()함수를 이용했다.

// 지연 작업과 상관없이 바로 실행되어야 하는 함수는 urgentWork()이다.
