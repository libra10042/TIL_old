var ArrayConvertor = /** @class */ (function () {
    function ArrayConvertor(elms) {
        this.elements = elms;
    }
    ArrayConvertor.prototype.array2string = function () {
        var text = "";
        for (var i = 0; i < this.elements.length; i++) {
            if (i > 0) {
                text += " ";
            }
            text += this.elements[i].toString();
        }
        return text;
    };
    ArrayConvertor.prototype.getValue = function (elms, index) {
        return elms[index];
    };
    return ArrayConvertor;
}());
var arr = [1, 2];
// var arr=[1,2,"hello"];   <--- 문자열 요소는 추가할 수 없음
var numConvertor = new ArrayConvertor(arr);
console.log(numConvertor.array2string());
console.log(numConvertor.getValue(arr, 0));
var arr2 = new Array();
arr2.push("a");
arr2.push("b");
// arr2.push(1234)  <-- 숫자 타입 값은 추가할 수 없음(선언된 배열이 타입이 없으면 가능. )
var stringConvertor = new ArrayConvertor(arr2);
console.log(stringConvertor.array2string());
console.log(stringConvertor.getValue(arr2, 0));
