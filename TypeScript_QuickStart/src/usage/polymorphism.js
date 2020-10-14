var Led = /** @class */ (function () {
    function Led(name) {
        this.name = name;
    }
    Led.prototype.getName = function () {
        return "LED =>" + this.name;
    };
    return Led;
}());
var Oled = /** @class */ (function () {
    function Oled(name) {
        this.name = name;
    }
    Oled.prototype.getName = function () {
        return "OLED =>" + this.name;
    };
    return Oled;
}());
var MonitorDisplayTest = /** @class */ (function () {
    function MonitorDisplayTest() {
    }
    //개선전 
    MonitorDisplayTest.prototype.display1 = function (monitor) {
        if (monitor instanceof Led) {
            //변수에 지정된 타입과 타입 어설션은 생략 가능
            var myMonitor = monitor;
            return myMonitor.getName();
        }
        else if (monitor instanceof Oled) {
            var myMonitor = monitor;
            return myMonitor.getName();
        }
    };
    //개선 후
    MonitorDisplayTest.prototype.display2 = function (monitor) {
        var myMonitor = monitor;
        return myMonitor.getName();
    };
    return MonitorDisplayTest;
}());
var displayTest = new MonitorDisplayTest();
console.log("\n    1\uBC88 " + displayTest.display1(new Led("LED TV")) + "\n    2\uBC88 " + displayTest.display1(new Oled("OLED TV")) + "\n    3\uBC88 " + displayTest.display2(new Led("LED TV")) + "\n    4\uBC88 " + displayTest.display2(new Oled("OLED TV")) + "\n");
