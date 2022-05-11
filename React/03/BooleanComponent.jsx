import React from "react";

class BooleanComponent extends React.Component {
  render() {
    //불리언 타입을 조건문에 적용한 예제
    const message = this.props.bored ? "놀러가자" : "하던 일 열심히 마무리하기";
    return <div className="message-container">{message}</div>;
  }
}

export default BooleanComponent;
