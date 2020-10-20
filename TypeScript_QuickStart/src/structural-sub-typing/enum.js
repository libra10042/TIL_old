// enum
var EastAsia1;
(function (EastAsia1) {
    EastAsia1[EastAsia1["korea"] = 88] = "korea";
    EastAsia1[EastAsia1["china"] = 86] = "china";
    EastAsia1[EastAsia1["japan"] = 81] = "japan";
})(EastAsia1 || (EastAsia1 = {}));
var EastAsia2;
(function (EastAsia2) {
    EastAsia2[EastAsia2["korea"] = 88] = "korea";
    EastAsia2[EastAsia2["china"] = 86] = "china";
    EastAsia2[EastAsia2["japan"] = 81] = "japan";
})(EastAsia2 || (EastAsia2 = {}));
var east1 = EastAsia1.china;
var east2 = EastAsia2.korea;
// var east1 : EastAsia1 = EastAsia2.china;
// var east2 : EastAsia2 = EastAsia1.korea;
east1 = 1000;
east2 = 2000;
console.log("east=" + east1 + typeof east1 + " east2=" + east2 + " " + typeof east2);
