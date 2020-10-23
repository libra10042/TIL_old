"use strict";
exports.__esModule = true;
var Rx = require("@reactivex/rxjs");
var interval = Rx.Observable.interval(100);
var take$ = interval.take(3);
take$.subscribe(function (val) { return console.log(val); });
