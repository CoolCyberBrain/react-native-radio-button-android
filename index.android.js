import {
  StyleSheet,
  ViewPropTypes,
  requireNativeComponent
} from "react-native";

import PropTypes from "prop-types";
import React from "react";

class RadioButton extends React.Component {
  _onChange = event => {
    this.props.onChange && this.props.onChange(event);
    this.props.onValueChange &&
      this.props.onValueChange(event.nativeEvent.event);
  };

  render() {
    return (
      <RCTRadioButton
        ref={"RCTRadioButton"}
        style={[this.props.style, styles.radioButton]}
        on={this.props.value}
        color={this.props.color}
        disabled={this.props.disabled}
        onChange={this._onChange}
      />
    );
  }
}

RadioButton.defaultProps = {
  value: false,
  disabled: false
};

const styles = StyleSheet.create({
  radioButton: {
    height: 27,
    width: 27
  }
});

RadioButton.propTypes = {
  value: PropTypes.bool,
  onValueChange: PropTypes.func,
  color: PropTypes.string,
  disabled: PropTypes.bool,
  ...ViewPropTypes
};

const RCTRadioButton = requireNativeComponent(
  "RCTRadioButtonAndroid",
  RadioButton,
  {
    nativeOnly: { on: true }
  }
);
export default RadioButton;
