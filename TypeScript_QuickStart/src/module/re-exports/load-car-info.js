"use strict";
exports.__esModule = true;
var car_info_module_1 = require("./car-info-module");
car_info_module_1.CarInfo.Hello();
var car = new car_info_module_1.CarInfo.car("My Car");
console.log(car.name);
var engine = new car_info_module_1.CarInfo.engine("My engine");
console.log(engine.name);
