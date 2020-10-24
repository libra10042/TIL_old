"use strict";
exports.__esModule = true;
var list_1 = require("./list");
var $ = require("jquery");
var App;
(function (App) {
    $(function () {
        var app = new list_1.RecommenPlaces();
        var items = new Array();
        items.push(new list_1.Item("수성유원지", 85));
        items.push(new list_1.Item("이월드", 80));
        items.push(new list_1.Item("안지랑 곱창 거리", 20));
        items.push(new list_1.Item("팔공산", 30));
        items.push(new list_1.Item("중앙로", 90));
        var listHTML = app.getList(items);
        $("#list").html(listHTML);
        var nameBestPlace = app.getBestPlace(items);
        $("#bestPlace").text(nameBestPlace);
    });
})(App || (App = {}));
