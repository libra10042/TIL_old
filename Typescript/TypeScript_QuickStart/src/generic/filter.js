var Filter = /** @class */ (function () {
    function Filter() {
    }
    Filter.prototype.unique = function (array) {
        return array.filter(function (v, i, array) { return array.indexOf(v) === i; });
    };
    return Filter;
}());
var myFilter = new Filter(); // 클래스 저네에 대해 T가 String 타입으로 정의됨. 
var resultFilter = myFilter.unique(["a", "b", "c", "a", "b"]);
console.log(resultFilter);
