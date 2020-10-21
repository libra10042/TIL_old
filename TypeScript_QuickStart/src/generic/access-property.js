var Profile = /** @class */ (function () {
    function Profile() {
        this.name = "happy!";
    }
    return Profile;
}());
var Accessor1 = /** @class */ (function () {
    function Accessor1() {
    }
    Accessor1.prototype.getKey = function (obj) {
        return obj["name"];
    };
    Accessor1.prototype.getKey2 = function (obj) {
        return obj["name"];
    };
    Accessor1.prototype.get = function (obj) {
        var objName = obj instanceof Profile ? obj.name : obj;
        return objName;
    };
    return Accessor1;
}());
var ac = new Accessor1();
console.log(ac.getKey(new Profile()));
console.log(ac.getKey2(new Profile()));
console.log(ac.get(new Profile()));
