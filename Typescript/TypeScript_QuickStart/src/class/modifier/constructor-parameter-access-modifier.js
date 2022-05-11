var Cube = /** @class */ (function () {
    // #1 생성자 매개변수 선언
    function Cube(width, length, height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }
    // #2 직육면체 부피 구하기
    Cube.prototype.getVolumn = function () {
        return this.width * this.length * this.height;
    };
    return Cube;
}());
var _a = [1, 2, 3], cWidth = _a[0], cLength = _a[1], cHeight = _a[2];
var cube = new Cube(cWidth, cLength, cHeight);
console.log("1번 세로 : ", cube.width, "cm");
console.log("2번 부피 : ", cube.getVolumn(), "ml");
