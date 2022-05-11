const p= { 
    name : "happy",
    age: 30
}

const h : string = "hello ts";
export { p as default, h as hello};

//default 키워드는 한번만 사용해야 한다 . 아래와 같이 사용하면 안된다.
// export { p as default, h as default }