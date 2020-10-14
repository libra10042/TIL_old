var Circle = /** @class */ (function () {
    function Circle() {
    }
    Circle.getArea = function (radius) {
        this.circleArea = radius * radius * Circle.pi;
        return this.circleArea;
    };
    Object.defineProperty(Circle, "area", {
        set: function (pArea) {
            Circle.circleArea = pArea;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Circle.prototype, "area", {
        get: function () {
            return Circle.circleArea;
        },
        enumerable: false,
        configurable: true
    });
    Circle.pi = 3.14;
    Circle.circleArea = 0;
    return Circle;
}());
console.log("1번 : " + Circle.getArea(3));
//정적 멤버 변수인 Circle에 값 설정
Circle.area = 100;
var circle = new Circle();
console.log("2번 : " + circle.area);
