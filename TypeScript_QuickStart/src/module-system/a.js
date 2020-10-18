"use strict";
exports.__esModule = true;
exports.unique = void 0;
function unique(arr) {
    console.log("a 모듈");
    return arr.filter(function (v, i, a) { return a.indexOf(v) === i; });
}
exports.unique = unique;
