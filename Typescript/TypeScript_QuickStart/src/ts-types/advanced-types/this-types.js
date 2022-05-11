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
var AddCalc = /** @class */ (function () {
    function AddCalc(value) {
        if (value === void 0) { value = 0; }
        this.value = value;
    }
    AddCalc.prototype.add = function (operand) {
        this.value += operand;
        return this;
    };
    return AddCalc;
}());
var MyCalc = /** @class */ (function (_super) {
    __extends(MyCalc, _super);
    function MyCalc() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    MyCalc.prototype.multiply = function (operand) {
        this.value *= operand;
        return this;
    };
    return MyCalc;
}(AddCalc));
var calc = new MyCalc(3).multiply(5).add(10);
console.log(calc.value);
