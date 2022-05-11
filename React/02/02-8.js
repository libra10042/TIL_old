import MyModule from './MyModule.js';
import { ModuleName } from './MyModule.js';
import { ModuleName as RenameModuleName } from './MyModule.js';

function Func(){
    MyModule();
}

export const CONST_VALUE = 0;
export class MyClass {}
export default new Func();