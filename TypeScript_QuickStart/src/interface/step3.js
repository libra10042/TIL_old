var Person3 = /** @class */ (function () {
    function Person3(name, city) {
        this.name = name;
        this.city = city;
        this.full = name + "(" + city + ")";
    }
    return Person3;
}());
var person3 = [
    new Person3("kim", "Seoul"),
    new Person3("park", "daejeon"),
    new Person3("jeong", "daegu")
];
console.log(JSON.stringify(person3));
