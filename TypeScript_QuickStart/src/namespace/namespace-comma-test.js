var MyAnimal;
(function (MyAnimal) {
    var Land;
    (function (Land) {
        function run() {
            console.log("육상 동물이 달립니다.");
        }
        Land.run = run;
    })(Land = MyAnimal.Land || (MyAnimal.Land = {}));
})(MyAnimal || (MyAnimal = {}));
(function (MyAnimal) {
    //run();  <---다른 이름 영역이므로 사용할 수 없다. 
    MyAnimal.Land.run();
})(MyAnimal || (MyAnimal = {}));
//동물
var Animal;
(function (Animal) {
    function run() {
        console.log("동물이 달립니다.");
    }
    Animal.run = run;
    // Animal.Land.run();
    //하위 네임스페이스 요소는 호출 불가.
})(Animal || (Animal = {}));
//육상 동물
(function (Animal) {
    var Land;
    (function (Land) {
        Animal.run();
        function run() {
            console.log("육상 동물이 달립니다.!");
        }
        Land.run = run;
    })(Land = Animal.Land || (Animal.Land = {}));
})(Animal || (Animal = {}));
//애완 동물
(function (Animal) {
    var Land;
    (function (Land) {
        var Pet;
        (function (Pet) {
            Animal.Land.run();
            function run() {
                console.log("애완 동물이 달립니다.");
            }
            Pet.run = run;
            //고양이 클래스
            var Cart = /** @class */ (function () {
                function Cart() {
                }
                Cart.prototype.run = function () {
                    Animal.Land.Pet.run();
                };
                return Cart;
            }());
            Pet.Cart = Cart;
        })(Pet = Land.Pet || (Land.Pet = {}));
    })(Land = Animal.Land || (Animal.Land = {}));
})(Animal || (Animal = {}));
var cat = new (Animal.Land.Pet).Cart();
cat.run();
