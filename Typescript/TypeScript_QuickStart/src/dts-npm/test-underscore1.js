"use strict";
exports.__esModule = true;
var _ = require("underscore");
var sum = _.reduce([1, 2, 3], function (memo, num) { return memo + num; }, 0);
console.log(sum);
