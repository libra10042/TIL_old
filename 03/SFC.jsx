import React from "react";
import PropTypes from "prop-types";

function SFC(props, context) {
  //클래스형 컴포넌트의 this.props 값과 동일하다.
  const { somePropValue } = props;
  //클래스형 컴포넌트의 this.context와 동일하다.
  const { someContextValue } = context;
  return <h1>Hello, {somePropValue}</h1>;
}

SFC.propTypes = { somePropValue: PropTypes.any };
SFC.defaultProps = { somePropValue: "default value" };

export default SFC;
