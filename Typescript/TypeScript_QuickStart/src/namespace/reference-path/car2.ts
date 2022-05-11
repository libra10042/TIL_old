/// <reference path="car1.ts" />
import * as ns from "./car1";
namespace Car {
    let wheels : number;
    console.log(ns.Car.auto);

    class Taxi implements ns.Car.ICar {
        name :string;
        verdor : string;
    }

}

console.log(ns.Car.auto);

//console.log(Car.wheels);  <--- 저급 불가. 