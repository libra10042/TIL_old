var PoliceOfficer = /** @class */ (function () {
    function PoliceOfficer() {
        this.getAlias = function () { return "happy"; };
    }
    PoliceOfficer.prototype.getAge = function () {
        return 10;
    };
    PoliceOfficer.prototype.hasClub = function () {
        return true;
    };
    return PoliceOfficer;
}());
var policeMan = new PoliceOfficer();
console.log(policeMan.getAlias());
console.log(policeMan.getAge());
