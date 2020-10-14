var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Planet = /** @class */ (function () {
    function Planet() {
        this.isTransduction = true; //공전
    }
    Planet.prototype.getIsTransduction = function () {
        return this.isTransduction;
    };
    Planet.prototype.stopTransduction = function () {
        console.log("stop1");
        this.isTransduction = false;
    };
    return Planet;
}());
var Earth = /** @class */ (function (_super) {
    __extends(Earth, _super);
    function Earth() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.features = ["soil", "water", "oxyzen"];
        return _this;
    }
    Earth.prototype.stopTransduction = function () {
        console.log("stop2");
        this.isTransduction = false;
    };
    return Earth;
}(Planet));
var earth = new Earth();
earth.diameter = 12656.2;
console.log("1번 : " + earth.diameter);
console.log("2번 : " + earth.getIsTransduction());
earth.stopTransduction();
console.log("3번" + earth.getIsTransduction());
