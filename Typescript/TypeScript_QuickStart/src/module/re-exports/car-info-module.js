"use strict";
exports.__esModule = true;
exports.CarInfo = void 0;
var my_car_1 = require("./my-car");
var CarInfo;
(function (CarInfo) {
    CarInfo.car = my_car_1.MyCar;
    CarInfo.engine = my_car_1.SuperEngine;
    function Hello() {
        console.log("hello");
    }
    CarInfo.Hello = Hello;
})(CarInfo = exports.CarInfo || (exports.CarInfo = {}));
