"use strict";
exports.__esModule = true;
var Rx = require("@reactivex/rxjs");
Rx.Observable.from([1, 2, 3]).subscribe(function (val) { return console.log(val); });
Rx.Observable.from(new Promise(function (resolve) { return resolve("hello!"); })).subscribe(function (val) { return console.log(val); });
var arr = Array.from([100, 200, 300], function (x) { return x + x; });
Rx.Observable.from(arr).subscribe(function (val) { return console.log(val); });
