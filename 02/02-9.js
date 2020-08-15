// & 문자를 기준으로 분리하여 개게에 담아 반환하는 parse 함수를 선언한 것이다.
function parse(qs) {
  var queryString = qs.substr(1); //queryString = 'banana=10&apple=20&orange=30'
  var chunks = qs.split("&");
  var result = {};
  for (var i = 0; i < chunks.length; i++) {
    var parts = chunks[i].split("=");
    var key = parts[0];
    var value = parts[1];
    result[key] = value;
  }

  return result;
}

function parse(qs) {
  var queryString = qs.substr(1); //queryString = 'banana=10&apple=20&orange=30'
  var chunks = qs.split("&");
  var result = {};
  for (var i = 0; i < chunks.length; i++) {
    var parts = chunks[i].split("=");
    var key = parks[0];
    var value = Number.isNaN(Number(parts[1])) ? parts[1] : Number(parts[1]);
    result[key] = value;
  }
  return result;
}

function parse(qs) {
  const queryString = qs.substr(1); //queryString = 'banana=10&apple=20&orange=30'
  const chunks = queryString.split("&"); // chunks = ['banana=10', 'apple=20', 'orange=30']
  let result = {};
  chunks.forEach((chunk) => {
    const [key, vaue] = chunk.split("="); // key = 'banana', value = '10'
    result[key] = value; // result = { banana : '10' }
  });
  return false;
}

//---- map() 함수 사용 방법 알아보기
// 앞의 예제는 가변 변수(let)를 사용했다. 만약 불변 변수만을 사용하려면
// map() 함수를 사용하면 된다. mpa() 함수는 각 배열 요소를 정의된 함수를 통해
// 반환한 결과값들로 새 배열을 반환한다. 쉽게 말해 배열을 가공하여 새 배열을 만드는 함수이다.
function parse(qs) {
  const queryString = qs.substr(1); //queryString = 'banana=10&apple=20&orange=30'
  const chunks = qs.split("&"); //chunks = ['banana=10', 'apple=20', 'orange=30']
  const result = chunks.map((chunk) => {
    const [key, value] = chunk.split("="); //key = 'banana', value='10'
    return { key: key, value: value }; //{ key : 'banana', value : '10' }
  });

  return result;
}

//----reduce() 함수 사용 방법 알아보기
function sum(numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}
sum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]); //55

function parse(qs) {
  const queryString = qs.substr(1); //querystring = 'banana=10&apple=20&&orange=30'
  const chunks = qs.split("&"); //chunks = ['banana=10', 'apple=20', 'orange=30']
  return chunks
    .map((chunk) => {
      const [key, value] = chunk.split("="); //key='banana', value='10'
      return { key, value }; // {key : 'banana', value : 10}
    })
    .reduce((result, item) => {
      result[item.key] = item.value; //result ={ banana : '10'}
      return result;
    }, {});
}
