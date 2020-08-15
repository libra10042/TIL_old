//필수 리갱트 구동 모듈이다.
import React from "react";
import ReactDOM from "react-dom";

//초기 화면을 구성하는 사용자 코드이다.
import "./index.css";
import App from "./App";
import * as serviceWorker from "./serviceWorker";

//리액트 엔진이 화면을 출력하는 코드이다.
//id가 root인 엘리먼트에 컴포넌트를 출력한다.
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

//리액트 엔진은 JSX의 XML 구조를 분석하여 위와 같은 자바스크립트 함수 코드로 변환한다.
//React.createElement() 함수는 리액트 엔진에 포함되어 있으며, 이 함수는 기존 자바스크립트의 document.createElement() 함수를 사용하여 객체 모델을 생성한다.

//하지만 리액트를 사용하면 이런 과정들을 일일이 알 필요 없이 JSX로 화면을 빠르게 구성하면 된다.
// 개발자는 JSX만 작성하고, 리액트 엔진은 JSX를 기존 자바스크립트로 해석하는 역할만 하게 된다.
// 이것을 선언형 화면 기술이라 부른다. ( 이처럼 JSX는 개발자가 화면 구성에만 집중할 수 있도록 도와준다.)
