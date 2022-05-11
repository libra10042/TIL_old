"use strict";
exports.__esModule = true;
/// <reference path="car1.ts" />
var ns = require("./car1");
var Car;
(function (Car) {
    var wheels;
    console.log(ns.Car.auto);
    var Taxi = /** @class */ (function () {
        function Taxi() {
        }
        return Taxi;
    }());
})(Car || (Car = {}));
console.log(ns.Car.auto);
//console.log(Car.wheels);  <--- 저급 불가. 
