//자바스크립트에서는 함수를 생성자 형태로 선언한 다음 상속이 필요한 변수나 함수를 prototype 객체에 할당하는 방법을 사용했다.
//protype 객체는 new 연산자로 생성되는 객체 안에서 this 연산자의 함수 및 변수 선언 위치를 참조할 수 있는 요소이다.

function Shape(x, y) {
  this.name = "Shape";
  this.move(x, y);
}

//static 함수를 선언하는 예제
Shape.create = function (x, y) {
  return new Shape(x, y);
};
//인스턴스 함수를 선언하는 예제
Shape.prototype.move = function () {
  return 0;
};

Shape.prototype.area = function () {
  return 0;
};
//혹은
Shape.prototype = {
  move: function (x, y) {
    this.x = x;
    this.y = y;
  },
  area: function () {
    return 0;
  },
};
var s = new Shape(0, 0);
s.area(); //0

//...
function Circle(x, y, radius) {
  Shape.call(this, x, y);
  this.name = "Circle";
  this.radius = radius;
}
Object.assign(Circle.prototype, Shape.prototype, {
  area: function () {
    return this.radius * this.radius;
  },
});

var c = new Circle(0, 0, 10);
c.area(); //100

//-----------------------
class Shape{
    static create(x, y){ return new Shape(x, y); }

    name = 'Shape';
    constructor (x, y){
        this.move(x, y);
    }   
    move(x, y){
        this.x = x; 
        this.y = y;
    }
    area(){
        return 0; 
    }
}

var s = new Shape(0, 0); 
s.area(); //0 

class Circle extends Shape {
    constructor(x, y, radius){
        super(x, y);
        this.radius = radius;
    }
    area(){
        if(this.radius === 0) return super.area();
        return this.radius * this.radius;
    }
}
var c = new Circle(0, 0, 10);
c.area(); //100 


