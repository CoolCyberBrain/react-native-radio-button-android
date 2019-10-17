import * as React from "react";
import { StyleProp, ViewStyle, ViewProps, Touchable } from "react-native";

export interface ElevatedViewProps extends ViewProps, Touchable {
  /**
   * @default false
   */
  value?: boolean;

  /**
   * @default false
   */
  disabled?: boolean;

  /**
   */
  color?: string;

  /**
   */
  onValueChange?: (response: { value: boolean }) => {};
}

export default class ElevatedView extends React.Component<ElevatedViewProps> {}
