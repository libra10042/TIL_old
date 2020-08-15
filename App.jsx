// import React from "react";
// import PropComponent from "./03/PropsComponent";

// class App extends React.Component {
//   render() {
//     return <PropComponent name="두잇 리액트" />;
//   }
// }
//-------------------------------------------------
// import React from "react";
// import PropComponent from "./03/ChildComponent";
// import ChildComponent from "./03/ChildComponent";

// class App extends React.Component {
//   render() {
//     return (
//       <ChildComponent
//         boolValue={true}
//         numValue={1}
//         arrayValue={[1, 2, 3]}
//         objValue={{ name: "제목", age: 30 }}
//         nodeValue={<h1>노드</h1>}
//         funcValue={() => {
//           console.log("메시지");
//         }}
//       />
//     );
//   }
// }

// import React from "react";
// import ChildComponent from "./03/ChildComponent";

// class App extends React.Component {
//   render() {
//     const array = [1, 2, 3];
//     const obj = { name: "제목", age: 30 };
//     const node = <h1>노드</h1>;
//     const func = () => {
//       console.log("메시지");
//     };

//     return (
//       <ChildComponent
//         boolValue={true}
//         numValue={1}
//         arrayValue={array}
//         objValue={obj}
//         nodeValue={node}
//         funcValue={func}
//       />
//     );
//   }
// }
// export default App;

// import React from "react";
// import BooleanComponent from "./03/BooleanComponent";

// class App extends React.Component {
//   render() {
//     return (
//       <div>
//         <div>
//           <b>지루할 때:</b>
//           <BooleanComponent bored />
//         </div>
//         <div>
//           <b>즐거울 때:</b>
//           <BooleanComponent />
//         </div>
//       </div>
//     );
//   }
// }

// import React from "react";
// import ChildComponent2 from "./03/ChildComponent2";

// class App extends React.Component {
//   render() {
//     return (
//       <div>
//         <ChildComponent2 objValue={{ age: "20살" }} />
//       </div>
//     );
//   }
// }

// export default App;

// import React from 'react';
// import ChildComponent2 from './03/ChildComponent2';

// class App extends React.Component{

//     render(){

//         return(
//             <div>

//                 <ChildComponent2
//                     objValue ={{ age: 20 }}
//                     requiredStringValue ="문자"
//                 />
//             </div>
//         );
//     }
// }

// import React from "react";
// import DefaultPropsComponent from "./03/DefaultPropsComponent";

// class App extends React.Component {
//   render() {
//     return (
//       <div>
//         <DefaultPropsComponent />
//       </div>
//     );
//   }
// }
// export default App;

import React from "react";
import ChildProperty from "./03/ChildProperty";

class App extends React.Component {
  render() {
    return (
      <div>
        <ChildProperty>
          <div>
            <span>자식 노드</span>
          </div>
        </ChildProperty>
      </div>
    );
  }
}

export default App;
