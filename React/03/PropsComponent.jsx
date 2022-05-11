import React from "react";
import Prototype from "prop-types";

class PropsComponent extends React.Component {
  render() {
    return <div className="message-container">{this.props.name}</div>;
  }
}

PropsComponent.propTypes = {
  name: propTypes.string,
};

export default PropsComponent;
