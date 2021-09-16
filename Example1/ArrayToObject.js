// 객체를 배열로
// Object.entries();

let fruit = {
  name : "apple",
  color : "red",
  location : "tai",
  grade : "A"
}
console.log(Object.entries(fruit));


// 배열을 객체로 바꾸는 법. 
// Object.assign(traget, source)
let fruit1 = [
  { name : "banana" },
  { color : "yellow" },
  { location : "tai" },
  { grade : "A" }
]
console.log(Object.assign({}, fruit1));



// 서로 다른 두 개의 객체 데이터를 하나의 객체로 만들기 
let name1 = {
  id : "j",  //  중복
  name : "jin"
}

let name2 = {
  id : "h", // 중복
  region : "white",
  location : "paris"
}

const target = Object.assign({}, name1, name2);
console.log(target);


// 객체의 속성 값만 모아서 배열 만들기 
// Object.keys();
let pInfo = {
  id : "j",
  name : "jin",
  location : "paris",
  region : "white"
}

const target2 = Object.keys(pInfo);
console.log(target2);


// 객체의 속성만 모아서 새로운 배열로 만들기 
// Object.value()
let pInfo2 = {
  id : "j",
  name : "jin",
  location : "paris",
  region : "white"
}

const target3 = Object.values(pInfo2);
console.log(target3);