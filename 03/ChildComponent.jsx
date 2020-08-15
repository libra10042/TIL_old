import React from "react";
import PropTypes from "prop-type";

//다양한 프로퍼티 사용하기
// 프로퍼티에 문자열을 전달할 때는 큰따옴표("") 를 사용한다
// 문자열 외의 값은 따옴표 대신 중괄호({})를 사용해야 한다.

class ChildComponent extends React.Component {
  render() {
    const {
      boolValue,
      numValue,
      arrayValue,
      objValue,
      nodeValue,
      funcValue,
    } = this.props;

    return (
      <div>
        <span>불리언값: {boolValue}</span>
        <span>숫자값 : {numValue}</span>
        <span>배열값 : {arrayValue}</span>
        <span>객체값 : {String(objValue)}</span>
        <span>노드값 : {nodeValue}</span>
        <span>함수값 : {String(funcValue)}</span>
      </div>
    );
  }
}

ChildComponent.PropTypes = {
  boolValue: PropTypes.bool,
  numValue: PropTypes.number,
  arrayValue: PropTypes.arrayOf(PropTypes.number),
  objValue: PropTypes.object,
  nodeValue: PropTypes.node,
  funcValue: PropTypes.func,
};

export default ChildComponent;
