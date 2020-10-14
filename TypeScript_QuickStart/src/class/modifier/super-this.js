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
var PC = /** @class */ (function () {
    function PC(hddCapacity) {
        this.hddCapacity = hddCapacity;
        this.ram = "0G";
    }
    Object.defineProperty(PC.prototype, "ramCapacity", {
        get: function () { return this.ram; },
        set: function (value) { this.ram = value; },
        enumerable: false,
        configurable: true
    });
    PC.prototype.getHddCapacity = function () {
        return this.hddCapacity;
    };
    return PC;
}());
var Desktop = /** @class */ (function (_super) {
    __extends(Desktop, _super);
    function Desktop(hddCapacity) {
        var _this = 
        //부모 클래스의 생성자를 호출함. 
        _super.call(this, hddCapacity) || this;
        _this.hddCapacity = hddCapacity;
        return _this;
    }
    Desktop.prototype.getInfo = function () {
        console.log("1번 HDD용량 : " + _super.prototype.getHddCapacity.call(this), _super.prototype.hddCapacity);
        console.log("2번 HDD용량 : " + this.getHddCapacity(), this.hddCapacity);
        this.hddCapacity = "2000G";
        console.log("3번 HDD용량 : " + _super.prototype.getHddCapacity.call(this), _super.prototype.hddCapacity);
        console.log("4번 HDD용량 : " + _super.prototype.getHddCapacity.call(this), this.hddCapacity);
        _super.prototype.ramCapacity = "16G"; //부모 클래스의 set 프로퍼티로 값을 설정함
        console.log("5번 RAM 용량 : " + this.ramCapacity, _super.prototype.ramCapacity);
        this.ramCapacity = "8G"; //상속받은 SET 프로퍼티로 값을 설정함. 
        console.log("6번 RAM 용량 : " + this.ramCapacity, _super.prototype.ramCapacity);
    };
    return Desktop;
}(PC));
var myDesktop = new Desktop("1000G");
myDesktop.getInfo();
