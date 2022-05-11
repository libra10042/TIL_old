"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
exports.__esModule = true;
exports.SuperEngine = exports.Engine = exports.MyCar = void 0;
var MyCar = /** @class */ (function () {
    function MyCar(name) {
        this.name = name;
    }
    MyCar.prototype.getName = function () {
        return this.name;
    };
    return MyCar;
}());
exports.MyCar = MyCar;
var Engine = /** @class */ (function () {
    function Engine(name) {
        this.name = name;
    }
    Engine.prototype.getName = function () {
        return this.name;
    };
    return Engine;
}());
exports.Engine = Engine;
var engine_1 = require("./engine"); //MyCar 모듈은 Engine 모듈을 불러와 하나의 외부 모듈이 되도로 구성함. 
__createBinding(exports, engine_1, "Engine", "SuperEngine");
