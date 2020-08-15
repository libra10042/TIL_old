// import React, { Component } from "react";
// import "./App.css";
// class App extends Component {
//   render() {
//     return (
//       <div className="App">
//         <h1 className="title">두잇! 리액트 시작하기</h1>
//       </div>
//     );
//   }
// }

// export default App;
import React from "react";
// create-react-app은 js 또는 jsx 파일의 확장자를 생략해도 해당 파일을 자동으로 찾을 수 있게 설정되었다.
import TodaysPlan from "./03/TodaysPlan";

class App extends React.Component {
  render() {
    return (
      <div className="body">
        <TodaysPlan />
      </div>
    );
  }
}

export default App;
