export class MyCar { 
    constructor(public name : string) { }

        getName(){
            return this.name;
        }
}


export class Engine{
    constructor(public name : string){}
    getName(){
        return this.name;
    }
}


export {Engine as SuperEngine} from "./engine"; //MyCar 모듈은 Engine 모듈을 불러와 하나의 외부 모듈이 되도로 구성함. 