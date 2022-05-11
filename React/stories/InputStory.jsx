import React from "react";
import { storiesOf } from "@storybook/react";

import Input from "../03/Input";

storiesOf("input", module)
  .addWithJSX("기본설정", () => <Input name="name" />)
  .addWithJSX("label 예제", () => <input type name="name" label="이름" />)
  .addWithJSX("onChange 예제", () => (
    <Input name="name" onChange={action("onChange 이벤트 발생")} />
  ));
