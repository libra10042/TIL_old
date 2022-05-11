var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
var ArrayList = /** @class */ (function () {
    function ArrayList() {
        this.arrayList = [];
    }
    ArrayList.prototype.add = function (indexOrValue, value) {
        if (value !== undefined) {
            //타입 가드
            if (typeof indexOrValue === "number") {
                this.arrayList.splice(indexOrValue, 0, value);
            }
        }
        else {
            this.arrayList.push(indexOrValue);
        }
    };
    ArrayList.prototype.remove = function (index) {
        this.arrayList.splice(index, 1);
    };
    ArrayList.prototype.addAll = function (elements) {
        this.arrayList = __spreadArrays(this.arrayList, elements);
    };
    ArrayList.prototype.get = function (index) {
        return this.arrayList[index];
    };
    ArrayList.prototype.clear = function () {
        this.arrayList = [];
    };
    ArrayList.prototype.isEmpty = function () {
        return this.arrayList.length === 0 ? true : false;
    };
    ArrayList.prototype.set = function (index, value) {
        this.arrayList[index] = value;
    };
    ArrayList.prototype.toArray = function () {
        return this.arrayList;
    };
    ArrayList.prototype.size = function () {
        return this.arrayList.length;
    };
    return ArrayList;
}());
var aList = new ArrayList();
aList.add("a");
aList.add("b");
aList.add("c");
console.log("1번 add : ", aList.toArray());
aList.add(1, "H1");
console.log("2번 index로 add : ", aList.toArray());
aList.remove(1);
console.log("3번 remove(1) : ", aList.toArray());
aList.addAll(["d", "e"]);
console.log("4번 addAll : ", aList.toArray());
console.log("5번 get(2) :", aList.get(2));
console.log("6번 size() : ", aList.size());
aList.clear();
console.log("7번 size() : ", aList.size());
if (aList.isEmpty()) {
    console.log("8번 empty!");
}
