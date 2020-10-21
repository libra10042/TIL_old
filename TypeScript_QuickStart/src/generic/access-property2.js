var Profile2 = /** @class */ (function () {
    function Profile2() {
        this.name = "happy!";
    }
    return Profile2;
}());
var Accessor2 = /** @class */ (function () {
    function Accessor2() {
    }
    Accessor2.prototype.getKey = function (obj) {
        return obj.name;
    };
    return Accessor2;
}());
var ac2 = new Accessor2();
console.log(ac2.getKey(new Profile2()));
