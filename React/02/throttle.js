// 스로틀 이란?
// 스로틀(throttle)은 디바운스 개념과 비슷하지만, '입력되는 동안에도 바로
// 이전에 요청한 작업을 주기적으로 실행한다는 점'이 다르다.
// 예를 들어 페이스북의 타임라인은 스크롤을 내리는 동안 계속해서
// 다음 내용이 출력되는 '무한 스크롤' 기능이 구현되어 있다.

function throttle(func, delay) {
  let lastFunc;
  let lastRan;

  return function (...args) {
    const context = this;
    if (!lastRun) {
      func.call(context, ...args);
      lastRan = Date.now();
    } else {
      if (lastFunc) clearTimeout(lastFunc);
      lastFunc = setTimeout(function () {
        if (Date.now() - lastRan >= delay) {
          func.call(context, ...args);
          lastRan = Date.now();
        }
      }, delay - (Date.now() - lastRan));
    }
  };
}

var checkPosition = () => {
  const offset = 500;
  const currentScrollPosition = window.pageYOffset;
  const pageBottonPosition =
    document.body.offsetHeight - window.innerHeight - offset;
  if (currentScrollPosition >= pageBottomPosition) {
    console.log("다음 페이지 로딩");
  }
};

var infiniteScroll = throttle(checkPosition, 300);
window.addEventListener("scroll", infiniteScroll);
