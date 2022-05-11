var Student2 = /** @class */ (function () {
    function Student2() {
    }
    Object.defineProperty(Student2.prototype, "name", {
        get: function () {
            return this.studentName;
        },
        set: function (name) {
            //포함되면 0, 포함되지 않으면 -1
            if (name.indexOf("happy") !== 0) {
                this.studentName = name;
            }
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Student2.prototype, "birthYear", {
        get: function () {
            return this.studentBirthYear;
        },
        set: function (year) {
            if (year <= 2000) {
                this.studentBirthYear = year;
            }
        },
        enumerable: false,
        configurable: true
    });
    return Student2;
}());
var student2 = new Student2();
student2.birthYear = 2001;
console.log("1번 : " + student2.birthYear);
student2.birthYear = 2000;
console.log("2번 : " + student2.birthYear);
student2.name = "happy";
console.log("3번 : " + student2.name);
student2.name = "lucky";
console.log("4번 : " + student2.name);
