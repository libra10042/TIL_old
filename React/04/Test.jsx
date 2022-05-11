import React, { PureComponent } from "react";
import PropTypes from "prop-types";
import withStyles from "./withStyles";

class Text extends PureComponent {
  render() {
    const { children } = this.props;
    return <Span>{children}</Span>;
  }
}

text.propTypes = {
  children: PropTypes.node.isRequired,
};

export default withStyles()(Text);
