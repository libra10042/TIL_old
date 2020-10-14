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
var Train = /** @class */ (function () {
    function Train(speed) {
        this.speed = speed;
    }
    Train.prototype.speedUp = function () {
        this.speed++;
    };
    return Train;
}());
var Ktx = /** @class */ (function (_super) {
    __extends(Ktx, _super);
    function Ktx(speed) {
        var _this = _super.call(this, speed) || this;
        _this.speed = speed;
        return _this;
    }
    Ktx.prototype.getSpeed = function () {
        return this.speed;
    };
    Ktx.prototype.sppedUpUp = function () {
        this.speed += 2;
    };
    return Ktx;
}(Train));
var ktx = new Ktx(300);
console.log("현재 속도 : " + ktx.getSpeed() + "km");
ktx.speedUp();
console.log("현재 속도 : " + ktx.getSpeed() + "km");
