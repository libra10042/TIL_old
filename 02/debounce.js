// 디바운스와 스로틀
// '지연 처리'를 효율적으로 구현할 수 있다.
// 서버의 데이터를 요청하는 등의 작업에서 생기는 부하를 크게 줄여준다.

// 디바운스란?
// 어떤 내용을 입력하다가 특정시간 동안 대기하고 있으며 마지막에 입력된 내용을
// 바탕으로 서버 요청하는 방법이다.
// 연관 검색어 창을 떠올리면 이해하기 쉬울 것이다.

//debounce.js를 실행하려면 export를 삭제해야 한다.
//실행 후 다시 export를 넣어주세요
export function debounce(func, delay) {
  let inDebounce;
  return function (...args) {
    if (inDebounce) {
      clearTimeout(inDebounce);
    }
    inDebounce = setTimeout(() => func(...args), delay);
  };
}

const run = debounce((val) => console.log(val), 100);
run("a");
run("b");
run(2);
